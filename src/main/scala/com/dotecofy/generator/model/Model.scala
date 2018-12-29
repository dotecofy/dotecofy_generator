package com.dotecofy.generator.model

class Field(val name: String,
            val dbName: String,
            val dataType: String,
            val dbType: String,
            val mandatory: Boolean = false,
            val insert: Boolean = true,
            val update: Boolean = true,
            val unique: Boolean = false,
            val generated: Boolean = false,
            val default: String = "",
            val min: Int = -1,
            val max: Int = -1)

class Father(_entity: => Entity,
             val name: String,
             val dbName: String,
             val dataType: String = "Int",
             val dbType: String = "int",
             val middleEntity: Entity = null,
             val middleEntityFieldName: String = null,
             val middleEntityDbFieldName: String = null,
             val mandatory: Boolean = true,
             val insert: Boolean = true,
             val update: Boolean = false) {
  lazy val entity: Entity = _entity
}

class Son(_entity: => Entity,
          val name: String,
          val dbName: String,
          _middleEntity: => Entity = null,
          val middleEntityFieldName: String = null,
          val middleEntityDbFieldName: String = null) {
  lazy val entity: Entity = _entity
  lazy val middleEntity: Entity = _middleEntity
}

class Signature(val name: String = "signature",
                val dbName: String = "signature",
                val generated: Boolean = true,
                val update: Boolean = true,
                val generateFrom: String = "name")

class Id(val name: String,
         val dbName: String,
         val dataType: String,
         val dbType: String,
         val generated: Boolean = true,
         val default: String = "0")

class Entity(val folder: String,
             val pkg: String,
             val name: String,
             val dbName: String,
             val id: Id = new Id("id", "id", "Int", "int"),
             val signature: Signature = new Signature,
             var fields: List[Field] = List(),
             var fathers: List[Father] = List(),
             var sons: List[Son] = List(),
             val createdDate: Boolean = true,
             val updatedDate: Boolean = true)

case class Link(name: String,
                link: String,
                active: Boolean)