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

    @PostMapping
    public R save(@RequestBody Book book){
        System.out.println("======添加操作=======");
        return new R(service.save(book));
    }

    @GetMapping("{id}")
    public R getByid(@PathVariable int id){
        Book byId = service.getById(id);
        return new R(true,byId);
    }

    @PutMapping
    public R update(@RequestBody Book book){
//        System.out.println("修改输出");
        return new R(service.updateById(book));
    }

    @GetMapping("{currentpage}/{pageSize}")
    public R getPage(@PathVariable int currentpage,@PathVariable  int pageSize, Book book){

        IPage<Book> page = service.getPage(currentpage, pageSize, book);
        return new R(true,page);

    }
}
