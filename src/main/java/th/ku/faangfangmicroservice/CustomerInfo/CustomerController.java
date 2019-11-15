package th.ku.faangfangmicroservice.CustomerInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ku.faangfangmicroservice.AvailableRoom.AvailableRoom;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerInfoRepository repository;

    @PostMapping("/addCustomerInfo")
    public String saveCustomerInfo(@RequestBody CustomerInfo customerInfo) {
        repository.save(customerInfo);
        return "Added Customer : " + customerInfo.getName();
    }

    @GetMapping("/findAllCustomer")
    public List<CustomerInfo> getDate() {
        return repository.findAll();
    }

    @GetMapping("/findCustomerByPhone/{phoneNum}")
    public CustomerInfo getByPhone(@PathVariable String phoneNum) {
        return repository.findByPhoneNum(phoneNum);
    }

    @PutMapping("/updateStatus/{phoneNum}")
    public CustomerInfo update(@PathVariable String phoneNum, @RequestBody CustomerInfo customerInfo) {
        CustomerInfo record =  repository.findByPhoneNum(phoneNum);
        record.setStatus(customerInfo.getStatus());
        repository.save(record);
        return record;
    }
}
