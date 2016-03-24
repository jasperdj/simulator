package com.knoldus.repo

import com.knoldus.connection.{DBComponent, H2DBImpl}

import scala.concurrent.Future


trait Bk_Scala_UP_Repository extends Bk_Scala_UP_Table { this: DBComponent =>

  import driver.api._

  /**
    * @param row
    * update existing bank
    */
  def update(row: Bk_Scala_UP): Future[Int] = db.run { bankTableQuery.filter(_.id === row.id.get).update(row) }


  //def ddl=db.run {bankTableQuery.schema.create}

}

 trait Bk_Scala_UP_Table { this: DBComponent =>

  import driver.api._

   class Bk_Scala_UP_Table(tag: Tag) extends Table[Bk_Scala_UP](tag, "Bk_Scala_") {
    val id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    val name = column[String]("name")
    def * = (name, id.?) <> (Bk_Scala_UP.tupled, Bk_Scala_UP.unapply)

  }

  protected val bankTableQuery = TableQuery[BankTable]

  protected def bankTableAutoInc = bankTableQuery returning bankTableQuery.map(_.id)

}

//for demo(connected to H2 in memory database )
trait Bk_Scala_UP_RepositoryImpl extends Bk_Scala_UP_Repository with H2DBImpl

//use this for production
//trait BankRepositoryImpl extends  Bk_Scala_UP_Repository with MySQLDBImpl

case class Bk_Scala_UP(name: String, id: Option[Int] = None)
