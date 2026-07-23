import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/** Recursive financial forecast with a memoized alternative. */
public final class FinancialForecast {
    private FinancialForecast() { }

    public static BigDecimal forecast(BigDecimal presentValue, BigDecimal rate, int periods) {
        validate(presentValue, rate, periods);
        if (periods == 0) return presentValue;
        return forecast(presentValue, rate, periods - 1).multiply(BigDecimal.ONE.add(rate));
    }

    public static BigDecimal forecastMemoized(BigDecimal presentValue, BigDecimal rate, int periods) {
        validate(presentValue, rate, periods);
        return memoized(presentValue, rate, periods, new HashMap<>());
    }

    private static BigDecimal memoized(BigDecimal value, BigDecimal rate, int periods,
                                       Map<Integer, BigDecimal> cache) {
        if (periods == 0) return value;
        if (cache.containsKey(periods)) return cache.get(periods);
        BigDecimal result = memoized(value, rate, periods - 1, cache)
                .multiply(BigDecimal.ONE.add(rate));
        cache.put(periods, result);
        return result;
    }

    private static void validate(BigDecimal value, BigDecimal rate, int periods) {
        if (value == null || rate == null || value.signum() < 0 || periods < 0) {
            throw new IllegalArgumentException("Value and periods must be non-negative");
        }
    }

    public static BigDecimal money(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP);
    }
}
