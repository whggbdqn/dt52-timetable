package cn.bdqn.pojo;

public class Teacher {
    private Integer teacherId;

    private String name;

    private String gender;

    private String scheduleName;

    private Integer dr;
    
    private Classes classes;
    
    private Course course;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getScheduleName() {
        return scheduleName;
    }

    public void setScheduleName(String scheduleName) {
        this.scheduleName = scheduleName == null ? null : scheduleName.trim();
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name
				+ ", gender=" + gender + ", scheduleName=" + scheduleName
				+ ", dr=" + dr + ", classes=" + classes + ", course=" + course
				+ "]";
	}

	
    
}