package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller 내부에 @Component 애노테이션이 있어서 컴포넌트 스캔 대상이 되기 때문에,
 * 스프링이 자동으로 빈으로 등록한다.
 */

@Controller
public class SpringMemberFormControllerV1 {

    /**
     *
     * @RequestMapping: 해당 URL이 호출되면 이 매서드가 호출된다.
     * 어노테이션 기반 동작으로 메소드명은 임의로 지어도 된다.
     *
     * RequestMappingHandlerMapping 은 스프링 빈 중에서 @RequestMapping 혹은 @Controller가
     * 클래스 레벨이 붙어있는 경우 매핑정보로 인식한다.
     */
    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }

}
