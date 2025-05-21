import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Main21 { //чисто дешифрование
    private static byte[] readBytes(String filePath) throws IOException {
        File file = new File(filePath);
        return Files.readAllBytes(file.toPath());
    }

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] key = new byte[16];
        byte[] IV = new byte[16];

        byte[] result = readBytes("resourses/aes.key");

        System.arraycopy(result, 16, key, 0, 16);
        System.arraycopy(result, 0, IV, 0, 16);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new GCMParameterSpec(128, IV));
        byte[] decodedBytes = cipher.doFinal(readBytes("resourses/secret_text.enc"));
        String string = new String(decodedBytes);
        System.out.println(string);//Java is the best, my dudes
    }
}