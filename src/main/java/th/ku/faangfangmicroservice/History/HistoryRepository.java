package th.ku.faangfangmicroservice.History;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoryRepository extends MongoRepository<History, String> {

    History findByPhoneNum(String phoneNum);
    String deleteByPhoneNum(String phoneNum);
}
