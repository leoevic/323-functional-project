package filmDB

import datatypes.Movie
import datatypes.Actor
import models.MovieModel
import models.ActorModel

import scala.language.postfixOps;
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt

/**
 * Main function
 * @return Unit
 */
@main def movieDBMain(): Unit =

  // Prepare variables
  var option: Int = 0
  var open: Boolean = true
  
  while open do
    // Get selection
    clearScreen()
    option = menu()
    clearScreen()

    // Select option
    option match
      case 1 => showAllMovies()
      case 2 => showMovieInformation()
      case 3 => addMovie()
      case 4 => editMovie()
      case 5 => deleteMovie()

      case 6 => showAllActors()
      case 7 => showActorInformation()
      case 8 => addActor()
      case 9 => editActor()
      case 10 => deleteActor()

      case 11 => exitApp()

      // Wait until user presses enter to continue
      println("Drücken Sie die Eingabetaste, um fortzufahren")
      scala.io.StdIn.readLine()





/**
 * Show menu of the movie database
 * Returns the index of the option
 * @return int
 */
def menu(): Int =
  println("1) Alle Filme anzeigen")
  println("2) Informationen über einen Film anzeigen")
  println("3) Film hinzufügen")
  println("4) Film bearbeiten")
  println("5) Film löschen")

  println("6) Alle Schauspieler anzeigen")
  println("7) Informationen über einen Schauspieler anzeigen")
  println("8) Schauspieler hinzufügen")
  println("9) Schauspieler bearbeiten")
  println("10) Schauspieler löschen")

  println("11) Anwendung beenden")

  try
    scala.io.StdIn.readInt()
  catch
    case nf: NumberFormatException =>
      println("Ungültige Eingabe.")
      -1


/**
 * Show all movies
 * @return Unit
 */
def showAllMovies(): Unit = {
  println("Übersicht über alle Filme")
  val movies = MovieModel.getMovies(None)
  if movies != Nil then
    movies.map(_.toString).foreach(println)
  else
    println("Keine Filme verfügbar")
}


/**
 * Show information about a specific movie
 * @return Unit
 */
def showMovieInformation(): Unit =
  println("Bitte geben Sie die Film-ID ein:")
  val filmId = scala.io.StdIn.readInt()

  // Get movie
  val filter = (movie: Movie) => movie.id == filmId
  val movieList = MovieModel.getMovies(Some(filter))
  if movieList.isEmpty then {
    println("Dieser Film existiert nicht.")
    return
  }

  // Show movie information
  val movie = movieList.head
  println(s"Film-ID: ${movie.id}")
  println(s"Name: ${movie.name}")
  println(s"Erscheinungsjahr: ${movie.releaseYear}")
  println(f"Budget in Millionen USD: ${movie.budgetInMillions}%.2f")



/**
 * Add a movie
 * @return Unit
 */
def addMovie(): Unit = {
  println("Film hinzufügen")
  println("Geben Sie die Film-ID ein:")
  val filmId = scala.io.StdIn.readInt()

  println("Geben Sie den Filmnamen ein:")
  val filmName = scala.io.StdIn.readLine()

  println("Geben Sie das Erscheinungsjahr ein:")
  val filmReleaseYear = scala.io.StdIn.readInt()

  println("Geben Sie den Kostenpunkt an (in Millionen USD):")
  val filmBudgetInMillions = BigDecimal(scala.io.StdIn.readDouble())

  // Check whether a movie with the same id already exists
  val movieFilter = (movie: Movie) => movie.id == filmId
  if MovieModel.getMovies(Some(movieFilter)).nonEmpty then {
    Console.err.println("Es existiert bereits ein Film mit dieser ID")
    return
  }

  // Create movie
  MovieModel.addMovie(filmId, filmName, filmReleaseYear, filmBudgetInMillions)
}


/**
 * Edit a movie
 * @return Unit
 */
