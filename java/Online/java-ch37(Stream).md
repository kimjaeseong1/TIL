## 스트림(Stream)

<h3>정의</h3>

저장 원소를 하나씩 참조해서 람다식으로 처리할 수 있도록 해주는 내부 반복자

- internal iterator

- stream 사용

- 컬렉션 내부에서 요소를 반복시키고 개발자는 요소당 처리할 코드만 제공되는 코드 패턴

- 객체를 통해 무엇을 할 것인지를 중심적으로 생각

- 어떻게 요소를 반복시킬 것 인가를 컬렉션에 맡겨두고 개발자는 요소처리 코드만 집중적으로 구현 가능

- 외부 반복자보다 효율적으로 요소 반복 가능

외부 반복자

- external iterator

- for, while, Iterator 등을 통해 각 요소를 접근하고 원하는 데이터만 추출하여 출력 및 반환

- 개발자가 코드로 직접 컬렉션 요소를 반복해서 가져오는 코드 패턴

- 자칫하면 코드가 복잡해질 수 있음

- 어떻게 할 것인지를 중심적으로 생각

- 직접 함수를 구현해야하는 경우가 많음
<hr> 


#### 원소 중 짝수 출력 예제
외부 반복자 사용 예
```shell
// List<Integer>
List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4));

// 일반 반복문 (외부 반복자)를 이용해서 짝수만 출력
for (int i = 0; i < integerList.size(); i++) {
    int integer1 = integerList.get(i) ;
    if (integer1 % 2 == 0) {
        System.out.print(integer1 + ", ");
    }
}
System.out.println();

// Iterator 이용해서 짝수만 출력
Iterator<Integer> integerIterator = integerList.iterator();
while (integerIterator.hasNext()) {
    int integer2 = integerIterator.next();
    if (integer2 % 2 == 0) {
        System.out.print(integer2 + ", ");
    }
}
System.out.println();
```

내부 반복자 사용 예
```shell
// List<Integer>
List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4));

// 일반 반복문 (외부 반복자)를 이용해서 짝수만 출력
for (int i = 0; i < integerList.size(); i++) {
    int integer1 = integerList.get(i) ;
    if (integer1 % 2 == 0) {
        System.out.print(integer1 + ", ");
    }
}
System.out.println();

// Iterator 이용해서 짝수만 출력
Iterator<Integer> integerIterator = integerList.iterator();
while (integerIterator.hasNext()) {
    int integer2 = integerIterator.next();
    if (integer2 % 2 == 0) {
        System.out.print(integer2 + ", ");
    }
}
System.out.println();
```
#### 문자열 사용 예제

외부 반복자 사용 예제
```shell
//////////////////////////////////////////////////////////
// List<String>
List<String> stringList = List.of("a", "b", "c", "d", "e");

// 일반 반복문 (외부 반복자)를 이용해서 문자열 결합
StringBuilder stringBuilder1 = new StringBuilder();
for (int i = 0; i < stringList.size(); i++) {
    stringBuilder1.append(stringList.get(i));
}
String concat1 = stringBuilder1.toString();
System.out.println("concat1 = " + concat1);

// Iterator 이용해서 문자열 결합
StringBuilder stringBuilder2 = new StringBuilder();
Iterator<String> stringIterator = stringList.iterator();
while(stringIterator.hasNext()) {
    stringBuilder2.append(stringIterator.next());
}
String concat2 = stringBuilder2.toString();
System.out.println("concat2 = " + concat2);
```

내부 반복자 사용 예제
```shell
// 스트림을 이용해서 문자열 합치기
String concat3 = stringList.stream().collect(Collectors.joining());
System.out.println("concat3 = " + concat3);

```
<hr>

### 스트림 종류


##### BaseStream - 모든 스트림에서 사용 할 수 있는 공통 메소드 정의, 코드에서 직접 사용하진 않음

- Stream - 객체 요소 처리 스트림

- InStream - int 요소 처리 스트림

- LongStream - long 요소 처리 스트림

- DoubleStream - double 요소 처리 스트림

