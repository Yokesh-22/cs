package Singleton;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("System startup...");
        logger2.log("Performing background tasks...");

        if (logger1 == logger2) {
            System.out.println("Confirmed: Only one instance of Logger exists.");
        } else {
            System.out.println("Singleton failed: Multiple instances found.");
        }
    }
}

