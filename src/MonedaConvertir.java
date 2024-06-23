import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MonedaConvertir {
    @SerializedName("base_code")
    private String baseCode;
    @SerializedName("target_code")
    private String targetCode;
    private double cantidad;
    private double resultado;

    public MonedaConvertir(String baseCode, String targetCode, double cantidad) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.cantidad = cantidad;
    }
    public double convert() throws IOException, InterruptedException {
        String apiKey = "9f4d76607dd276ea609f746c";
        String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCode;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlStr))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
            double conversionRate = conversionRates.get(targetCode).getAsDouble();
            resultado = cantidad * conversionRate;
            return resultado;
        } else {
            throw new IOException("Error de solicitud al servidor: " + response.statusCode());
        }
    }
}
