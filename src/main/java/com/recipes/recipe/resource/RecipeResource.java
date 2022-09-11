package com.recipes.recipe.resource;

import com.recipes.recipe.dto.RecipeDetail;
import com.recipes.recipe.exception.RecipeException;
import com.recipes.recipe.service.RecipeService;
import com.recipes.recipe.util.RecipeConstant;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/")
public class RecipeResource {
    private static final Logger log = LoggerFactory.getLogger(RecipeResource.class);

    @Autowired
    private RecipeService recipeService;

    /**
     * Use to get all recipes
     *
     * @return
     * @throws RecipeException
     */
    @GetMapping("recipes")
    ResponseEntity<?> getAllrecipe() throws RecipeException {
        log.info("Fetching Recipe");
        List<RecipeDetail> recipeDetailList = recipeService.getAllrecipe();
        if (recipeDetailList != null && recipeDetailList.size() != 0) {
            return new ResponseEntity<>(recipeDetailList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new RecipeException(RecipeConstant.ISSUE_TO_GET_DATA), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * This is used to find recipe as per filter
     *
     * @param recipeDetail
     * @return
     * @throws RecipeException
     */
    @GetMapping("recipes/find")
    List<RecipeDetail> findRecipe(@RequestBody RecipeDetail recipeDetail) throws RecipeException {
        log.info("Find recipe as per filter");
        return recipeService.findRecipe(recipeDetail);
    }

    /**
     * This is use for add new recipe in DB
     *
     * @param recipeDetail
     * @return
     */
    @PostMapping("recipes/add")
    RecipeDetail addRecipe(@RequestBody RecipeDetail recipeDetail) {
        return recipeService.addRecipe(recipeDetail);
    }

    /**
     * This is use for update recipe according to id
     *
     * @param recipeDetail
     * @param id
     * @return
     */
    @PutMapping("recipes/update/{id}")
    RecipeDetail updateRecipe(@RequestBody RecipeDetail recipeDetail, @PathVariable long id) {

        return recipeService.updateRecipe(recipeDetail, id);
    }

    /**
     * This is use for delete recipe according to recipe id.
     *
     * @param id
     * @throws RecipeException
     */
    @DeleteMapping("recipes/delete/{id}")
    ResponseEntity<?> deleteRecipe(@PathVariable Long id) throws RecipeException {
        log.info("Delete recipeDetail object");
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>("Deleted Successfully id "+id, HttpStatus.OK);

    }


}
