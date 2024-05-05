import java.util.InputMismatchException;
import java.util.Scanner;

public class MovieModule {
    private Movie[] movies;

    public MovieModule() {
        // Initialize the movie array here
        initMovies();
    }

    private void initMovies() {
        this.movies = new Movie[] {
            new Movie("Star Wars", "English", "Sci-Fi", "3:00PM", "13+", 2),
            new Movie("Your Name", "Japanese", "Fiction", "5:00PM", "13+", 5),
            new Movie("Deadpool", "English", "Comics", "5:00PM", "18+", 1),
            new Movie("Among Us", "English", "Sci-Fi", "8:00PM", "13+", 3),
            new Movie("Imposter", "English", "History", "9:00PM", "18+", 4)
        };
    }

    // Method to add new movies
    public void addMovie(Movie movie) {
        // Create a new array with increased size to accommodate the new movie
        Movie[] updatedMovies = new Movie[movies.length + 1];
        // Copy existing movies to the new array
        System.arraycopy(movies, 0, updatedMovies, 0, movies.length);
        // Add the new movie to the end of the array
        updatedMovies[movies.length] = movie;
        // Update the movies array reference to point to the new array
        movies = updatedMovies;
    }

    public void displayMovies() {
        System.out.println("\nAvailable Movies for today: ");
        Movie movie = new Movie();
        movie.movieTableHeader();

        for (int i = 0; i < this.movies.length; i++) {
            System.out.printf("|%-3d", i + 1);
            this.movies[i].printMovieDetails();
        }
        PaymentUtil.printLine();
    }

    public int selectMovie() {
        Movie movie = new Movie();
        return movie.inputValidation(this.movies);
    }

    public Movie getSelectedMovie(int index) {
        return this.movies[index];
    }
}
