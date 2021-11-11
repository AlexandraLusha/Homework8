import java.io.IOException;
import java.text.ParseException;

public interface IWeatherProvider {

    Weather getWeather(String cityKey) throws IOException, ParseException;

    void getWeatherFiveDays(String cityKey) throws IOException, ParseException;
}
