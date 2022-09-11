package com.recipes.recipe.repository;

import com.recipes.recipe.dto.RecipeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeDetail, Long> {
    /**
     * Filter recipe according to recipe field.
     *
     * @param recipeDetail
     * @return
     */
    @Query(" SELECT r FROM RecipeDetail r WHERE  ( r.recipeName = :#{#recipeDetail.recipeName} OR  r.recipeName IS NULL ) " +
            "AND  ( r.noOfServing  =  :#{#recipeDetail.noOfServing} or  :#{#recipeDetail.noOfServing} is null )" +
            "AND ( r.type = :#{#recipeDetail.type}  or  :#{#recipeDetail.type} is null ) " +
            "AND ( r.ingredientExclude = :#{#recipeDetail.ingredientExclude} or  :#{#recipeDetail.ingredientExclude} is null ) " +
            "AND ( r.ingredientInclude = :#{#recipeDetail.ingredientInclude} or  :#{#recipeDetail.ingredientInclude} is null ) " +
            "AND ( r.instruction = :#{#recipeDetail.instruction} or  :#{#recipeDetail.instruction} is null )")
    List<RecipeDetail> findByRecipeFilter(@Param("recipeDetail") RecipeDetail recipeDetail);

    Optional<RecipeDetail> findByRecipeName(String recipeName);



   /*
    List<RecipeDetail> findByRecipeNameAndNoOfServing(String recipeName,String noOfServing);

    List<RecipeDetail> findByRecipeNameAndType(String recipeName,String type);

    List<RecipeDetail> findByType(String type);

    List<RecipeDetail> findByRecipeNameAndNoOfServingAndIngredientExcludeAndIngredientIncludeAndInstructionAndType(String recipeName,String noOfServing,String ingredientExclude,String ingredientInclude,String instruction,String type);
*/
}

