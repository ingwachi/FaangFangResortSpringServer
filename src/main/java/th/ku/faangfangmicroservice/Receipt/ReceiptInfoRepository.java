package th.ku.faangfangmicroservice.Receipt;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceiptInfoRepository extends MongoRepository<ReceiptInfo, String> {

    ReceiptInfo findByPhoneNum(String phoneNum);
    String deleteByPhoneNum(String phoneNum);
}
