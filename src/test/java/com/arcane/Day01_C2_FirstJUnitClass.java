package com.arcane;

import org.junit.*;

public class Day01_C2_FirstJUnitClass {

        //@Test : test case olustur. Bu test cases olusturma ve kosturmaya yardimci olur
        // @Before : Runs before each @Test annotation. tekrarlanan pre condition icin kullanilir
        // @After : Runs after each @Test annotation. tekrarlanan post conditions icin kullanilir
        // @AfterClass, @BeforeClass
        // @Ignore: test case atlatmak icin kullanilir

    @Before
    public void setUp(){
        System.out.println("Bu bir seUp methodudur");
    }

    @Test
    public void test01(){
        System.out.println("Test case 1");
    }

    @Ignore
    @Test
    public void test02(){
        System.out.println("Test case 2");
    }

    @Test
    public void test03(){
        System.out.println("Test case 3");
    }
    @After
    public void tearDown(){
        System.out.println("Bu bir tearDown methodudur");
    }
    /*
    JUnıt Assertion
        expected = actual ,ise assertion yapilir
     */

    @Test
    public void assertion(){

        //1. Assert.assertTrue
        Assert.assertTrue(3==3);//Test geçer

        //2. Assert.assertFalse
        Assert.assertFalse(3==4);//Test geçer

        Assert.assertFalse("selenıum".contains("a"));//Test başarılı

        // 3. Assert.assertEquals()
        Assert.assertEquals("java","java");//Test başarılı

       // Assert.assertEquals("Java","javascript");//Test başarısiz
    }
}
