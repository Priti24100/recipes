package com.recipes.recipe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
/**
 * This class is used to create table and respective column.
 */
@Table(name = "RecipeDetail")
public class RecipeDetail {

    @Id
    @GeneratedValue
    Long id;
    String recipeName;
    String noOfServing;
    String type;
    String ingredientExclude;
    String ingredientInclude;
    String instruction;


    @Override
    public String toString() {
        return super.toString();
    }
}
