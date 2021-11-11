import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class UserInterface implements IUserInterface {

    IController controller = new Controller();

    @Override
    public void Menu() {
        while (true) {
            System.out.println("Здравствуйте. Что Вы хотите?");
            System.out.println("\n1 - узнать о погоде в городе\n2 - получить информацию из предыдущих обращений \n  'exit' для выхода");

            Scanner scanner = new Scanner(System.in);

            String menuChoice = scanner.nextLine();

            checkIsExit(menuChoice);


            if (menuChoice.equalsIgnoreCase("2")) {
                try {
                    controller.onCommandChosen(3);
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Введите название города на английском:");
                String userResponse = scanner.nextLine();

                try {
                    controller.onCityInput(userResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }

                System.out.println("\n1 - погода на текущий день\n2 - погода на 5 дней");


                System.out.println("***");
                int selectedCommand = scanner.nextInt();

                try {
                    controller.onCommandChosen(selectedCommand);
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void checkIsExit(String userResponse) {
        if (userResponse.equalsIgnoreCase("exit") ||
                userResponse.equalsIgnoreCase("выход")) {

            System.out.println("Пока-пока)");
            System.exit(0);
        }
    }
}
