package com.softwaremill.quicklens

import java.util.NoSuchElementException




class ModifyOptionAtTest extends munit.FunSuite {

  test("modify a Option with case class item") {
    assertEquals(modify(Option(1))(_.at).using(_ + 1), (Option(2)))
  }

  test("modify a Option in a case class hierarchy") {
    case class Foo(a: Int)
    case class Bar(foo: Foo)
    case class BarOpt(maybeBar: Option[Bar])
    case class BazOpt(barOpt: BarOpt)
    assertEquals(
      modify(BazOpt(BarOpt(Some(Bar(Foo(4))))))(_.barOpt.maybeBar.at.foo.a).using(_ + 1),
      BazOpt(BarOpt(Some(Bar(Foo(5)))))
    )
  }

  test("crashes on missing key") {
    intercept[NoSuchElementException] {
      modify(Option.empty[Int])(_.at).using(_ + 1)
    }
  }
}
