package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface
MemberRepository {
    Member save(Member member);

    // Optional : NPE 발생을 방지하기 위해 사용
    Optional<Member> findById(Long Id);
    Optional<Member> findByName(String name);

    List<Member> findAll();

}
