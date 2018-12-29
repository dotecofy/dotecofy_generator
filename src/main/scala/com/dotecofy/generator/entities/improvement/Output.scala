package com.dotecofy.generator.entities.improvement

import com.dotecofy.generator.entities.workspace.Feature
import com.dotecofy.generator.model._

object Output {

  val fields: List[Field] = List(
    //new Field("name", "name", "String", "varchar", mandatory = true, unique = true, min = 3, max = 50),
    new Field("remark", "remark", "String", "varchar", default = "null", min = 0, max = 200),
  )

  val fathers: List[Father] = List(
    new Father(Assignment.entity, "idAssignment", "id_assignment"),
    new Father(ImprovementCycle.entity, "idImprCycle", "id_impr_cycle")
  )

  val sons: List[Son] = List(
    new Son(Feature.entity,"idOutput", "id_output"),
  )

  val entity: Entity = new Entity(
    "/improvement/output",
    "com.dotecofy.improvement.output",
    "Output",
    "output",
    signature = new Signature(generateFrom = "_random"),
    fields = fields,
    fathers = fathers
  )
}
