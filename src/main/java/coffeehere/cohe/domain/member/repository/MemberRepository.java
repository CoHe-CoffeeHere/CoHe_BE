package coffeehere.cohe.domain.member.repository;

import coffeehere.cohe.domain.member.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	
	Optional<Member> findByMemberId(String memberId);
	
	boolean existsByMemberId(String memberId);
}
