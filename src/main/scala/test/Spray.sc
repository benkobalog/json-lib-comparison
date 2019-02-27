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
implicit val dateTimeRW: RootJsonFormat[DateTime] = new RootJsonFormat[DateTime] {
  override def write(obj: DateTime): JsValue = JsString(obj.toString)

  override def read(json: JsValue): DateTime = {
    val withOutQuotes = json.compactPrint.tail.init
    new DateTime(withOutQuotes)
  }
}
implicit val newTypeFormat: RootJsonFormat[NewTypes] = jsonFormat1(NewTypes)
val stringNT = newTypes.toJson.toString
stringNT.parseJson.convertTo[NewTypes]