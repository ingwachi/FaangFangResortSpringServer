package th.ku.faangfangmicroservice.CustomerInfo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "CustomerInfo")
public class CustomerInfo {

    @Id
    private String id;

    private String name;
    private String phoneNum;
    private String email;
}

//0971530463

