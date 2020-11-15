package CompareTool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    private static String checkAndConvertString(String announcement) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        while (true) {
            if (string == null || string.trim().isBlank()) {
                System.out.println("String cannot be empty. Please try again.");
                System.out.print(announcement);
                string = br.readLine();
            } else if (string.length() > 50) {
                System.out.println("You can enter up no more 50 letters. Please try again.");
                System.out.print(announcement);
                string = br.readLine();
            } else {
                break;
            }
        }

        return string.replaceAll("[^\\p{Alnum}]", "").toLowerCase();
    }

    private static void printBorder() {
        for (int i = 0; i < 150; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        PersonalData object1 = new PersonalData();
        PersonalData object2 = new PersonalData();

        //Data entry for OBJECT 1
        System.out.println("---PersonalData OBJECT 1---");

        System.out.print("Please type OBJECT 1 first name: ");
        object1.setFirstName(checkAndConvertString("Please type OBJECT 1 first name: "));

        System.out.print("Please type OBJECT 1 second name: ");
        object1.setSecondName(checkAndConvertString("Please type OBJECT 1 second name: "));

        System.out.print("Please type OBJECT 1 patronymic name: ");
        object1.setPatronymicName(checkAndConvertString("Please type OBJECT 1 patronymic name: "));

        System.out.println();

        //Data entry for OBJECT 2
        System.out.println("---PersonalData OBJECT 2---");

        System.out.print("Please type OBJECT 2 first name: ");
        object2.setFirstName(checkAndConvertString("Please type OBJECT 2 first name: "));

        System.out.print("Please type OBJECT 2 second name: ");
        object2.setSecondName(checkAndConvertString("Please type OBJECT 2 second name: "));

        System.out.print("Please type OBJECT 2 patronymic name: ");
        object2.setPatronymicName(checkAndConvertString("Please type OBJECT 2 patronymic name: "));

        System.out.println();


        //Result output
        System.out.println("---------------");
        System.out.println("PersonalData OBJECT 1: " + object1);
        System.out.println("PersonalData OBJECT 2: " + object2);
        System.out.println();

        Result result = new Result();

        printBorder();
        System.out.printf("|%-20s|%-52s|%-52s|%-10s|%-10s|%n",
                "", "OBJECT 1", "OBJECT 2", "isValid", "errCount");
        printBorder();

        result.compareTwoStrings(object1.getFirstName(), object2.getFirstName());
        System.out.printf("|%-20s", "first name");
        System.out.print(result);

        result.compareTwoStrings(object1.getSecondName(), object2.getSecondName());
        System.out.printf("|%-20s", "second name");
        System.out.print(result);

        result.compareTwoStrings(object1.getPatronymicName(), object2.getPatronymicName());
        System.out.printf("|%-20s", "patronymic name");
        System.out.print(result);

        printBorder();
    }
}
