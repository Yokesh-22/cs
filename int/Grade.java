import java.util.*;

public class Grade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter number of subjects : ");
        int num = scanner.nextInt();
        int sum=0,marks=0,avg=0;
        for (int i = 0;i<num;i++){
            System.out.printf("Subject-%d : ",i+1);
            marks=scanner.nextInt();
            sum+=marks;
        }
        avg= sum/num;
        System.out.printf("Total marks in %d subjects is: %d. \nAverage percentage is %d.\n",num,sum,avg);
        if(avg>=90) System.out.println("Grade = O.");
        else if(avg>=80 && avg<90) System.out.println("Grade = A+.");
        else if(avg>=70 && avg<80) System.out.println("Grade = A.");
        else if(avg>=60 && avg<70) System.out.println("Grade = B+.");
        else if(avg>=50 && avg<60) System.out.println("Grade = B.");
        else System.out.println("Grade = Fail.");
    }    
}
