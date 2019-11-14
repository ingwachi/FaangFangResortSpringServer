package th.ku.faangfangmicroservice.CustomerInfo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerInfoRepository extends MongoRepository<CustomerInfo, String> {
}
