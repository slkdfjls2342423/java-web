package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_lophoc")
public class LopHoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(mappedBy = "lophoc")
	List<SinhVien> sinhViens;
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
	public List<SinhVien> getSinhViens() {
		return sinhViens;
	}
	public void setSinhViens(List<SinhVien> sinhViens) {
		this.sinhViens = sinhViens;
	}
	@Override
	public String toString() {
		return "LopHoc [id=" + id + ", name=" + name + "]";
	}
	public LopHoc(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public LopHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
