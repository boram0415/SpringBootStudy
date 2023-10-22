package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// localhost:8080 첫 화면 맵핑 시 우선순위 : controller -> static
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }


}
