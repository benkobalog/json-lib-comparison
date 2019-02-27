import test.Main._
import spray.json._
import DefaultJsonProtocol._
import org.joda.time.DateTime

// Simple case
implicit val simpleFormat = jsonFormat1(Simple)
val string = Simple(1).toJson.toString()
// throws exceptions on failures
string.parseJson.convertTo[Simple]

// Over 22 case classes
// Can't handle case class over 22 :(

// Adding a custom field
implicit val dateTimeRW: JsonFormat[DateTime] = new JsonFormat[DateTime] {
  override def write(obj: DateTime): JsValue = JsString(obj.toString)

  override def read(json: JsValue): DateTime = {
    val withOutQuotes = json.compactPrint.tail.init
    new DateTime(withOutQuotes)
  }
}
implicit val newTypeFormat: JsonFormat[NewTypes] = jsonFormat1(NewTypes)
val stringNT = newTypes.toJson.toString
stringNT.parseJson.convertTo[NewTypes]

// ADTs
// Too lazy to to this now: https://gist.github.com/jrudolph/f2d0825aac74ed81c92a

// Recursive data types
// This give stack overflow TODO fix it...
//implicit val recFormat: JsonFormat[Recur] = jsonFormat2(Recur)
//val stringRec = rec1.toJson.toString
//stringRec.parseJson.convertTo[Recur]

// Multilevel classes
implicit val lvl1Format: JsonFormat[Lvl1] = jsonFormat2(Lvl1)
implicit val lvl2Format: JsonFormat[Lvl2] = jsonFormat2(Lvl2)
implicit val lvl3Format: JsonFormat[Lvl3] = jsonFormat1(Lvl3)
val stringLvl = lvl1.toJson.toString
stringLvl.parseJson.convertTo[Lvl1]