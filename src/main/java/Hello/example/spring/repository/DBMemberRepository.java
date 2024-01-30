package Hello.example.spring.repository;

import Hello.example.spring.domain.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Primary
public interface DBMemberRepository extends JpaRepository<Member, Long> ,MemberRepository {

    @Override
    Member save(Member member);

    @Override
    Optional<Member> findByName(String name);

    @Override
    default void clear(){

    }
}
