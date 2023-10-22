package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
// 테스트 코드를 작성한 뒤 그에 맞춰 개발을 할 수도 있음 (Test Driven Development)
// 수백개의 테스트를 검증해야할 시 상위 패키지에서 Run 'Tests in hello.helloSpring' 돌려보면 됨
// 테스트 코드 없이 다중 인원과 개발은 불가피함 (테스트 코드 많이 작성해보기)
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 하나의 메소드가 끝난 뒤 자동으로 실행되게 만들어주는 콜백 어노테이션
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("boram");

        repository.save(member);
        // Optional 로 감싸있는 객체의 경우 get 으로 반환가능(좋은 코드는 아님)
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);


    }



}
