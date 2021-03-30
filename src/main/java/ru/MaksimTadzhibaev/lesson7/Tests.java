package ru.MaksimTadzhibaev.lesson7;



public class Tests {

    @BeforeSuite
    public static void before() {
        System.out.println("BeforeSuite");
    }

    @Test (priority = 7)
    public static void reaction1 (){
        System.out.println("reaction1");
    }

    @Test (priority = 6)
    public static void reaction2 (){
        System.out.println("reaction2");
    }

    @Test (priority = 5)
    public static void reaction3 (){
        System.out.println("reaction3");
    }

    @Test (priority = 4)
    public static void reaction4 (){
        System.out.println("reaction4");
    }

    @Test (priority = 3)
    public static void reaction5 (){
        System.out.println("reaction5");
    }

    @Test (priority = 2)
    public static void reaction6 (){
        System.out.println("reaction6");
    }

    @Test (priority = 1)
    public static void reaction7 (){
        System.out.println("reaction7");
    }

    @AfterSuite
    public static void after() { System.out.println("AfterSuite"); }

}
