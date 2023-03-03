package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void eatMeatShowsListMeat() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void getFamilyShowsFeline() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutKittensCount() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getKittensWithKittensCount() {
        assertEquals(2, feline.getKittens(2));
    }
}
