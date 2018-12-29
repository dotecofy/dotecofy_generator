package com.dotecofy.generator.entities.access

import com.dotecofy.generator.model.{Entity, Field, Son}

object Group {

  val fields: List[Field] = List(
    new Field("name", "name", "String", "varchar", mandatory = true, unique = true, min = 3, max = 50),
    new Field("description", "description", "String", "varchar", default = "null", min = 0, max = 200),
  )

   val sons: List[Son] = List(
    new Son(User.entity,  "idGroup", "id_group"),
  )

  val entity: Entity = new Entity(
    "/access/group",
    "com.dotecofy.access.group",
    "Group",
    "group",
    fields = fields,
    sons = sons
  )

  //def entity: Entity = entityInst
}
