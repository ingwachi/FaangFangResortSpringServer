package th.ku.faangfangmicroservice.CustomerInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/findAllAvailableRoom")
    public List<CustomerInfo> getDate() {
        return repository.findAll();
    }
}
