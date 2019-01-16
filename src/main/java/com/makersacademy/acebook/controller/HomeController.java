package com.makersacademy.acebook.controller;


import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.model.PostForm;
import com.makersacademy.acebook.model.User;
import com.makersacademy.acebook.repository.PostRepository;
import com.makersacademy.acebook.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

	private final PostRepository postRepository;
	private final UsersRepository usersRepository;

	@Autowired  // Injects the Post repo into the controller
	public HomeController(PostRepository postRepository, UsersRepository usersRepository) {
		this.postRepository = postRepository;
		this.usersRepository = usersRepository;
	}


	@RequestMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("test", postRepository.findAll());
		return "index";
	}

	@RequestMapping(value = "/greeting")
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	// Added title
	@GetMapping("/post")
	public String post(Model model) {
		model.addAttribute("post", new Post("change me", "change me too"));
		return "postForm";
	}

	@PostMapping("/post")
	public String post(@ModelAttribute Post post) {
		System.out.println(post); //View post before it is saved
		postRepository.save(post); // Post is saved
		System.out.println(postRepository.findAll()); // Prints out an array containing the posts saved in Posts table
		return "result";
	}

//	@GetMapping("/destroy")
//	public String destroy(){
//		return "destroy";
//	}

	@PostMapping("/destroyed")
    public String destroyed(@RequestParam("id")long id){
	    postRepository.deleteById(id);
		return "redirect:/readPosts";
    }

	//Create a new GET endpoint which lists all the posts

	@GetMapping("/readPosts")
	public String readPosts(Model model){
		model.addAttribute("posts", postRepository.findAll());
		return "readPosts";
	}

//	@GetMapping("/findById")
//	public String updatePost(){
//		return "findById";
//	}

	@PostMapping("updatePost")
	public String updatedPost(@RequestParam("id")long id, Model model, HttpSession session){
		Post post = postRepository.findById((id)).get();
		session.setAttribute("id", id);
		model.addAttribute("content", post.getContent());
		model.addAttribute("title", post.getTitle());
		return "updatePost";
	}

	@PostMapping("updatedPost")
	public String updatedPost(@ModelAttribute Post post, @RequestParam("title") String title, @RequestParam("content") String content, HttpSession session){
		long id = (long) session.getAttribute("id");
		post.setId(id);
		post.setTitle(title);
		post.setContent(content);
		postRepository.save(post);
		return "redirect:/readPosts";
	}

	@GetMapping("signUp")
	public String signUp(){
		return "signUp";
	}

	@PostMapping("addUser")
	public String addUser(@RequestParam("username")String username, @RequestParam("password")String password,
						  @RequestParam("name")String name, @RequestParam("email")String email, RedirectAttributes redirectAttributes){
		User user = new User(username, password, name, email);
		usersRepository.save(user);
		redirectAttributes.addAttribute("success", "Success, you're signed up and good to go " + user.getName());
		return "redirect:/readPosts";
	}

	// Hard coded test of adding a user to the users table
	@GetMapping("/signUpTest")
	public String signUpTest(){
		User user = new User("Ajay123", "123abc", "Ajay", "ajay123@hotmail.com");
		usersRepository.save(user);
		return "redirect:/readPosts";
	}

	@PostMapping("/updateAced")
	public String updateAced(@RequestParam("id")long id, Model model) {
		Post post = postRepository.findById((id)).get();
		post.incrementAced();
		postRepository.save(post);
		model.addAttribute("aces", post.getAced());
		return "redirect:/readPosts";
	}


}
