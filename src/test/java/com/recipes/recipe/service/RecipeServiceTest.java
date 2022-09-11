package com.recipes.recipe.service;

import com.recipes.recipe.dto.RecipeDetail;
import com.recipes.recipe.exception.RecipeException;
import com.recipes.recipe.repository.RecipeRepository;
import com.recipes.recipe.resource.RecipeResource;
import com.recipes.recipe.util.RecipeConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class RecipeServiceTest {

    @InjectMocks
    RecipeService recipeService;
    @Mock
    RecipeRepository recipeRepository;
    @Autowired
    RecipeDetail recipeDetail;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RecipeDetail recipeDetail = new RecipeDetail();
        recipeDetail.setRecipeName("Pasta");
    }

    @Test
    public void getAllrecipeTest(){
        List<RecipeDetail> recipeDetailList = new ArrayList<>();
        recipeDetailList.add(recipeDetail);
        Mockito.when(recipeRepository.findAll()).thenReturn(recipeDetailList);

        List<RecipeDetail> allRecipeDetail = recipeService.getAllrecipe();
        Assertions.assertNotNull(allRecipeDetail);
        Assertions.assertEquals(allRecipeDetail.size(),1);


        recipeService.getAllrecipe();

    }

}
