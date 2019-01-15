package com.makersacademy.acebook.controller;


import com.makersacademy.acebook.model.Post;
import com.makersacademy.acebook.model.PostForm;
import com.makersacademy.acebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

	private final PostRepository postRepository;

	@Autowired  // Injects the Post repo into the controller
	public HomeController(PostRepository postRepository) {
		this.postRepository = postRepository;
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
		System.out.println(post);
		postRepository.save(post);
		System.out.println(postRepository.findAll());
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

}
