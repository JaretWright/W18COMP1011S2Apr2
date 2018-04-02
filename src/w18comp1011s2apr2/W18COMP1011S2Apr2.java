package w18comp1011s2apr2;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author JWright
 */
public class W18COMP1011S2Apr2
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException
    {
        byte[] salt = PasswordGenerator.getSalt();
        byte[] salt2 = PasswordGenerator.getSalt();
        System.out.printf("Hashing the password \"Hello\": %s%n", PasswordGenerator.getPW("Hello", salt));
        System.out.printf("Hashing the password \"Hello\": %s%n", PasswordGenerator.getPW("Hello", salt2));
        
    }
    
}
