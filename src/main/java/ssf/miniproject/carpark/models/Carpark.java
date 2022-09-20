package ssf.miniproject.carpark.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Carpark {
    
    private String CarParkID;
    private String Area;
    private String Development;
    private String Location;
    private String AvailableLots;
    private String LotType;
    private String Agency;

    public String getCarParkID() {
        return CarParkID;
    }
    public void setCarParkID(String carParkID) {
        CarParkID = carParkID;
    }
    public String getArea() {
        return Area;
    }
    public void setArea(String area) {
        Area = area;
    }
    public String getDevelopment() {
        return Development;
    }
    public void setDevelopment(String development) {
        Development = development;
    }
    public String getLocation() {
        return Location;
    }
    public void setLocation(String location) {
        Location = location;
    }
    public String getAvailableLots() {
        return AvailableLots;
    }
    public void setAvailableLots(String availableLots) {
        AvailableLots = availableLots;
    }
    public String getLotType() {
        return LotType;
    }
    public void setLotType(String lotType) {
        LotType = lotType;
    }
    public String getAgency() {
        return Agency;
    }
    public void setAgency(String agency) {
        Agency = agency;
    }

    public static Carpark create(JsonObject jo) {
        Carpark cp = new Carpark();
        cp.setCarParkID(jo.getString("carparkID"));
        cp.setArea(jo.getString("area"));
        cp.setDevelopment(jo.getString("development"));
        cp.setLocation(jo.getString("location"));
        cp.setAvailableLots(jo.getString("availableLots"));
        cp.setLotType(jo.getString("lotType"));
        cp.setAgency(jo.getString("agency"));
        
        return cp;

        
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
            .add("CarparkID", CarParkID)
            .add("Area", Area)
            .add("Development", Development)
            .add("Location", Location)
            .add("AvailableLots", AvailableLots)
            .add("LotType", LotType)
            .add("Agency", Agency)

            .build();



}

}

    
    