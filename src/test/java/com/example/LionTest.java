package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    private final String sex = "Самка";

    @Test
    public void getKittens() throws Exception {
        Lion lion = new Lion(feline, sex);

        Mockito.when(feline.getKittens()).thenReturn(3);

        assertEquals(3, lion.getKittens());
    }

    @Test
    public void doesHaveManeWithIncorrectSexShowsError() {
        assertThrows("Используйте допустимые значения пола животного - самец или самка",
                Exception.class, () -> new Lion(feline, "Н/д"));
    }

    @Test
    public void getFoodShowsMeat() throws Exception {
        Lion lion = new Lion(feline, sex);

        List<String> expectedFood = List.of("Meat");

        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());

        assertEquals(expectedFood, actualFood);
    }
}
