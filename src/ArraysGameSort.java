public class ArraysGameSort {

    private String name;
    private int score;

    public ArraysGameSort(String n , int s){
        name = n;
        score = s;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String toString()
    {
        return "(" + name + ", " + score + ")";
    }
}
