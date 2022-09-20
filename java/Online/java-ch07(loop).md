## 반복문

### while 문

#### 조건이 참(true)인 동안 반복 수행하기


- 주어진 조건에 맞는 동안(true) 지정된 수행문을 반복적으로 수행하는 제어문

- 조건이 맞지 않으면 반복하던 수행을 멈추게 됨

- 조건은 주로 반복 횟수나 값의 비교의 결과에 따라 tyre, flase 판단됨

- 예) 달리는 자동차, 일정 횟수만큼 돌아가는 나사못, 특정 온도까지 가동되는 에어컨 등


#### while 문
 - 수행문을 수행하기 전 조건을 체크하고 그 조건을 결과가 true인 동안 반복 수행
![image (5)](https://user-images.githubusercontent.com/105026909/191203800-551dc6fb-340d-4fd0-b31c-8b28c6c95069.png)

### 예제 
- 1 ~ 10 까지 모든 숫자 더하기 
```
package ch17;

public class WhileTest {

	public static void main(String[] args) {

		int num = 1;
		int sum = 0;

		while( num <= 10) {
			sum += num;
			num++;
		}
		System.out.println(sum);
		System.out.println(num);
	}

}
```

### do - while 문

#### 조건과 상관없이 한 번은 수행문을 수행

- while 문은 조건을 먼저 체크하고 반복 수행이 된다면, do-while은 조건과 상관없이 수행을 한 번 하고 나서 조건을 체크

![image (7)](https://user-images.githubusercontent.com/105026909/191204304-0c80687c-290f-4ba1-959e-029da770de55.png)

- 조건이 맞지 않으면(true 가 아니면 ) 더 이상 수행하지 않음

입력받는 모든 숫자의 합을 구하는 예제 단, 입력이 0이 되면 반복을 그만하고 합을 출력

![image (6)](https://user-images.githubusercontent.com/105026909/191203966-51c8ce32-dc92-494e-9fae-1664fc0237b4.png)


```
import java.util.Scanner;

public class DoWhiletest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int input;
		int sum = 0 ;

		do{
			input = sc.nextInt();
			sum += input;
		}while(input != 0);

		System.out.println(sum);
	}

}
```
![image (8)](https://user-images.githubusercontent.com/105026909/191204586-b864ab3a-09ae-4629-88fd-2262c2fb702f.png)

### for 문

#### for 문의 수행 순서

![image (9)](https://user-images.githubusercontent.com/105026909/191204719-314ee344-7c25-487b-9747-936052323acf.png)


#### 예제(while과 비교)

- 1부터 10까지 더한 결과를 출력하세요
```
package ch19;

public class ForTest {

	public static void main(String[] args) {

		int count = 1;
		int sum =0;

		for(int i = 0; i<10; i++,count++) {

			sum += count;

		}
		System.out.println(sum);


		int num = 1;
		int total = 0;

		while(num <= 10) {
			total += num;
			num++;
		}

		System.out.println(total);

	}
```
### 반복문은 주로 언제 사용하나요?

![화면 캡처 2022-09-20 171615](https://user-images.githubusercontent.com/105026909/191205070-76761a49-45bb-4b16-bc1b-fd20c8bfdbea.png)

### for 문의 문장들은 생략 가능

- 초기화식 생략: 이미 이전에 값이 초기화되어 for 내부에서 값을 지정할 필요가 없는 경우
![image (10)](https://user-images.githubusercontent.com/105026909/191205312-55fbc7d8-025a-4993-ae64-aed57c3728ac.png)

- 조건식 생략: 반복 수행에 대한 조건이 수행문 내부에 있는 경우
![image (11)](https://user-images.githubusercontent.com/105026909/191205517-53f6aa4f-f1d5-4e67-ab9c-d5821e91e311.png)
- 증감식 생략: 증감식에 대한 연산이 복잡하거나 다른 변수의 연산 결괏값에 결정되는 경우 
![image (12)](https://user-images.githubusercontent.com/105026909/191205685-44d678ec-be10-40df-834f-36790ae9f1ea.png)

- 무한 반복
![image (13)](https://user-images.githubusercontent.com/105026909/191205769-583bc466-6d87-4d97-896a-312ff7bee25d.png)

### 참고하세요

```
i+1 과 i++은 다릅니다.
i+1 자체는 i 값이 증가되지 않습니다. 증가하기 위해서는 대입연산자를 써야합니다.
하지만 i++은 i = i+1, i+=1 과 동일한 의미입니다.
따라서 값을 1씩 증가하려고 한다면 i++을 사용하세요
```
