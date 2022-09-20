package ssf.miniproject.carpark.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CarparkService {
    

private static final String URL = "http://datamall2.mytransport.sg/ltaodataservice/CarParkAvailabilityv2";


@Value
("${API_KEY}")
private String key;


}
