import org.joda.time.DateTime
import upickle.default._
import test.Main._

// Simple case
implicit val simpleFormat: ReadWriter[Simple] = macroRW
val string = write(Simple(1))
// throws exceptions on failures
read[Simple](string)

// Over 22 case classes
implicit val over22Format: ReadWriter[Over22] = macroRW
val string22 = write(over22)
read[Over22](string22)

// Adding a custom field
implicit val dateTimeRW: ReadWriter[DateTime] =
  readwriter[ujson.Str].bimap(
    dt => ujson.Str(dt.toString),
    json => new DateTime(json.value)
  )
implicit val newTypesFormat: ReadWriter[NewTypes] = macroRW
val stringNT = write(newTypes)
read[NewTypes](stringNT)

// ADTs
implicit val adtFormat: ReadWriter[ADT] = macroRW
implicit val p0Format: ReadWriter[Product0.type] = macroRW
implicit val p1Format: ReadWriter[Product1] = macroRW
val stringADT = write(adts)
// stringADT: String = [{"$type":"test.Main.Product0"},{"$type":"test.Main.Product1","x":243}]
read[List[ADT]](stringADT)


// Recursive data types
implicit val recFormat: ReadWriter[Recur] = macroRW
val stringRec = write(rec1)
read[Recur](stringRec)

// Multilevel classes
implicit val lvl1Format: ReadWriter[Lvl1] = macroRW
implicit val lvl2Format: ReadWriter[Lvl2] = macroRW
implicit val lvl3Format: ReadWriter[Lvl3] = macroRW
val stringLvl = write(lvl1)
read[Lvl1](stringLvl)