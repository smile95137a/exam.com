package exam.com.dao;

import java.util.List;

import exam.com.entity.Article;
import exam.com.entity.Board;

public interface BoardDao {

	public List<Board> finAll();

	public void save(Article article);

}
