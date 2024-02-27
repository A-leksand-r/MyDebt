package pet.project.mydebt.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Loan {
    @Embeddable
    @Getter
    @Setter
    class Pk implements Serializable {

        private Long idLoan;

        private Long idRecipient;

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pk) {
                if (this.idLoan.equals(((Pk)obj).idLoan))
                    return this.idLoan.equals(((Pk)obj).idLoan);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(idLoan);
        }
    }
    @EmbeddedId
    private Pk id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "idDonor", nullable = false)
    private Long idDonor;

    @Column(nullable = false)
    private BigDecimal loanAmount;

    @Column(nullable = false)
    private BigDecimal remainingDebt;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate dateOfIssue;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate returnDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;
}
