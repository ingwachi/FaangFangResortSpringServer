package th.ku.faangfangmicroservice.Status;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Status")
public class Status {

    private String id;

    private String name;
    private String phoneNum;
    private String status;
}
