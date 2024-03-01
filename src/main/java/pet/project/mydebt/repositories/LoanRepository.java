package pet.project.mydebt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.project.mydebt.entities.Loan;
import pet.project.mydebt.entities.UserLoan;

public interface LoanRepository extends JpaRepository<Loan, UserLoan> {
}
