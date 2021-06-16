
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeff
 */
public class Recipe {
    
    private String name;
    private int cookingTime;
    private ArrayList<String> ingredients;
    
    public Recipe (String name, int cookingTime, ArrayList<String> ingredients) {
    this.name = name;
    this.cookingTime = cookingTime;
    this.ingredients = ingredients;
}

    public void setName(String name) {
        this.name = name;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }
    
    @Override
    public String toString(){
        return this.getName() + ", cooking time: " + this.getCookingTime();
    }
}
