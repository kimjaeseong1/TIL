## break문,continue문

### 중간에 머무는 break문, 무시하는 계속 진행하는 comtine문

### break문 사용하기

- 감싸고 있는 제어문의 블록을 빠져 나오는 기능(switch문 에서도 사용)

- 반복문에서는 주로 조건문(if)와 같이 사용하여 조건에 해당되는 경우 반복 수행을 멈추고 반복문 외부로 수행이 이동

- 여러 반복문이 중첩되어 있는 경우엔 break 문이 포함되어 있는 반복문만 빠져 나옴

### break문 예제

- 1부터 숫자를 더하여 100이 넘는 순간의 그 숫자의 합을 출력하세요

```
public class BreakTest {

	public static void main(String[] args) {

		int sum = 0;
		int num;

		for(num =1; ; num++) {

			sum += num;
			if(sum >= 100) // sum이 100을 넘어갔을 때 break문 실행
				break;

		}
		System.out.println(sum);
		System.out.println(num);

	}

}
```

![image (15)](https://user-images.githubusercontent.com/105026909/191296295-c1875dd8-b5c4-4cda-aed7-4bd22b71fce4.png)


### Continue문 사용하기
- 반복문 내부에서 조건문(if)와 같이 사용하며, 조건이 맞는 경우 (true 이면) 이후 반복문 블럭 내부의 다른 수행문들을 수행하지 않음

### Continue문 예제
- 1부터 100까지 숫자 중 3의 배수를 출력하세요

```
package ch21;

public class ContinueTest {

	public static void main(String[] args) {

		int num;
		for(num =1; num<=100; num++) {
			if(num % 3 != 0)continue; // 이 부분을 실행하지 않고 넘어감

			System.out.println(num);
		}

	}

}
```

![image (16)](https://user-images.githubusercontent.com/105026909/191296872-03c36091-ffb7-4f61-8b68-51a11d070da6.png)


