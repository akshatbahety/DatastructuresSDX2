public class PublishingLocation {


    private String city;
    private String state;
    private String postCode;


    public void setPublishingLocation(String city,String state,String postCode)
    {
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
