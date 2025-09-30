package filmDB.models

import filmDB.datatypes.Actor
import scala.collection.mutable.ListBuffer

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
}
