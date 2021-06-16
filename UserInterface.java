
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
    // private ArrayList<Recipe> recipesReadFromFile;
    ArrayList<String> allLinesReadFromFile = new ArrayList<>();
    ArrayList<String> breakingIntoIndividualRecipes = new ArrayList<>();
    // going to try and make this a private 
    ArrayList<Recipe> recipesReadFromFile = new ArrayList<>();

    // private ArrayList<String> allLinesReadFromFile;
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        // this.fileScanner = fileScanner;
    }

    public void start() {

        // skipping scanner for now
        //  System.out.println("File to read:");
        //  String input = scanner.nextLine();
        String input = "recipes.txt";

        try ( Scanner fileScanner = new Scanner(Paths.get(input))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println("line: " + line);
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
        addARecipe();
 
        for (Recipe recipeList : recipesReadFromFile) {
            System.out.println(recipeList);
        }

    }

    public void addARecipe() {
        String recipeName = breakingIntoIndividualRecipes.get(0);
        System.out.println("TEST: recipe name : " + recipeName);
        int recipeTime = Integer.valueOf(breakingIntoIndividualRecipes.get(1));
        System.out.println("TEST: recipe time : " + recipeTime);

        int howManyIngredients = (breakingIntoIndividualRecipes.size());
        ArrayList<String> ingredients = new ArrayList<>();
        for (int i = 2; i < breakingIntoIndividualRecipes.size(); i++) {
            ingredients.add(breakingIntoIndividualRecipes.get(i));
        }
        Recipe recipe = new Recipe(recipeName, recipeTime, ingredients);
        recipesReadFromFile.add(recipe);
        breakingIntoIndividualRecipes.clear();
    }
}
