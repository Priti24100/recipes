package com.recipes.recipe.resource;

import com.recipes.recipe.dto.RecipeDetail;
import com.recipes.recipe.repository.RecipeRepository;
import com.recipes.recipe.service.RecipeService;
import com.recipes.recipe.service.RecipeServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class RecipeResourceTest {

    @Autowired
    RecipeDetail recipeDetail;

    @Mock
    RecipeService recipeService;
    @InjectMocks
    RecipeResource recipeResource;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        RecipeDetail recipeDetail = new RecipeDetail();
        recipeDetail.setRecipeName("Pasta");
    }

    @Test
    public void getAllRecipeTest() {
        List<RecipeDetail> recipeDetailList = new ArrayList<>();
        recipeDetailList.add(recipeDetail);
        Mockito.when(recipeService.getAllrecipe()).thenReturn(recipeDetailList);
        ResponseEntity<?> recipeDetailResponse = recipeResource.getAllrecipe();
        Assertions.assertNotNull(recipeDetailResponse);
        Assertions.assertEquals(recipeDetailResponse.getStatusCode().value(),200);

    }
}
