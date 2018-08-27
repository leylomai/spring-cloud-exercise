package com.cmiot.feign;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@org.springframework.cloud.netflix.feign.FeignClient(value = "eureka-client")
public interface FeignClient {

    @RequestMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String uploadFile(@RequestPart(value = "file") MultipartFile file);

}
