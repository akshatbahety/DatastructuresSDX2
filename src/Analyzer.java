import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;



/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		/* IMPLEMENT THIS METHOD! */

		/*
         *So this method reads every line in the file
         * breaks it into two parts a score(int) and a sentence (String)
         * So we achieve this by Reading the file using InputStream
         * And the Splitting each line into an Array using split method
         * then checking if the line is valid according to the given homework specifications
         *
         */

        ArrayList<Sentence> list = new ArrayList<>();

        Path file = Paths.get(filename);
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                //line =  reader.readLine();
                String temp[] = line.split(" ");
                String f = "";
                int tempi  = Integer.parseInt(temp[0]);

                if(tempi >= -2 && tempi <= 2) {
                     {
                        for(int i =1 ; i < temp.length ;i++ ) {
                            if(i == 1)
                                f = "" + temp[i];
                            else
                            f = f+ " " + temp[i] ;

                        }
                        list.add(new Sentence(tempi , f));
                    }
                }


            }
        } catch (IOException x) {
            System.err.println(x);
            return list;
        }


            if(list.isEmpty() || list.size() > 0)
            {
                return list;
            }

		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 2
	 */
	/*
	* Retrieve a Word object from HashSet<>
	*
	*
	* */

   protected static Word findIfPresent(Word source, HashSet<Word> set)
    {
        if (set.contains(source)) {
            for (Word obj : set) {
                if (obj.equals(source))
                    return obj;
            }
        }

        return null;
    }


	public static Set<Word> allWords(List<Sentence> sentences) {



		// IMPLEMENT THIS METHOD!
        HashSet<Word> hs = new HashSet<>();

        if(sentences != null && sentences.isEmpty() == false) {

            for (int i = 0; i < sentences.size(); i++) {

                Sentence s = sentences.get(i);

               if(s != null) {
                   String temp[] = ((s.getText()).toLowerCase()).split(" ");


                   for (int j = 0; j < temp.length; j++) {
                       if (temp[j].matches("^[a-z].*$")) {
                           Word x = new Word(temp[j]);
                           if (!hs.contains(x)) {
                               hs.add((x));
                           } else if (hs.contains(x)) {
                               Word w = findIfPresent(x, hs);
                               w.increaseTotal(1);
                           } else
                               continue;
                       }
                   }

               }
               else
                   continue;
            }

        }
        else
        {
            return hs;
        }
        if(hs.size() > 0)
            return hs;



		return null; // this line is here only so this code will compile if you don't modify

	}



	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		/* IMPLEMENT THIS METHOD! */
        //  if(words != null)

		HashMap<String , Double> hm = new HashMap<>();

		//Word w = new Word();

         if(words.isEmpty() == false && words != null)
       {
        for (Word w: words) {

            if (w != null) {

                double score;
                String text = "";
                score = w.calculateScore();
                text = w.getText();

                hm.put(text, score);
            } else
                continue;
        }
       }

        if(words == null)
        {
            return hm;
        }
        else if (words != null)
        {
            return hm;
        }
		
		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		/* IMPLEMENT THIS METHOD! */

        double score = 0.0;
        double sentenceScore = 0.0;
        String temp[] = sentence.toLowerCase().split(" ");
        for (int i = 0; i < temp.length; i++) {

            if(wordScores.containsKey(temp[i]))
            {
                 score = wordScores.get(temp[i]);
                 sentenceScore = sentenceScore + score;
            }
            else if(wordScores.containsKey(temp[i]) == false)
            {
                score = 0.0;
                sentenceScore = sentenceScore + score;
            }


        }

        sentenceScore = sentenceScore/temp.length;

        if(wordScores.isEmpty() || wordScores == null ||sentence == null || sentence.isEmpty())
        {
            return  0;
        }
        else if(wordScores.isEmpty() == false)
        {
            return sentenceScore;
        }





		
		return 0; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("reviews");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
