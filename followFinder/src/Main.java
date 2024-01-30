// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.*;
import java.io.*;
/*
This program will help you find Instagram
followers who do not follow you back, or followers you do not follow back. To use this program, download your data from Instagram,
and transfer followers and following data to the corresponding files. More detailed instructions are soon to come.
*/
public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner(System.in);

        Scanner followingFile = new Scanner(new File("src\\following"));
        Set<String> following = new HashSet<>();

        Scanner followersFile = new Scanner(new File("src\\followers"));
        Set<String> followers = new HashSet<>();

        tracker t = new tracker(following, followers);
        System.out.println("Welcome to Follow Finder! Use this program to find people who do not follow you back on Instagram.");
        System.out.println("");
        System.out.println("There are two steps you must take. First, is retrieving your following and followers data from Instagram."
                + "\n" + "For this step, you will need access to your email address that is registered with your Instagram account."
                + "\n" + "Next, running the Follow Finder program!");
        System.out.println("");
        System.out.println("Type 'start' when you are ready to begin");

        String begin = input.nextLine();

        while (!begin.equalsIgnoreCase("start")) {
            System.out.println("Type 'start' when you are ready");
        }
        t.printIntro();

        System.out.println("paste following");
        String pasteFollowing = input.next();
        t.getFollowing(pasteFollowing);
        loadFile(followingFile, following);

        System.out.println("paste followers");
        String pasteFollowers = input.next();
        t.getFollowers(pasteFollowers);
        loadFile(followersFile, followers);

        t.printMenu();

        String choice = input.nextLine();
        while (!choice.equals("3")) {
            if (choice.equals("1")) {
                t.computeFollowers();
            } else if (choice.equals("2")) {
                t.computeFollowing();
            } else {
                System.out.println("\nIncorrect input! Please try again.");
            }

            if (t.isComplete()) {
                choice = "3";
            } else {
                t.printMenu();
                choice = input.nextLine();
            }
        }

        System.out.println("Thank you for using Follow Finder!");
    }

    //Loads in file to sets
    public static void loadFile(Scanner input, Set<String> target){
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (!line.contains(" ")) {
                target.add(line);
            }
        }
    }
}