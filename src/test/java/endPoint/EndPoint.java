package endPoint;

public enum EndPoint {

    BASE_URL("https://jsonplaceholder.typicode.com"),
    POSTS("/posts/"),
    USERS("/users/");

    private String endPoint;

    public String getEndPoint() {
        return endPoint;
    }

    EndPoint(String endPoint) {
        this.endPoint = endPoint;
    }
}
