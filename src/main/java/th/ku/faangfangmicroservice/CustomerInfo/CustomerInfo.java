package th.ku.faangfangmicroservice.CustomerInfo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "CustomerInfo")
public class CustomerInfo {


    private String id;

    private String name;
    private String phoneNum;
    private String email;
    private String details;
    private float cost;
    private String dateCheckIn;
    private String dateCheckOut;
    private int reserveA;
    private int reserveB;
    private int reserveC;
    private int reserveD;
    private int reserveE;
    private int reserveF;
    private String status;
}

//0971530463
