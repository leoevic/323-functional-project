package filmDB.datatypes


/**
 * Movie case class (dataset)
 * @param id
 * @param name
 * @param releaseYear
 * @param budgetInMillions
 */
case class Movie(id: Int, name: String, releaseYear: Int, budgetInMillions: BigDecimal) {

  /**
   * Format movie to string
   * @return String
   */
  override def toString: String =
    f"Film ${this.id} - ${this.name}: Erschienen ${this.releaseYear}, Kostenpunkt: USD M${this.budgetInMillions}%.2f"
}