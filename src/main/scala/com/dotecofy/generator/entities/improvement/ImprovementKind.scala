package com.dotecofy.generator.entities.improvement

import com.dotecofy.generator.entities.context.Kind
import com.dotecofy.generator.model.{Entity, Father}

object ImprovementKind {

  /*val fields: List[Field] = List(
    new Field("name", "name", "String", "varchar", mandatory = true, unique = true),
    new Field("description", "description", "String", "varchar", default = "null"),
  )*/

  val fathers: List[Father] = List(
    new Father(Improvement.entity, "idImprovement", "id_improvement"),
    new Father(Kind.entity, "idKind", "id_kind")
  )

  val entity: Entity = new Entity(
    "/improvement/improvementkind",
    "com.dotecofy.improvement.improvementkind",
    "ImprovementKind",
    "improvement_kind",
    fathers = fathers
  )
}
