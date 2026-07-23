import java.math.BigDecimal;

public class FinancialForecastDemo {
    public static void main(String[] args) {
        BigDecimal futureValue = FinancialForecast.forecastMemoized(
                new BigDecimal("100000"), new BigDecimal("0.08"), 5);
        System.out.println("Forecast after 5 years: Rs. " + FinancialForecast.money(futureValue));
    }
}
