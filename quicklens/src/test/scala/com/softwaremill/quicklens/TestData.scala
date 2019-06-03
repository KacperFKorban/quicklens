package com.softwaremill.quicklens

object TestData {
  def duplicate(s: String) = s + s

  case class A1(a2: A2)
  case class A2(a3: A3)
  case class A3(a4: A4)
  case class A4(a5: A5)
  case class A5(name: String)

  val a5 = A5("data")
  val a5dup = A5("datadata")

  val a1 = A1(A2(A3(A4(A5("data")))))
  val a1dup = A1(A2(A3(A4(A5("datadata")))))
  val a1dupdup = A1(A2(A3(A4(A5("datadatadatadata")))))
  val a1mod = A1(A2(A3(A4(A5("mod")))))

  case class B1(b2: String, b3: Option[String])

  val b1 = B1("data", Some("data"))
  val b1dupdup = B1("datadata", Some("datadata"))

  case class X1(x2: X2)
  case class X2(x3: Option[X3])
  case class X3(x4: X4)
  case class X4(x5: Option[X5])
  case class X5(name: String)

  val x4 = X4(Some(X5("data")))
  val x4dup = X4(Some(X5("datadata")))

  val x4none = X4(None)

  val x1 = X1(X2(Some(X3(X4(Some(X5("data")))))))
  val x1dup = X1(X2(Some(X3(X4(Some(X5("datadata")))))))

  val x1none = X1(X2(None))

  case class Y1(y2: Y2)
  case class Y2(y3: List[Y3])
  case class Y3(y4: Option[Y4])
  case class Y4(name: String)

  val y1 = Y1(Y2(List(Y3(Some(Y4("d1"))), Y3(Some(Y4("d2"))), Y3(None))))
  val y1dup = Y1(Y2(List(Y3(Some(Y4("d1d1"))), Y3(Some(Y4("d2d2"))), Y3(None))))
  val y1at1dup = Y1(
    Y2(List(Y3(Some(Y4("d1"))), Y3(Some(Y4("d2d2"))), Y3(None))))

  case class Z1(name: Option[String])
  val z1 = Z1(Some("data"))
  val z1dup = Z1(Some("datadata"))

  val l1 =
    List(A3(A4(A5("d1"))), A3(A4(A5("d2"))), A3(A4(A5("d3"))), A3(A4(A5("d4"))))
  val l1at2dup = List(A3(A4(A5("d1"))),
                      A3(A4(A5("d2"))),
                      A3(A4(A5("d3d3"))),
                      A3(A4(A5("d4"))))
  val ll1 = List(List(A5("d1"), A5("d2")),
                 List(A5("d3"), A5("d4"), A5("d5")),
                 List(A5("d6"), A5("d7")))
  val ll1at2at1dup = List(List(A5("d1"), A5("d2")),
                          List(A5("d3"), A5("d4"), A5("d5")),
                          List(A5("d6"), A5("d7d7")))
  val ll1at2eachdup = List(List(A5("d1"), A5("d2")),
                           List(A5("d3"), A5("d4"), A5("d5")),
                           List(A5("d6d6"), A5("d7d7")))
  val ll1eachat1dup = List(List(A5("d1"), A5("d2d2")),
                           List(A5("d3"), A5("d4d4"), A5("d5")),
                           List(A5("d6"), A5("d7d7")))

  case class M2(m3: Map[String, A4])

  val m1 = Map("K1" -> A4(A5("d1")), "K2" -> A4(A5("d2")), "K3" -> A4(A5("d3")))
  val m2 = M2(
    Map("K1" -> A4(A5("d1")), "K2" -> A4(A5("d2")), "K3" -> A4(A5("d3"))))
  val m1dup =
    Map("K1" -> A4(A5("d1d1")), "K2" -> A4(A5("d2")), "K3" -> A4(A5("d3")))
  val m1dupEach =
    Map("K1" -> A4(A5("d1d1")), "K2" -> A4(A5("d2d2")), "K3" -> A4(A5("d3d3")))
  val m2dup = M2(
    Map("K1" -> A4(A5("d1d1")), "K2" -> A4(A5("d2")), "K3" -> A4(A5("d3"))))
  val ms1 = collection.immutable.SortedMap("K1" -> A4(A5("d1")),
                                           "K2" -> A4(A5("d2")),
                                           "K3" -> A4(A5("d3")))
  val mh1 = collection.immutable.HashMap("K1" -> A4(A5("d1")),
                                         "K2" -> A4(A5("d2")),
                                         "K3" -> A4(A5("d3")))
  val ml1 = collection.immutable.ListMap("K1" -> A4(A5("d1")),
                                         "K2" -> A4(A5("d2")),
                                         "K3" -> A4(A5("d3")))
}
