package hello.springmvc.basic.requestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    // 모든 HTTP method 허용
    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    // Get
    @RequestMapping(value = "/hello-basic-v1", method = RequestMethod.GET)
    public String getMapping1() {
        log.info("helloBasic");
        return "ok";
    }

    // 축약 어노테이션
    @GetMapping("/hello-basic-v2")
    public String getMapping2() {
        log.info("helloBasic");
        return "ok";
    }

    // PathVariable(경로 변수) 사용
    @GetMapping("/hello-basic-v3/{userId}")
    public String getMapping3(@PathVariable("userId") String data) {
        log.info("mappingPath userId = {}", data);
        return "ok";
    }

    // 경로 변수와 사용할 변수명이 같으면 다음과 같이 사용도 가능하다
    @GetMapping("/hello-basic-v4/{userId}")
    public String getMapping4(@PathVariable String userId) {  // 축약
        log.info("mappingPath userId = {}", userId);
        return "ok";
    }

    // 쿼리 파라미터
    @GetMapping(value = "/hello-basic-v5", params = "mode=debug")
    public String getMapping5() {
        log.info("mappingParam");
        return "ok";
    }

    // 헤어 맵핑
    @GetMapping(value = "/hello-basic-v6", headers = "mode=debug")
    public String getMapping6() {
        log.info("mappingHeader");
        return "ok";
    }
}

