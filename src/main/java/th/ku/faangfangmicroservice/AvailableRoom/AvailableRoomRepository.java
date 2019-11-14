package th.ku.faangfangmicroservice.AvailableRoom;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvailableRoomRepository extends MongoRepository<AvailableRoom, String> {

    AvailableRoom findByDate(String date);
}
