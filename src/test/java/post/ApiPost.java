package post;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiPost {
// ����� �� ������
    @JsonProperty("userId")
    public int userId;

    @JsonProperty("id")
    public int id;

    @JsonProperty("title")
    public String title;

    @JsonProperty("body")
    public String body;
}
