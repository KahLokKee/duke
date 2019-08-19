import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        System.out.println("Hello! I'm Duke\nWhat can I do for you?");
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNextLine()) {
                String command = sc.nextLine();
                if (command.equals("bye")) {
                    System.out.println("Bye. Hope to see you again soon!");
                    break;
                } else if (command.equals("list")) {
                    int count = 1;
                    for (String item : tasks) {
                        System.out.println(count + ". " + item);
                        count++;
                    }
                } else {
                    tasks.add(command);
                    System.out.println("added: " + command);
                }
            }
        }
    }
}