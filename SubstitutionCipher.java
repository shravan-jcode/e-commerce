import java.util.Scanner;

public class SubstitutionCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter key (number): ");
        int key = sc.nextInt();

        String encrypted = "";
        String decrypted = "";

        // Encryption
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                char shift = (char)(((c - 'A' + key) % 26) + 'A');
                encrypted += Character.isUpperCase(c) ? shift : Character.toLowerCase(shift);
            } else {
                encrypted += c;
            }
        }

        // Decryption
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            if (Character.isLetter(c)) {
                char shift = (char)(((c - 'A' - key + 26) % 26) + 'A');
                decrypted += Character.isUpperCase(c) ? shift : Character.toLowerCase(shift);
            } else {
                decrypted += c;
            }
        }

        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);
    }
}
