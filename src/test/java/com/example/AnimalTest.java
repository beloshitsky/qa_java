package com.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    Animal animal = new Animal();

    @Test
    public void getFoodWithoutAnimalKindShowsError() {
        assertThrows("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                Exception.class, () -> animal.getFood(""));
    }

    @Test
    public void getFamilyShowsAnimalsFamily() {
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                animal.getFamily());
    }
}
