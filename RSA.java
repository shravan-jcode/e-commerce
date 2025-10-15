import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input two prime numbers
        System.out.print("Enter prime number p: ");
        int p = sc.nextInt();
        System.out.print("Enter prime number q: ");
        int q = sc.nextInt();

        // Step 2: Compute n and phi(n)
        int n = p * q;
        int phi = (p - 1) * (q - 1);

        // Step 3: Choose e (1 < e < phi and gcd(e, phi) = 1)
        int e = 2;
        while (e < phi) {
            if (gcd(e, phi) == 1)
                break;
            e++;
        }

        // Step 4: Compute d (multiplicative inverse of e mod phi)
        int d = 1;
        while ((d * e) % phi != 1) {
            d++;
        }

        System.out.println("Public Key (e,n): (" + e + "," + n + ")");
        System.out.println("Private Key (d,n): (" + d + "," + n + ")");

        // Step 5: Input number to encrypt
        System.out.print("Enter number to encrypt: ");
        int msg = sc.nextInt(); 
        // Note: message number should be less than n for proper encryption

        // Encryption: c = (msg^e) % n
        int cipher = modExp(msg, e, n);
        System.out.println("Encrypted Number: " + cipher);

        // Decryption: m = (cipher^d) % n
        int decrypted = modExp(cipher, d, n);
        System.out.println("Decrypted Number: " + decrypted);
    }

    // Function to compute gcd
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Function for modular exponentiation
    public static int modExp(int base, int exp, int mod) {
        BigInteger result = BigInteger.valueOf(base).modPow(BigInteger.valueOf(exp), BigInteger.valueOf(mod));
        return result.intValue();
    }
}
