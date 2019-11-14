package th.ku.faangfangmicroservice.AvailableRoom;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "AvailableRoom")
public class AvailableRoom {

    @Id
    private String id;

    private String date;
    private int typeA;
    private int typeB;
    private int typeC;
    private int typeD;
    private int typeE;
    private int typeF;
}
