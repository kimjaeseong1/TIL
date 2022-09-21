## 반복문 (중첩)

### 반복문이 여러 번 포개진 중첩 반복문

#### 중첩 반복문이란?

- 반복문 내부에 또 다른 반복문이 있음

- 여러 겹으로 반복문을 겹쳐서 구현 가능 ( 단 수행시간에 문제가 발생할 수 있음)

- 외부 반복문과 내부 반복문 간의 변수 값 변화에 유의 하며 구현하여야 함

### 구구단을 for와 while로 구현해보기 
```
public class NestedLoopTest {

	public static void main(String[] args) {

		int dan =2 ;
		int count = 1;

//		for(; dan<=9; dan++) {  //for문
//
//			for(count =1; count <=9; count++) {
//
//				System.out.println(dan + "X" + count + "=" + dan * count);
//			}
//			System.out.println();
//		}

		dan =2;
		while(dan <=9) {
			count =1;    // 초기화를 진행해주지 않으면 count는 두번째 while문이 끝나면 10으로 변하기 때문에 항상 1 로 초기화를 해줘야 한다.
			while(count <= 9) {
				System.out.println(dan + "X" + count + "=" + dan * count);
				count++;
			}
			dan++;
			System.out.println();
		}


	}

}
```

![image (14)](https://user-images.githubusercontent.com/105026909/191294739-a359c96c-deb8-4334-b215-9a7786be0ea5.png)
