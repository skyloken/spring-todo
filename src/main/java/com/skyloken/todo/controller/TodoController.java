package com.skyloken.todo.controller;

import com.skyloken.todo.TodoRepository;
import com.skyloken.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    @Autowired
    TodoRepository repository;

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Todo> list = repository.findAll();
        model.addAttribute("datas", list);
        return "/index.html";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(Model model, @RequestParam("text") String text) {
        Todo newData = new Todo(text, false);
        repository.saveAndFlush(newData);

        Iterable<Todo> list = repository.findAll();
        model.addAttribute("datas", list);
        return "/index.html";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String done(Model model, @RequestParam("id") Integer id) {
        Todo doneData = repository.getOne(id);
        doneData.setIs_done(true);
        repository.saveAndFlush(doneData);

        Iterable<Todo> list = repository.findAll();
        model.addAttribute("datas", list);
        return "/index.html";
    }

    @RequestMapping(value = "/undone", method = RequestMethod.POST)
    public String undone(Model model, @RequestParam("id") Integer id) {
        Todo doneData = repository.getOne(id);
        doneData.setIs_done(false);
        repository.saveAndFlush(doneData);

        Iterable<Todo> list = repository.findAll();
        model.addAttribute("datas", list);
        return "/index.html";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(Model model, @RequestParam("id") Integer id) {
        Todo delData = repository.getOne(id);
        repository.delete(delData);

        Iterable<Todo> list = repository.findAll();
        model.addAttribute("datas", list);
        return "/index.html";
    }

}
