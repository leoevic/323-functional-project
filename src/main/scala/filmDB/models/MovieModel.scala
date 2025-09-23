package filmDB.models

import filmDB.datatypes.Movie

import scala.collection.mutable.ListBuffer


/**
 * Movie model
 */
object MovieModel {
  private val movies: ListBuffer[Movie] = ListBuffer()
  private var autoIncrement: Int = 0



  /**
   * Add a movie to the model
   * @param id: Int
   * @param name: String
   * @param releaseYear: Int
   * @param budgetInMillions: bigDecimal
   * @return Int
   */
  def addMovie(id: Int, name: String, releaseYear: Int, budgetInMillions: BigDecimal): Int = {
    this.movies.addOne(Movie(id, name, releaseYear, budgetInMillions))
    id
  }



  /**
   * Get movies by a filter or without filter
   * @param filter
   * @return List[Movie]
   */
  def getMovies(filter: Option[(Movie => Boolean)]): List[Movie] =
    filter match
      case None => this.movies.toList
      case Some(f) => this.movies.filter(f).toList



  /**
   * Delete movies by a filter
   * @param filter
   */
  def deleteMovie(filter: Option[(Movie => Boolean)]): Unit =
    filter match
      case None => this.movies.empty
      case Some(f) => this.movies.dropWhile(f)


  /**
   * Edit a movie by a filter
   * @param newMovie
   * @param filter
   */
  def editMovie(newMovie: Movie, filter: Option[(Movie => Boolean)]): Unit =
    filter match
      case None => this.movies.mapInPlace(_ => newMovie)
      case Some(f) => this.movies.filter(f).mapInPlace(_ => newMovie)
}
