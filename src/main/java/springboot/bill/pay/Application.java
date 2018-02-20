package springboot.bill.pay;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springboot.bill.pay.dto.Account;
import springboot.bill.pay.dto.BillPayVendor;
import springboot.bill.pay.repository.AccountRepository;
import springboot.bill.pay.repository.BillPayVendorRepository;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    /**
     * @param args
     * This is the starting point for Bill Pay service
     */

	public static void main(String args[]) {
		new SpringApplication().run(Application.class, args);
	}


	/**
	 *
	 * @param accountRepository
	 * @param repository
	 * @return
	 * This is just to create records in H2 Database.
	 */
	@Bean
	CommandLineRunner init(AccountRepository accountRepository,
                           BillPayVendorRepository repository) {
		return (evt) -> Arrays.asList("abcd,xyz,Test1,Test2".split(","))
				.forEach(
						a -> {
							Account account = accountRepository.save(new Account(a, "test"));
							repository.save(new BillPayVendor(account,"ATT", "Recurrent", null, new BigDecimal(14)));
							repository.save(new BillPayVendor(account,"WaterCo", "oneOff", null, new BigDecimal(44)));
						});
	}

}
