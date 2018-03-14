package cn.bdqn.pojo;

public class Classes {
    private Integer classPk;

    private Integer stuNum;

    private String className;

    private String major;

    private Integer courseId;
    
    private Integer teacherId;

    private Integer instructorId;

    private Integer dr;

	public Integer getClassPk() {
		return classPk;
	}

	public void setClassPk(Integer classPk) {
		this.classPk = classPk;
	}

	public Integer getStuNum() {
		return stuNum;
	}

	public void setStuNum(Integer stuNum) {
		this.stuNum = stuNum;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(Integer instructorId) {
		this.instructorId = instructorId;
	}

	public Integer getDr() {
		return dr;
	}

	public void setDr(Integer dr) {
		this.dr = dr;
	}

	@Override
	public String toString() {
		return "Classes [classPk=" + classPk + ", stuNum=" + stuNum
				+ ", className=" + className + ", major=" + major
				+ ", courseId=" + courseId + ", teacherId=" + teacherId
				+ ", instructorId=" + instructorId + ", dr=" + dr + "]";
	}

	
}