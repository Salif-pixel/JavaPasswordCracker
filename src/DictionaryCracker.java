import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

class DictionaryCracker implements PasswordCracker {
    private List<String> dictionary;
    private String Algorithm;

    public DictionaryCracker(List<String> dictionary,String Algorithm) {
        this.dictionary = dictionary;
        this.Algorithm = Algorithm;
    }

    @Override
    public String crack(String hash) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            for (String word : dictionary) {
                byte[] hashedBytes = digest.digest(word.getBytes());
                String hashedWord = bytesToHex(hashedBytes);
                if (hashedWord.equals(hash)) {
                    return word;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}