package com.project.service;

import com.project.domain.Contact;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:ApplicationContext.xml","classpath:TestContext.xml"})
public class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    @BeforeClass
    public static void setUpClass() {

    }

    @Test
    public void findById(){

        Contact contact2 = contactService.findById(-1l);

        Assert.assertEquals(contact2.getId(),new Long(-1l));

    }

    @Test
    public void findByUserId(){

        Contact contact2 = contactService.findByUserId(-1l);

        Assert.assertEquals(contact2.getUserid(),new Long(-1l));

    }

    @Test
    public void findAll() {

        Long size = new Long(contactService.findAll().size());

        Assert.assertEquals(size,contactService.size());

    }

    @Test
    public void delete(){
        Contact contact = new Contact();
        contact.setFirstname("Test");

        contactService.insert(contact);

        Contact contact2 = contactService.findById(contact.getId());

        Assert.assertEquals(contact.getId(),contact2.getId());

        contactService.delete(contact.getId());

        contact2 = contactService.findById(contact.getId());

        Assert.assertNull(contact2);
    }




    @Test
    public void update(){
        Contact contact = new Contact();
        contact.setFirstname("Test");

        contactService.insert(contact);

        Contact contact2 = contactService.findById(contact.getId());

        Assert.assertEquals(contact.getId(),contact2.getId());

        contact2.setFirstname("Updated");

        contactService.update(contact2);

        contact2 = contactService.findById(contact.getId());

        Assert.assertEquals(contact2.getFirstname(),"Updated");

        contact2.setId(100l);

        contactService.update(contact2);

        contact2 = contactService.findById(contact.getId());

        Assert.assertEquals(contact.getId(),contact2.getId());

        contactService.delete(contact.getId());
        contactService.delete(contact2.getId());
    }


}