package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalTest {

    private String animalKind;
    private List<String> food;

    Animal animal = new Animal();

    public AnimalTest(String animalKind, List<String> food) {
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
    public void getFoodWithParameters() throws Exception {
        assertEquals(animal.getFood(animalKind), food);
        assertThrows("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                Exception.class, () -> animal.getFood(""));
    }

    @Test
    public void getFamilyShowsAnimalsFamily() {
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                animal.getFamily());
    }
}
