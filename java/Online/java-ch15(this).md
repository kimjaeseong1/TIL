## this
### 객체 자신을 가리키는 this

### this가 하는 일

- 인스턴스 자신의 메모리를 가리킴

- 생성자에서 또 다른 생성자를 호출 할때 사용

- 자신의 주소(참조값)을 반환 함


### 생성된 인스턴스 메모리의 주소를 가짐

- 클래스 내에서 참조변수가 가지는 주소 값과 동일 한 주소 값을 가지는 키워드

![image (34)](https://user-images.githubusercontent.com/105026909/191509026-f1dce235-9537-48b0-a262-434ff130df73.png)

`
public void setYear(int year)
{
    this.year = year;
}
`
### 생성자에서 다른 생성자를 호출 하는 this

- 클래스에 생성자가 여러 개 인경우, this를 이용하여 생성자에서 다른 생성자를 호출할 수 있음

- 생성자에서 다른 생성자를 호출하는 경우, 인스턴스의 생성이 완전하지 않은 상태이므로 this()

statement 이전에 다른 statement를 쓸 수 없음

``
public class Person {

	String name;
	int age;

	public Person() {
		this("이름없음", 1);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
``

### 자신의 주소를 반환하는 this

```
public class Person {

	String name;
	int age;

	public Person() {
		this("이름없음", 1);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person getPerson() {
		return this;
	}


	public static void main(String[] args)
	{
		Person p = new Person();
		p.name = "James";
		p.age = 37;

		Person p2 = p.getPerson();
		System.out.println(p);
		System.out.println(p2);
	}
}
```
![image (35)](https://user-images.githubusercontent.com/105026909/191509288-4d5e79de-7e7b-4aca-af62-30406e274345.png)


### 객체 간의 협렵(collabration)

#### 객체 지향 프로그래밍에서의 협력

- 객체 지향 프로그램에서 객체 간에는 협력이 이루어짐

- 협력을 위해서는 필요한 메세지를 전송하고 이를 처리하는 기능이 구현되어야 함

- 매개 변수로 객체가 전달되는 경우가 발생

- 객체 협력의 예

![image (36)](https://user-images.githubusercontent.com/105026909/191509405-420c21d4-fbd2-4085-9892-f46fee3600c6.png)

### 버스 타고 학교 가는 학생의 과정을 객체 지향 프로그래밍으로 구현해보기

#### 버스와 지하철을 타는 예제 프로그래밍
``
James와 Tomas는 각각 버스와 지하철을 타고 학교에 갑니다.
James는 5000원을 가지고 있었고, 100번 버스를 타면서 1000원을 지불합니다.
Tomas는 10000원을 가지고 있었고, 초록색 지하철을 타면서 1200원을 지불합니다.

두 학생이 버스와 지하철을 타는 상황을 구현해 봅시다.
``

student.java
``
package ch14;

public class Student {

	String studentName;
	int money;

	public Student(String studentName , int money) {
		this.studentName = studentName;
		this.money = money;
	}

	public void takeBus(Bus bus) {
		bus.take(1000);
		this.money  -= 1000;
	}

	public void takeSubway(Subway subway) {
		subway.take(1200);
		this.money -= 1200;
	}

	public void showInfo()
	{
		System.out.println(studentName+ "님의 남은 돈은 " + money + "원 입니다.");
	}
}
``
bus.java

``
package ch14;

public class Bus {

	int busNumber;
	int passengerCount;
	int money;

	public Bus(int busNumber ) {
		this.busNumber = busNumber;
	}


	public void take(int money) {
		this.money += money;
		passengerCount++;
	}

	public void showBuwinfo() {
		System.out.println(busNumber + "번의  버스의 승객 수는 " + passengerCount + "명 이고 , 수입은 "+money+"원 입니다. ");
	}
}
``
Subway.java
``
package ch14;

public class Subway {

	int subNumber;
	int passengerCount;
	int money;

	public Subway(int busNumber ) {
		this.subNumber = busNumber;
	}


	public void take(int money) {
		this.money += money;
		passengerCount++;
	}

	public void showSubinfo() {
		System.out.println(subNumber + "번 지하철의 승객수는 " + passengerCount + "명 이고 , 수입은 "+money+"원 입니다. ");
	}
}
``
TakeTransTest.java

``
package ch14;

public class TakeTransTest {

	public static void main(String[] args) {

		Student studentJ = new Student("james", 5000);
		Student studentK = new Student("Kim", 10000);

		Bus bus100 = new Bus(100);
		Bus bus200 = new Bus(500);

		studentJ.takeBus(bus100);

		Subway greenSubway = new Subway(2);
		studentK.takeSubway(greenSubway);

		studentJ.showInfo();
		studentK.showInfo();

		bus100.showBuwinfo();
		greenSubway.showSubinfo();


	}

}
``

![image (37)](https://user-images.githubusercontent.com/105026909/191509906-93d08c3c-e172-4c01-8b89-d8132f9235d4.png)
