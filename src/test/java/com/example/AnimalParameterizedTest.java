package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    private final String animalKind;
    private final List<String> food;

    Animal animal = new Animal();

    public AnimalParameterizedTest(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodWithAnimalKind() throws Exception {
        assertEquals(animal.getFood(animalKind), food);
    }
}
