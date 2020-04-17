import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class otp {
    static int length;
    static String encrypted = "";
    static String decrypted = "";
    static boolean boo = true;
    static char[] splitKey = new char[50];

    public static void oneTimePad(){

        HashMap<Integer, Character> hashMap = new HashMap<>();
        hashMap.put(0,'A');
        hashMap.put(1,'B');
        hashMap.put(2,'C');
        hashMap.put(3,'D');
        hashMap.put(4,'E');
        hashMap.put(5,'F');
        hashMap.put(6,'G');
        hashMap.put(7,'H');
        hashMap.put(8,'I');
        hashMap.put(9,'J');
        hashMap.put(10,'K');
        hashMap.put(11,'L');
        hashMap.put(12,'M');
        hashMap.put(13,'N');
        hashMap.put(14,'O');
        hashMap.put(15,'P');
        hashMap.put(16,'Q');
        hashMap.put(17,'R');
        hashMap.put(18,'S');
        hashMap.put(19,'T');
        hashMap.put(20,'U');
        hashMap.put(21,'V');
        hashMap.put(22,'W');
        hashMap.put(23,'X');
        hashMap.put(24,'Y');
        hashMap.put(25,'Z');

        // Generates random bytes array to pull random key # from
        Random random = new Random();
        byte[] randomBytes = new byte[50];
        random.nextBytes(randomBytes);

        while(boo){
            System.out.println("Enter: (1) Generate random key (2) Encrypt (3) Decrypt (4) Exit");
            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();
            System.out.println("Choice: " + choice);

            if (choice == 1){

                System.out.println("Enter the length of the key: ");
                length = scanner.nextInt();
                System.out.println("Random key of length " + length + " generated.");

                // randomly generates key
                for (int i = 0; i < length; i++){
                    splitKey[i] = hashMap.get(Math.abs(randomBytes[i] % 26));
                }
            }

            else if (choice == 2){
                System.out.println("Enter the plaintext: ");
                String text = scanner.next();

                if(length < text.length()){
                    System.out.println("Please enter a key length that is greater than or equal to the length of your plaintext.");
                    length = scanner.nextInt();
                    System.out.println("Random key of length " + length + " generated.");
                    // randomly generates key
                    for (int i = 0; i < length; i++){
                        splitKey[i] = hashMap.get(Math.abs(randomBytes[i] % 26));
                    }

                }

                // Take input and split it up individually.
                // ch is char array of plain text, splitKey is char array of key.
                char[] ch = new char[text.length()];
                for (int i = 0; i < text.length(); i++){
                    ch[i] = text.charAt(i);
                    encrypted = encrypted + hashMap.get(Math.abs(splitKey[i] + ch[i] % 26));
                }

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
