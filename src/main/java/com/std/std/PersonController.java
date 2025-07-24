package com.std.std;

import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {
    int lastId;
    List<Person> personList;

    PersonController(){
        lastId = 0;
        personList = new ArrayList<>();
    }

    @GetMapping("/person/add")
    @ResponseBody
    public String addPerson(
            @RequestParam("name") String name,
            @RequestParam("age") int age){
        lastId++;

        Person person = new Person(lastId, age, name);
        personList.add(person);

        return String.format("%d번째 사람 %s이(가) 추가되었습니다", person.getId(), person.getName());
    }

    @GetMapping("/person/remove")
    @ResponseBody
    public String removePerson(@RequestParam("id") int id){

        Person person = null;
        String result = "";
        for(Person p : personList){
            if(p.getId() == id){
                person = p;
            }
        }
        if(person == null){
            result = String.format("%d번 사람은 존재하지 않습니다",id);
        } else {
            personList.remove(person);
            result = String.format("%d번 사람이 삭제되었습니다",person.getId());
        }


        return result;
    }


    @GetMapping("/person/people")
    @ResponseBody
    public List<Person> getPersonList(){
        return personList;
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
class Person{
    private int id;
    private int age;
    private String name;
}