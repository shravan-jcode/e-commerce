import java.util.Scanner;

public class TranspositionCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter key (number of columns): ");
        int key = sc.nextInt();

        String encrypted = encrypt(text, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);
    }

    static String encrypt(String text, int key) {
        String cipher = "";
        for (int i = 0; i < key; i++) {
            for (int j = i; j < text.length(); j += key) {
                cipher += text.charAt(j);
            }
        }
        return cipher;
    }

    static String decrypt(String cipher, int key) {
        String plain = "";
        int n = cipher.length() / key;
        int extra = cipher.length() % key;
        int index = 0;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < key && index < cipher.length(); j++) {
                plain += cipher.charAt(index++);
            }
        }
        return plain;
    }
}
