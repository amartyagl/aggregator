package com.globallogic.feign;

import com.globallogic.modal.GloQuoraPost;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "gloquora-post-app")
public interface GloQuroPostProxy {

    @GetMapping("/getAllPost")
    List<GloQuoraPost> getAllPost();
}
