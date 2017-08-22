import com.project.domain.Person;
import com.project.domain.User;
import com.project.service.PersonService;
import com.project.service.UserService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class UserSample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:ApplicationContext.xml");
		ctx.refresh();
		
		UserService userService = ctx.getBean("userService", UserService.class);

		User user = userService.getUser("user");

		User newUser = new User();
		newUser.setUsername("11111");
		newUser.setPassword("123123123");
		newUser.setRole(3);

		userService.save(newUser);

		user = userService.getUser("11111");

		userService.delete(user);

		user = userService.getUser("11111");


	}



}
