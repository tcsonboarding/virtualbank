package springboot.bill.pay.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @JsonIgnore
    private String test;

    @OneToMany(mappedBy = "account")
    private Set<BillPayVendor> vendors = new HashSet<>();

    private Account() { } // JPA only

    public Account(final String username, final String test) {
        this.username = username;
        this.test = test;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getTest() {
        return test;
    }

    public Set<BillPayVendor> getVendors() {
        return vendors;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", test='" + test + '\'' +
                ", vendors=" + vendors +
                '}';
    }
}
