package th.ku.faangfangmicroservice.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ku.faangfangmicroservice.Receipt.ReceiptInfo;

import java.util.List;

@RestController
public class StatusController {

    @Autowired
    StatusRepository repository;

    @PostMapping("/AddStatus")
    public String saveHistory(@RequestBody Status status) {
        repository.save(status);
        return "Added Status : " + status.getName();
    }

    @GetMapping("/findAllStatus")
    public List<Status> getAllStatus() {
        return repository.findAll();
    }

    @GetMapping("/findStatusByPhoneNum/{phoneNum}")
    public Status getStatusByPhone(@PathVariable String phoneNum) {
        return repository.findByPhoneNum(phoneNum);
    }


    @DeleteMapping("/deleteStatusInfoByPhone/{phoneNum}")
    public String deleteStatusByPhone(@PathVariable String phoneNum) {
        repository.deleteByPhoneNum(phoneNum);
        return "delete : " + phoneNum;
    }

    @PutMapping("/updateStatusRec/{phoneNum}")
    public Status update(@PathVariable String phoneNum, @RequestBody Status status) {
        Status record =  repository.findByPhoneNum(phoneNum);
        record.setStatus(status.getStatus());
        repository.save(record);
        return record;
    }

    @DeleteMapping("/deleteAllStatus")
    public String deleteStatus() {
        repository.deleteAll();
        return "delete all history";
    }
}
