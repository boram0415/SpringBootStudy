package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Service 는 비즈니스에 의존적으로 설계를 하기 때문에 메소드명을 비즈니스적으로 명명함
@Transactional
public class MemberService {
// ctrl+shift+T:테스트 클래스 쉽게 생성 가능
    private final MemberRepository memberRepository;

     /*
    * 생성자에 @Autowired 를 사용하면 객체 생성 시점에 스프링 컨테이너에서 해당 스프링 빈을 찾아서
    * 주입한다. (생성자가 1개만 있으면 @Autowired 는 생략할 수 있다)
        service 관점에서 외부에서 주입이 들어옴(DI)
    */

    /*
    * @Autowired 를 통한 DI는 helloController , memberService 등과 같이 스프링이 관리하는 객체에서만 동작한다.
    * 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다
    * */


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입 (중복 이름 가입 불가)
    public long join(Member member) {
        // ctrl+alt+v : 반환타입을 자동으로 만들어주는 단축키
        // Optional 에서 get() 으로 바로 꺼내 사용하는 것을 권장하지 않음.
        // ifPresent() 는 Optional 이 제공하는 메소드
        System.out.println("회원가입 완료 !");
        validateDuplicateMemeber(member);
        memberRepository.save(member);
        return member.getId();
    }


    /*
    * 중복 회원 검증
    * */
    private void validateDuplicateMemeber(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m->{
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
    }

    /*
     * 전체 회원 조회
     * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
