package lesson4.lecture;

public class SwitchExample {

    public static void main(String[] args) {
        String name = "Kappa";

        switch (name) {
            case "Jack":
                System.out.println("Hello");
                break;

            case "Jim":
            case "Bob":
                System.out.println("GTFO");
                break;

            default:
                System.out.println("Who the hell r u?");
                break;
        }
    }
}
