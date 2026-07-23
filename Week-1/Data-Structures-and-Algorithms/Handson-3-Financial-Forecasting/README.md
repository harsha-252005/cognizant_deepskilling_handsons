# Financial Forecasting

Forecasts the value of an investment after `n` periods using the recurrence
`F(n) = F(n - 1) * (1 + growthRate)`. `forecastMemoized` avoids repeated work
when several period forecasts are requested.

```powershell
cd src
javac *.java
java FinancialForecastDemo
```
