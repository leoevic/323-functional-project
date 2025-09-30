package filmDB.datatypes

case class Actor(id: Int, name: String, bornYear: Int, diedYear: Option[Int]) {

  /**
   * Format actor to string
   * @return String
   */
  override def toString: String =
    f"Schauspieler ${this.id} - ${this.name}: Geboren ${this.bornYear}, Verstorben ${this.diedYear.getOrElse("-")}"
}
