package th.ku.faangfangmicroservice.BookingInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookingController {

    @Autowired
    private BookingInfoRepository repository;

    @PostMapping("/addBookingInfo")
    public String saveBookingInfo(@RequestBody BookingInfo bookingInfo) {
        repository.save(bookingInfo);
        return "Added Booking : " + bookingInfo.getName();
    }

    @GetMapping("/findAllBookingInfo")
    public List<BookingInfo> getBookingInfo() {
        return repository.findAll();
    }

    @GetMapping("/findBookingInfoByName/{name}")
    public BookingInfo getBookingInfoByName(@PathVariable String name) { return  repository.findByName(name); }

    @GetMapping("/findBookingInfoById/{id}")
    public Optional<BookingInfo> getOneCustomer(@PathVariable String id) { return repository.findById(id); }

    @GetMapping("/findBookingInfoByPhone/{phoneNum}")
    public BookingInfo getBookingInfoByPhone(@PathVariable String phoneNum) {
        return repository.findByPhoneNum(phoneNum);
    }

    @PutMapping("/updateStatusBooking/{phoneNum}")
    public BookingInfo updateStatusBooking(@PathVariable String phoneNum, @RequestBody BookingInfo bookingInfo) {
        BookingInfo record =  repository.findByPhoneNum(phoneNum);
        record.setStatus(bookingInfo.getStatus());
        repository.save(record);
        return record;
    }

    @PutMapping("/updateStatusBookingById/{id}")
    public Optional<BookingInfo> updateById(@PathVariable String id, @RequestBody BookingInfo bookingInfo) {
        Optional<BookingInfo> record =  repository.findById(id);
        BookingInfo bk = record.get();
        bk.setStatus(bookingInfo.getStatus());
        repository.save(bk);
        return record;
    }

    @PutMapping("/updateDetails/{phoneNum}")
    public BookingInfo updateDetails(@PathVariable String phoneNum, @RequestBody BookingInfo bookingInfo) {
        BookingInfo record =  repository.findByPhoneNum(phoneNum);
        record.setDetails(bookingInfo.getDetails());
        repository.save(record);
        return record;
    }

    @PutMapping("/updateDetailsById/{id}")
    public Optional<BookingInfo> updateAssignRoomById(@PathVariable String id, @RequestBody BookingInfo bookingInfo) {
        Optional<BookingInfo> record =  repository.findById(id);
        BookingInfo bk = record.get();
        bk.setDetails(bookingInfo.getDetails());
        repository.save(bk);
        return record;
    }

    @DeleteMapping("/deleteBookingInfoByPhone/{phoneNum}")
    public String deleteBookingInfoByPhone(@PathVariable String phoneNum) {
        repository.deleteByPhoneNum(phoneNum);
        return "delete : " + phoneNum;
    }

    @DeleteMapping("/deleteBookingInfoById/{id}")
    public String deleteBookingInfoById(@PathVariable String id) {
        repository.deleteById(id);
        return "delete : " + id;
    }

}