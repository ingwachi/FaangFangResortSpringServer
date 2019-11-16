package th.ku.faangfangmicroservice.CheckIn;


import org.springframework.data.mongodb.repository.MongoRepository;
import th.ku.faangfangmicroservice.Receipt.ReceiptInfo;

public interface CheckInRepository extends MongoRepository<CheckInInfo, String> {

    CheckInInfo findByPhoneNum(String phoneNum);
    String deleteByPhoneNum(String phoneNum);

}
