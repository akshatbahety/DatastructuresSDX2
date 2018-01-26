import java.util.Date;

public abstract class Document {


    private String title;
    private String author;
    private Date date;
    PublishingLocation pl;



    public boolean sameAuthor(Document doc){
        return this.getAuthor().equals(doc.getAuthor());
    }




    public int compareWithGeneralDate(Date date){
        return this.getDate().compareTo(date);
    }

    public int compareDates(Document doc){
        return this.getDate().compareTo(doc.getDate());
    }

    public String getTitle() {
        return title;
    }


    public String getAuthor() {
        return author;
    }


    public Date getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
