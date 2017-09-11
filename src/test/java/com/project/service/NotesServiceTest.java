package com.project.service;

import com.project.domain.Lists;
import com.project.domain.Notes;
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
public class NotesServiceTest {

    @Autowired
    private NotesService notesService;

    @Test
    public void findById(){

        Notes note = notesService.findById(-1l);

        Assert.assertEquals(note.getId(),new Long(-1l));

    }

    @Test
    public void findByUserId(){

        List<Notes> list = notesService.findByListId(-1l);

        Assert.assertEquals(list.get(0).getListsid(),new Long(-1l));

    }

    @Test
    public void findAll() {

        Long size = new Long(notesService.findAll().size());

        Assert.assertEquals(size,notesService.size());

    }

    @Test
    public void delete(){
        Notes note = new Notes();
        note.setName("Test");
        note.setListsid(-1l);
        note.setCheckmark(false);

        notesService.insert(note);

        Notes note2 = notesService.findById(note.getId());

        Assert.assertEquals(note.getId(),note2.getId());

        notesService.delete(note.getId());

        note2 = notesService.findById(note.getId());

        Assert.assertNull(note2);
    }

    @Test
    public void update(){
        Notes note = new Notes();
        note.setName("Test");
        note.setListsid(-1l);
        note.setCheckmark(false);

        notesService.insert(note);

        Notes note2 = notesService.findById(note.getId());

        Assert.assertEquals(note.getId(),note2.getId());

        note2.setName("Updated");

        notesService.update(note2);

        note2 = notesService.findById(note.getId());

        Assert.assertEquals(note2.getName(),"Updated");

        note2.setId(100l);

        notesService.update(note2);

        note2 = notesService.findById(note.getId());

        Assert.assertEquals(note.getId(),note2.getId());

        notesService.delete(note.getId());
        notesService.delete(note2.getId());
    }

    @Test
    public void findByName(){
        Notes note = notesService.findByName("Test");

        Assert.assertEquals(note.getName(),"Test");
    }

    @Test
    //есть в ли в списке с id запись с n_id
    public void contains()
    {

        boolean accept = notesService.contains(-1l,-1l);

        Assert.assertTrue(accept);

        boolean wrong = notesService.contains(-1l,1l);

        Assert.assertFalse(wrong);
    }


}