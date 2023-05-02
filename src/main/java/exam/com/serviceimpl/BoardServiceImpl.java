package exam.com.serviceimpl;

import java.util.List;

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
	public void save(Article article) {
		boardDao.save(article);
	}
	
	
}
