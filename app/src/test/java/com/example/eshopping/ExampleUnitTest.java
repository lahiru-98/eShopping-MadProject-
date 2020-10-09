package com.example.eshopping;

import com.example.eshopping.Offers.OffersMainActivity;

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

   private OffersMainActivity offersMainActivity;

    @Before
    public void setUp(){
        offersMainActivity=new OffersMainActivity();
    }

    @Test
    public void discount_isCorrect(){
        float Final =offersMainActivity.result(10,100);
        assertEquals(10,Final,0);
    }


}