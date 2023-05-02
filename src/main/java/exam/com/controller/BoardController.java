package exam.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import exam.com.entity.Article;
import exam.com.entity.Board;
import exam.com.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/list")
	public String findList(Model model) {
		List<Board> resultList = boardService.findAll();
		model.addAttribute("resultList" , resultList);
		return "list"; 
	}
	
	@PostMapping("/create")
	public String createBoard(Article article) {
		boardService.save(article);
		return "create";
	}
}
