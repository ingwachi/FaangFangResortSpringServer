package th.ku.faangfangmicroservice.History;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("History")
public class History {

    private String id;

    private String name;
    private String phoneNum;
    private String dateCheckIn;
    private String dateCheckOut;
    private String status;
    private String assignRoom;
}
