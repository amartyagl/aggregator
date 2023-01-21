package com.globallogic.feign;

import com.globallogic.modal.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="USER-SERVICE")
public interface UserProxy {
    @GetMapping("/getUser/{userId}")
    User getUserDetails(@PathVariable int userId);
    @GetMapping("/getAllUser")
    List<User> getAllUser();

}
