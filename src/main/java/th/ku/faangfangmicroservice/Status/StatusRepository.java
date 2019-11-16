package th.ku.faangfangmicroservice.Status;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatusRepository extends MongoRepository<Status, String> {

    Status findByPhoneNum(String phoneNum);
    String deleteByPhoneNum(String phoneNum);
}
