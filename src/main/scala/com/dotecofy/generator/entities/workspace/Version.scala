package com.dotecofy.generator.entities.workspace

import com.dotecofy.generator.entities.improvement.{Improvement, ImprovementVersion}
import com.dotecofy.generator.model._

object Version {

  val fields: List[Field] = List(
    new Field("version", "version", "String", "varchar", mandatory = true, unique = true, min = 1, max = 25),
    new Field("description", "description", "String", "varchar", default = "null", min = 0, max = 200),
  )

  val fathers: List[Father] = List(
    new Father(Project.entity, "idProject", "id_project")
  )

  val sons: List[Son] = List(
    new Son(Improvement.entity, "idVersion", "id_version", ImprovementVersion.entity, "idImprovement", "id_improvement"),
  )

  val entity: Entity = new Entity(
    "/workspace/version",
    "com.dotecofy.workspace.version",
    "Version",
    "version",
    fields = fields,
    fathers = fathers,
    signature = new Signature(generateFrom = "version"),
    sons = sons
  )

  /*def entity = entityInst
  def fathers = fathersInst
  def fields = fieldsInst*/
}
