package com.dotecofy.generator

import java.io._
import java.nio.file.{Files, Path, Paths}

import com.dotecofy.generator.entities.access.{User, Group}
import com.dotecofy.generator.entities.context.{Cycle, Kind, Layer}
import com.dotecofy.generator.entities.improvement.{Assignment, Improvement, Output, Verification}
import com.dotecofy.generator.entities.workspace.{Feature, Project, Version, Workspace}
import com.dotecofy.generator.model.{Entity, Link}
import org.fusesource.scalate.TemplateEngine

import scala.collection.mutable.ListBuffer

object CRUDGenerator {

  val frontEndSrc: Path = Paths.get("/home/joel/dest_cloud/dotecofy/dotecofy_ui/src/")
  val backEndSrc: Path = Paths.get("/home/joel/dest_cloud/dotecofy/dotecofy/src/main/scala/com/dotecofy/")
  val backEndTestSrc: Path = Paths.get("/home/joel/dest_cloud/dotecofy/dotecofy/src/test/scala/com/dotecofy/")

  val engine = new TemplateEngine()

  def genCRUDRepository(path: Path, entity: Entity): Unit = {
    val src: Path = Paths.get(path.toString, entity.folder)

    if (!Files.exists(src)) {
      Files.createDirectories(src)
    }

    val
    output = engine.layout("templates/CRUDRepository.ssp", Map("entity" -> entity))

    val pw = new PrintWriter(new File(src + "/" + entity.name + "Repository.scala"))
    pw.write(output)
    pw.close

  }

  def genCRUDServices(path: Path, entity: Entity): Unit = {
    val src: Path = Paths.get(path.toString, entity.folder)

    if (!Files.exists(src)) {
      Files.createDirectories(src)
    }

    val
    output = engine.layout("templates/CRUDServices.ssp", Map("entity" -> entity))

    val pw = new PrintWriter(new File(src + "/" + entity.name + "Services.scala"))
    pw.write(output)
    pw.close
  }

  def genCRUDAPI(path: Path, entity: Entity): Unit = {
    val src: Path = Paths.get(path.toString, entity.folder)

    if (!Files.exists(src)) {
      Files.createDirectories(src)
    }

    val
    output = engine.layout("templates/CRUDAPI.ssp", Map("entity" -> entity))

    val pw = new PrintWriter(new File(src + "/" + entity.name + "API.scala"))
    pw.write(output)
    pw.close
  }

  def genCRUDList(path: Path, entity: Entity): Unit = {
    val src: Path = Paths.get(path.toString, entity.folder)

    if (!Files.exists(src)) {
      Files.createDirectories(src)
    }

    val
    output = engine.layout("templates/ui/CRUDList.ssp", Map("entity" -> entity))

    val pw = new PrintWriter(new File(src + "/" + entity.name + "s.vue"))
    pw.write(output)
    pw.close
  }

  def genCRUDDetail(path: Path, entity: Entity): Unit = {
    val src: Path = Paths.get(path.toString, entity.folder)

    if (!Files.exists(src)) {
      Files.createDirectories(src)
    }

    val
    output = engine.layout("templates/ui/CRUDDetail.ssp", Map("entity" -> entity))

    val pw = new PrintWriter(new File(src + "/" + entity.name + ".vue"))
    pw.write(output)
    pw.close
  }

  def genCRUDNew(path: Path, entity: Entity): Unit = {
    val src: Path = Paths.get(path.toString, entity.folder)

    if (!Files.exists(src)) {
      Files.createDirectories(src)
    }

    val
    output = engine.layout("templates/ui/CRUDNew.ssp", Map("entity" -> entity))

    val pw = new PrintWriter(new File(src + "/New" + entity.name + ".vue"))
    pw.write(output)
    pw.close
  }

  def genCRUDSonList(path: Path, entity: Entity): Unit = {
    val src: Path = Paths.get(path.toString, entity.folder)

    if (!Files.exists(src)) {
      Files.createDirectories(src)
    }

    var output: String = null

    for (son <- entity.sons) {

      val links = new ListBuffer[Link]
      links.append(Link("Detail","{path: '/"+entity.name.toLowerCase+"s/' + this.$route.params.signature}", false))
      for (son2 <- entity.sons) {
        links.append(Link(son2.entity.name+"s", "{path: '/"+entity.name.toLowerCase+"s/' + this.$route.params.signature +'/"+son2.entity.name.toLowerCase+"s'}", son.entity.name.equals(son2.entity.name)))
      }

      output = engine.layout("templates/ui/CRUDSonList.ssp", Map("entity" -> son.entity, "fatherName" -> entity.name, "links" -> links.toList))

      val pw = new PrintWriter(new File(src + "/" + entity.name + son.entity.name + ".vue"))
      pw.write(output)
      pw.close
    }
  }

  def genCRUDFrontEndRouter(path: Path, entities: List[Entity]): Unit = {
    val src: Path = Paths.get(path.toString, "routes")

    if (!Files.exists(src)) {
      Files.createDirectories(src)
    }

    val
    output = engine.layout("templates/ui/CRUDRouter.ssp", Map("entities" -> entities))

    val pw = new PrintWriter(new File(src + "/GeneratedRoutes.js"))
    pw.write(output)
    pw.close
  }

  def genTestCRUDService(path: Path, entity:Entity): Unit = {
    val src: Path = Paths.get(path.toString, entity.folder)

    if (!Files.exists(src)) {
      Files.createDirectories(src)
    }

    val
    output = engine.layout("templates/test/TestCRUDServices.ssp", Map("entity" -> entity))

    val pw = new PrintWriter(new File(src + "/Test" + entity.name + "Services.scala"))
    pw.write(output)
    pw.close
  }

  def main(args: Array[String]): Unit = {

    val entities: List[Entity] = List(
      Workspace.entity,
      Project.entity,
      Feature.entity,
      Version.entity,
      Layer.entity,
      Cycle.entity,
      Kind.entity,
      Improvement.entity,
      Assignment.entity,
      Output.entity,
      Verification.entity,
      User.entity,
      Group.entity,

    )

    for (entity <- entities) {
      println("ENTITY:" + entity.name)
      genCRUDRepository(backEndSrc, entity)
      genCRUDServices(backEndSrc, entity)
      genCRUDAPI(backEndSrc, entity)
      genCRUDList(frontEndSrc, entity)
      genCRUDDetail(frontEndSrc, entity)
      genCRUDNew(frontEndSrc, entity)
      genCRUDSonList(frontEndSrc, entity)

      genTestCRUDService(backEndTestSrc, entity)
    }

    genCRUDFrontEndRouter(frontEndSrc, entities)

    /*output = engine.layout("templates/CRUDServices.ssp", Map("entity" -> entity))
    pw = new PrintWriter(new File("/home/joel/dest_cloud/dotecofy/dotecofy/src/main/scala/com/dotecofy/workspace/feature/FeatureServices.scala"))
    pw.write(output)
    pw.close

    output = engine.layout("templates/CRUDAPI.ssp", Map("entity" -> entity))
    pw = new PrintWriter(new File("/home/joel/dest_cloud/dotecofy/dotecofy/src/main/scala/com/dotecofy/workspace/feature/FeatureAPI.scala"))
    pw.write(output)
    pw.close


    output = engine.layout("templates/ui/CRUDList.ssp", Map("entity" -> entity))
    pw = new PrintWriter(new File("/home/joel/dest_cloud/dotecofy/dotecofy_ui/src/workspace/feature/Features.vue"))
    pw.write(output)
    pw.close*/
  }

}