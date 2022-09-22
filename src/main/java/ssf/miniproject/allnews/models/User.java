package ssf.miniproject.allnews.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class User {
    
    private String name;
    private String email;
    private String password;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public static User create(String name, String email, String password) {
		User u = new User();
        u.setName(name);
        u.setEmail(email);
		u.setPassword(password);
	
        System.out.println(u);
		return u;
    }

    public static User create(JsonObject user) {
		User u = new User();
        u.setName(user.getString("name"));
        u.setEmail(user.getString("email"));
		u.setPassword(user.getString("password"));
	
        System.out.println(user);
		return u;
    }

    public JsonObject toJson(User u) {
        return Json.createObjectBuilder()
            .add("name", u.getName())
            .add("email", u.getEmail())
            .add("password", u.getPassword())
            .build();
    }
    
}
