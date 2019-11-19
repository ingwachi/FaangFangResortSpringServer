package th.ku.faangfangmicroservice.TempData;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "TempData")
public class TempData {

    @Id
    private String id;

    private float cost;
    private String dateCheckIn;
    private String dateCheckOut;
    private int reserveA;
    private int reserveB;
    private int reserveC;
    private int reserveD;
    private int reserveE;
    private int reserveF;
    private int dateCount;
}
