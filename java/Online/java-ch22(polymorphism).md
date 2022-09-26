## 다형성(polymorphism) 이란?

- 하나의 코드가 여러 자료형으로 구현되어 실행되는 것
- 같은 코드에서 여러 다른 실행 결과가 나옴
- 정보은닉, 상속과 더불어 객체지향 프로그래밍의 가장 큰 특징 중 하나임
- 다형성을 잘 활용하면 유연하고 확장성있고, 유지보수가 편리한 프로그램을 만들수 있음

### 다형성의 예

```shell
class Animal{

	public void move() {
		System.out.println("동물이 움직입니다.");
	}

	public void eating() {

	}
}

class Human extends Animal{
	public void move() {
		System.out.println("사람이 두발로 걷습니다.");
	}

	public void readBooks() {
		System.out.println("사람이 책을 읽습니다.");
	}
}

class Tiger extends Animal{

	public void move() {
		System.out.println("호랑이가 네 발로 뜁니다.");
	}

	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
}


class Eagle extends Animal{
	public void move() {
		System.out.println("독수리가 하늘을 날아갑니다.");
	}

	public void flying() {
		System.out.println("독수리가 날개를 쭉 펴고 멀리 날아갑니다");
	}
}



public class AnimalTest {

	public static void main(String[] args) {

		Animal hAnimal = new Human();
		Animal tAnimal = new Tiger();
		Animal eAnimal = new Eagle();

		AnimalTest test = new AnimalTest();
		test.moveAnimal(hAnimal);
		test.moveAnimal(tAnimal);
		test.moveAnimal(eAnimal);

		ArrayList<Animal> animalList = new ArrayList<Animal>();
		animalList.add(hAnimal);
		animalList.add(tAnimal);
		animalList.add(eAnimal);

		for(Animal animal : animalList) {
			animal.move();
		}
	}

	public void moveAnimal(Animal animal) {
		animal.move();

	}
}
```

### 다형성을 사용하는 이유?

- 다른 동물을 추가하는 경우
- 상속과 메서드 재정의를 활용하여 확장성 있는 프로그램을 만들 수 있음
- 그렇지 않는 경우 많은 if-else if문이 구현되고 코드의 유지보수가 어려워짐

![image (63)](https://user-images.githubusercontent.com/105026909/192278400-eec6f7ec-6501-43a4-90f9-0520af12fb34.png)

- 상위 클래스에서는 공통적인 부분을 제공하고 하위 클래스에서는 각 클래스에 맞는 기능 구현
- 여러 클래스를 하나의 타입(상위 클래스)으로 핸들링 할 수 있음

### 다형성을 활용한 멤버십 프로그램 확장

- 일반 고객과 VIP 고객 중간 멤버십 만들기
고객이 늘어 일반 고객보다는 많이 구매하고 VIP보다는 적게 구매하는 고객에게도 해택을 주기로 했다.

GOLD 고객 등급을 만들고 혜택은 다음과 같다

1. 제품을 살때는 10프로를 할인해준다
2. 보너스 포인트는 2%를 적립해준다

GoldCustomer.java

```shell
public class GoldCustomer extends Customer{

	double saleRatio;

	public GoldCustomer(int customerID, String customerName){
		super(customerID, customerName);

		customerGrade = "GOLD";
		bonusRatio = 0.02;
		saleRatio = 0.1;

	}

	public int calcPrice(int price){
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio);
	}
}
```

VIPCustomer.java
```shell
//showCustomerInfo() 재정의
public String showCustomerInfo(){
		return super.showCustomerInfo() + " 담당 상담원 번호는 " + agentID + "입니다";
}
```
CustomerTest.java
```shell
public class CustomerTest {

	public static void main(String[] args) {

		ArrayList<Customer> customerList = new ArrayList<Customer>();

		Customer customerLee = new Customer(10010, "이순신");
		Customer customerShin = new Customer(10020, "신사임당");
		Customer customerHong = new GoldCustomer(10030, "홍길동");
		Customer customerYul = new GoldCustomer(10040, "이율곡");
		Customer customerKim = new VIPCustomer(10050, "김유신", 12345);

		customerList.add(customerLee);
		customerList.add(customerShin);
		customerList.add(customerHong);
		customerList.add(customerYul);
		customerList.add(customerKim);

		System.out.println("====== 고객 정보 출력 =======");

		for( Customer customer : customerList){
			System.out.println(customer.showCustomerInfo());
		}

		System.out.println("====== 할인율과 보너스 포인트 계산 =======");

		int price = 10000;
		for( Customer customer : customerList){
			int cost = customer.calcPrice(price);
			System.out.println(customer.getCustomerName() +" 님이 " +  + cost + "원 지불하셨습니다.");
			System.out.println(customer.getCustomerName() +" 님의 현재 보너스 포인트는 " + customer.bonusPoint + "점입니다.");
		}
	}
}
```
![image (64)](https://user-images.githubusercontent.com/105026909/192278761-14f12b2e-9ca9-49be-a566-d5b1f42d4e5a.png)


## 상속은 언제 사용 할까?

### IS-A 관계(is a relationship : inheritance)

- 일반적인(general) 개념과 구체적인(specific) 개념과의 관계
- 상위 클래스 : 하위 클래스보다 일반적인 개념 ( 예: Employee )
- 하위 클래스 : 상위 클래스보다 구체적인 개념들이 더해짐 ( 예: Engineer, Manager...)
- 상속은 클래스간의 결합도가 높은 설계
- 상위 클래스의 수정이 많은 하위 클래스에 영향을 미칠 수 있음
- 계층구조가 복잡하거나 hierarchy가 높으면 좋지 않음

### HAS-A 관계(composition)

- 클래스가 다른 클래스를 포함하는 관계 ( 변수로 선언 )
- 코드 재사용의 가장 일반적인 방법
- Student가 Subject를 포함하는
- Library를 구현할 때 ArrayList 생성하여 사용
- 상속하지 않음


