import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		/* IMPLEMENT THIS METHOD! */

		Queue<HtmlTag> copy = tags;
        Stack<HtmlTag> stack1 = new Stack<>();


        //This solves the basic problem of checking if the tags are in the correct order

      while(copy.size() > 0)
      {
          HtmlTag check = copy.remove();
          if (check.isOpenTag() && !check.isSelfClosing())
          {
              stack1.push(check);
          }
          else if (check.isOpenTag() == false)
          {

             if(stack1.size() > 0) {

                 if ((stack1.peek()).matches(check)) {
                     stack1.pop();
                 } else {
                     return stack1;
                 }

             }
             else{
                 return null;
             }
          }

      }
        if(stack1.size() > 0 || stack1.empty()) {
            return stack1;
        }


		return null; // this line is here only so this code will compile if you don't modify it
	}


    public static void main(String[] args) {

        HtmlReader hr = new HtmlReader();
        Queue<HtmlTag> q = null;
        try {
            q = hr.getTagsFromHtmlFile("H:\\Education\\test.htm");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stack<HtmlTag> s = new Stack<>();
        s = isValidHtml(q);

        System.out.println(s);


    }


}

