package com.vit.domain;
import com.vit.domain.Users;
import com.vit.domain.service.UsersService;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

public class MyBatisSample {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:ApplicationContext.xml");
        ctx.refresh();

        UsersService usersService = ctx.getBean("usersService", UsersService.class);

        List userss;

        // Find all users
        userss = usersService.findAll();
       // listUserss(userss);

        // Find user by id
        userss = new ArrayList();
        System.out.println("Finding user with id 1");
        Users users = usersService.findById(1L);
        userss.add(users);
     //   listUserss(userss);

        // Add new user
        System.out.println("Add new user");
        users = new Users();
        users.setEmail("dog@mail.ru");
        users.setPassword("Roberts");
        usersService.save(users);
        userss = usersService.findAll();
   //     listUserss(userss);

        // Update user
        System.out.println("Update user with id 1");
        users = usersService.findById(1L);
        users.setEmail("Vlad@yandex.ru");
        usersService.save(users);
        userss = usersService.findAll();
 //       listUserss(userss);

        // Delete user
        System.out.println("Delete user with id 1");
        users = usersService.findById(1L);
        usersService.delete(users);
        userss = usersService.findAll();
//        listUserss(userss);
    }

   // private static void listUserss(List userss) {
        //System.out.println("Listing userss without details:");
        //Users users,a;
        //for (Users users: userss) {
        //    System.out.println(users + "\n");
      //  }
    //}
}