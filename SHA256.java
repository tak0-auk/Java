package SHA256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by tak0 on 2016/08/01.
 */
public class SHA256 {

    public String stretchedSHA256(String value, int many){
        String salt = getSHA256(value);
        String hash = "";
        for(int i=0; i<many; i++){
            hash = getSHA256(hash + salt);
        }
        return hash;
    }

    public String getSHA256(String value){
        MessageDigest digest = null;
        StringBuilder builder = null;
        try {
            digest = MessageDigest.getInstance("SHA256");
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        digest.update(value.getBytes());
        builder = new StringBuilder();
        for (byte b : digest.digest()){
            String hex = String.format("%02x", b);
            builder.append(hex);
        }
        return builder.toString();
    }
}
