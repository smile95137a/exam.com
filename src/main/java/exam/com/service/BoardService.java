package exam.com.service;

import java.util.List;

import exam.com.entity.Board;

public interface BoardService {

	public List<Board> findAll();

	public void save(Board board);

	public Board findById(Integer id);

	public void delete(int boardId);

	public void update(Board board);

}
