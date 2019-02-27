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

