# Getting Started

### Prerequisite
* Maven
* Java 8
* Used In Memory Data Base

### API details :
* POST: Add Recipe - v1/api/recipes/add
>>Sample Input
> 
> {
  "recipeName": "Pasta",
  "noOfServing": "4",
  "type": "veg",
  "ingredientExclude": "Potato",
  "ingredientInclude": "Beans",
  "instruction": "less chill"
  }
> 
>>Sample Output
> 
>{
"id": 1,
"recipeName": "Pasta",
"noOfServing": "4",
"type": "veg",
"ingredientExclude": "Potato",
"ingredientInclude": "Beans",
"instruction": "less chill"
}

* PUT: Update Recipe - /v1/api/recipes/update/{id}
* DELETE: Delete Recipe - v1/api/recipes/delete/{id}
* GET: Find Recipe - v1/api/recipe/find 


