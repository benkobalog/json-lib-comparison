import io.circe._
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import org.joda.time.DateTime
import test.Main._

import scala.util.Try

// Simple case
val string = Simple(1).asJson.noSpaces
// returns Either[Error, A]
decode[Simple](string)

// Over 22 case classes
val string22 = over22.asJson.noSpaces
decode[Over22](string22)

// Adding a custom field
implicit val dateTimeEncoder: Encoder[DateTime] =
  (dt: DateTime) => Json.fromString(dt.toString)
implicit val dateTimeDecoder: Decoder[DateTime] =
  Decoder.decodeString
    .emap(str => Try(new DateTime(str)).toEither.left.map(_.getMessage))
val stringNT = newTypes.asJson.noSpaces
decode[NewTypes](stringNT)

// ADTs
val stringADT = adts.asJson.noSpaces
// stringADT: String = [{"Product0":{}},{"Product1":{"x":243}}]
decode[List[ADT]](stringADT)

// Recursive data types
val stringRec = rec1.asJson.noSpaces
decode[Recur](stringRec)

// Multilevel classes
val stringLvl = lvl1.asJson.noSpaces
decode[Lvl1](stringLvl)
