package day05_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setup(){            // before olusturulurken genelde methodun ismi setup olur

        System.out.println("Her Test Methodun Once Calisir");

    }
    @After
    public void tearDown(){
        System.out.println("Her Test Methodun Sonra Calisir");
    }
    @Test
    public void test01(){
        System.out.println("ilk Test");
    }
    @Test
    public void test02(){
        System.out.println("ikinci Test");
    }
}
