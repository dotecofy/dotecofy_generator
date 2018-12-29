package com.dotecofy.generator.entities.workspace

import com.dotecofy.generator.model.{Entity, Father, Field, Son}

object Project {

  val fields: List[Field] = List(
    new Field("name", "name", "String", "varchar", mandatory = true, unique = true, min = 3, max = 50),
    new Field("description", "description", "String", "varchar", default = "null", min = 0, max = 200),
  )

  val sons: List[Son] = List(
    new Son(Feature.entity, "idProject", "id_project"),
    new Son(Version.entity, "idProject", "id_project")
  )

  val fathers: List[Father] = List(
    new Father(Workspace.entity, "idWorkspace", "id_workspace")
  )

  val entity: Entity = new Entity(
    "/workspace/project",
    "com.dotecofy.workspace.project",
    "Project",
    "project",
    fields = fields,
    fathers = fathers,
    sons = sons
  )

  //def entity = entityInst
  /*def fathers = fathersInst
  def fields = fieldsInst
  def sons = sonsInst*/

}
