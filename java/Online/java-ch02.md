### 컴퓨터에서 자료 표현하기

## 2진수로 표현

- 0과 1로만 데이터를 저장함
- bit(1비트) : 컴퓨터가 표현하는 데이터의 최소 단위로 2진수 하나의 값을 저장할 수 있는 메모리의 크기
- byte(바이트) : 1byte = 8bit

## 2진수와 10진수
![binary](https://user-images.githubusercontent.com/105026909/190973581-4cd5dc67-129f-4aef-a70b-cf5fdc15c3d8.png)

## 2진수와 8진수 16진수

![binary2](https://user-images.githubusercontent.com/105026909/190973679-a896b456-0aff-4275-a144-ffacaa603154.png)

## 비트로 나타낼 수 있는 수의 범위

- 개의 비트로 나타낼 수 있는 수 : 0. 1 (2개)
- 개의 비트로 나타낼 수 있는 수 : 00, 01, 10, 11 (4개)
- 개의 비트로 나타낼 수 있는 수 : 000, 001, 010, 011, 100, 101, 110, 111 (8개)

## 2진수, 8진수, 16진수를 프로그램에서 사용하는 예제

```
public class BinaryTest {

	public static void main(String[] args) {
		int num = 10;
		int bNum = 0B1010;
		int oNum = 012;
		int xNum = 0XA;


		System.out.println(num);
		System.out.println(bNum);
		System.out.println(oNum);
		System.out.println(xNum);
	}
}
```

