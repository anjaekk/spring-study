package hello.springmvc.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request,
                               HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody // RestController와 같은 기능
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge) {

        log.info("name={}, age={}", memberName, memberAge);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, // 파라미터와 사용할 변수명이 같다면 변수 생략 가능
                                 @RequestParam  int age) {
        log.info("name={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    // 요청 파라미터와 변수명이 같고 String, int, Integer와 같이 단순타입은 @RequestParam도 생략 가능
    public String requestParamV4(String username, int age) {
        log.info("name={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    // 기본값 required=true
    public String requestParamRequired(@RequestParam(required = true) String username, // 없으면 400 error(기본값 true라 안넣어줘도 됨, "" 빈문자열 성공)
                                       // @RequestParam(required = false)  int age) -> 500 error(int에 null 들어갈 수 없음)
                                       @RequestParam(required = false)  Integer age) {
        log.info("name={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    // defulatValue 설정시 required를 설정할 필요가 없긴 함
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username,
                                       @RequestParam(required = false, defaultValue = "-1")  int age) {
        log.info("name={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("name={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }
}
