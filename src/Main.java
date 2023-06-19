import java.util.Objects;
import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        UserSignIn work = signInto();
//       ArrayList<String> favShow = new ArrayList<>();
        HashMap<String, String> favShow = new HashMap<>();
        System.out.println(work.loggedIn);
        if(work.loggedIn == false){
            signInImplement();
        }else if(work.loggedIn == true){
            char option = 'x';
            while(option != 'q'){
                option = optionsImplement();
                if (option == 'a'){
                    addShowImplement(favShow);
                }else if (option =='v'){
                    viewShow(favShow);
                }else if (option == 'd'){
                    deleteImplement(favShow);
                }
            }System.out.println("Program terminated.");
        }
    }

    // Sign in
    public static void signInImplement(){
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        char option = 'x';
        while(valid != true){
            System.out.print("≫[S]ign In or [q]uit: ");
            String select = scan.nextLine();
            select = select.toLowerCase();
            option = select.charAt(0);
            valid = signInErrorCheck(option);
        }
    }

    //Error check for signing in
    private static boolean signInErrorCheck(char option){
        if(Character.toLowerCase(option) == 's'){
            signInto();
            return true;
        } else if (Character.toLowerCase(option) == 'q') {
            System.out.println("Program terminated.");
            return true;
        }
        System.out.println("Invalid option!");
        return false;
    }

    // Getting username input
    //TODO
    private static UserSignIn signInto(){
        Scanner scan = new Scanner(System.in);
        System.out.print("≫Username?: ");
        String select = scan.nextLine();
        return new UserSignIn(select, "0");
        //signIntoError(work, select);
        // another call? checks for username? or if password is correct?
    }

    // username input error check
    private static void signIntoError(UserSignIn work, String select){
        if(Objects.equals(select, "cam")){
            work.loggedIn = true;
            System.out.println("User signed in, should change to true");
            return;
        }System.out.println("Invalid option!");
    }


    // When signed in they can view this
    public static char optionsImplement(){
        Scanner scan = new Scanner(System.in);

        boolean valid = false;
        char option = 'x';
        while(valid != true){
            System.out.print("≫[A]dd favorite show, [v]iew shows, [d]elete show or [Q]uit: ");
            String select = scan.nextLine();
            select = select.toLowerCase();
            option = select.charAt(0);
            valid = initialErrorCheck(option);
        }return option;
    }

    private static boolean initialErrorCheck(char option){
        if(Character.toLowerCase(option) == 'a'){
            return true;
        } else if (Character.toLowerCase(option) == 'v') {
            return true;
        } else if (Character.toLowerCase(option) == 'd') {
            return true;
        } else if (Character.toLowerCase(option) == 'q') {
            return true;
        }else if (Character.toLowerCase(option) == 'f') {
            return true;
        }
        System.out.println("Invalid option!");
        return false;
    }


    //adding show
    private static void addShowImplement(HashMap<String, String> favShow){
        Scanner scan = new Scanner(System.in);
        System.out.print("≫Add show: ");
        String select = scan.nextLine();
        Scanner scanned = new Scanner(System.in);
        System.out.print("≫Add platform: ");
        String selected = scan.nextLine();
        select = select.toLowerCase();
        favShow.put(select, selected);
    }

    private static void viewShow(HashMap<String, String> favShow){
        // shows all the shows, asks which show you'd like to see the anime characters form
        if (favShow.size() == 0){
            System.out.println("≫ You haven't added a show yet.");
        }else{
            System.out.println(favShow);
        }
    }
    private static void deleteImplement(HashMap<String, String> favShow){
        if(favShow.size() == 0){
            System.out.println("You haven't added a show, yet.");
        }else{
        Scanner scan = new Scanner(System.in);
        System.out.println("≫ Which show would you like to delete?: ");
        String select = scan.nextLine();
        select = select.toLowerCase();
        if (favShow.containsKey(select)){
            favShow.remove(select);
            System.out.println("Removed!");
        }else{
            System.out.println("We can't find that show.");
        }
        }
    }
}