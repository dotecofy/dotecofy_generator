package com.dotecofy.generator.entities.improvement

import com.dotecofy.generator.model.{Entity, Father, Field}

object Assignment {

  val fields: List[Field] = List(
    new Field("name", "name", "String", "varchar", mandatory = true, unique = true, min = 3, max = 50),
    new Field("description", "description", "String", "varchar", default = "null", min = 0, max = 200),
  )

  val fathers: List[Father] = List(
    new Father(Improvement.entity, "idImprovement", "id_improvement"),
    new Father(ImprovementKind.entity, "idImprKind", "id_impr_kind")
  )

  val entity: Entity = new Entity(
    "/improvement/assignment",
    "com.dotecofy.improvement.assignment",
    "Assignment",
    "assignment",
    fields = fields,
    fathers = fathers,
  )
}
