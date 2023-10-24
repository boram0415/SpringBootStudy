package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {
        private final EntityManager em;

        /*JPA 는 API 의 일종으로 EntityManager 로 모든것이 동작 함
         * jpa 라이브러리 사용 시 springBoot 가 자동으로 EntityManager 를 생성해 줌
         * */
        public JpaMemberRepository(EntityManager em) {
                this.em = em;
        }

        @Override
        public Member save(Member member) {
                em.persist(member);
                return member;
        }

        @Override
        public Optional<Member> findById(Long id) {
                Member member = em.find(Member.class, id);
                return Optional.ofNullable(member);
        }

        @Override
        public Optional<Member> findByName(String name) {
                List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                        .setParameter("name", name).getResultList();
                return result.stream().findAny();
        }

        @Override
        public List<Member> findAll() {
                /* jpql 란?
                 * -객체를 사용하여 객체 지향 쿼리를 사용하여 객체 생성
                 * -테이블 대상으로 쿼리를 날리는 것이 아닌 객체 대상으로 쿼리를 날려 생성 함 */
                return em.createQuery("select m from Member as m", Member.class)
                        .getResultList();
        }

}