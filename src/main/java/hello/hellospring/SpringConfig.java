package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }


//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

    /*SOLID 중 개방-폐쇄 원칙(OCP, Open-Closed Principle)에 해당하는 부분
    * 스프링의 DI 를 이용해 기존 코드를 전혀 손대지 않고,
    * 설정만으로 MemberRepository 의 구현클래스를 변경
    * */
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//        return new JpaMemberRepository(em);
//    }



}
