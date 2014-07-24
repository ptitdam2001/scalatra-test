package fr.suhdam.scalatra.view

import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import fr.suhdam.scalatra.models.{Advertiser => AdvertiserModel}


object Advertiser {

  object Marshaller {

    val simple = new Writes[AdvertiserModel] {
      override def writes(adv: AdvertiserModel): JsValue = {
        Json.obj(
          "id" -> adv.id,
          "id_entity" -> adv.id_entity,
          "status" -> adv.status,
          "name" -> adv.name,
          "description" -> adv.description,
          "id_theme" -> adv.id_theme,
          "brand_logo" -> adv.brand_logo,
          "created_at" -> adv.created_at,
          "updated_at" -> adv.updated_at

        )
      }
    }

    val collection = new Writes[List[AdvertiserModel]] {
      def writes(o: List[AdvertiserModel]): JsValue = {
        Json.obj(
          "count" -> o.size,
          "_embedded" -> Json.obj(
            "advertisers" -> (o map simple.writes)))
      }
    }
  }
/*
  object Unmarshaller {

    val simple =
      ((__ \ 'id).readNullable[Long] and
        (__ \ "id_entity").read[Long] and
        (__ \ "name").read[String](maxLength[String](45)) and
        (__ \ "description").readNullable[String] and
        (__ \ "id_theme").readNullable[Long] and
        (__ \ "brand_logo").readNullable[String](maxLength[String](255)))((id, id_entity, name, description, id_theme, brand_logo) ⇒
        Advertiser(id, id_entity, 1, name, description, id_theme, brand_logo, None, None))


  }
  */
}
