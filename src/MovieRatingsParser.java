/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		/* IMPLEMENT THIS METHOD! */

		TreeMap<String,PriorityQueue<Integer>> tm = new TreeMap<>();

            /*Iterates over each element from the given list
            *  Checks if the TreeMap contains the specific movie or not
            *  If it doesn't have the movie adds it to the TreeMap by adding a PriorityQueue (Heap) with its rating
            *
            *  If it does have the movie updates the Heap of that movie and
            *  adds it back again with the updated value
            */

        for (UserMovieRating a : allUsersRatings) {


            if(a == null  || a.getMovie().equals("") || a.getMovie() == null || a.getUserRating() < 0) {
                continue;
            }
                String movie = a.getMovie().toLowerCase();

            if(!tm.containsKey(movie)) {
                PriorityQueue<Integer> temp = new PriorityQueue<>();
                temp.add(a.getUserRating());
                tm.put(movie,temp);

            }
            else if(tm.containsKey(movie)) {
                PriorityQueue<Integer> copy = tm.get(movie);
                copy.add(a.getUserRating());
                tm.put(movie,copy);

            }
        }

        if(allUsersRatings == null || allUsersRatings.isEmpty())
            return tm;
        else if(allUsersRatings != null)
            return tm;



		return null; // this line is here only so this code will compile if you don't modify it
	}

}
