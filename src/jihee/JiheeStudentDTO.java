package jihee;

import java.io.Serializable;

public class JiheeStudentDTO implements Serializable{

		private String name;
		private String stNum;
		private String add;
		private int age;
		
		
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
		public String getAdd() {
			return add;
		}
		public void setAdd(String add) {
			this.add = add;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
	

}
