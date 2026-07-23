import java.math.BigDecimal;

/** Domain boundary used by the loan microservice. */
public final class LoanService {
    public boolean eligible(BigDecimal monthlyIncome, BigDecimal requestedAmount) {
        return monthlyIncome != null && requestedAmount != null && monthlyIncome.multiply(BigDecimal.valueOf(24)).compareTo(requestedAmount) >= 0;
    }
}
