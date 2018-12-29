package com.dotecofy.generator.entities.workspace

import com.dotecofy.generator.entities.context.{Cycle, Kind, Layer}
import com.dotecofy.generator.model.{Entity, Field, Son}

object Workspace {

  val fields = List(
    new Field("name", "name", "String", "varchar", mandatory = true, unique = true, min = 3, max = 50),
    new Field("description", "description", "String", "varchar", default = "null", min = 0, max = 200),
  )

  val sons: List[Son] = List(
    new Son(Project.entity,  "idWorkspace", "id_workspace"),
    new Son(Cycle.entity, "idWorkspace", "id_workspace"),
    new Son(Kind.entity, "idWorkspace", "id_workspace"),
    new Son(Layer.entity, "idWorkspace", "id_workspace")
  )

  val entity = new Entity(
    "/workspace/workspace",
    "com.dotecofy.workspace.workspace",
    "Workspace",
    "workspace",
    fields = fields,
    sons = sons
  )
}
