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
            if (Character.isUpperCase(c)) {
                char shift = (char)(((c - 'A' + key) % 26) + 'A');
                encrypted += shift;
            } else if (Character.isLowerCase(c)) {
                char shift = (char)(((c - 'a' + key) % 26) + 'a');
                encrypted += shift;
            } else {
                encrypted += c; // Non-letter characters remain unchanged
            }
        }

        // Decryption
        for (int i = 0; i < encrypted.length(); i++) {
            char c = encrypted.charAt(i);
            if (Character.isUpperCase(c)) {
                char shift = (char)(((c - 'A' - key + 26) % 26) + 'A');
                decrypted += shift;
            } else if (Character.isLowerCase(c)) {
                char shift = (char)(((c - 'a' - key + 26) % 26) + 'a');
                decrypted += shift;
            } else {
                decrypted += c; // Non-letter characters remain unchanged
            }
        }

        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);
    }
}