![화면 캡처 2022-10-17 164048](https://user-images.githubusercontent.com/105026909/196117718-a078b398-826f-4191-b369-731783fed3ea.png)

<hr>

### 컬렉션 스트림 얻기 예제
```shell
public static void streamFromCollection() {
    List<Student> studentList = Arrays.asList(
            new Student("kelly", 90),
            new Student("john" , 100),
            new Student("smith", 70)
    );
    studentList.stream() // 컬렉션에서 스트림 얻기
            .forEach(s -> System.out.println("s = " + s));
}
```

### 배열 스트림 얻기 예제
```shell
public static void streamFromStrArray() {
    String[] strings = { "string1", "string2", "string3" };
    List<String> stringList = Arrays.stream(strings) // 배열에서 스트림 얻기
            .map(s -> Character.toString(s.charAt(s.length() - 1)))
            .collect(Collectors.toList());
    System.out.println("stringList = " + stringList);
}
```
```shell
public static void streamFromIntArray() {
        int[] ints = {90, 97, 20, 30, 35, 80, 90, 95, 95, 97, 98};
        boolean isEven = Arrays.stream(ints) // 배열에서 스트림 얻기
                .allMatch(i -> i % 2 == 0);
        System.out.println("isEven = " + isEven);
    }
```

<hr>

### 스트림 파이프 라인
![image](https://user-images.githubusercontent.com/105026909/196118037-6307851d-bf58-45ed-b8e7-b5f699126c39.png)

- 여러 개의 스트림이 연결된 구조 컬렉션/배열.스트림얻기(). 중간 스트림().중간스트림().최종처리()

- 대량의 데이터를 가공해서 축소하는 것을 리덕션 reduction이라고 함

- 컬렉션의 요소를 리덕션의 결과물로 바로 집계 할 수 없을 경우에는 집계하기 좋도록 필터링, 매핑,정렬,그룹핑 등의 필요함

- 중간 스트림이 생성될 때 요소들이 바로 중간 처리 필터링,매핑,정렬이 되는 것이 아니라 최종 시작되기 전까지 중간 처리는 지연 lazy 되었다가 최종 처리가 시작하면 컬렉션 요소가 하나씩 중간 스트림에서 처리되고 최종 처리까지 오게 됨

### 중간 처리 스트림 
- 반환값이 스트림 형태

#### 메소드 종류
- 필터링 / 중복제거 filter, distinct

    - filter는 매개값으로 주어진 predicate가 true 이면 리턴하는 요소만 필터링

    - distinct는 Object.equals(Object)가 true이면 동일한 객체로 판단하고 중복 제거함
      ![image (1)](https://user-images.githubusercontent.com/105026909/196118417-019a3824-3d5a-491a-8417-827e6586c485.png)

예제
```shell
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamFilterExample {
    public static void main(String[] args) {
        // 1 ~ 10이 중복 저장된 컬렉션에서 중복을 제거하고 홀수만 필터링해서 컬렉션에 저장하는 예제
        System.out.print("1 ~ 10 중복 저장 => ");
        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList()); // 1 ~ 10 저장
        numbers.addAll(numbers); // 1 ~ 10 중복 저장
        System.out.println(numbers);

        System.out.print("중복 제거 => ");
        numbers.stream()
                .distinct()
                .forEach(i -> System.out.print(i + ", "));
        System.out.println();

        System.out.print("필터링 => ");
        numbers.stream()
                .filter(i -> i % 2 == 1)
                .forEach(i -> System.out.print(i + ", "));
        System.out.println();

        System.out.print("중복 제거 후 필터링해서 컬렉션 저장 => ");
        numbers = numbers.stream()
                .distinct() // 중복 제거
                .filter(i -> i % 2 == 1) // 홀수 필터링
                .collect(Collectors.toList());
        System.out.println(numbers);
    }
}
```

#### 매핑 flatMapXXX, mapXXX, asDoubleStream(), asLongStream, boxed()

- 스트림의 요소를 다른 요소로 대체하는 작업

- flatMapXXX
![image (2)](https://user-images.githubusercontent.com/105026909/196118596-6b6dc0a1-daac-41ae-8d57-d2aef5ab06ca.png)


- 요소를 대체하는 복수 개의 요소들로 구성된 새로운 스트림 리턴

- 스트림에서 A라는 요소는 A1,A2요소로 대체되고 B라는 요소는 B1,B2로 대체된다고 가정

   -> A1,A2,B1,B2요소를 가지는 새로운 스트림이 생성 


메서드
![image](https://user-images.githubusercontent.com/105026909/196118805-6d315116-5ac6-4ecf-9108-ba47c6c36cd3.png)

예제
```shell
import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        // 입력된 데이터 (요소)들이 List<String>에 저장되어 있다고 가정하고 요소별로 단어를 뽑아 단어 스트림으로 재생성
        // 입력된 데이터들이 숫자라면 숫자를 뽑아 숫자 스트림으로 재생성할 수 있음
        
				List<String> inputList1 = Arrays.asList("java8 lambda", "stream mapping");
        inputList1.stream()
                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(word -> System.out.println(word));

        System.out.println();

        List<String> inputList2 = Arrays.asList("10, 20, 30", "40, 50, 60");
        inputList2.stream()
                .flatMapToInt(data -> {
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(number -> System.out.println(number));
    }
}
```

#### mapXXXX
![image (2)](https://user-images.githubusercontent.com/105026909/196118997-1382043d-25d3-4295-93fe-84ecdfb4902e.png)

- 요소를 대체하는 요소로 구성된 새로운 스트림을 리턴

- A 요소는 C 요소로 대체되고 B 요소는 D 요소로 대체된다고 가정

   -> C,D 요소를 가지는 새로운 스트림 생성

메서드
![image (3)](https://user-images.githubusercontent.com/105026909/196119124-f718b7f0-04cb-47e8-b04f-c9f921070d30.png)

- 객체 요소일 경우에는 Comparable을 구현하지 않으면 ClassCastException 발생 가능



예제
```shell
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

class Fruit implements Comparable<Fruit> {
    private String name;
    private Integer price;

    public Fruit() {
    }

    public Fruit(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Fruit o) {
        return Integer.compare(price, o.price);
    }
}


public class SortedExample {
    public static void main(String[] args) {
        // 숫자 요소일 경우
        IntStream intStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});
        intStream
                .sorted()
                .forEach(n -> System.out.print(n + ", "));
        System.out.println();
        System.out.println();

        // 객체 요소일 경우
        List<Fruit> fruitList = Arrays.asList(
                new Fruit("b", 3000),
                new Fruit("b", 1000),
                new Fruit("a", 3000),
                new Fruit("c", 2000)
        );

        fruitList.stream()
                .sorted() // 기본 비교 방법으로 정렬
                .forEach(s -> System.out.print(s.getPrice() + ", "));
        System.out.println();

        fruitList.stream()
                .sorted(Comparator.naturalOrder()) // 기본 비교 방법으로 정렬
                .forEach(s -> System.out.print(s.getPrice() + ", "));
        System.out.println();

        fruitList.stream()
                .sorted(Comparator.reverseOrder()) // 기본 비교 방법과 정반대 방법으로 정렬
                .forEach(s -> System.out.print(s.getPrice() + ", "));
        System.out.println();


        // 새로운 비교 방법 제시
        Comparator<Fruit> fruitComparator
                = Comparator.comparing(Fruit::getName)
                .thenComparing(Fruit::getPrice);
        fruitList.stream()
                .sorted(fruitComparator) // 새로운 비교 방법 정렬
                .forEach(s -> System.out.print(s + ", "));
        System.out.println();
        System.out.println();

        // null 포함된 객체 요소일 경우
        List<Fruit> fruitListWithNull = Arrays.asList(
                new Fruit("b", 3000),
                new Fruit("b", 1000),
                new Fruit("a", 3000),
                new Fruit("c", 2000),
                null,
                null
        );
        Comparator<Fruit> fruitComparatorWithNullFirst
                = Comparator.nullsFirst(fruitComparator);
        fruitListWithNull.stream()
                .sorted(fruitComparatorWithNullFirst) // 새로운 비교 방법 정렬
                .forEach(s -> System.out.print(s + ", "));
        System.out.println();

        Comparator<Fruit> fruitComparatorWithNullLast
                = Comparator.nullsLast(fruitComparator);
        fruitListWithNull.stream()
                .sorted(fruitComparatorWithNullLast) // 새로운 비교 방법 정렬
                .forEach(s -> System.out.print(s + ", "));
    }
}
```

중간 결과물 반복 Peek
- 중간 처리 단계에서 전체 요소를 루핑하면서 추가적인 작업을 하기 위해 사용

- 최종 처리 메소드가 실행되지 않으면 지연되기 때문에 반드시 최종 처리 메서드가 호출되어야 동작 

예제
```shell
import java.util.stream.IntStream;

public class PeekExample {
    public static void main(String[] args) {
        // 필터링 후 어떤 요소만 남았는지 확인하기 위해 peek()를 마지막에서 호출할 경우 스트림은 전혀 동작하지 않음
        IntStream.rangeClosed(1, 10)
                .filter(i -> i % 2 == 0)
                .peek(i -> System.out.print(i + ", "));

        // 요소 처리의 최종 단계가 합을 구하는 것이라면 peek() 메소드 호출 후 sum()을 호출해야만 정상적으로 동작함
        int sum = IntStream.rangeClosed(1, 10)
                .filter(i -> i % 2 == 0)
                .peek(i -> System.out.print(i + ", "))
                .sum();
        System.out.println("\nsum = " + sum);

        // forEach는 최종처리 메소드이기 때문에 파이프라인 마지막에 루핑하면서 정상적으로 동작
        IntStream.rangeClosed(1, 10)
                .filter(i -> i % 2 == 0)
                .forEach(i -> System.out.print(i + ", "));
    }
}
```