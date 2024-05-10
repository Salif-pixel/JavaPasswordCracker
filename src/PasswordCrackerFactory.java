import java.util.ArrayList;
import java.util.List;

class PasswordCrackerFactory {

     public static  List<String> methode =List.of("Dictionary","BruteForce");
     public static List<String> Algorithm =List.of("MD5","SHA-1","SHA-256","SHA-384","SHA-512","SHA-224");
    public static PasswordCracker createCracker(String type, List<String> dictionary,String Algorithm) {
        if (type.equalsIgnoreCase("Dictionary")) {
            return new DictionaryCracker(dictionary,Algorithm);
        } else if (type.equalsIgnoreCase("BruteForce")) {
            return new BruteForceCracker(Algorithm);
        }
        return null;
    }
}
