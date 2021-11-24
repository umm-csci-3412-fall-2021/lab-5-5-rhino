/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package xrate;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String NICS_DUMMY_DATA_URL = "http://facultypages.morris.umn.edu/~mcphee/ExchangeRateData/";

    /**
     * Prompts the user for a currency code, and prints out the exchange rate for
     * that currency code for the (fixed) date 25 June 2010 as read from the cached
     * data.
     * 
     * @param args these are ignored
     * @throws IOException if there are problems reading the exchange rate data from
     *                     the URL
     */
    public static void main(String[] args) throws IOException {
        ExchangeRateReader exchangeRateReader = new ExchangeRateReader(NICS_DUMMY_DATA_URL);

        System.out.print("Enter the desired currency code: ");
        Scanner scanner = new Scanner(System.in);
        String currencyCode = scanner.nextLine();
        System.out.print("\nEnter the currency to use as base, or leave blank to use EUR:");
        String baseCode = scanner.nextLine();
        if(baseCode.isBlank()){
            baseCode = "EUR";
        }
        scanner.close();

        System.out.println(exchangeRateReader.getExchangeRate(currencyCode, baseCode, 2010, 6, 25));
    }
}
