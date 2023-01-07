package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {

    ;
    @Test
    public void javaFakerTest() {
        // 1  Faker Objesi olstur
        Faker faker = new Faker();

        // 2 . Faker objesi ile fake data olustur
        String ilkIsim = faker.name().firstName();
        System.out.println("ilkIsim = " + ilkIsim);
        
        // last name datsasi
        String soyIsim = faker.name().lastName();
        System.out.println("soyIsim = " + soyIsim);

        //username
        String username = faker.name().username();


        System.out.println(faker.name().title());

        System.out.println(faker.address().countryCode());

        System.out.println(faker.address().state());

        System.out.println(faker.phoneNumber().cellPhone());

        System.out.println(faker.internet().emailAddress());

       // rasgele 10 haneli numara

        System.out.println(faker.number().digits(15));
      /*
        Test Datalari Kimden Alinir
        1. Business Analysis(acceptance Criteria lari yazar)
        2. Test Lead
        3.Manuel Tester
        4. Tech lead & Team Lead & Dev Lead
        5. Developer dan bazen
        6.Database
        7.API dan
        8.Documamtasyon
        9.Java Faker
        Test Datalari Kimden alinmaz
        1.Kullanicidan
        2.Scrum Master

*/
    }
}
