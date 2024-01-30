import java.util.*;
import java.io.*;
public class tracker {
    //variables
    int[] soFar;
    Set<String> following;
    Set<String> followers;

    public tracker(Set<String> following, Set<String> followers) {
        this.following = following;
        this.followers = followers;
        soFar = new int[2];

    }

    public void printIntro() {
        System.out.println("");
    }

    public void printMenu() {
        System.out.println("\nWhat action would you like to take? (Enter 1, 2, or 3).");
        System.out.println("(1) View who does not follow you back");
        System.out.println("(2) View who you don't follow back");
        System.out.println("(3) Quit \n");
    }

    public void getFollowing(String input) throws FileNotFoundException {
        PrintStream output = new PrintStream("src\\following");
        output.println(input);
    }

    public void getFollowers(String input) throws FileNotFoundException {
        PrintStream output = new PrintStream("src\\followers");
        output.println(input);
    }

    public void computeFollowing() {
        Set<String> result = new HashSet<>();

        for (String name : followers) {
            if (!following.contains(name)) {
                result.add(name);
            }
        }

        if (result.isEmpty()) {
            System.out.println("You follow everyone back!");
        } else {
            System.out.println("You don't follow back: ");
            for (String n : result) {
                System.out.println(n);
            }
        }

        soFar[0] = 1;
    }

    public void computeFollowers() {
        Set<String> result = new HashSet<>();
        for (String name : following) {
            if (!followers.contains(name)) {
                result.add(name);
            }
        }

        if (result.isEmpty()) {
            System.out.println("Everyone follows you back!");
        } else {
            System.out.println("Users who don't follow you back are: ");
            for (String n : result) {
                System.out.println(n);
            }
        }

        soFar[1] = 2;
    }

    public boolean isComplete() {
        if (soFar[0] == 1 && soFar[1] == 2) {
            return true;
        }
        return false;
    }

    //When restarted, the restart method erases all data in the
    //following and followers files, the files can be updated
    public void restart() {

    }
}
