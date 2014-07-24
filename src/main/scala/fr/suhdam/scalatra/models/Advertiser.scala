package fr.suhdam.scalatra.models


case class Advertiser(
   id: Option[Long],
   id_entity: Long,
   status: Int,
   name: String,
   description: Option[String],
   id_theme: Option[Long],
   brand_logo: Option[String],
   created_at: Option[String] = None,
   updated_at: Option[String] = None,
   contacts: List[Contact]
)