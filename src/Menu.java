import java.util.Scanner;


public class Menu {

    public static void start() {

        Action action = askAction();
        switch (action) {
            case ENCRYPTED, DECRYPTED -> {
                int withShift = Menu.askShift();
                ActionUtils.run(action, withShift);
                sendMessage(true);
            }
            case BRUTFORCE -> {
                int shift = ActionUtils.runBrutForce();
                sendMessage(true);
                sendMessage("Смещение = " + shift);
            }
            default -> {
                sendMessage("Нет указанного действия, ничего делать не будем.");
                sendMessage(false);
            }
        }
    }

    private static Action askAction() {

        System.out.println("""
                Укажите номер действия, которое требуется выполнить:
                1. encrypted
                2. decrypted
                3. brutforce
                """);
        Scanner scanner = new Scanner(System.in);
        return Action.values()[scanner.nextInt() - 1];
    }


    private static int askShift() {

        System.out.println("""
                Укажите число знаков смещения:
                """);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    private static void sendMessage(String message) {

        System.out.println(message);
    }

    private static void sendMessage(boolean ok) {

        System.out.println((ok) ? "Выполнено" : "Не выполнено");
    }
}
