package th.ku.faangfangmicroservice.CustomerInfo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class CustomerInfoController {

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

    @GetMapping("/findCustomerByName/{name}")
    public CustomerInfo getDataByName(@PathVariable String name) { return  repository.findByName(name); }

    @GetMapping("/findCustomerById/{id}")
    public Optional<CustomerInfo> getOneCustomer(@PathVariable String id) { return repository.findById(id); }

    @GetMapping("/findCustomerByPhone/{phoneNum}")
    public CustomerInfo getByPhone(@PathVariable String phoneNum) {
        return repository.findByPhoneNum(phoneNum);
    }

    @PutMapping("/updatePhoneNumCusByName/{name}")
    public CustomerInfo update(@PathVariable String name, @RequestBody CustomerInfo customerInfo) {
        CustomerInfo record =  repository.findByName(name);
        record.setPhoneNum(customerInfo.getPhoneNum());
        repository.save(record);
        return record;
    }

    @PutMapping("/updateEmailCusByName/{name}")
    public CustomerInfo updateByName(@PathVariable String name, @RequestBody CustomerInfo customerInfo) {
        CustomerInfo record =  repository.findByName(name);
        record.setEmail(customerInfo.getEmail());
        repository.save(record);
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
