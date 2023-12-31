package ch06_sll.ex01.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch06_sll.ex01.dao.CategoryDao;
import ch06_sll.ex01.dao.ProductEntityDao;
import ch06_sll.ex01.model.Category;
import ch06_sll.ex01.model.ProductEntity;
import ch06_sll.ex01.service.ProductEntityService;
@Transactional
@Service
public class ProductEntityServiceImpl implements ProductEntityService {

	ProductEntityDao  productEntityDao;
	CategoryDao  categoryDao;
//	SessionFactory  factory;
	
//	@Autowired
	public ProductEntityServiceImpl(ProductEntityDao productEntityDao, CategoryDao categoryDao
//			,SessionFactory factory
			) {
		super();
		this.productEntityDao = productEntityDao;
		this.categoryDao = categoryDao;
//		this.factory = factory;
	}

	@Override
	public ProductEntity save(ProductEntity product) {
		ProductEntity productEntity = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			Category category = categoryDao.findByName(product.getCategory().getName());
			if (category != null) {
				product.setCategory(category);
			} else {
				categoryDao.save(product.getCategory());
			}
			productEntity = productEntityDao.save(product);
//			tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		return productEntity;
	}

	@Override
	public ProductEntity findById(int id) {
		ProductEntity productEntity = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			productEntity = productEntityDao.findById(id);
//			tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		
		return productEntity;
	}

	@Override
	public void update(ProductEntity product) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			productEntityDao.update(product);
//			tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
	}

	@Override
	public void delete(int id) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			productEntityDao.delete(id);
//			tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
	}

	@Override
	public List<ProductEntity> findAll() {
		List<ProductEntity>  ProductEntities = null;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			ProductEntities = productEntityDao.findAll();
//		    tx.commit();
//		} catch(Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			throw new RuntimeException(ex.getMessage());
//		}
		return ProductEntities;
	}
}
