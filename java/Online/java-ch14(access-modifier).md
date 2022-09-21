## 접근 제어 지시자와 정보은닉

### 접근 제어 지시자 (accesss modifier)

- 클래스 외부에서 클래스의 멤버 변수, 메서드, 생성자를 사용할 수 있는지 여부를 지정하는 키워드

- private : 같은 클래스 내부에서만 접근 가능 ( 외부 클래스, 상속 관계의 클래스에서도 접근 불가)

- 아무것도 없음 (default) : 같은 패키지 내부에서만 접근 가능 ( 상속 관계라도 패키지가 다르면 접근 불가)

- protected : 같은 패키지나 상속관계의 클래스에서 접근 가능하고 그 외 외부에서는 접근 할 수 없음

- public : 클래스의 외부 어디서나 접근 할 수 있음

- private 으로 선언된 멤버 변수 (필드)에 대해 접근, 수정할 수 있는 메서드를 public으로 제공

- get() 메서드만 제공 되는 경우 read-only 필드

- 이클립스에서 자동으로 생성됨

### 정보은닉

- private으로 제어한 멤버 변수도 public 메서드가 제공되면 접근 가능하지만 변수가 public으로 공개되었을 때보다

- private 일때 각 변수에 대한 제한을 public 메서드에서 제어 할 수 있다.

```
public void setMonth(int month) {

		if ( month < 1 || month > 12) {
			isValid = false;
		}
		else {
			this.month = month;
		}
	}
```

- 객체 지향 프로그램에서 정보 은닉은 필요한 외부에서 접근 가능한 최소한의 정보를 오픈함으로써 객체의 오류를 방지하 클라이언트 객체가 더 효율적으로 객체를 활용할 수 있도록 해준다.

Birthday.class
```
package ch10;

public class Birthday {

		private int day;
		private int month;
		private int year;

		private boolean isValid;

		public int getDay() {
			return day;
		}
		public void setDay(int day) {
			this.day = day;
		}
		public int getMonth() {
			return month;
		}
		public void setMonth(int month) {
			if(month <1 || month >12) {
				isValid = false;
			}else {
				isValid = true;
				this.month = month;

			}
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}

		public void showDate() {
			if(isValid) {
				System.out.println(year + "년" + month+ "월" + day + "일 입니다.");
			}else {
				System.out.println("유효하지 않은 날짜 입니다. ");
			}
		}

}
```

birthdatTest.java
```
package ch10;

public class BirthDayTest {

	public static void main(String[] args) {

		Birthday date = new Birthday();

		date.setYear(2019);
		date.setMonth(12); // date.setMonth(13) 일때는 유효하지 않은 날짜입니가 출력
		date.setDay(30);

		date.showDate();
	}

}
```
![image (31)](https://user-images.githubusercontent.com/105026909/191508009-fa3c2892-058d-492a-b23e-1c6d0b421cc7.png)

![image (32)](https://user-images.githubusercontent.com/105026909/191508036-affeb847-d3be-49b8-ae2a-2e7c2ecdecea.png)

## 캡슐화 (encapsulation)

### 정보 은닉을 활용한 캡슐화

- 꼭 필요한 정보와 기능만 외부에 오픈함

- 대부분의 멤버 변수와 메서드를 감추고 외부에 통합된 인터페이스만은 제공하여 일관된 기능을 구현 하게 함

- 각각의 메서드나 멤버 변수를 접근함으로써 발생하는 오류를 최소화 한다.

### 레포트 만들기 예제

```
public class MakeReport {

	StringBuffer buffer = new StringBuffer();
	
	private String line = "===========================================\n";
	private String title = "  이름\t   주소 \t\t  전화번호  \n";
	private void makeHeader()
	{
		buffer.append(line);
		buffer.append(title);
		buffer.append(line);
	}
	
	private void generateBody()
	{
		buffer.append("James \t");
		buffer.append("Seoul Korea \t");
		buffer.append("010-2222-3333\n");
		
		buffer.append("Tomas \t");
		buffer.append("NewYork US \t");
		buffer.append("010-7777-0987\n");
	}
	
	private void makeFooter()
	{
		
		buffer.append(line);
	}
	
	public String getReport()
	{
		makeHeader();
		generateBody();
		makeFooter();
		return buffer.toString();
	}
}
```
```
public class TestReprt {

	public static void main(String[] args) {

		MakeReport report = new MakeReport();
		String builder = report.getReport();

		System.out.println(builder);
	}

}
```

![image (33)](https://user-images.githubusercontent.com/105026909/191508380-9ae6c831-742e-4571-9d9d-ff9fb0ef5401.png)




