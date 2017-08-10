import com.project.domain.Person;
import com.project.service.PersonService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

public class MyBatisSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ApplicationContext.xml");
		ctx.refresh();
		
		PersonService personService = ctx.getBean("personService", PersonService.class);

		List<Person> persons;

		// Find all persons
		persons = personService.findAll();
		listPersons(persons);




        // Find person by id
		persons = new ArrayList<Person>();
		System.out.println("Finding person with id 1");
		Person person = personService.findById(1L);
		persons.add(person);
		listPersons(persons);
		
		// Add new person
		System.out.println("Add new person");
		person = new Person();
		person.setFirstName("Layla");
		person.setLastName("Roberts");
		personService.save(person);
		persons = personService.findAll();
		listPersons(persons);
		
		// Update person
		System.out.println("Update person with id 1");
		person = personService.findById(1L);
		person.setFirstName("Vlad");
		personService.save(person);
		persons = personService.findAll();
		listPersons(persons);

		// Delete person
		System.out.println("Delete person with id 1");
		person = personService.findById(1L);
		personService.delete(person);
		persons = personService.findAll();
		listPersons(persons);
	}



	private static void listPersons(List<Person> persons) {
		System.out.println("Listing persons without details:");
		for (Person person: persons) {
			System.out.println(person+"\n");
		}
	}
}
