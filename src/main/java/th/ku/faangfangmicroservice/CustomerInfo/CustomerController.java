package th.ku.faangfangmicroservice.CustomerInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import th.ku.faangfangmicroservice.CheckIn.CheckInInfo;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/findCustomerById/{id}")
    public Optional<CustomerInfo> getOneCustomer(@PathVariable String id) { return repository.findById(id); }

    @GetMapping("/findCustomerByPhone/{phoneNum}")
    public CustomerInfo getByPhone(@PathVariable String phoneNum) {
        return repository.findByPhoneNum(phoneNum);
    }

    @PutMapping("/updateStatusCus/{phoneNum}")
    public CustomerInfo update(@PathVariable String phoneNum, @RequestBody CustomerInfo customerInfo) {
        CustomerInfo record =  repository.findByPhoneNum(phoneNum);
        record.setStatus(customerInfo.getStatus());
        repository.save(record);
        return record;
    }

    @PutMapping("/updateStatusCusById/{id}")
    public Optional<CustomerInfo> updateById(@PathVariable String id, @RequestBody CustomerInfo customerInfo) {
        Optional<CustomerInfo> record =  repository.findById(id);
        CustomerInfo ctm = record.get();
        ctm.setStatus(customerInfo.getStatus());
        repository.save(ctm);
        return record;
    }

    @PutMapping("/updateDetails/{phoneNum}")
    public CustomerInfo updateDetails(@PathVariable String phoneNum, @RequestBody CustomerInfo customerInfo) {
        CustomerInfo record =  repository.findByPhoneNum(phoneNum);
        record.setDetails(customerInfo.getDetails());
        repository.save(record);
        return record;
    }

    @PutMapping("/updateDetailsById/{id}")
    public Optional<CustomerInfo> updateAssignRoomById(@PathVariable String id, @RequestBody CustomerInfo customerInfo) {
        Optional<CustomerInfo> record =  repository.findById(id);
        CustomerInfo ctm = record.get();
        ctm.setDetails(customerInfo.getDetails());
        repository.save(ctm);
        return record;
    }

    @DeleteMapping("/deleteCustomerByPhone/{phoneNum}")
    public String deleteCusByPhone(@PathVariable String phoneNum) {
        repository.deleteByPhoneNum(phoneNum);
        return "delete : " + phoneNum;
    }

    @DeleteMapping("/deleteCustomerById/{id}")
    public String deleteCusById(@PathVariable String id) {
        repository.deleteById(id);
        return "delete : " + id;
    }

}