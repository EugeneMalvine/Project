// В данном тесте мы создаем персону, сохраняем ее id , далее ищем ее по id
// сравниваем поля,  удаляем ее и проверяем!
import com.project.domain.Person;
import com.project.service.PersonService;
import com.project.service.PersonServiceImpl;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.springframework.context.support.GenericXmlApplicationContext;


import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class person_JU {



    public static void main(String[] args) throws Exception
    {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(person_JU.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());

    }

    @Test
    public void personTest()
    {
        long TEST_ID;
        String test_fname= "TEST_FNAME" , test_lname ="TEST_LNAME";
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:ApplicationContext.xml");
        ctx.refresh();
        PersonService personService = ctx.getBean("personService", PersonService.class);
        //add new person
        Person person = new Person();
        person.setFirstName(test_fname);
        person.setLastName(test_lname);
        personService.save(person);
        TEST_ID=person.getId();

        //search
        person = personService.findById(TEST_ID);

        //check
        assertEquals( test_fname , person.getFirstName());
        assertEquals( test_lname , person.getLastName());


        //delete
        personService.delete(person);

        //after delete check
        assertTrue(personService.findById(TEST_ID)==null);

    }

}
