import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

class BruteForceCracker implements PasswordCracker {
    private String Algorithm;
    public BruteForceCracker( String Algorithm) {
        this.Algorithm = Algorithm;
    }
    @Override
    public String crack(String hash) {
        try {
            MessageDigest digest = MessageDigest.getInstance(Algorithm);
            for (int len = 1; len < 9; len++) {
                String password = bruteForce("", len, hash, digest);
                if (password != null) {
                    return password;
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String bruteForce(String prefix, int length, String hash, MessageDigest digest) {
        if (length == 0) {
            byte[] hashedBytes = digest.digest(prefix.getBytes());
            String hashedWord = bytesToHex(hashedBytes);
            if (hashedWord.equals(hash)) {
                return prefix;
            } else {
                return null;
            }
        } else {
            for (int i = 32; i < 127; i++) {
                char c = (char) i;
                String newPrefix = prefix + c;
                String password = bruteForce(newPrefix, length - 1, hash, digest);
                if (password != null) {
                    return password;
                }
            }
            return null;
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}
