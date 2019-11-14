package th.ku.faangfangmicroservice.TempData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TempDataController {

    @Autowired
    private TempDataRepository repository;

    @PostMapping("/addTempData")
    public String saveTempData(@RequestBody TempData tempData) {
        repository.save(tempData);
        return "Added Customer : " + tempData.getId();
    }

    @GetMapping("/findTempData")
    public List<TempData> getData() {
        return repository.findAll();
    }

    @DeleteMapping("/deleteTempData")
    public String deleteData() {
        repository.deleteAll();
        return "delete all date";
    }
}
