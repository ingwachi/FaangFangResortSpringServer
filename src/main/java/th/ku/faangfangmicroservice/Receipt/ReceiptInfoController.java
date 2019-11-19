package th.ku.faangfangmicroservice.Receipt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ku.faangfangmicroservice.CustomerInfo.CustomerInfo;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/updateStatusReceiptById/{id}")
    public Optional<ReceiptInfo> updateById(@PathVariable String id, @RequestBody ReceiptInfo receiptInfo) {
        Optional<ReceiptInfo> record =  repository.findById(id);
        ReceiptInfo rc = record.get();
        rc.setStatus(receiptInfo.getStatus());
        repository.save(rc);
        return record;
    }

    @DeleteMapping("/deleteReceiptInfoByPhone/{phoneNum}")
    public String deleteCusByPhone(@PathVariable String phoneNum) {
        repository.deleteByPhoneNum(phoneNum);
        return "delete : " + phoneNum;
    }

    @DeleteMapping("/deleteReceiptInfoById/{id}")
    public String deleteCusById(@PathVariable String id) {
        repository.deleteById(id);
        return "delete : " + id;
    }

}
