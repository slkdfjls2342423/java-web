package util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.LopHocDao;
import entity.LopHoc;

public class HibernateUtil {
	private static EntityManagerFactory ef=Persistence.createEntityManagerFactory("onthi");
	public EntityManager getEntityManager() {
		return ef.createEntityManager();
	}
	public static void main(String[] args) {
		EntityManager em=new HibernateUtil().getEntityManager();
		List<LopHoc> ls=new LopHocDao().getAll();
		for (LopHoc lopHoc : ls) {
			System.out.println(lopHoc);
		}
	}
}
