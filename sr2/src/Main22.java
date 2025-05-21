import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Main22{

    public static String getSHA512Hash(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 128) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String hash = "2a2375e1171723a0e04a3c49adccb4ec6db86b2f7527db45e0bb84d8d76a9b9d3536d39e01b92d303fc966b36aa73475f9aea541d63f5ad894a50dda63b68a1c";
        String pas = "abcde";
        StringBuilder string = new StringBuilder();
        char[] chars = pas.toCharArray();
        for (char ch1: chars) {
            for (char ch2: chars) {
                for (char ch3: chars) {
                    for (char ch4 : chars) {
                        for (char ch5 : chars) {
                            string.setLength(0);
                            string.append(ch1).append(ch2).append(ch3).append(ch4).append(ch5);
                            String pasHash = getSHA512Hash(string.toString());

                            if (pasHash.equals(hash)){
                                System.out.println(pasHash);
                                System.out.println(string);//eabec
                            }
                        }
                    }
                }
            }
        }
    }
}