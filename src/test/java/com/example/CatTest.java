package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;

    @Test
    public void getSound() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodShowsMeat() throws Exception {
        Cat cat = new Cat(feline);

        List<String> expectedFood = List.of("Meat");

        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        Mockito.verify(feline, Mockito.times(1)).eatMeat();

        assertEquals(expectedFood, actualFood);
    }
}
