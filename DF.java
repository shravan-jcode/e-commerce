import java.util.Scanner;

public class DF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input public prime number and base (generator)
        System.out.print("Enter prime number (p): ");
        int p = sc.nextInt();
        System.out.print("Enter primitive root (g): ");
        int g = sc.nextInt();

        // Step 2: Input private keys for Alice and Bob
        System.out.print("Enter Alice's private key: ");
        int a = sc.nextInt();
        System.out.print("Enter Bob's private key: ");
        int b = sc.nextInt();

        // Step 3: Calculate public keys
        int A = modExp(g, a, p); // Alice's public key
        int B = modExp(g, b, p); // Bob's public key

        // Step 4: Generate shared secret key
        int keyA = modExp(B, a, p); // Alice calculates shared key
        int keyB = modExp(A, b, p); // Bob calculates shared key

        // Display results
        System.out.println("\nAlice's Public Key: " + A);
        System.out.println("Bob's Public Key: " + B);
        System.out.println("Shared Secret Key (Alice): " + keyA);
        System.out.println("Shared Secret Key (Bob): " + keyB);
        // Both shared keys should be same
    }

    // Function for modular exponentiation
    public static int modExp(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;
        for (int i = 0; i < exp; i++) {
            result = (result * base) % mod;
        }
        return result;
    }
}
