package com.dotecofy.generator.entities.context

import com.dotecofy.generator.entities.improvement.{Improvement, ImprovementKind}
import com.dotecofy.generator.entities.workspace.Workspace
import com.dotecofy.generator.model.{Entity, Father, Field, Son}

object Kind {

  val fields: List[Field] = List(
    new Field("name", "name", "String", "varchar", mandatory = true, unique = true, min = 3, max = 50),
    new Field("description", "description", "String", "varchar", default = "null", min = 0, max = 200),
  )

  val fathers: List[Father] = List(
    new Father(Workspace.entity, "idWorkspace", "id_workspace")
  )

  val sons: List[Son] = List(
    new Son(Improvement.entity, "idKind", "id_kind", ImprovementKind.entity, "idImprovement", "id_improvement"),
  )

  val entity: Entity = new Entity(
    "/context/kind",
    "com.dotecofy.context.kind",
    "Kind",
    "kind",
    fields = fields,
    fathers = fathers,
    sons = sons
  )

}
