package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.AssertionErrors;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/*
* 보통 순수 자바코드로 테스트 하는 것을 단위테스트라고 하고, (<- 이것이 좋은 테스트일 확률이 높다)
* 스프링컨테이너와 DB 까지 연동해서 테스트 하는 것을 통합테스트 라고 한다
* */

@SpringBootTest
// DB insert 데이터 롤백해주는 어노테이션 (DB commit 하지 않음)
// 부분적으로 commit 이 필요한경우 commit 어노테이션을 사용하면 됨
@Transactional
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @AfterEach
    public void afterEach() {
//        memberService.memberRe
    }

    @Test
    void 회원가입() {
        //given : 주어진 데이터
        Member member = new Member();
        member.setName("boram1243");
        //when  : 실행
        Long saveId = memberService.join(member);

        //then  : 검증 및 결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member("boram5");
        Member member2 = new Member("boram5");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        try {
            memberService.join(member2);
            AssertionErrors.fail("예외발생!!");
        } catch (IllegalStateException ex) {
            Assertions.assertThat(ex.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }

        //then
    }

}