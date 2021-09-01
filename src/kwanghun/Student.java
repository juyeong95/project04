package kwanghun;

import java.io.Serializable;

public class Student implements Serializable{
	
	private String name=null;
	private String stNum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}

}
