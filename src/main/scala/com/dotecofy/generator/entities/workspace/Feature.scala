package com.dotecofy.generator.entities.workspace

import com.dotecofy.generator.model.{Entity, Field, Father}

object Feature {

  val fields: List[Field] = List(
    new Field("name", "name", "String", "varchar", mandatory = true, unique = true, min = 3, max = 50),
    new Field("description", "description", "String", "varchar", default = "null", min = 0, max = 200),
  )

  val fathers: List[Father] = List(
    new Father(Project.entity, "idProject", "id_project")
  )

  val entity: Entity = new Entity(
    "/workspace/feature",
    "com.dotecofy.workspace.feature",
    "Feature",
    "feature",
    fields = fields,
    fathers = fathers
  )

  //def entity = entityInst
  //def fathers = fathersInst
 // def fields = fieldsInst
}
