package lab01.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import lab01.dao.MemberDao;
import lab01.dao.impl.MemberHibernateDaoImpl;
import lab01.model.MemberBean;
import lab01.service.MemberService;
import lab01.utils.HibernateUtils;

public class MemberHibernateServiceImpl implements MemberService {
	
	MemberDao memberDao = null;
	SessionFactory factory = null;
	
	public MemberHibernateServiceImpl() {
		memberDao = new MemberHibernateDaoImpl();
		factory = HibernateUtils.getSessionFactory();
	}	

	public MemberBean findById(Integer id) {
		MemberBean memberBean = null;
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			memberBean = memberDao.findById(id);
			//...
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		}
		return memberBean;
	}
	
	public List<MemberBean> findAll() {
		List<MemberBean> beans = new ArrayList<>();
		
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			beans = memberDao.findAll();
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		}
		return beans;
	}

	public void save(MemberBean bean) {
		
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			memberDao.save(bean);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		}
		
//		 memberDao.save(bean);
	}

	public void deleteById(Integer id) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			memberDao.deleteById(id);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		}
//		memberDao.deleteById(id);
	}

	@Override
	public boolean existsByMemberId(String memberId) {
		boolean result = false;
		
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			result = memberDao.existsByMemberId(memberId);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		}
		return result;
	}

	@Override
	public void update(MemberBean memberBean) {
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			memberDao.update(memberBean);
			tx.commit();
		} catch(Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new RuntimeException(e);
		}
//		memberDao.update(memberBean);
		
	}
}