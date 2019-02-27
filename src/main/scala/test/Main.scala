package test


import org.joda.time.DateTime


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
}
