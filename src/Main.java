import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String hashToCrack = "a9fbf652584d2904a8bf8246e7b3387c";
        String choice;
        String Algorithm;
        Scanner saisir = new Scanner(System.in);
        System.out.println("Veuillez donner un mot de passe hasher");
        hashToCrack= saisir.nextLine();
        System.out.println("Choisissez une methode pour trouver le mot de passe");
        for(String methode : PasswordCrackerFactory.methode){
            System.out.println(methode);
        }
        choice=saisir.nextLine();
        System.out.println("Choisissez un Algorithm pour trouver le mot de passe");
        for(String algorithm : PasswordCrackerFactory.Algorithm){
            System.out.println(algorithm);
        }
        Algorithm=saisir.nextLine();
        List<String> dictionary = Dictionnaire.Chargerdictionnaire();
        PasswordCracker passwordCracker= PasswordCrackerFactory.createCracker(choice,dictionary,Algorithm);
        String password=passwordCracker.crack(hashToCrack);
        if (password != null) {
            System.out.println("Mot de passe trouvé : " + password);
        } else {
            System.out.println("Mot de passe non trouvé ");
        }


    }
}