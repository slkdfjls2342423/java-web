package entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_sinhvien")
public class SinhVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id=0;
	private String name;
	private Date birthday;
	private float dtb;
	@ManyToOne
	@JoinColumn(name = "lophoc_id")
	private LopHoc lophoc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public float getDtb() {
		return dtb;
	}
	public void setDtb(float dtb) {
		this.dtb = dtb;
	}
	public LopHoc getLophoc() {
		return lophoc;
	}
	public void setLophoc(LopHoc lophoc) {
		this.lophoc = lophoc;
	}
	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", name=" + name + ", birthday=" + birthday + ", dtb=" + dtb + ", lophoc="
				+ lophoc.getName() + "]";
	}
	public SinhVien(String name, Date birthday, float dtb, LopHoc lophoc) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.dtb = dtb;
		this.lophoc = lophoc;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
