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

    public static void main(String[] args) throws IOException {
        PersonalData objectOne = new PersonalData();
        PersonalData objectTwo = new PersonalData();

        //START entry PersonalData objects

        //Data entry for PersonalData OBJECT 1
        System.out.println("---PersonalData OBJECT 1---");

        System.out.print("Please type OBJECT 1 first name: ");
        objectOne.setFirstName(checkAndConvertString("Please type OBJECT 1 first name: "));

        System.out.print("Please type OBJECT 1 second name: ");
        objectOne.setSecondName(checkAndConvertString("Please type OBJECT 1 second name: "));

        System.out.print("Please type OBJECT 1 patronymic name: ");
        objectOne.setPatronymicName(checkAndConvertString("Please type OBJECT 1 patronymic name: "));

        System.out.println();

        //Data entry for PersonalData OBJECT 2
        System.out.println("---PersonalData OBJECT 2---");

        System.out.print("Please type OBJECT 2 first name: ");
        objectTwo.setFirstName(checkAndConvertString("Please type OBJECT 2 first name: "));

        System.out.print("Please type OBJECT 2 second name: ");
        objectTwo.setSecondName(checkAndConvertString("Please type OBJECT 2 second name: "));

        System.out.print("Please type OBJECT 2 patronymic name: ");
        objectTwo.setPatronymicName(checkAndConvertString("Please type OBJECT 2 patronymic name: "));

        System.out.println();
        //END entry PersonalData objects

        Result result = new Result(objectOne, objectTwo);

        //Output

        System.out.println(result);
    }
}
