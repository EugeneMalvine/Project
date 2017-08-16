// В данном тесте мы создаем персону, сохраняем ее id , далее ищем ее по id
// сравниваем поля, и если они совпали, удаляем ее!
import com.project.domain.Person;
import com.project.service.PersonService;
import org.springframework.context.support.GenericXmlApplicationContext;


import java.util.*;

public class DB_test1 {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:ApplicationContext.xml");
        ctx.refresh();

        PersonService personService = ctx.getBean("personService", PersonService.class);


        long TEST_ID;
        int test_key=0;
        String test_fname= "TEST_FNAME" , test_lname ="TEST_LNAME";

        // Add test
        Person  person = new Person();
        person.setFirstName(test_fname);
        person.setLastName(test_lname);
        personService.save(person);
        TEST_ID=person.getId();
        System.out.println("Test person created with id: "+TEST_ID);

        //find this test person
        person = personService.findById(TEST_ID);
        if(person.getFirstName().equals(test_fname) && person.getLastName().equals(test_lname))
        {
            System.out.println("verify test success");
            test_key=1;
        }
        else
        {
            System.out.println("verify test failed");
        }

        if(test_key==1)
        {
        //delete test person
        person = personService.findById(TEST_ID);
        personService.delete(person);
        if(personService.findById(TEST_ID)==null)
            {
            System.out.println("delete test success");
            }
        else
            {
            System.out.println("delete test failed");
            }
        }
        else
        {
            System.out.println("person test not completed");
        }
        System.out.println("person test completed successful");
    }

}
