package exam.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/create")
	public String newArticle(Model model) {
		Board board = new Board();
		model.addAttribute("board", board);
		return "create";
	}
	
	@PostMapping("/create")
	public String createArticle(Board board) {
		boardService.save(board);
		return "redirect:list";
	}
	
	@GetMapping("/update")
	public String updateArticle(@RequestParam int boardId, ModelMap model) {
		Board theboard = boardService.findById(boardId);
		model.addAttribute("board", theboard);
		return "update";
	}
	
	@PostMapping("/update")
	public String editArticle(Board board) {
		boardService.update(board);
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String deleteArticle(@RequestParam("boardId") int boardId) {
		boardService.delete(boardId);
		return "redirect:list";
	}
	
	@GetMapping("/content")
	public String context(@RequestParam int boardId, ModelMap model) {
	    Board theboard = boardService.findById(boardId);
	    List<Board> listContext = new ArrayList<>();
	    listContext.add(theboard);
	    model.addAttribute("contexts", listContext);
	    return "view";
	}
	
}
