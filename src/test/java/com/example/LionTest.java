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

    @Test
    public void getKittens() {
        Lion lion = new Lion(feline);

        Mockito.when(feline.getKittens()).thenReturn(3);

        assertEquals(3, lion.getKittens());
    }
    @Test
    public void doesHaveMane() throws Exception {
        assertTrue(new Lion("Самец").doesHaveMane());
        assertFalse(new Lion("Самка").doesHaveMane());
        assertThrows("Используйте допустимые значения пола животного - самец или самка",
                Exception.class, () -> new Lion("Н/д"));
    }

    @Test
    public void getFoodShowsMeat() throws Exception {
        Lion lion = new Lion(feline);
        lion.getFood();

        Mockito.verify(feline, Mockito.times(1)).getFood(Mockito.anyString());
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(List.of("Meat"));

        assertEquals(List.of("Meat"), lion.getFood());
    }
}
