package com.demo.springboot.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.springboot.dao.BookDAO;
import com.demo.springboot.pojo.Book;

/**
 * book  控制器
 * @author ycn
 */
@Controller
@RequestMapping("/book")
public class BookController {

	@Resource
	private BookDAO bookDAO;
	
	/**
	 * 查看所有图书
	 * @return
	 */
	@RequestMapping("/findAllBook.do")
	public ModelAndView findAllBook() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bookList", bookDAO.findAll());
		mv.setViewName("BookIndex");
		return mv;
	}
	
	/**
	 * 添加图书
	 * @param book
	 * @return
	 */
	@RequestMapping(value = "/addBook.do",method = RequestMethod.POST)
	public String addBook(Book book) {
		bookDAO.save(book);
		return "forward:/book/findAllBook.do";
	}
	
	/**
	 * 修改图书
	 * @param id
	 * @return
	 */
	@GetMapping("/preUpdateBook/{id}")
	public ModelAndView preUpdateBook(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("book",bookDAO.findOne(id));
		mv.setViewName("BookUpdate");
		return mv;
	}
	@PostMapping("/updateBook.do")
	public String updateBook(Book book) {
		bookDAO.save(book);
		return "forward:/book/findAllBook.do";
	}
	
	/**
	 * 删除图书
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteBook.do",method = RequestMethod.GET)
	public String deleteBook(Integer id) {
		bookDAO.delete(id);
		return "forward:/book/findAllBook.do";
	}
	
}
