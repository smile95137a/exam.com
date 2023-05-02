package exam.com.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import exam.com.dao.BoardDao;
import exam.com.entity.Article;
import exam.com.entity.Board;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Board> finAll() {
		String sql = "select * from board";
		Query query = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Board.class);
		
		@SuppressWarnings("unchecked")
		List<Board> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void save(Article article) {
		sessionFactory.getCurrentSession().save(article);
	}
}
