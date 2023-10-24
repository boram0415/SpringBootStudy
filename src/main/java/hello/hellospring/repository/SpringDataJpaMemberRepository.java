package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/* springBoot 가 JpaRepository 객체를 들고 있는 경우
*  해당 springDataJpaMemberRepository 가 MemberRepository 의 구현체를
*  자동으로 생성 및 springBoot 컨테이너에 자동 등록 함 */
public interface SpringDataJpaMemberRepository  extends JpaRepository<Member,Long>, MemberRepository{
    @Override
    Optional<Member> findByName(String name);

}
