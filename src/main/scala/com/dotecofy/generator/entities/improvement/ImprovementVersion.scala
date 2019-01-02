package com.dotecofy.generator.entities.improvement

import com.dotecofy.generator.model.{Entity, Father, Signature}
import com.dotecofy.generator.entities.workspace.Version

object ImprovementVersion {

  val fathers: List[Father] = List(
    new Father(Improvement.entity, "idImprovement", "id_improvement"),
    new Father(Version.entity, "idVersion", "id_version")
  )

  val entity: Entity = new Entity(
    "/improvement/improvementversion",
    "com.dotecofy.improvement.improvementversion",
    "ImprovementVersion",
    "improvement_version",
    signature = new Signature(generateFrom = "_random"),
    fathers = fathers
  )
}
