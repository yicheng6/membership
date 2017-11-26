package org.springframework.samples.petclinic.membership;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.samples.petclinic.model.BaseEntity;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {
	@Column(name = "number")
    @NotEmpty
	private String number;
	
	@Column(name = "name")
    @NotEmpty
	private String name;
	
	@Column(name = "sex")
    @NotEmpty
	private String sex;
	
	@Column(name = "grade")
    @NotEmpty
	private String grade;
	
	@Column(name = "major")
    @NotEmpty
	private String major;
	
	@Column(name = "class_name")
    @NotEmpty
	private String className;
	
	@Column(name = "id_card")
    @NotEmpty
	private String idCard;
	
	@Column(name = "moblie")
    @NotEmpty
	private String moblie;
	
	@Column(name = "remark")
	private String remark;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getMoblie() {
		return moblie;
	}

	public void setMoblie(String moblie) {
		this.moblie = moblie;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
