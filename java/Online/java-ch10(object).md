## 객체와 객체 지향 프로그래밍

### 객체(object)

- 의사나 행위가 미치는 대상 (사전적 의미)
- 구체적, 추상적 데이터의 단위(학생, 회원, 생산, 주문, 배송)

### 객체 지향 프로그래램과 절차 지향 프로그래밍

- 아침에 일어나 학교를 가는 과정을 예를 들어보면

- 절차 지향 프로그래밍
 시간이나 사건의 흐름에 따른 프로그래밍
 일어난다 -> 씻는다 -> 밥을 먹는다 -> 버스를 탄다-> 요금을 지불한다 -> 학교에 도착

![image (17)](https://user-images.githubusercontent.com/105026909/191454934-6a0ecee1-cc72-41a8-b991-e82846a1a0f4.png)

### 객체 지향 프로그램은 어떻게 구현하는가?

- 객체를 정의 하고, 각 객체 제공하는 기능들을 구현하고
- 각 객체가 제공하는 기능들 간의 소통(메세지 전달)을 통하여 객체간의 협력을 구현

### 객체를 찾아 봅시다

- 온라인 쇼핑몰(객체)에 회원 로그인을 하고 여러 판매자(객체)가 판매하고 있는 제품(객체) 중 하나를 골라 주문을 한다
- 아침에 회사(객체)에 가는 길에 별다방 커피숍(객체)에 들려 아이스 카페라떼(객체)를 주문했다
- 성적확인을 위해 학사 관리 시스템(객체)에 로그인 하여 수강 한 과목(객체)들의 성적(객체)을 확인했다

### 클래스는 객체의 청사진(blueprint) 입니다

- 객체의 속성은 클래스의 멤버 변수(member variable)로 선언 함
- 학생 클래스
```
public class Student {

	int studentNumber;
	String studentName;
	int majorCode;
	String majorName;
	int grade;
}
```

- 주문 클래스
```
public class Order {

	int orderId;
	String buyerId;
	String sellerId;
	int productId;
	String orderDate;
}
```
- 회원 클래스
```
public class UserInfo {

	String userId;
	String userPassWord;
	String userName;
	String userAddress;
	int phoneNumber;
}
```

### 객체 지향 프로그램을 할 때는

- 객체를 정의 하고
- 각 객체의 속성을 멤버 변수로 역할을 메서드로 구현하고
- 각 객체간의 협력을 구현합니다.

### 클래스 코딩하기

- 클래스는 대문자로 시작하는것이 좋음
- java 파일 하나에 클래스는 여러 개가 있을 수 있지만, public 클래스는 하나이고, public - 클래스와 .java 파일의 이름은 동일함
- camel notation 방식으로 명명

![image (18)](https://user-images.githubusercontent.com/105026909/191456059-e2af01b5-c930-4d50-9dc9-945b686f3f29.png)

![image (19)](https://user-images.githubusercontent.com/105026909/191456072-30acd624-87e6-40bc-9ba3-a0439810b4aa.png)

![image (20)](https://user-images.githubusercontent.com/105026909/191456077-a7c7b71f-4bd2-44ad-87d8-084a4a5ca53c.png)




