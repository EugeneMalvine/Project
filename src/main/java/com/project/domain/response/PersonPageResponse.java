package com.project.domain.response;

import com.project.Constant;
import com.project.domain.Person;
import com.project.persistence.PersonMapper;
import com.project.service.PersonService;

import java.util.List;

/**
 * Created by Denis on 20.08.2017.
 */
//структура для хранения ответа на запрос страницы данных из person
public class PersonPageResponse extends PageResponse<Person>{
     public static PersonPageResponse fromService(PersonService mapper, int page){
         PersonPageResponse response = new PersonPageResponse();
         response.fullSize = mapper.size();
         response.data = mapper.findRange(Constant.PERSON_PAGE_SIZE * page,Constant.PERSON_PAGE_SIZE);
         response.ammountOfPage = response.data.size() == 0 ? 0 : (response.fullSize -1) /  Constant.PERSON_PAGE_SIZE + 1;

         response.currentPage = page;
         response.pageSize = Constant.PERSON_PAGE_SIZE;
         return response;
     }
}
