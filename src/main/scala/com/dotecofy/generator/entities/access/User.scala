package com.dotecofy.generator.entities.access

import com.dotecofy.generator.model.{Entity, Field, Son}

object User {

  val fields: List[Field] = List(
    new Field("name", "name", "String", "varchar", mandatory = true, unique = true, min = 3, max = 50),
    new Field("description", "description", "String", "varchar", default = "null", min = 0, max = 200),
  )

  val sons: List[Son] = List(
    new Son(Group.entity,  "idUser", "id_user"),
  )

  val entity: Entity = new Entity(
    "/access/user",
    "com.dotecofy.access.user",
    "User",
    "user",
    fields = fields,
    sons = sons
  )

  //def entity: Entity = entityInst

}
