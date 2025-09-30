package filmDB.models

import filmDB.datatypes.Actor

import scala.collection.mutable.ListBuffer


/**
 * Actor model
 */
object ActorModel {
    private val actors: ListBuffer[Actor] = ListBuffer()

  

  /**
   * Add an actor to the model
   * @param id
   * @param name
   * @param bornYear
   * @param diedYear
   * @return Int
   */
  def addActor(id: Int, name: String, bornYear: Int, diedYear: Option[Int]): Int = {
    this.actors.addOne(Actor(id, name, bornYear, diedYear))
    id
  }

  

  /**
   * Get actors by a filter or without filter
   * @param filter
   * @return
   */
  def getActors(filter: Option[(Actor => Boolean)]): List[Actor] =
    filter match
      case None => this.actors.toList
      case Some(f) => this.actors.filter(f).toList


  
  /**
   * Delete actors by filter
   * @param filter
   */
  def deleteActor(filter: Option[(Actor => Boolean)]): Unit =
    filter match
      case None => this.actors.empty
      case Some(f) => this.actors.dropWhileInPlace(f)

  

  /**
   * Edit an actor by a filter
   * @param newActor
   * @param filter
   */
  def editActor(newActor: Actor, filter: Option[Actor => Boolean]): Unit = {
    filter match
      case None => this.actors.mapInPlace(_ => newActor)
      case Some(filterValue) => this.actors.mapInPlace { actor => 
        if filterValue(actor) then
          newActor
        else actor
      }
  }
}
