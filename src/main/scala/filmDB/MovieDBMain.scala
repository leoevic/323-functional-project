package filmDB

import datatypes.Movie
import datatypes.Actor
import models.MovieModel
import models.ActorModel

import scala.language.postfixOps;

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
  val moviesAsString = MovieModel.getMovies(None)
  if moviesAsString != Nil then
    moviesAsString.map(_.toString).foreach(println)
  else
    println("Keine Filme verfügbar")
}


/**
 * TODO: Show information about a specific movie
 * @return Unit
 */
def showMovieInformation(): Unit =
  println("TODO")


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
 * TODO: Edit a movie
 * @return Unit
 */
def editMovie(): Unit =
  println("TODO")


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
 * TODO: Show all actors
 * @return Unit
 */
def showAllActors(): Unit =
  println("TODO")


/**
 * TODO: Show information about a specific actor
 * @return Unit
 */
def showActorInformation(): Unit =
  println("TODO")


/**
 * TODO: Add an actor
 * @return Unit
 */
def addActor(): Unit =
  println("TODO")


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