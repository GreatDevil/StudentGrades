import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Загрузить файл? : yes or no");
        String answer = System.console().readLine();
        if("yes".equals(answer)) {
            System.out.println("введите имя файла");
            System.out.println(FileWorker.read(System.console().readLine()));
        }
        handler(showMenu());
    }

    private static void handler(String input) {
        if(Arrays.stream(Menu.values()).map(Enum::name).toList().contains(input)) {
            action(Menu.valueOf(input));
        }
    }

    private static void action(Menu menu) {
        System.out.println(menu.answer);
        System.out.println(menu.action.apply(System.console().readLine()));
        handler(showMenu());
    }

    private static String showMenu() {
        Arrays.stream(Menu.values()).map(r -> r.describe).forEach(System.out::println);
        return System.console().readLine().toUpperCase();
    }
}
