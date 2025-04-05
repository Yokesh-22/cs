import java.util.*;
public class number_game{
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner (System.in);
        int attempts=0,guess_num;
        System.out.println("Let's start the game!!!");
        int choose = 1;
        while (choose!=0){
            int num = random.nextInt(0,100);
            attempts=0;
            while(attempts>=0){
                System.out.println("Guess the number between 1 to 100");
                guess_num=scanner.nextInt();
                if (num==guess_num) {
                    System.out.print("You guessed a correct number!! \n");
                    attempts++;
                    break;
                }
                else {
                    if (num>guess_num) System.out.println("The number is too low");
                    else System.out.println("The number is too high");
                    //System.out.printf("Your guess is wrong \nYou have %d chances left\n",5-attempts);
                    attempts++;
                }
            }
            System.out.printf("You attend %d rounds.\n**********************************************************\nIf you want to continue the game type 1 else 0\n",attempts);
            choose = scanner.nextInt();
        }
    }
}