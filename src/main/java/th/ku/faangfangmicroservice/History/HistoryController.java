package th.ku.faangfangmicroservice.History;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ku.faangfangmicroservice.Receipt.ReceiptInfo;
import th.ku.faangfangmicroservice.Status.Status;

import java.util.List;

@RestController
public class HistoryController {

    @Autowired
    private HistoryRepository repository;

    @PostMapping("/AddHistory")
    public String saveHistory(@RequestBody History history) {
        repository.save(history);
        return "Added History : " + history.getName();
    }

    @GetMapping("/findAllHistory")
    public List<History> getAllHistory() {
        return repository.findAll();
    }

    @GetMapping("/findHistoryByPhoneNum/{phoneNum}")
    public History getHistoryByPhoneNum(@PathVariable String phoneNum) {
        return repository.findByPhoneNum(phoneNum);
    }


    @DeleteMapping("/deleteHistoryInfoByPhone/{phoneNum}")
    public String deleteHistoryByPhone(@PathVariable String phoneNum) {
        repository.deleteByPhoneNum(phoneNum);
        return "delete : " + phoneNum;
    }

    @DeleteMapping("/deleteHistoryInfoById/{id}")
    public String deleteHistoryById(@PathVariable String id) {
        repository.deleteById(id);
        return "delete : " + id;
    }

    @DeleteMapping("/deleteAllHistory")
    public String deleteHistory() {
        repository.deleteAll();
        return "delete all history";
    }
}

