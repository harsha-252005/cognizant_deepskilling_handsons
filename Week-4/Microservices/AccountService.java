import java.math.BigDecimal;
import java.util.Map;

/** Domain boundary used by the account microservice. */
public final class AccountService {
    private static final Map<String, BigDecimal> BALANCES = Map.of("AC-100", new BigDecimal("12500.00"));
    public BigDecimal balance(String accountNumber) {
        BigDecimal balance = BALANCES.get(accountNumber);
        if (balance == null) throw new IllegalArgumentException("Account not found: " + accountNumber);
        return balance;
    }
}
