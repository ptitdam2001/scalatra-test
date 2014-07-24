package fr.suhdam.scalatra.models

import java.sql.Timestamp


case class Agency(id: Option[Long],
  id_entity: Long,
  status: Int,
  name: Option[String],
  description: Option[String],
  address: Option[String],
  created_at: Option[Timestamp] = None,
  updated_at: Option[Timestamp] = None,
  contact: List[Contact]
)