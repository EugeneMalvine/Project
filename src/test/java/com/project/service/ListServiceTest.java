package com.project.service;

import com.project.domain.Contact;
import com.project.domain.Lists;
import com.project.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml","classpath:TestContext.xml"})
public class ListServiceTest {

    @Autowired
    private ListsService listsService;

    @Test
    public void findById(){

        Lists list = listsService.findById(-1l);

        Assert.assertEquals(list.getId(),new Long(-1l));

    }

    @Test
    public void findByUserId(){

        List<Lists> list = listsService.findByUserId(-1l);

        Assert.assertEquals(list.get(0).getUserId(),new Long(-1l));

    }

    @Test
    public void findAll() {

        Long size = new Long(listsService.findAll().size());

        Assert.assertEquals(size,listsService.size());

    }

    @Test
    public void delete(){
        Lists list = new Lists();
        list.setName("Test");
        list.setUserId(-1l);

        listsService.insert(list);

        Lists list2 = listsService.findById(list.getId());

        Assert.assertEquals(list.getId(),list2.getId());

        listsService.delete(list.getId());

        list2 = listsService.findById(list.getId());

        Assert.assertNull(list2);
    }

    @Test
    public void update(){
        Lists list = new Lists();
        list.setName("Test");
        list.setUserId(-1l);

        listsService.insert(list);

        Lists list2 = listsService.findById(list.getId());

        Assert.assertEquals(list.getId(),list2.getId());

        list2.setName("Updated");

        listsService.update(list2);

        list2 = listsService.findById(list.getId());

        Assert.assertEquals(list2.getName(),"Updated");

        list2.setId(100l);

        listsService.update(list2);

        list2 = listsService.findById(list.getId());

        Assert.assertEquals(list.getId(),list2.getId());

        listsService.delete(list.getId());
        listsService.delete(list2.getId());
    }

    @Test
    public void findByName(){
        Lists list = listsService.findByName("Test");

        Assert.assertEquals(list.getName(),"Test");
    }


    @Test
    //имеет ли user права на список id
    public void checkAuthority(){
        User user = new User();
        user.setId(-1l);
        Long listId = -1l;

        boolean accept = listsService.checkAuthority(user,listId);

        Assert.assertTrue(accept);

        boolean wrong = listsService.checkAuthority(user,1l);

        Assert.assertFalse(wrong);

    }

}