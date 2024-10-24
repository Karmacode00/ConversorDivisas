import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String API_KEY = "05bfbc6092ec3a3f41e720aa";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la moneda base (ej. USD): ");
        String baseCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Ingresa la moneda destino (ej. EUR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Ingresa la cantidad a convertir: ");
        double amount = scanner.nextDouble();

        try {
            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
            double convertedAmount = amount * exchangeRate;

            System.out.printf("%.2f %s son equivalentes a %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);

        } catch (IOException e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }
    }

    // Método para obtener la tasa de cambio entre dos monedas
    private static double getExchangeRate(String baseCurrency, String targetCurrency) throws IOException {
        String url = BASE_URL + API_KEY + "/latest/" + baseCurrency;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);

        if (response.getStatusLine().getStatusCode() == 200) {
            String jsonResponse = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = new JSONObject(jsonResponse);

            return jsonObject.getJSONObject("conversion_rates").getDouble(targetCurrency);
        } else {
            throw new IOException("No se pudo obtener la tasa de cambio.");
        }
    }
}
