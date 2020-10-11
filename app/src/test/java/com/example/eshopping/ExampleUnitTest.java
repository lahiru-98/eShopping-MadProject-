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

    private AdminAddNewProductActivity adminAddNewProductActivity;

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