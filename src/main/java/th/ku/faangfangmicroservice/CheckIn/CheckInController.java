package th.ku.faangfangmicroservice.CheckIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ku.faangfangmicroservice.Receipt.ReceiptInfo;

import java.util.List;

@RestController
public class CheckInController {

    @Autowired
    private CheckInRepository repository;

    @PostMapping("/AddCheckInInfo")
    public String saveReceiptInfo(@RequestBody CheckInInfo checkInInfo) {
        repository.save(checkInInfo);
        return "Added CheckIn Info : " + checkInInfo.getName();
    }

    @GetMapping("/findAllCheckInInfo")
    public List<CheckInInfo> getAllReceipt() {
        return repository.findAll();
    }

    @GetMapping("/findCheckInInfoByPhoneNum/{phoneNum}")
    public CheckInInfo getByDate(@PathVariable String phoneNum) {
        return repository.findByPhoneNum(phoneNum);
    }

    @PutMapping("/updateAssignRoom/{phoneNum}")
    public CheckInInfo updateAssignRoom(@PathVariable String phoneNum, @RequestBody CheckInInfo checkInInfo) {
        CheckInInfo record =  repository.findByPhoneNum(phoneNum);
        record.setAssignRoom(checkInInfo.getAssignRoom());
        repository.save(record);
        return record;
    }
    @PutMapping("/updateStatusCheckIn/{phoneNum}")
    public CheckInInfo update(@PathVariable String phoneNum, @RequestBody CheckInInfo checkInInfo) {
        CheckInInfo record =  repository.findByPhoneNum(phoneNum);
        record.setStatus(checkInInfo.getStatus());
        repository.save(record);
        return record;
    }

    @DeleteMapping("/deleteCheckInInfoByPhone/{phoneNum}")
    public String deleteCusByPhone(@PathVariable String phoneNum) {
        repository.deleteByPhoneNum(phoneNum);
        return "delete : " + phoneNum;
    }
}