import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean again = true;

        while (again) {
            Connect4.playGame(input);
            System.out.print("Do you want to play another game? (y/n)? ");
            String reply = input.next();
            again = (reply.equalsIgnoreCase("y"));
        }
    }
}

