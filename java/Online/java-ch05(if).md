## 자바 - 조건문 if문(만약에..라면)

### ﻿
조건문 이란?

- 주어진 조건에 따라 다른 실행이 이루어 지도록 구현
- '재산이 1억 이상이면 100만원을 세금으로 낸다 그렇지 않으면 내지 않는다.' 를 구현 한다면

만약에(재산이 1억 이상이면){
세금을 100만원 낸다.
}
그렇지 않으면{
세금을 내지 않는다.
}

- if문 문법
`if(조건식){

수행문; // 조건식이 '참'인 경우에(조건에 맞아야함) 수행문이 수행됨

}      // 조건식이 '참'이 아니면(조건이 맞지 않은 경우) 수행문이 수행되지 않음
`

- if-else 예제

``import java.util.Scanner;

public class IfElseTest {

	public static void main(String[] args) {

		int age = 7;

		//Scanner scanner = new Scanner(System.in);
		//int age = scanner.nextInt();
		
		if( age >= 8) {
			System.out.println("학교에 다닙니다");
		}
		else {
			System.out.println("학교에 다니지 않습니다.");
		}
	}
}
``
### 조건이 여러 개 일 때의 if 문

#### if-else if-else문


- 하나의 상황에 대한 조건이 여러개로 나뉘고 각 조건에 다른 수행이 이루어져야 할 경우 사용
- 각 조건은 상호 배타적임

``if(조건식1){
      수행문1;        // 조건식1이 '참'인 경우 수행하고 전체 조건문을 빠져나감
  }
  else if(조건식2){
      수행문2;        // 조건식2이 '참'인 경우 수행하고 전체 조건문을 빠져나감
  }
  else if(조건식3){
      수행문3;        // 조건식3이 '참'인 경우 수행하고 전체 조건문을 빠져나감
  }
  else{
      수행문4;        // 위 조건이 모두 해당되지 않는 경우 수행됨 (디폴트 조건)
  }

  수행문5;            // if-else if-else 문이 끝나면 수행됨

  가령 조건식2가 만족되면 수행문2 -> 수행문5  순으로 수행됨
  ``
  ![image](https://user-images.githubusercontent.com/105026909/191198904-ccffcaa0-a8ed-4617-b336-3f46f9f76cc4.png)

 ![image (1)](https://user-images.githubusercontent.com/105026909/191198985-872e66a1-4dda-4c3e-8464-24d54936e7e5.png)

 ![image (2)](https://user-images.githubusercontent.com/105026909/191199075-a9b9bf5e-8c49-4a71-93be-8b065bc42c51.png)


### if-esle if 문과 if - if문의 차이점

- if - else if 를 사용하는 경우 하나의 조건이 만족 되면 나머지 else if 부분은 수행되지 않음
- if - if 로 사용하게 되면 각각 다른 조건 문으로 해석되어 각각 수행하게 됨
``
public class IfElseIfTest {

	public static void main(String[] args) {

		int age = 12;
		int charge;

		if(age<8) {
			charge = 1000;
			System.out.println("미 취학 아동입니다.");
		}if(age < 14) {
			charge = 2000;
			System.out.println("초등학생 입니다. ");
		}if(age < 20) {
			charge = 2500;
			System.out.println("중, 고등학생입니다.");
		}else{
			charge = 3000;
			System.out.println("일반인입니다. ");
		}
		System.out.println("입장료는 " + charge + "입니다. ");

	}

}
``
![image (3)](https://user-images.githubusercontent.com/105026909/191199254-a89ec5cc-b426-4573-917a-4881c30e4b44.png)


if 문으로 다 바꾸게 되면 age가 12일 때 초등학생 입니다. 가 출력이 되고 그 다음에 중, 고등학생입니다 라는 문장도 출력하게 된다 age가 20보다 작다는 조건문도 성립하기 때문!

그래서 조건이 여러개 일 때 는 if else를 쓰는게 좋음



