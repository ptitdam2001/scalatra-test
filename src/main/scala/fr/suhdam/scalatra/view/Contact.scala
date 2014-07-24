package fr.suhdam.scalatra.view


import play.api.libs.json._
import fr.suhdam.scalatra.models.{Contact => ContactModel}
import play.api.libs.functional.syntax._
import play.api.libs.json.Reads._


object Contact {

  object Marshaller {

    val simple = new Writes[ContactModel] {
      override def writes(o: ContactModel): JsValue = {
        Json.obj(
          "id" -> o.id,
          "id_advertiser" -> o.id_advertiser,
          "id_agency" -> o.id_agency,
          "name" -> o.name,
          "firstname" -> o.firstname,
          "email" -> o.email,
          "function" -> o.function,
          "phone1" -> o.phone1,
          "phone1_type" -> o.phone1_type,
          "phone2" -> o.phone2,
          "phone2_type" -> o.phone2_type,
          "phone3" -> o.phone3,
          "phone3_type" -> o.phone3_type
        )
      }
    }

  }

  object Unmarshaller {

    val simple = ((__ \ 'id).readNullable[Long] and
      (__ \ 'id_advertiser).readNullable[Long] and
      (__ \ 'id_agency).readNullable[Long] and
      (__ \ 'name).readNullable[String](maxLength[String](45)) and
      (__ \ 'firstname).readNullable[String](maxLength[String](45)) and
      (__ \ 'email).readNullable[String](maxLength[String](45)) and
      (__ \ 'function).readNullable[String](maxLength[String](45)) and
      (__ \ 'phone1).readNullable[String](maxLength[String](45)) and
      (__ \ 'phone1_type).readNullable[String](maxLength[String](45)) and
      (__ \ 'phone2).readNullable[String](maxLength[String](45)) and
      (__ \ 'phone2_type).readNullable[String](maxLength[String](45)) and
      (__ \ 'phone3).readNullable[String](maxLength[String](45)) and
      (__ \ 'phone3_type).readNullable[String](maxLength[String](45)))(ContactModel(_, _, _, _, _, _, _, _, _, _, _, _, _))

  }

}
