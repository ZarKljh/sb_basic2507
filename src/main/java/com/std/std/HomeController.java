package com.std.std;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller의 의미는?
// @ : 어너테이션
// 개발자가 스프링부트에게 알려주는 것
// 아래에 있는 HomeController 는 컨트롤러이다.
@Controller
public class HomeController {
    //@GetMapping의 의미는?
    // 개발자가 스프릥부트에게 알려주는 것
    // 만약에 /home/main 이런 요청이 오면 아래 메서드를 실행해줘.
    // 기본적으로 요청은 localhost:8080/home/main 이렇게 들어온다
    @GetMapping("/home/main")
    // 요청이 들어오면 이 아래에 적혀있는 메서드가 실행된다
    @ResponseBody
    //@ResponseBody MVC모델에서 View 모델에게 출력을 전가하지 않고, 직접 출력하겠다는 의미이다
    public String ShowMain(){
        return "Hello World";
    }

}
