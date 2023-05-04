package exam.com.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import exam.com.dao.BoardDao;
import exam.com.entity.Board;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Board> finAll() {
		String sql = "select * from board";
		Query query = sessionFactory.openSession().createSQLQuery(sql).addEntity(Board.class);
		
		@SuppressWarnings("unchecked")
		List<Board> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void save(Board board) {
		sessionFactory.openSession().save(board);
	}

	@Override
	public Board findById(Integer id) {
//		String sql = "select * from board where borad_id = :id";
//		Query query = sessionFactory.openSession().createSQLQuery(sql).addEntity(Board.class);
//		query.setParameter("boardId", id);
//		return (Board) query.getSingleResult();
		Session session = sessionFactory.openSession();
		Board board = session.get(Board.class, id);
		return board;
	}

	public void delete(int boardId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Query query = session.createQuery("delete from Board where board_id = :boardId");
			query.setParameter("boardId", boardId);
			query.executeUpdate();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally {
			session.close();
		}
//		Session session = sessionFactory.openSession();
//        Board board = session.get(Board.class, boardId);
//        session.delete(board);
	}

	@Override
	public void update(Board board) {
		sessionFactory.openSession().update(board);
	}

}
