package th.ku.faangfangmicroservice.Receipt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceiptInfoController {

    @Autowired
    private ReceiptInfoRepository repository;

    @PostMapping("/addReceiptInfo")
    public String saveReceiptInfo(@RequestBody ReceiptInfo receiptInfo) {
        repository.save(receiptInfo);
        return "Added Receipt Information : " + receiptInfo.getName();
    }

    @GetMapping("/findAllReceiptInfo")
    public List<ReceiptInfo> getAllReceipt() {
        return repository.findAll();
    }

    @GetMapping("/findReceiptByPhoneNum/{phoneNum}")
    public ReceiptInfo getByDate(@PathVariable String phoneNum) {
        return repository.findByPhoneNum(phoneNum);
    }

    @PutMapping("/updateStatusReceipt/{phoneNum}")
    public ReceiptInfo update(@PathVariable String phoneNum, @RequestBody ReceiptInfo receiptInfo) {
        ReceiptInfo record =  repository.findByPhoneNum(phoneNum);
        record.setStatus(receiptInfo.getStatus());
        repository.save(record);
        return record;
    }

    @DeleteMapping("/deleteReceiptInfoByPhone/{phoneNum}")
    public String deleteCusByPhone(@PathVariable String phoneNum) {
        repository.deleteByPhoneNum(phoneNum);
        return "delete : " + phoneNum;
    }

}
