
import java.nio.file.Paths;
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
    ArrayList<String> allLinesReadFromFile = new ArrayList<>();
    ArrayList<String> breakingIntoIndividualRecipes = new ArrayList<>();
    ArrayList<Recipe> recipesReadFromFile = new ArrayList<>();

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        fileReader();
        System.out.println("Commands:\n"
                + "list - lists the recipes\n"
                + "stop - stops the program\n"
                + "find name - searches recipes by name\n"
                + "find cooking time - searches recipes by cooking time\n"
                + "find ingredient - searches recipes by ingredient");
        while (true) {
            System.out.println("Enter command: ");
            String command = scanner.nextLine();
            if (command.equals("list")) {
                System.out.println("Recipes:");
                recipeReader();
            } else if (command.equals("find name")) {
                findName();
            } else if (command.equals("find cooking time")) {
                findTime();
            }else if (command.equals("find ingredient")) {
                findIngredient();
            }    else {
                break;
            }
        }

    }

    public void addARecipe() {
        String recipeName = breakingIntoIndividualRecipes.get(0);
        // System.out.println("TEST: recipe name : " + recipeName);
        int recipeTime = Integer.valueOf(breakingIntoIndividualRecipes.get(1));
        // System.out.println("TEST: recipe time : " + recipeTime);

        int howManyIngredients = (breakingIntoIndividualRecipes.size());
        ArrayList<String> ingredients = new ArrayList<>();
        for (int i = 2; i < breakingIntoIndividualRecipes.size(); i++) {
            ingredients.add(breakingIntoIndividualRecipes.get(i));
        }
        Recipe recipe = new Recipe(recipeName, recipeTime, ingredients);
        recipesReadFromFile.add(recipe);
        breakingIntoIndividualRecipes.clear();
    }

    public void fileReader() {
        System.out.println("File to read:");
        String input = scanner.nextLine();
        // use below to skip scanner
        //  String input = "recipes.txt";

        try ( Scanner fileScanner = new Scanner(Paths.get(input))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                //      System.out.println("TEST: line: " + line);
                allLinesReadFromFile.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        int lengthOfEverything = allLinesReadFromFile.size();

        for (String piece : allLinesReadFromFile) {
            //System.out.println("TEST: " + piece);
            if (piece.isEmpty()) {
                //   recipeCounter++;
                addARecipe();
            } else {
                breakingIntoIndividualRecipes.add(piece);
            }
        }
        /*
        //TEST: what's in recipesReadFromFile after the try/ except?
        for (Recipe rcp : recipesReadFromFile) {
            System.out.println("TEST: recipes after TRY:" + rcp);
        }

        //TEST: checking to see what's left in breakingIntoIndividualRecipes
        //the lines of the last recipes are there,
        //just have to get them, make a recipe, and add to breakingIntoIndividualRecipes
        
        for (String whatsLeft : breakingIntoIndividualRecipes) {
            System.out.println("Whats: left: " + whatsLeft);
        }
         */
        addARecipe();

    }

    public void recipeReader() {
        for (Recipe recipeList : recipesReadFromFile) {
            System.out.println(recipeList);
        }
    }

    public void findName() {
        System.out.println("Searched word:");
        String searchedName = scanner.nextLine();
        System.out.println("Recipes:");

        for (Recipe recipe : recipesReadFromFile) {
            if (recipe.getName().contains(searchedName)) {
                System.out.println(recipe);
                System.out.println();

            }
        }
    }

    public void findTime() {
        System.out.println("Max cooking time: ");
        int searchedTime = Integer.valueOf(scanner.nextLine());
        System.out.println("Recipes:");
        for (Recipe recipe : recipesReadFromFile) {
            if (recipe.getCookingTime() <= (searchedTime)) {
                System.out.println(recipe);
                System.out.println();

            }
        }
    }
    
    public void findIngredient(){
        
    }

}
