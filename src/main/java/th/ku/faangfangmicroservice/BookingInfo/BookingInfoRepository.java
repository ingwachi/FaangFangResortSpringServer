package th.ku.faangfangmicroservice.BookingInfo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingInfoRepository extends MongoRepository<BookingInfo, String> {

    BookingInfo findByPhoneNum(String phoneNum);
    String deleteByPhoneNum(String phoneNum);
    BookingInfo findByName(String name);
    BookingInfo findByPhoneNumAndId(String phoneNum, String id);
}
