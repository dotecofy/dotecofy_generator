package com.dotecofy.generator.entities.improvement

import com.dotecofy.generator.entities.context.Cycle
import com.dotecofy.generator.model.{Entity, Father, Signature}

object ImprovementCycle {

  val fathers: List[Father] = List(
    new Father(Improvement.entity, "idImprovement", "id_improvement"),
    new Father(Cycle.entity, "idCycle", "id_cycle")
  )

  val entity: Entity = new Entity(
    "/improvement/improvementcycle",
    "com.dotecofy.improvement.improvementcycle",
    "ImprovementCycle",
    "improvement_cycle",
    signature = new Signature(generateFrom = "_random"),
    fathers = fathers,
  )
}
