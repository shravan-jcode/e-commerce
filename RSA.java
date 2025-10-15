import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter prime number p: ");
        int p = sc.nextInt();
        System.out.print("Enter prime number q: ");
        int q = sc.nextInt();

        
        int n = p * q;
        int phi = (p - 1) * (q - 1);

       
        int e = 2;
        while (e < phi) {
            if (gcd(e, phi) == 1)
                break;
            e++;
        }

     
        int d = 1;
        while ((d * e) % phi != 1) {
            d++;
        }

        System.out.println("Public Key (e,n): (" + e + "," + n + ")");
        System.out.println("Private Key (d,n): (" + d + "," + n + ")");

       
        System.out.print("Enter number to encrypt: ");
        int msg = sc.nextInt(); 
     

        
        int cipher = modExp(msg, e, n);
        System.out.println("Encrypted Number: " + cipher);

       
        int decrypted = modExp(cipher, d, n);
        System.out.println("Decrypted Number: " + decrypted);
    }

    
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

   
    public static int modExp(int base, int exp, int mod) {
        BigInteger result = BigInteger.valueOf(base).modPow(BigInteger.valueOf(exp), BigInteger.valueOf(mod));
        return result.intValue();
    }
}
