package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// springFramework 는 좋은 객체 지향 애플리케이션을 만들 수 있도록 개발자들을 도와주는 프레임워크이다.
// spring 은 톰캣을 내장하고 있다.
@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
