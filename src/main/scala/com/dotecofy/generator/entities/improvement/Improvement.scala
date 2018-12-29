package com.dotecofy.generator.entities.improvement

import com.dotecofy.generator.entities.context._
import com.dotecofy.generator.entities.workspace.{Feature, Version}
import com.dotecofy.generator.model.{Entity, Father, Field, Son}

object Improvement {

  val fields: List[Field] = List(
    new Field("name", "name", "String", "varchar", mandatory = true, unique = true, min = 3, max = 50),
    new Field("description", "description", "String", "varchar", default = "null", min = 0, max = 200),
  )

  val fathers: List[Father] = List(
    new Father(Feature.entity, "idFeature", "id_feature")
  )

  val sons: List[Son] = List(
    new Son(Assignment.entity, "idImprovement", "id_improvement"),
    new Son(Cycle.entity, "idImprovement", "id_improvement", ImprovementCycle.entity, "idCycle", "id_cycle"),
    new Son(Layer.entity, "idImprovement", "id_improvement", ImprovementLayer.entity, "idLayer", "id_layer"),
    new Son(Version.entity, "idImprovement", "id_improvement", ImprovementVersion.entity, "idVersion", "id_version"),
    new Son(Kind.entity, "idImprovement", "id_improvement", ImprovementKind.entity, "idKind", "id_kind"),
  )

  val entity: Entity = new Entity(
    "/improvement/improvement",
    "com.dotecofy.improvement.improvement",
    "Improvement",
    "improvement",
    fields = fields,
    fathers = fathers,
    sons = sons
  )
}
