package com.dotecofy.generator.entities.improvement

import com.dotecofy.generator.model.{Entity, Father, Signature}
import com.dotecofy.generator.entities.context.Layer

object ImprovementLayer {

  val fathers: List[Father] = List(
    new Father(Improvement.entity, "idImprovement", "id_improvement"),
    new Father(Layer.entity, "idLayer", "id_layer")
  )

  val entity: Entity = new Entity(
    "/improvement/improvementlayer",
    "com.dotecofy.improvement.improvementlayer",
    "ImprovementLayer",
    "improvement_layer",
    signature = new Signature(generateFrom = "_random"),
    fathers = fathers
  )
}
