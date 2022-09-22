package ssf.miniproject.allnews.models;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class TopNews {
    
    private String title;
    private String url;


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public static TopNews create(JsonObject json) {
		final TopNews n = new TopNews();
		n.setTitle(json.getString("title"));
        n.setUrl(json.getString("url"));
		return n;
	}

	public static TopNews create(String json) {
		try (StringReader strReader = new StringReader(json)) {
			JsonReader j = Json.createReader(strReader);
			return create(j.readObject());
		}
	}
    
	public JsonObject toJson() {
		return Json.createObjectBuilder()
			.add("title", this.title)
			.add("url", this.url)
			.build();
	}

	@Override
    public String toString() {
        return "TopNews [title=" + title + ", url=" + url + "]";
    }

}





