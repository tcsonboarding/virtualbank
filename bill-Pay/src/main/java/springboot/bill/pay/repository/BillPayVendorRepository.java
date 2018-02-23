package springboot.bill.pay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.bill.pay.dto.BillPayVendor;

import java.util.Optional;

public interface BillPayVendorRepository extends JpaRepository<BillPayVendor, Long> {

    Optional<BillPayVendor> findByAccountId(Long accountId);

}
