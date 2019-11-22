package th.ku.faangfangmicroservice.CheckIn;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CheckInRepository extends MongoRepository<CheckInInfo, String> {

    CheckInInfo findByPhoneNum(String phoneNum);
    String deleteByPhoneNum(String phoneNum);
    List<CheckInInfo> findAllByDateCheckin(String dateCheckin);
}
