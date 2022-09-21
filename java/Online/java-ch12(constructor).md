## 생성자(constructor)

### 생성자

- 생성자 기본 문법 <class_name>([<argument_list]) { [<statements>] }

- 객체를 생성할 때 new 키워드와 함께 사용 - new Student();

- 생성자는 일반 함수처럼 기능을 호출하는 것이 아니고 객체를 생성하기 위해 new 와 함께 호출 됨

- 객체가 생성될 때 변수나 상수를 초기화 하거나 다른 초기화 기능을 수행하는 메서드를 호출 함

- 생성자는 반환 값이 없고, 클래스의 이름과 동일

- 대부분의 생성자는 외부에서 접근 가능하지만, 필요에 의해 private 으로 선언되는 경우도 있음


### 기본 생성자 (default constructor)

- 클래스에는 반드시 적어도 하나 이상의 생성자가 존재

- 클래스에 생성자를 구현하지 않아도 new 키워드와 함께 생성자를 호출할 수 있음

- 클래스에 생성자가 하나도 없는 경우 컴파일러가 생성자 코드를 넣어 줌public Student(){}
- 매개 변수가 없음, 구현부가 없음

### 생성자 만들기

- 컴파일러가 제공해 주는 기본 생성자외에 필요에 의해 생성자를 직접 구현 할 수 있음

Student.java

```
public class Student {

	public int studentNumber;
	public String studentName;
	public int grade;

	public Student(int studentNumber, String studentName, int grade) {
		this.studentNumber = studentNumber;   //this.멤버변수 : 매개 변수와 객체 자신이 가지고 있는 변수의 이름이 같은 겨우 이를 구분하기 위해 this 를 붙인다.
		this.studentName = studentName;
		this.grade = grade;
	}

	public String showStudentInfo() {
		return studentName + "학생의 학번은 " + studentNumber + "이고, " + grade + "학년 입니다.";
	}
}
 ```
 StudentTest.java

 ```
public class StudentTest {

	public static void main(String[] args) {

		//Student studentLee = new Student();
		
		Student studentLee = new Student(12345, "Lee", 3);
		
		String data = studentLee.showStudentInfo();
		System.out.println(data);
	}
```

![image (26)](https://user-images.githubusercontent.com/105026909/191505445-78a673c5-a75a-44d0-918a-296ba7c48f09.png)

![image (27)](https://user-images.githubusercontent.com/105026909/191505517-a3226e49-779a-415b-8e1a-e6f99c5e65b3.png)

![image (28)](https://user-images.githubusercontent.com/105026909/191505544-2c6105db-4b0f-4b67-b077-c0f051d1dcf0.png)

## 여러가지 생성자를 정의하는 생성자 오버로딩(overloading)

### 생성자 정의 하기 

- 생성자를 구현해서 사용할 수 있음

- 클래스에 생성자를 따로 구현하면 기본 생성자 (default constructor)는 제공되지 않음

- 생성자를 호출하는 코드(client 코드)에서 여러 생성자 중 필요에 따라 호출해서 사용할 수 있음

UserInfo.java

```
public class UserInfo {

	public String userId;
	public String userPassWord;
	public String userName;
	public String userAddress;
	public String phoneNumber;

	public UserInfo(){}

	public UserInfo(String userId, String userPassWord, String userName) {
		this.userId = userId;
		this.userPassWord = userPassWord;
		this.userName = userName;
	}

	public String showUserInfo() {
		return "고객님의 아이디는 " + userId + "이고, 등록된 이름은 " + userName + "입니다.";
	}
}
```

```
public class UserInfoTest {

	public static void main(String[] args) {

		UserInfo userLee = new UserInfo();
		userLee.userId = "a12345";
		userLee.userPassWord = "zxcvbn12345";
		userLee.userName = "Lee";
		userLee.phoneNumber = "01034556699";
		userLee.userAddress = "Seoul, Korea";

		System.out.println(userLee.showUserInfo());

		UserInfo userKim = new UserInfo("b12345", "09876mnbvc", "Kim");
		System.out.println(userKim.showUserInfo());
	}
}
```



