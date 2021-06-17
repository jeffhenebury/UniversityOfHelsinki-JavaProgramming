
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jeff
 */
public class UserInterface {

    private Scanner scanner;
    ArrayList<Bird> birdList = new ArrayList<>();

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        //intro query for user
        while (true) {
            System.out.println("?");
            String input = scanner.nextLine();
            if (input.equals("Quit")) {
                break;
            } else if (input.equals("Add")) {
                addBird();
            } else if (input.equals("Observation")) {
                addObservation();
            } else if (input.equals("All")) {
                printAllBirds();
            } else if (input.equals("One")) {
                printOneBird();
            }
        }

    }

    public void addBird() {
        System.out.println("Name: ");
        String inputCommonName = scanner.nextLine();
        System.out.println("Name in Latin: ");
        String inputLatinName = scanner.nextLine();
        birdList.add(new Bird(inputCommonName, inputLatinName));
    }

    public void addObservation() {
        System.out.println("Bird?");
        String input = scanner.nextLine();
        {
            for (Bird bird : birdList) {
                if (input.equals(bird.getCommonName())) {
                    if (bird.getNumberOfObservations() == 1) {
                        System.out.print(bird + ": " + bird.getNumberOfObservations());
                        // System.out.println("observation");
                        bird.setNumberOfObservations((bird.getNumberOfObservations() + 1));
                        return;
                    } else {
                        System.out.print(bird + ": " + bird.getNumberOfObservations());
                        //  System.out.println("observations");
                        bird.setNumberOfObservations((bird.getNumberOfObservations() + 1));
                        return;
                    }

                }
            }
            System.out.println("Not a bird!");
        }
    }

    public void printAllBirds() {
        for (Bird bird : birdList) {
            System.out.println(bird);
        }
    }

    public void printOneBird() {
        System.out.println("Bird?");
        String input = scanner.nextLine();
        for (Bird bird : birdList) {
            if (bird.getCommonName().equals(input)) {
                System.out.println(bird);
                return;
            }
        }
        System.out.println("Not a bird!");
    }
}
