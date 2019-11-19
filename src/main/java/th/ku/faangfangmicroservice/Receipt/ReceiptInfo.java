package th.ku.faangfangmicroservice.Receipt;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ReceiptInfo")
public class ReceiptInfo {

    private String id;

    private String name;
    private String phoneNum;
    private String datePayment;
    private String timePayment;
    private String price;
    private String url;
    private String status;
}
