package com.softwaremill.quicklens

import com.softwaremill.quicklens.TestData._

class ModifyEachWhereTest extends munit.FunSuite {
  test("modify a single-nested optional case class field only if the condition returns true") {
    assertEquals(modify(x4)(_.x5.eachWhere(_ => true).name).using(duplicate), (x4dup))
    assertEquals(modify(x4)(_.x5.eachWhere(_ => false).name).using(duplicate), (x4))
  }

  test("modify a single-nested optional case class field (pimped) only if the condition returns true") {
    assertEquals(x4.modify(_.x5.eachWhere(_ => true).name).using(duplicate), (x4dup))
    assertEquals(x4.modify(_.x5.eachWhere(_ => false).name).using(duplicate), (x4))
  }

  test("not modify an optional case class field if it is none regardless of the condition") {
    assertEquals(modify(x4none)(_.x5.eachWhere(_ => true).name).using(duplicate), (x4none))
    assertEquals(modify(x4none)(_.x5.eachWhere(_ => false).name).using(duplicate), (x4none))
  }

  test("modify only those list elements where the condition returns true") {
    assertEquals(modify(y1)(_.y2.y3.eachWhere(_.y4.map(_.name) == Some("d2")).y4.each.name).using(duplicate), (y1at1dup))
  }

  test("allow .each at then end only if the condition returns true") {
    assertEquals(modify(z1)(_.name.eachWhere(_.startsWith("d"))).using(duplicate), (z1dup))
    assertEquals(modify(z1)(_.name.eachWhere(_.startsWith("e"))).using(duplicate), (z1))
  }
}
