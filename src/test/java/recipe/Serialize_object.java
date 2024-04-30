package recipe;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Serialize_object {


    public static void main(String[] args) throws IOException {
        Serialize_object runner = new Serialize_object();
//        runner.toJson();
        runner.fromJson();
    }

    public void toJson() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        Recipe recipe = new Recipe("Salad",
                Arrays.asList
                        (new Ingredient("Tomato", 2),
                        new Ingredient("Cucumber", 1)), 3);
        objectMapper.writerWithDefaultPrettyPrinter()
                .writeValue(new File("src/test/resources/newRecipe.json"), recipe);
    }

    public void fromJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Recipe recipe = objectMapper
            .readValue(new File("src/test/resources/recipe.json"), Recipe.class);
        System.out.println(recipe);}
}
