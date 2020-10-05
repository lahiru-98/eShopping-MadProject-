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
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    private CartActivity cartActivity;

    //IT19101316

    @Before

    public void setUp(){

        cartActivity=new CartActivity();
    }

    @Test

    public void testGetOneTypeProductPrice(){

        double result = cartActivity.getOneTypeProductPrice(1615,2);
        assertEquals(3230,result,0.01);
        
    }

    @Test
    public void testCartTotalPrice(){

        double result = cartActivity.getCartTotalPrice(3230);
        assertEquals(3230,result,0.01);

    }

}