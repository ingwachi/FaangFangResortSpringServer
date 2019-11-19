package th.ku.faangfangmicroservice.CheckIn;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "CheckIn")
public class CheckInInfo {

    private String id;

    private String name;
    private String phoneNum;
    private String email;
    private String details;
    private String dateCheckIn;
    private String dateCheckOut;
    private String status;
    private String assignRoom;
}
