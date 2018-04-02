package w18comp1011s2apr2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author JWright
 */
public class PasswordGenerator
{
    /**
     * This will create a random salt consisting of 16 bytes
     */
    public static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom rng = SecureRandom.getInstanceStrong();
        byte[] salt = new byte[16];
        rng.nextBytes(salt);
        return salt;
    }
    
    /**
     * This will hash a password with a given salt and return it as a String
     */
    public static String getPW(String pw, byte[] salt)
    {
        String hashedPW = null;
        
        try
        {
            //configure the hashing algorithm
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            
            byte[] hashed = md.digest(pw.getBytes());
            
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            
            //remove starting here
//            System.out.printf("byte array length: %d%n", hashed.length);
//            for (int i=0; i<hashed.length; i++)
//            {
//                System.out.printf("'%s' ", hashed[i]);
//            }
            //remove ending here - just to see how this works
            
            for (int i=0; i<hashed.length; i++)
            {
                sb.append(Integer.toString((hashed[i] & 0xff)+0x100,16).substring(1));
//                System.out.printf("%s%n",sb.toString());
            }
            
            for (int i=0; i<hashed.length; i++)
            {
                //does the same as the previous loop, but uses String.format 
                //instead of bitwise &
                sb2.append(String.format("%02x", hashed[i]));
            }
            hashedPW = sb.toString();
            System.out.printf("\nThe hashed PW is:                  %s %n", hashedPW);
            System.out.printf("The hashed PW using String.format: %s %n", sb2.toString());

        }
        catch (NoSuchAlgorithmException e)
        {
           System.err.println(e);
        }
        
        return hashedPW;
    }
    
}
