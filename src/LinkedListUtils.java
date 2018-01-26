

import java.util.Collections;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

    public static void insertSorted(LinkedList<Integer> list, int value) {

		/* IMPLEMENT THIS METHOD! */
       if(list != null) {
           if (list.size() > 0) {

        	/*
        	* The below code implements
        	* the most basic need of this function
        	* to insert a value within a sorted list
        	* it checks the list for the next value and then compares it with the given value
        	* if value needs to be added it should satisfy two different conditions
        	* it should be greater than the element before it and less than the element after it
        	* if this is satisfied it adds the value after the element it was greater than
        	* */

               if (list.size() > 1) {
                   for (int i = 0; i < list.size() - 1; i++) {

                       if (list.get(i) < value && value < list.get(i + 1)) {
                           list.add(i + 1, value); //add (index,element)
                           break;
                       }
                       if (list.get(i) == value) {
                           list.add(i + 1, value);
                       }

                   }
               }

            /*
            * The Below code implements a
            * addition of value either at end of the list
            * or at the start of the list
            * */


               if (list.getLast() < value) {
                   list.addLast(value);
               } else if (list.getFirst() > value) {
                   list.addFirst(value);
               }

           } else {
               list.add(value);
           }

       }


    }


    public static void removeMaximumValues(LinkedList<String> list, int N) {


		/* IMPLEMENT THIS METHOD! */

        if(list != null && !list.isEmpty())
        {
            int counter = 0;

            while(counter < N && !list.isEmpty()) {
                //This part then selects the actual longest element
                String l = Collections.max(list);
                while (list.contains(l)) {
                    list.remove(l);
                }
                    counter++;
            }

        }


    }






    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		/* IMPLEMENT THIS METHOD! */



                if (one != null && two != null && !one.isEmpty() && !two.isEmpty()) {


                    LinkedList<Integer> ll = new LinkedList<>(); //list to sort


                    int flag = 0, counter = 0;

                    for (int j = 0; j < two.size(); j++) {

                        inner:
                        for (int i = 0; i < one.size(); i++) {

                            if (two.get(j) == one.get(i)) {
                                flag++;
                                ll.add(i);
                                break inner;
                            }

                        }

                    }

                    for (int i = 0; i < ll.size() - 1; i++) {

                        if (ll.get(i + 1) < ll.get(i)) {
                            counter++;
                            break;
                        }

                    }


                    if (flag == two.size() && counter == 0) {
                        return true;
                    } else {
                        return false;
                    }

                }
                else





        return false;


//line is here only so this code will compile if you don't m
    }

}
