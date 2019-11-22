package th.ku.faangfangmicroservice.History;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HistoryRepository extends MongoRepository<History, String> {

    History findByPhoneNum(String phoneNum);
    String deleteByPhoneNum(String phoneNum);
    History findByPhoneNumAndStatus(String phoneNum, String status);
    List<History> findAllByStatus(String status);
}
