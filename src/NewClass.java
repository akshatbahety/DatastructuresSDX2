

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

class letmework {

    static void removeMaximumValues(LinkedList<String> list, int N) {


        /* IMPLEMENT THIS METHOD! */

        if (list != null && list.isEmpty())
        {

            while(N > 0)
            {

                String longest = list.get(0);


                for (int i = 0 ; i < list.size();i++ ) {

                    if(list.get(i+1).compareTo(list.get(i)) > 0 ) {
                        longest = list.get(i+1);
                    }
                }

                for (int i = 0 ; i < list.size(); i++ ) {

                    if(longest.equals(list.get(i))) {
                        list.remove(i);
                    }
                }

                N--;
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(list.get(i));
                }
            }

        }

    }


 public   static void main(String[] args) {
        LinkedListUtils llu =  new LinkedListUtils();

        LinkedList <String> list = new LinkedList<>();
        list.add("AkshatB");
        list.add("Bahety");
        list.add("Rambo");
        list.add("India");
        list.add("Game");

        int N = 2;


            while(N > 0)
            {

                String longest = list.get(0);

                System.out.println(list.size() + "");
                for (int i = 0 ; i < list.size()-1;i++ ) {

                    if(list.get(i+1).compareTo(list.get(i)) > 0 ) {
                        longest = list.get(i+1);
                    }
                }

                for (int i = 0 ; i < list.size(); i++ ) {

                    if(longest == list.get(i)) {
                        list.remove(i);
                    }


                }

                N--;
                for (int j = 0; j < list.size(); j++) {
                    System.out.println(list.get(j));
                }

            }


        }

    }




