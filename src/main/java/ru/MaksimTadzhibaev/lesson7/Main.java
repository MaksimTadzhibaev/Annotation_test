package ru.MaksimTadzhibaev.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        start(Tests.class);
    }

    public static void start(Class reaction) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = reaction.getDeclaredMethods();
        int beforeSuite = 0, afterSuite = 0;
        ArrayList<Method> al = new ArrayList<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                al.add(m);
            }
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuite++;
                if (beforeSuite > 1) throw new RuntimeException("Несколько методов с анотацией @BeforeSuite");
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                afterSuite++;
                if (afterSuite > 1) throw new RuntimeException("Несколько методов с анотацией @AfterSuite");
            }
            al.sort(Comparator.comparingInt(m2 -> m2.getAnnotation(Test.class).priority()));
        }
        for (Method a : methods) if (a.isAnnotationPresent(BeforeSuite.class)) {a.invoke(null);}
        for (Method b : al) b.invoke( null);
        for (Method c : methods)  if (c.isAnnotationPresent(AfterSuite.class)) {c.invoke(null);}
    }
}
