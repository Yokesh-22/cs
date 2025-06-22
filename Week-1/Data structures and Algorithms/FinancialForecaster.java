public class FinancialForecaster {


    public static double calculateFutureValue(double currentValue, double[] growthRates, int periods) {
        if (periods == 0) {
            return currentValue;
        }

        int index = getSafeIndex(growthRates.length, periods);
        double growthRate = growthRates[index];
        double nextValue = currentValue * (1 + growthRate);

        return calculateFutureValue(nextValue, growthRates, periods - 1);
    }

    public static double calculateFutureValueMemoized(double currentValue, double[] growthRates, int periods) {
        double[] memo = new double[periods + 1];
        memo[0] = currentValue;

        return futureValueHelper(memo, growthRates, periods);
    }

    private static double futureValueHelper(double[] memo, double[] growthRates, int periods) {
        if (memo[periods] != 0) {
            return memo[periods];
        }

        if (periods == 0) {
            return memo[0];
        }

        double prevValue = futureValueHelper(memo, growthRates, periods - 1);
        int index = getSafeIndex(growthRates.length, periods);
        double growthRate = growthRates[index];
        memo[periods] = prevValue * (1 + growthRate);

        return memo[periods];
    }

    private static int getSafeIndex(int totalLength, int currentPeriod) {
        return ((totalLength - currentPeriod) % totalLength + totalLength) % totalLength;
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double[] growthRates = {0.05, 0.03, 0.07}; // 5%, 3%, 7%
        int forecastPeriods = 5;

        double futureValue = calculateFutureValue(initialValue, growthRates, forecastPeriods);
        System.out.printf("Future value after %d periods: $%.2f%n", forecastPeriods, futureValue);

        double memoizedValue = calculateFutureValueMemoized(initialValue, growthRates, forecastPeriods);
        System.out.printf("Memoized future value after %d periods: $%.2f%n", forecastPeriods, memoizedValue);
    }
}
