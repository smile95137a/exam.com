package exam.com.service;

import java.util.List;

import exam.com.entity.Article;
import exam.com.entity.Board;

public interface BoardService {

	public List<Board> findAll();

	public void save(Article article);

}
