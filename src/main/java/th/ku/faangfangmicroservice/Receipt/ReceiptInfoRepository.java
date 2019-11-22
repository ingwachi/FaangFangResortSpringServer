package th.ku.faangfangmicroservice.Receipt;

import org.springframework.data.mongodb.repository.MongoRepository;
import th.ku.faangfangmicroservice.History.History;

import java.util.List;

public interface ReceiptInfoRepository extends MongoRepository<ReceiptInfo, String> {

    ReceiptInfo findByPhoneNum(String phoneNum);
    String deleteByPhoneNum(String phoneNum);
    List<ReceiptInfo> findAllByDateCheckin(String dateCheckin);
    List<History> findAllByStatus(String status);
}
