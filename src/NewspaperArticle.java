/*
 * SD2x Homework #9
 * This class represents a newspaper article.
 * Refactor the code according to the suggestions in the assignment description.
 */
import java.util.*;

public class NewspaperArticle extends Document {

	private int startPage;
	private int endPage;
	private Set<String> editors;
	private String newspaper;



	public NewspaperArticle(String title, String author, int startPage, int endPage, Set<String> editors, String newspaper, Date date, String city, String state, String postCode) {
		setTitle(title);
		setAuthor(author);
		this.startPage = startPage;
		this.endPage = endPage;
		this.editors = editors;
		this.newspaper = newspaper;
		setDate(date);
		pl.setCity(city);
        pl.setState(state);
		pl.setPostCode(postCode);
	}



	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public Set<String> getEditors() {
		return editors;
	}

	public String getNewspaper() {
		return newspaper;
	}


	public String getCity() {
		return pl.getCity();
	}

	public String getState() { return pl.getState(); }

	public String getPostCode() { return pl.getPostCode(); }

	public int numPages(){
		return endPage - startPage + 1;
	}


	public boolean sameNewspaper(NewspaperArticle article) {
		return this.newspaper.equals(article.newspaper);
	}

	public int numEditors(){
		return editors.size();
	}

	public Set<String> commonEditors(NewspaperArticle article){
		Set<String> sameEditors = new HashSet<String>();
		for(String ed : article.editors){
			if(this.editors.contains(ed)){
				sameEditors.add(ed);
			}
		}
		return sameEditors;
	}

	public int compareDates(NewspaperArticle article){
		return this.getDate().compareTo(article.getDate());
	}

    public boolean sameAuthor(NewspaperArticle article){
        return this.getAuthor().equals(article.getAuthor());
    }




}
