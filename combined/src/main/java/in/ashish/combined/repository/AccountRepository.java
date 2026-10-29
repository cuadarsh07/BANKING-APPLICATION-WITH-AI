package in.ashish.combined.repository;

import in.ashish.combined.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for Account persistence operations.
 *
 * Interview Concepts:
 * - Spring Data JPA generates the proxy implementation at runtime based on method names.
 * - findByAccountNumber: Spring parses the method name ("findBy" + "AccountNumber") and creates "SELECT a FROM Account a WHERE a.accountNumber = :accountNumber".
 * - existsByAccountNumber: Generates an optimized COUNT or EXISTS SQL query without loading entire entity state into memory.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);

    boolean existsByAccountNumber(String accountNumber);

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);
}
