package springboot.bill.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.bill.pay.dto.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
