package dao;

import java.util.List;

import javax.persistence.EntityManager;

import entity.LopHoc;
import util.HibernateUtil;

public class LopHocDao {
	private EntityManager em = new HibernateUtil().getEntityManager();
	public List<LopHoc> getAll(){
		return em.createQuery("from LopHoc").getResultList();
	}
	public LopHoc get(int id) {
		return em.find(LopHoc.class, id);
	}
}
