import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class MAC {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

      
        System.out.print("Enter message: ");
        String message = sc.nextLine();

       
        System.out.print("Enter secret key: ");
        String secretKey = sc.nextLine();

       
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256");
        mac.init(keySpec);

       
        byte[] macBytes = mac.doFinal(message.getBytes());
        String macCode = Base64.getEncoder().encodeToString(macBytes);

        
        System.out.println("Message: " + message);
        System.out.println("Secret Key: " + secretKey);
        System.out.println("Generated MAC: " + macCode);
    }
}
