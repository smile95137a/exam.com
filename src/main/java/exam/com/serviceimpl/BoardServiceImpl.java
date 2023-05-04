package exam.com.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.com.dao.BoardDao;
import exam.com.entity.Article;
import exam.com.entity.Board;
import exam.com.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Board> findAll() {
		return boardDao.finAll();
	}

	@Override
	public void save(Board board) {
		boardDao.save(board);
	}

	@Override
	public Board findById(Integer id) {
		return boardDao.findById(id);
	}
	@Transactional
	public void delete(int boardId) {
		boardDao.delete(boardId);
	}

	@Override
	public void update(Board board) {
		boardDao.update(board);
	}
	
	
}
