## 배열
 - 데이터를 나열하고 , 각 데이터를 인덱스에 대응하도록 구성한 데이터 구조
 - 파이썬에서는 리스트 타입이 배열 기능을 제공함 

### 배열은 왜 필요할까?
- 같은 종류의 데이터를 효율적으로 관리하기 위해 사용 
- 같은 종류의 데이터를 순차적으로 저장
- 장점:
  - 빠른 접근 가능
     - 첫 데이터의 위치에서 상대적인 위치로 데이터 접근(인덱스 번호로 접근)
- 단점
  - 데이터 추가/삭제의 어려움
     - 미리 최대 길이를 지정해야 함

### JAVA와 배열

 #### JAVA 에서는 기본 문법으로 배열 지원 
  - 1차워 배열은 [] 를 통해 선언 할 수 있음
  - 각 아이템은 {} 내에 콤마로 작성
```shell
// new 키워드를 사용해서, 배열을 미리 선언하고, 데이터를 넣을 수도 있음
Integer[] data_list = new Integer[10];
data_list[0] = 1
```

```shell
// 직접 배열 데이터 선언시 넣을 수도 있음
Integer data_list1[] = {5, 4, 3, 2, 1};
Integer[] data_list2 = {1, 2, 3, 4, 5};

System.out.println(data_list2[0]);
```
### List 와 ArraysList

- List 와 ArrayList 선언의 차이점

  List<Integer> list1 = new ArrayList<Integer>();

  ArrayList<Integer> list1 = new ArrayList<Integer>();
- List 는 인터페이스이고, ArrayList 는 클래스이다

- 클래스는 크게 일반 클래스와 클래스 내에 '추상 메서드' 가 하나 이상 있거나, abstract 로 정의된 추상 클래스로 나뉨
- 인터페이스는 모든 메서드가 추상 메서드인 경우를 의미하며, 인터페이스를 상속받는 클래스는 인터페이스에서 정의된 추상 메서드를 모두 구현해야 함 (따라서 다양한 클래스를 상속받는 특정 인터페이스는 결국 동일한 메서드를 제공함)
- ArrayList 가 아니라, List 로 선언된 변수는 다음과 같이 필요에 따라 다른 리스트 클래스를 쓸 수 있는 구현상의 유연성 을 제공함
  
  List<Integer> list1 = new ArrayList<Integer>();

  list1 = new LinkedList<Integer>();

```shell
// JAVA 에서는 기본적으로 java.util 패키지에 가변 크기의 배열을 다룰 수 있는 ArrayList 클래스도 제공하고 있음
import java.util.ArrayList;

ArrayList<Integer> list1 = new ArrayList<Integer>(); // int 형 데이터를 담을 수 있는 가변 길이의 배열 선언
```
```shell
list1.add(1); // 배열에 아이템 추가 시 add(아이템) 메서드 사용
list1.add(2);
list1.get(0) // 배열에 특정 아이템을 읽을 시 get(인덱스번호) 메서드 사용 (굳이 System.out.println() 을 사용하지 않아도 됨)
```

```shell
list1.set(0, 5); // 특정 인덱스에 해당하는 아이템 변경 시, set(인덱스번호, 변경할값) 메서드 사용
list1.get(0)
```

```shell
list1.remove(0); // 특정 인덱스에 해당하는 아이템 삭제 시, remove(인덱스번호) 메서드 사용
list1.get(0)
```

```shell
// 배열 길이 확인하기
list1.size()
```

#### JAVA 에서는 기본 문법으로 다차원 배열도 작성 가능(2차원 배열)
```shell
Integer data_list[][] = { {1, 2, 3}, {4, 5, 6} };

// 데이터 2 인덱스로 지정해서 출력해보기
System.out.println( data_list[0][1] );
//2
// 데이터 5 인덱스로 지정해서 출력해보기
System.out.println( data_list[1][1] );
//5
```

#### JAVA 에서는 기본 문법으로 다차원 배열도 작성가능 (3차원 배열)
```shell
Integer[][][] data_list = { 
        {
            {1, 2, 3}, 
            {4, 5, 6} 
        },
        {
            {7, 8, 9}, 
            {10, 11, 12} 
        }
};

// 데이터 5 인덱스로 지정해서 출력해보기
System.out.println( data_list[0][1][1] );
// 5
// 데이터 12 인덱스로 지정해서 출력해보기
System.out.println( data_list[1][1][2] );
//12
```

