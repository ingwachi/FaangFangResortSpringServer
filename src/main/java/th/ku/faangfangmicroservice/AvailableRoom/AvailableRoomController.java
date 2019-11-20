package th.ku.faangfangmicroservice.AvailableRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AvailableRoomController {
    @Autowired
    private AvailableRoomRepository repository;

    @PostMapping("/addAvailableRoom")
    public String saveAvailableRoom(@RequestBody AvailableRoom availableRoom) {
        repository.save(availableRoom);
        return "Added AvailableRoom : " + availableRoom.getDate();
    }

    @GetMapping("/findAllAvailableRoom")
    public List<AvailableRoom> getAllAvailableRoom() {
        return repository.findAll();
    }

    @GetMapping("/{date}")
    public AvailableRoom getAvailableRoomByDate(@PathVariable String date) {
        return repository.findByDate(date);
    }

    @PutMapping("/updateRoom/{date}")
    public AvailableRoom updateAvailableRoom(@PathVariable String date, @RequestBody AvailableRoom availableRoom) {
        AvailableRoom record =  repository.findByDate(date);
        record.setTypeA(availableRoom.getTypeA());
        record.setTypeB(availableRoom.getTypeB());
        record.setTypeC(availableRoom.getTypeC());
        record.setTypeD(availableRoom.getTypeD());
        record.setTypeE(availableRoom.getTypeE());
        record.setTypeF(availableRoom.getTypeF());
        repository.save(record);
        return record;
    }

    @DeleteMapping("/{date}")
    public String deleteAvailableRoom(@PathVariable String date) {
        repository.deleteById(date);
        return "delete with date: " + date;
    }

    @DeleteMapping("/deleteAllAvailableRoom")
    public String deleteAllAvailableRoom() {
        repository.deleteAll();
        return "delete all room";
    }
}
