package business;

import java.util.Objects;

public class ApiPost {
    public int userId;
    public int id;
    public String title;
    public String body;

    public ApiPost() {
    }

    public ApiPost(String body, String title, int userId) {
        this.body = body;
        this.title = title;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiPost apiPost = (ApiPost) o;
        return userId == apiPost.userId && Objects.equals(title, apiPost.title) && Objects.equals(body, apiPost.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, title, body);
    }
}
