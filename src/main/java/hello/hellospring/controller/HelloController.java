package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// MVC 의 정형화된 패턴은 controller -> service -> Repository 순으로 처리 됨
// controller 단에서 데이터를 받고 service 에서 비즈니스 로직을 만들고 Repository 에서 데이터를 저장한다.
@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","why not?!");
        return "hello";
    }

    @GetMapping("getName")
    public String getName(@RequestParam("name") String name, Model model) {
        model.addAttribute("stringName", name);
        return "userName";

    }

    @GetMapping("helloSpring")
    @ResponseBody
    public String helloSpring(@RequestParam("name") String name) {
        return "hello " + name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("userName") String name2 ,@RequestParam("age") int age) {
        Hello h = new Hello(name2,age);
        System.out.println(age);
        return h;
    }

    static class Hello{
        String name1;
        int age;

        Hello(String name1, int age){
            this.name1 = name1;
            this.age = age;
        }

        public String getName(){
            return name1;
        }
        public void setName(String name1){
            this.name1=name1;
        }

    }

}
