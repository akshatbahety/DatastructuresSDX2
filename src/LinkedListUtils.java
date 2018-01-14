

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
       else if(list == null)
       {
           System.exit(0);
       }

    }


    public static void removeMaximumValues(LinkedList<String> list, int N) {


		/* IMPLEMENT THIS METHOD! */




        if (list != null)
        {

            while(N > 0)
            {
                if(list.isEmpty()==false)
                {
                    //For refrence purposes this selects the first element of the
                    //list as the longest element
                    String longest = list.get(0);


                    //This part then selects the actual longest element
                    for (int i = 0 ; i < list.size()-1;i++ ) {

                        if(list.get(i+1).compareTo(list.get(i)) > 0 ) {
                            longest = list.get(i+1);
                        }
                    }

                    for (int i = list.size() -1; i >=0; i-- ) {

                        if(longest.equals(list.get(i))) {
                            list.remove(i);
                        }



                    }



                    N--;

                }
                else{
                    break;
                }

            }

        }


    }


    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		/* IMPLEMENT THIS METHOD! */

        try {

                if (one.isEmpty() == false && two.isEmpty() == false) {


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

                if(one.isEmpty() || two.isEmpty())
                {
                    return false;
                }



        }catch(NullPointerException ex) {
            System.out.println(ex);
        }



        return false;


//line is here only so this code will compile if you don't m
    }

}
