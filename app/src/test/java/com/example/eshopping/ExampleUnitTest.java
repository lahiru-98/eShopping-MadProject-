package com.example.eshopping;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private SettingFragment settingFragment;

    @Before
    public void setup(){
        settingFragment = new SettingFragment();
    }



    private AdminAddNewProductActivity adminAddNewProductActivity;


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    // IT 19158778 -----------------------------
    @Before
    public void setup(){
        adminAddNewProductActivity = new AdminAddNewProductActivity();
    }

    @Test
    public void testcalcDiscount(){
        double result = adminAddNewProductActivity.calcDiscount(500,5);
        assertEquals(25,result,0.01);
    }

    @Test
    public void testetPriceAfterDiscount(){
        double result = adminAddNewProductActivity.setPriceAfterDiscount(30,"500");
        assertEquals(470,result,0.01);
    }



}