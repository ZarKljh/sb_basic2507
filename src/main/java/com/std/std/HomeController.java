package com.std.std;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/home/plus")
    // 요청이 들어오면 이 아래에 적혀있는 메서드가 실행된다
    @ResponseBody
    //@ResponseBody MVC모델에서 View 모델에게 출력을 요청하지 않고, 직접 출력하겠다는 의미이다
    //파라메터로 들오는 모든 인자값은 String타입으로 들어온다.
    //형변환은 자동으로 이루어진다
    public int ShowMain(@RequestParam(value="a", defaultValue ="0") int a, @RequestParam(value="b", defaultValue ="0") int b){

        int answer = a+b;

        return answer;
    }

    @GetMapping("home/returnCar")
    @ResponseBody
    public Car showReturncar(){
        Car car = new Car(1, 100, "Wife Car", new ArrayList());
        car.setId(2);
        car.setSpeed(200);
        car.setName("MyCar");
        car.setIds(new ArrayList(){{add(1); add(2); add(3);}});
        return car;
    }
    //전체 속성을 포함하는 생성자 함수 생성
    // getter setter 생성
    @AllArgsConstructor
    // 파라메터가 없는 생성자도 같이 생성한다
    @NoArgsConstructor
    @Getter
    @Setter
    class Car {
        private int id;
        private int speed;
        private String name;
        private List<Integer> ids;
    }

}
