package receiver.models;

/**
 * Created by 1 on 06.02.14.
 */
public class Weather {
    private int temperature;
    private int humidity;
    private String forecast;
    private String url;

    public Weather(int temperature, int humidity, String forecast, String url) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.forecast = forecast;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", forecast='" + forecast + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
