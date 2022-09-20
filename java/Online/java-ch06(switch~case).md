## 자바 - switch ~ case

### 조건이 여러 개 일 때 간단히 표현되는 switch-case 문

#### switch - case 문

- if - else if - else 문을 사용할 때 복잡하고 번거로운 부분을 가독성 좋게 구현

- 비교 조건이 특정 값이나 문자열인 경우 사용

- break 문을 사용하여 각 조건이 만족되면 switch 블럭을 빠져나오도록 함

- 자바 14부터 좀 더 간결해진 표현식이 지원 됨 ( break 사용하지 않음 )

### 한 달이 며칠인지 알려주는 프로그램 구현
```
package ch16;

import java.util.Scanner;

public class SwitchCaseTest {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);

		int month = sc.nextInt();
		int day;

		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			day = 31;
		 	break;
		case 2: case 6: case 9: case 11:
			day = 28;
			break;

		case 4:
			day = 30;
			break;
		default :
			System.out.println("존재하지 않는 달 입니다. ");
			day = -1;
		}
		System.out.println(month + "월은" + day + "일 입니다." );

	}

}
```
![image (4)](https://user-images.githubusercontent.com/105026909/191202070-a07c06be-1fe7-44b8-990c-f8e0182f7ee5.png)

case를 12까지 하나하나 다 세로로 쭉 적을 수 있지만 그럼 코드가 너무 길어지기 때문에 크게 28일 30 일 31일로 나눠서 case를 옆으로 나열해서 코드를 작﻿Java 14 부터 지원 되는 Switch Expression

### Java 14 부터 지원 되는 Switch Expression

- 간단하게 쉼표(,)로 조건 구분

- 식으로 표현 하여 반환 값을 받을 수 있음. 리턴 값이 없는 경우는 오류가 생김

- yield 키워드 사용

```
public class SwitchCaseUpTest {

	public static void main(String[] args) {

		int month = 3;

		int day = switch (month) {
	    	case 1, 3, 5, 7, 8, 10,12 -> {
	    		System.out.println("한 달은 31일입니다.");
	    		yield 31;
	    	}
	    	case 4,6,9,11 -> {
	    		System.out.println("한 달은 30일입니다.");
	    		yield 30;
	    	}
	    	case 2 ->{
	    		System.out.println("한 달은 28일입니다.");
	    		yield 28;
	    	}
	    	default->{
	    		System.out.println("존재하지 않는 달 입니다.");
	    		yield 0;
	    	}
		};
		System.out.println(month + "월은 " + day + "일입니다.");
	}
}
```

- : 대신 -> 를 이용해서 코드를 작성을 할 수 있다.

그리고 case를 이어서 작성을 할 때 일일이 case를 작성하지 않고 ,를 사용해서 나열을 할 수 있다.

`case 4,6,9,11 -> {
	    		 30;
	    	}`


이런식으로 출력문이 없는 case에는 yeild 키워드를 안 붙여도 가능하다

스위치 표현식 및 스위치 문장에서 값을 명시적으로 리턴하기 위해 새로운 키워드인 yield를 도입





