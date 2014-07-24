package fr.suhdam.scalatra.models

import java.sql.Timestamp

case class Advertiser(
   id: Option[Long],
   id_entity: Long,
   status: Int,
   name: String,
   description: Option[String],
   id_theme: Option[Long],
   brand_logo: Option[String],
   created_at: Option[Timestamp] = None,
   updated_at: Option[Timestamp] = None,
   contacts: List[Contact]
)