import java.util.Scanner;

public class otp {

    public static void oneTimePad(){

        boolean boo = true;
        while(boo){
            String encrypted = "test";
            String decrypted = "test2";
            String key = "random";

            System.out.println("Enter: (1) Generate random key (2) Encrypt (3) Decrypt (4) Exit");
            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();
            System.out.println("Choice: " + choice);

            if (choice == 1){
                System.out.println("Enter the length of the key: ");
                int length = scanner.nextInt();
                System.out.println("Random key of length " + length + " generated.");
            }

            else if (choice == 2){
                System.out.println("Enter the plaintext: ");
                String text = scanner.next();
                System.out.println(text + " encrypted using the one-time pad is " + encrypted);
            }

            else if (choice == 3){
                System.out.println("Enter the ciphertext:");
                encrypted = scanner.next();
                System.out.println(encrypted + " decrypted using the one-time pad is " + decrypted);
            }

            else if (choice == 4){
                boo = false;
            }
        }
    }

    public static void main(String[] args){
        oneTimePad();
    }
}
