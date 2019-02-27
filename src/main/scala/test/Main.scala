package test


import org.joda.time.DateTime

import scala.collection.immutable


object Main {

  case class Simple(x: Int)
  val simple1 = Simple(1)

  case class Over22(
                       int0: Int,
                       int1: Int,
                       int2: Int,
                       int3: Int,
                       int4: Int,
                       int5: Int,
                       int6: Int,
                       int7: Int,
                       int8: Int,
                       int9: Int,
                       int10: Int,
                       int11: Int,
                       int12: Int,
                       int13: Int,
                       int14: Int,
                       int15: Int,
                       int16: Int,
                       int17: Int,
                       int18: Int,
                       int19: Int,
                       int20: Int,
                       int21: Int,
                       int22: Int,
                       int23: Int,
                       int24: Int
                     )
  val over22 = Over22(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

  case class NewTypes(dateTime1: DateTime)
  val newTypes = NewTypes(DateTime.now())

  sealed trait ADT
  case class Product1(x: Int) extends ADT
  case object Product0 extends ADT
  val adts: List[ADT] = List(Product0, Product1(243))

  case class Recur(value: String, recurs: List[Recur])
  val rec1 = Recur("lvl1", List(Recur("lvl2", Nil)))

  case class Lvl3(x: Int)
  case class Lvl2(x: Int, lvl3: Lvl3)
  case class Lvl1(x: String, lvl2: Lvl2)
  val lvl1 = Lvl1("root", Lvl2(2, Lvl3(333)))
}
