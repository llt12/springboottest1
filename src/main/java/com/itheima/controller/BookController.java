package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utile.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService service;

    @GetMapping
    public R getAll(){

        return new R(true,service.list());
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable int id){
        return new R(service.removeById(id));
    }


    @GetMapping("{currentpage}/{pageSize}")
    public R getPage(@PathVariable int currentpage,@PathVariable  int pageSize, Book book){

        IPage<Book> page = service.getPage(currentpage, pageSize, book);
        return new R(true,page);

    }
}
