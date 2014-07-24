package fr.suhdam.scalatra.models

case class Contact(id: Option[Long],
   id_advertiser: Option[Long],
   id_agency: Option[Long],
   name: Option[String],
   firstname: Option[String],
   email: Option[String],
   function: Option[String],
   phone1: Option[String],
   phone1_type: Option[String],
   phone2: Option[String],
   phone2_type: Option[String],
   phone3: Option[String],
   phone3_type: Option[String]
)