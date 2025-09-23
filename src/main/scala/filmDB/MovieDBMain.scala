package filmDB



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

      case 11 => open = false

  // Give polite farewell to user :-)
  println("Bye")



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
 * TODO: Show all movies
 * @return Unit
 */
def showAllMovies(): Unit =
  println("TODO")


/**
 * TODO: Show information about a specific movie
 * @return Unit
 */
def showMovieInformation(): Unit =
  println("TODO")


/**
 * TODO: Add a movie
 * @return Unit
 */
def addMovie(): Unit =
  println("TODO")


/**
 * TODO: Edit a movie
 * @return Unit
 */
def editMovie(): Unit =
  println("TODO")


/**
 * TODO: Delete a movie
 * @return Unit
 */
def deleteMovie(): Unit =
  println("TODO")


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
  do
    println("")