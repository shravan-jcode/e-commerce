import java.util.Scanner;

public class DF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        System.out.print("Enter prime number (p): ");
        int p = sc.nextInt();
        System.out.print("Enter primitive root (g): ");
        int g = sc.nextInt();

       
        System.out.print("Enter Alice's private key: ");
        int a = sc.nextInt();
        System.out.print("Enter Bob's private key: ");
        int b = sc.nextInt();

        
        int A = modExp(g, a, p); 
        int B = modExp(g, b, p); 

       
        int keyA = modExp(B, a, p); 
        int keyB = modExp(A, b, p); 

        
        System.out.println("\nAlice's Public Key: " + A);
        System.out.println("Bob's Public Key: " + B);
        System.out.println("Shared Secret Key (Alice): " + keyA);
        System.out.println("Shared Secret Key (Bob): " + keyB);
       
    }

  
    public static int modExp(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;
        for (int i = 0; i < exp; i++) {
            result = (result * base) % mod;
        }
        return result;
    }
}
