package th.ku.faangfangmicroservice.CheckIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ku.faangfangmicroservice.CustomerInfo.CustomerInfo;
import th.ku.faangfangmicroservice.Receipt.ReceiptInfo;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/findCheckInInfoById/{id}")
    public Optional<CheckInInfo> getOneCheckIn(@PathVariable String id) { return repository.findById(id); }

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

    @PutMapping("/updateAssignRoomById/{id}")
    public Optional<CheckInInfo> updateAssignRoomById(@PathVariable String id, @RequestBody CheckInInfo checkInInfo) {
        Optional<CheckInInfo> record =  repository.findById(id);
        CheckInInfo ctm = record.get();
        ctm.setAssignRoom(checkInInfo.getAssignRoom());
        repository.save(ctm);
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

    @DeleteMapping("/deleteCheckInInfoById/{id}")
    public String deleteCusById(@PathVariable String id) {
        repository.deleteById(id);
        return "delete : " + id;
    }
}