package endPoint;

public enum EndPoint {
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
