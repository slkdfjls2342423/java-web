package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.SinhVien;
import util.HibernateUtil;

public class SinhVienDao {
	private EntityManager em=new HibernateUtil().getEntityManager();
	public List<SinhVien> getAll(){
		return em.createQuery("from SinhVien").getResultList();
	}
	public SinhVien get(int id) {
		return em.find(SinhVien.class, id);
	}
	public void add(SinhVien sv) {
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		em.persist(sv);
		trans.commit();
		em.close();
	}
	public void delete(int id) {
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		em.remove(get(id));
		trans.commit();
		em.close();
	}
	public void update(SinhVien sv) {
		EntityTransaction trans=em.getTransaction();
		trans.begin();
		em.merge(sv);
		trans.commit();
		em.close();
	}
}
