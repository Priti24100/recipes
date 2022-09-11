package com.recipes.recipe.service;

import com.recipes.recipe.dto.RecipeDetail;
import com.recipes.recipe.exception.RecipeException;
import com.recipes.recipe.repository.RecipeRepository;
import com.recipes.recipe.resource.RecipeResource;
import com.recipes.recipe.util.RecipeConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private static final Logger log = LoggerFactory.getLogger(RecipeResource.class);
    @Autowired
    private RecipeRepository recipeRepository;

    public List<RecipeDetail> getAllrecipe() {
        log.info("getAllrecipe start");
        try {
            List<RecipeDetail> recipeList = recipeRepository.findAll();
            if (recipeList != null && recipeList.size() != 0)
                return recipeList;
            else
                throw new RecipeException(RecipeConstant.RECORDS_NOT_FOUND);
        } catch (RecipeException e) {
            throw new RuntimeException(RecipeConstant.ISSUE_TO_GET_DATA);
        }
    }

    public List<RecipeDetail> findRecipe(RecipeDetail recipeDetail) {
        log.info("Find recipe start");
        try {
            List<RecipeDetail> recipeList = recipeRepository.findByRecipeFilter(recipeDetail);
            log.info("Find recipe as per filter is recipeList" + recipeList.toString());
            if (recipeList != null && recipeList.size() != 0)
                return recipeList;
            else
                throw new RecipeException(RecipeConstant.RECORDS_NOT_FOUND);
        } catch (RecipeException e) {
            throw new RuntimeException(RecipeConstant.ISSUE_TO_GET_DATA);
        }
    }


    public RecipeDetail addRecipe(RecipeDetail recipeDetail) {
        log.info("save new recipe");
        return recipeRepository.save(recipeDetail);
    }


    public RecipeDetail updateRecipe(RecipeDetail recipeDetail, long id) {
        log.info("update recipe using id.");
        return recipeRepository.findById(id)
                .map(updateRecipe -> {
                    updateRecipe.setRecipeName(recipeDetail.getRecipeName());
                    return recipeRepository.save(updateRecipe);
                })
                .orElseGet(() -> {
                    recipeDetail.setId(id);
                    return recipeRepository.save(recipeDetail);
                });
    }


    public void deleteRecipe(long id) throws RecipeException {
        try {
            log.info("Recipe deleted by recipe id.");
           recipeRepository.deleteById(id);
        } catch (Exception e) {
            log.error("There is  no id available to delete recipe");
            throw new RecipeException("There is no id available to perform the delete operation");
        }

    }

}
