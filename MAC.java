import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class MAC {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input message from user
        System.out.print("Enter message: ");
        String message = sc.nextLine();

        // Step 2: Input shared secret key
        System.out.print("Enter secret key: ");
        String secretKey = sc.nextLine();

        // Step 3: Create MAC using HmacSHA256
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        mac.init(keySpec);

        // Step 4: Generate MAC
        byte[] macBytes = mac.doFinal(message.getBytes());
        String macCode = Base64.getEncoder().encodeToString(macBytes);

        // Step 5: Display results
        System.out.println("Message: " + message);
        System.out.println("Secret Key: " + secretKey);
        System.out.println("Generated MAC: " + macCode);
    }
}
