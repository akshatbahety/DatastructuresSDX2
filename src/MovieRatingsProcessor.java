/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import sun.reflect.generics.tree.Tree;

import java.util.*;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		
		/* IMPLEMENT THIS METHOD! *
		 */
        ArrayList<String> list = new ArrayList<>();

        if (movieRatings == null || movieRatings.isEmpty())
            return list;

        Set<String> temp = movieRatings.keySet();
        for (String a : temp)
        {
            list.add(a);
        }


        if(list.size()> 0)
            return list;

        return null; // this line is here only so this code will compile if you don't modify it
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
        ArrayList<String> list = new ArrayList<>();

        if (movieRatings == null || movieRatings.isEmpty())
            return list;

        Set<String> set = movieRatings.keySet();

        for(String s : set) {
                PriorityQueue<Integer> pq = movieRatings.get(s);
            if(pq.peek() > rating)
                list.add(s);
        }

        if(list.size() > 0 || list.isEmpty())
         return  list;
		
		return null; // this line is here only so this code will compile if you don't modify it
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */

		TreeMap<String , Integer> tm = new TreeMap<>();
		ArrayList<String> templ = new ArrayList<>();
        if (movieRatings == null || movieRatings.isEmpty())
            return tm;

        Set<String> set = movieRatings.keySet();

        for(String s : set)
        {

            PriorityQueue<Integer> pq = movieRatings.get(s);
            List<Integer> list = new ArrayList<>(pq);
            int temp = pq.size();
            int counter = 0;

            for (int a : list) {

                if(a < rating) {
                    pq.remove(a);
                    counter++;
                }
            }

            if(counter == temp) {
                templ.add(s);
            }

            if(counter > 0)
                tm.put(s,counter);

        }

        for(String s : templ)
        {
            movieRatings.remove(s);
        }


        if(tm.size() > 0 || tm.isEmpty())
            return tm;


        return null; // this line is here only so this code will compile if you don't modify it
	}
}
