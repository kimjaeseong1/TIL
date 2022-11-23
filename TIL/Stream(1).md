## java Stream 총 정리

#### 살펴볼 내용

 - 생성하기
   - 배열 / 컬렉션 / 빈스트림
   - Stream.builder() / Stream.generate() / Stream.iterate()
   - 기본 타입형 / String/ 파일 스트림
   - 병령 스트림 / 스트림 연결하기

   
 - 가공
    - Filtering
    - Mapping
    - Sorting
    - Iterating

 - 결과 만들기
   - Calculating
   - Reduction
   - Collection
   - Matching
   - Iterating

#### 스트림 Streams

자바 8에서 추가한 스트림(Streams)은 람다를 활용할 수 있는 기술 중 하나입니다. 자바 8 이전에는 배열 또는 컬렉션 인슽너스를 다루는 방법은 for 또는 foreach 문을 돌면서 요소 하나씩을 꺼내서 다루는 방법이었습니다. 간단한 경우람녀 상관없지만 로직이 복잡해질 수록 코드의 양이 만아져 여러 로직이 섞이게 되고 ,메소드를 나눌 경우 루프를 여러 번 도는 경우가 발생.

스트림은 ' 데이터의 흐름'이다 배열 또틑 컬렉션 인스턴스에 함수 여러 개를 조합해서 원하는 결과는 필터링하고 가동된 경과를 얻을 수 있습니다. 또한 람다를 이용해서 코드의 양을 줄이고 간결하게 표현 할 수 있다
즉 배열과 컬렉션을 함수형으로 처리 가능함

스트림에 대한 내용은 크게 세 가지로 나눌 수 있다. 

1. 생성하기 : 스트림 인스턴스 생성
2. 가공하기 : 필터링(filtering) 및 맵핑(mapping) 등 원하는 결과를 만들어가는 중간 작업(intermdiate operations).
3. 결과 만들기 : 최종적으로 결과를 만들어내는 작업(terminal operations)

> 전체 -> 맵핑 -> 필터링1 -> 필터링2 -> 결과 만들기 -> 결과물 

### 생성하기
- 보통 배열과 컬렉션을 이용해서 스트림을 만들지만 이외애도 다양한 방법으로 스트림을 만들 수 있음! 

### 배열 스트림
- 스트림을 용하기 위해서는 먼저 생성을 해야 한다. 스트림은 배열 또는 컬렉션 인스턴스를 이용해서 생성할 수 있음 배열은 다음과 같이 Arrays.stream 메소드를 사용함! 
>1. String[] arr = new String[] {"a", "b", "c"};
>2. Stream<String> stream = Arrays.stream(arr);
>3. Stream<String> StreamOgArrayPart = Arrays.stream(arr, 1, 3);

### 컬렉션 스트림
- 컬렉션 타입(Collection , list, Set)의 경우 인터페이스에 추가된 디폴트 메소드 stream을 이용해서 스트림을 만들 수 있습니다. 

> 1. public interface Collection<E> extends Iterable<E>{
> 2.  default Stream<e> stream() {
> 3.    return StreamSupport.stream(spliterator(), false);
>4.    }
> 5.   //..
> 6. }

그러면 다음과 같이 생성할 수 있다. 

> 1. List<String> list = Arrays.asList("a","b","c");
> 2. String<String> Stream = list.stream();
> 3. Stream<String> parallelStream = list.parallelStream(); // 병렬 처리

### 비어 있는 스트림
 - 비어 있는 스트림(empty streams) 도 생성할 수 있습니다. 언제 빈 스트림이 필요하냐면 요소가 없을 때 null 대신 사용 가능
```shell
public Stream<String> streamOf(List<String> list){
   return list == null "" list.isEmpty()
      ? Stream.empty()
      : list.stream();
}
```

### Stream.generate()
generate 메소드를 이용하면 Supplier<T>에 해당하는 람다로 값을 넣을 수 있다. SUpplier<T> 는 인자는 없고 리턴값만 있는 함수형 인터페이스!  
람다에서 리턴하는 값이 들어간다. 
>  public status<T> Stream<T> generate(Supplier<T> s) {...}

이 때 생성되는 스트림은 크기가 정해져 있지 않고 무한(infinite)하기 때문에 특정 사이즈로 최대 크기를 재한해야 한다.

```shell
Steram<String> generatedStream = 
  Stream.generate(() -> "gen").limit(5);
```

5개의 "gen"이 들어간 스트림이 생성된다. 

### Stream.iterate()

iterate 메소드를 이용하면 초기값과 해당 값을 다루는 람다를 이용해서 스트림에 들어갈 요소를 만든다. 
다음 예제는 30이 초기값이고 값이 2씩 증가하는 값들이 들어가기 된다. 즉 요소가 다음 요소의 인풋으로 들어간다. 이 방법도 스트림의 사이즈가 무한하기 때문에 특정 사이즈로 제한해야 한다. 
```shell
Stream<Integer> iteratedStream = 
    Stream.iterate(30, n -> n + 2).limit(5); // [30,32,34,36,38]
```

### 기본 타입형 스트림
물론 제네릭을 사용하면 리스트나 배열을 이용해서 기본 타입(int, long, double) 스트림을 생성할 수 있습니다. 하지만 제네릭을 사용하지 않고 직접적으로 해당 타입의 스트림을 다룰 수 도 있습니다. range와 rangeClosed는 법위의 차이입니다. 
두번째 인자인 종료지접이 포함되느냐 안되느냐의 차이입니다. 

```shell
IntStream intStream = IntStream.range(1, 5); // [1,2,3,4]
LongStream longStream = LongStream.range.Closed(1,5); //[1,2,3,4,5]


```

제네릭을 사용하지 않기 때문에 불 필요한 오토박싱(auto-boxing) 이 일어나지 않습니다. 필요한 경우 boxed 메소드를 이용해서 박생(boxing) 할 수 있습니다. 
> Stream <Integer) boxedIntStream = IntStream.range(1,5).boxed();


Java 8 의 Random 클래스는 난수를 가지고 세 가지 타입의 스트림(IntStream, LongStream, DoubleStream)을 만들어 낼 수 있습니다. 쉽게 난수 스트림을 생성해서 여러가지 후속 작업ㅇ르 취할 수 있어 유용 합니다. 

` DoubleStream doubles - new  Random().doubles(3); // 난수 3개 생성`



### 문자열 스트링
스트링을 이용해서 스트림을 생성 할 수 도 있습니다. 다음은 스트링의 각 문자(char)를 IntStream 으로 변환한 예제 입니다. char는 문자이지만 본질적으로 숫자이기 때문에 가능합니다. 
```shell
IntStream charsStream = 
 " Stream".chars(); // [83 ,116 ,114 ,104 ,97 , 109]
```

다음은 정규 표현식 (RegEx)을 이용해서 문자열을 자르고 각 요소들로 스트림을 만든 예제입니다. 
```shell
Stream<string> StringStream = 
  Pattern.compile(",").splitAsStream("Eric, Elena, java");
   // [Eric, Elena, java]
```

### 파일 스트림

자바 NIO의 Files 클래스의 lines 메소드는 해당 파일의 각 라인을 스트링 타입의 스트림으로 만들어 줍니다. 
```shell
Stream<String> lineStream = 
  Files.lines(Path.get("file.txt"),
              Charset.forName("UTF-8"));     
```
