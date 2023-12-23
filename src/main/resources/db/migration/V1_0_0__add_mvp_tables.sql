CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS Recipes (
   "id" UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
   "name" VARCHAR NOT NULL,
   "slug" VARCHAR UNIQUE NOT NULL,
   "steps" JSONB NULL,
   "createdAt" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
   "updatedAt" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS RecipeNutritions (
    "id" UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    "recipeId" UUID NOT NULL REFERENCES Recipes(id) ON DELETE CASCADE,
    "calories" DECIMAL(10,2) DEFAULT 0,
    "totalFat" DECIMAL(10,2) DEFAULT 0,
    "saturatedFat" DECIMAL(10,2) DEFAULT 0,
    "cholesterol" DECIMAL(10,2) DEFAULT 0,
    "sodium" DECIMAL(10,2) DEFAULT 0,
    "totalCarbohydrate" DECIMAL(10,2) DEFAULT 0,
    "dietaryFiber" DECIMAL(10,2) DEFAULT 0,
    "sugars" DECIMAL(10,2) DEFAULT 0,
    "protein" DECIMAL(10,2) DEFAULT 0,
    "potassium" DECIMAL(10,2) DEFAULT 0,
    "phosphorus" DECIMAL(10,2) DEFAULT 0,
    "createdAt" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Ingredients (
    "id" UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    "recipeId" UUID NOT NULL REFERENCES Recipes(id) ON DELETE CASCADE,
    "name" VARCHAR NOT NULL,
    "servingQty" NUMERIC NOT NULL,
    "servingUnit" VARCHAR NOT NULL,
    "servingWeightInGram" DECIMAL(10,2) DEFAULT 0,
    "nutritions" JSONB DEFAULT '{}',
    "metadata" JSONB DEFAULT '{}',
    "createdAt" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);