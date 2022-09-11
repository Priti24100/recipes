package com.recipes.recipe.exception;

/**
 * Custom Exception
 */
public class RecipeException extends RuntimeException {
    public RecipeException() {
        super();
    }

    public RecipeException(String message) {
        super(message);
    }
}
