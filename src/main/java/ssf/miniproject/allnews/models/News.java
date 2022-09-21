package ssf.miniproject.allnews.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class News {
    
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String content;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrlToImage() {
        return urlToImage;
    }
    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public static News create(JsonObject json) {
		final News n = new News();
		n.setTitle(json.getString("title"));
        n.setDescription(json.getString("description"));
        n.setUrl(json.getString("url"));
        n.setUrlToImage(json.getString("urlToImage"));
        n.setContent(json.getString("content"));
		return n;
	}

	public static News create(String json) {
		try (StringReader strReader = new StringReader(json)) {
			JsonReader j = Json.createReader(strReader);
			return create(j.readObject());
		}
	}
    
	public JsonObject toJson() {
		return Json.createObjectBuilder()
			.add("title", this.title)
			.add("description", this.description)
			.add("url", this.url)
			.add("urlToImage", this.urlToImage)
			.add("content", this.content)
			.build();
	}

	@Override
    public String toString() {
        return "News [content=" + content + ", description=" + description + ", title=" + title + ", url=" + url
                + ", urlToImage=" + urlToImage + "]";
    }

}



