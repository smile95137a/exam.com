package exam.com.dao;

import java.util.List;

import exam.com.entity.Board;

public interface BoardDao {

	public List<Board> finAll();

	public void save(Board board);

	public Board findById(Integer id);

	public void delete(int boardId);

	public void update(Board board);

}