def editMovie(): Unit = {
  println("Bitte geben Sie die Film-ID ein:")
  val filmId = scala.io.StdIn.readInt()

  // Get movie
  val filter = (movie: Movie) => movie.id == filmId
  val movieList = MovieModel.getMovies(Some(filter))
  if movieList.isEmpty then {
    println("Dieser Film existiert nicht.")
    return
  }

  // Get the movie itself
  val movieCurrent = movieList.head

  // Show current movie information
  println("Bisherige Film-Informationen")
  println(s"Name: ${movieCurrent.name}")
  println(s"Erscheinungsjahr: ${movieCurrent.releaseYear}")
  println(f"Budget in Millionen USD: ${movieCurrent.budgetInMillions}%.2f")

  // Edit info
  // Name
  println("Neuer Filmname (Leer lassen für keine Änderung)")
  var newFilmName = scala.io.StdIn.readLine()
  if newFilmName.isEmpty then
    newFilmName = movieCurrent.name

  // Release year
  println("Neues Erscheinungsjahr (Leer lassen für keine Änderung)")
  var newFilmReleaseYearInput = scala.io.StdIn.readLine()
  var newFilmReleaseYear: Int = 0
  if newFilmReleaseYearInput.nonEmpty then
    newFilmReleaseYear = newFilmReleaseYearInput.toInt
  else
    newFilmReleaseYear = movieCurrent.releaseYear

  // Budget in millions
  println("Neues Budget in Millionen (Leer lassen für keine Änderung")
  var newFilmBudgetInMillionsInput = scala.io.StdIn.readLine()
  var newFilmBudgetInMillions: BigDecimal = BigDecimal(0)
  if newFilmBudgetInMillionsInput.nonEmpty then
    newFilmBudgetInMillions = BigDecimal(parseDouble(newFilmBudgetInMillionsInput))
  else
    newFilmBudgetInMillions = movieCurrent.budgetInMillions

  // Prepare the filter function
  val replaceFilter = (movie: Movie) => movie.id == filmId
  MovieModel.editMovie(Movie(filmId, newFilmName, newFilmReleaseYear, newFilmBudgetInMillions), Some(replaceFilter))
}


/**
 * Delete a movie
 * @return Unit
 */
def deleteMovie(): Unit =
  // First, get all movies
  val movies = MovieModel.getMovies(None)
  if movies == Nil then {
    println("Es existieren keine Filme, die gelöscht werden können")
    return
  }

  // Ask for the movie id
  println("Bitte wählen Sie den Film aus, der gelöscht werden soll:")
  val filmId = scala.io.StdIn.readInt()
  val filter = (movie: Movie) => movie.id == filmId

  // Delete all movies
  MovieModel.deleteMovie(Some(filter))

  // Get difference of movies
  val newMovies = MovieModel.getMovies(None)
  val difference = movies.length - newMovies.length

  println(s"Es wurden ${difference} Filme gelöscht.")


/**
 * Show all actors
 * @return Unit
 */
def showAllActors(): Unit = {
  println("Übersicht über alle Schauspieler")
  val actors = ActorModel.getActors(None)
  if actors != Nil then
    actors.map(_.toString).foreach(println)
  else
    println("Keine Schauspieler verfügbar")
}


/**
 * Show information about a specific actor
 * @return Unit
 */
def showActorInformation(): Unit = {
  println("Bitte geben Sie die Schauspieler-ID ein:")
  val actorId = scala.io.StdIn.readInt()

  // Get actor
  val filter = (actor: Actor) => actor.id == actorId
  val actorList = ActorModel.getActors(Some(filter))
  if actorList.isEmpty then {
    println("Dieser Schauspieler existiert nicht.")
    return
  }

  // Show actor information
  val actor = actorList.head
  println(s"Schauspieler-ID: ${actor.id}")
  println(s"Name: ${actor.name}")
  println(s"Geburtsjahr: ${actor.bornYear}")
  if actor.diedYear.nonEmpty then
    println(s"Todesjahr: ${actor.diedYear.get}")
}


/**
 * TODO: Add an actor
 * @return Unit
 */
def addActor(): Unit = {
  println("Schauspieler hinzufügen")
  println("Geben sie die Schauspieler-ID ein:")
  val actorId = scala.io.StdIn.readInt()

  println("Geben Sie den Namen des Schauspielers ein:")
  val actorName = scala.io.StdIn.readLine()

  println("Geben Sie das Geburtsdatum des Schauspielers ein:")
  val actorBornYear = scala.io.StdIn.readInt()

  println("Geben Sie das Todesjahr des Schauspielers ein (leer lassen, falls er noch lebt):")
  val actorDiedYearInput = scala.io.StdIn.readLine()
  var actorDiedYear: Option[Int] = None
  if actorDiedYearInput.nonEmpty then actorDiedYear = Some(parseInt(actorDiedYearInput))
  
  // Add actor
  ActorModel.addActor(actorId, actorName, actorBornYear, actorDiedYear)
}


/**
 * TODO: Edit an actor
 * @return Unit
 */
def editActor(): Unit =
  println("TODO")


/**
 * TODO: Delete an actor
 * @return Unit
 */
def deleteActor(): Unit =
  println("TODO")



/**
 * Clear the screen
 * @return Unit
 */
def clearScreen(): Unit =
  for
    i <- 1 to 50
  do {
    println("")
  }



/**
 * Exit the application
 * @return Unit
 */
def exitApp(): Unit =
  // Give polite farewell to user :-)
  println("Bye")
  sys.exit