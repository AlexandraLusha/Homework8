import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Controller implements IController {

    ICityCode codeProvider = new AccuWeatherCity();
    IWeatherProvider weatherProvider = new AccuWeather();
    IWeatherRepository weatherRepository = new SQLite();


    @Override
    public void onCityInput(String city) throws IOException {

        if (city.length() == 1) {
            throw new IOException("Такой город точно есть?");
        }
        codeProvider.getCityName(city);

    }

    @Override
    public void onCommandChosen(int selectedCommand) throws IOException, ParseException {
        System.out.println();
        switch (selectedCommand) {
            case 1: {
                Weather currentWeather = weatherProvider.getWeather(AppGlobalState.getInstance().getCityKey());
                System.out.println(currentWeather);
                weatherRepository.saveWeatherObject(currentWeather);
                break;
            }
            case 2: {
                weatherProvider.getWeatherFiveDays(AppGlobalState.getInstance().getCityKey());
                break;
            }
            case 3: {
                List<Weather> allData = weatherRepository.getAllData();
                allData.forEach(System.out::println);

                break;
            }
            default: {
                throw new IOException("Что-то пошло не так...\n");
            }
        }
    }
}
