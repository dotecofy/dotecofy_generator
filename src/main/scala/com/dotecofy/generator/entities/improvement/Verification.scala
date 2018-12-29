package com.dotecofy.generator.entities.improvement

import com.dotecofy.generator.model.{Entity, Father, Field, Signature}

object Verification {

  val fields: List[Field] = List(
    new Field("remark", "remark", "String", "varchar", default = "null", min = 0, max = 200),
  )

  val fathers: List[Father] = List(
    new Father(Output.entity, "idOutput", "id_output")
  )

  val entity: Entity = new Entity(
    "/workspace/verification",
    "com.dotecofy.workspace.verification",
    "Verification",
    "verification",
    signature = new Signature(generateFrom = "_random"),
    fields = fields,
    fathers = fathers,
  )

}
