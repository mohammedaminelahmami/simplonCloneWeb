package com.example.simploncloneweb.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromotionServiceTest {

    @Test
    void getPromoNameCheckValidId()
    {
        assertEquals("Margaret hamilton", PromotionService.getPromoName(16));
    }

}