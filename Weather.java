public class Weather {

    private String date;
    private String city;
    private String temperature;
    private String weatherText;

    public Weather(String date, String city, String temperature, String weatherText) {
        this.date = date;
        this.city = city;
        this.temperature = temperature;
        this.weatherText = weatherText;
    }

    public Weather() {
    }

    public String getDate() {
        return date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWeatherText() {
        return weatherText;
    }

    @Override
    public String toString() {
        return date + " в городе " + city + " будет погода " + weatherText + " с температурой " + temperature + " °C";
    }
}
