package lab01.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import lab01.dao.MemberDao;
import lab01.model.MemberBean;
import lab01.utils.HibernateUtils;

public class MemberHibernateDaoImpl implements MemberDao {

    SessionFactory factory ;
	
	public MemberHibernateDaoImpl() {
		factory = HibernateUtils.getSessionFactory();
	}

	public MemberBean findByMemberId(String id) {
		MemberBean result = null;
		String hql = "FROM MemberEntity WHERE memberId = :mid";
		Session session = factory.getCurrentSession();
		List<MemberBean> beans = session.createQuery(hql, MemberBean.class)
				                        .setParameter("mid", id)
				                        .getResultList();
		if (beans.size() > 0) {
			result = beans.get(0);
		}

		return result;
	}

	public List<MemberBean> findAll() {
		String hql = "FROM MemberEntity";
		Session session = factory.getCurrentSession();
		List<MemberBean> result = session.createQuery(hql, MemberBean.class)
                                         .getResultList();
		return result;
	}

	public void save(MemberBean bean) {
		Session session = factory.getCurrentSession();
		session.save(bean);
	}

	public void deleteByMemberId(String memberId) {
		Session session = factory.getCurrentSession();
		MemberBean bean = findByMemberId(memberId);
		session.delete(bean);
	}

	@Override
	public boolean existsByMemberId(String memberId) {
		MemberBean memberBean = findByMemberId(memberId);
		return (memberBean != null);
	}

	@Override
	public MemberBean findById(Integer id) {
		Session session = factory.getCurrentSession();
		MemberBean memberBean = session.get(MemberBean.class, id);
		return memberBean;
	}

	@Override
	public void deleteById(Integer id) {
		Session session = factory.getCurrentSession();
		MemberBean memberBean = new MemberBean();
		memberBean.setId(id);
		session.delete(memberBean);
		return;
	}

	@Override
	public void update(MemberBean memberBean) {
		Session session = factory.getCurrentSession();
		MemberBean temp = findById(memberBean.getId());
		memberBean.setRegisterDate(temp.getRegisterDate());
		//session.evict(temp);
//		session.saveOrUpdate(memberBean);
		session.merge(memberBean);
	}
}