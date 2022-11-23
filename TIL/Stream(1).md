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

### 병렬 스트림 Parallel Stream
- 스트림 생성 시 사용하는 Steam 대신 parallelStream 메소드를 사용해서 병렬 스트림을 쉽게 생성할 수 있습니다. 내부적으로 는 쓰레드를 처리하기 위해 자바 7부터 도입된 Fork/Join framework를 사용합니다 
```shell
// 병렬 스트림 생성
Steam<Product> parallelStream = productList.parallelStream();

// 병렬 여부 확인
boolean isParallel = ParallelStream.isParallel();
```
따라서 다음 코드는 각 작업을 쓰레드를 이용해 병렬 처리됩니다. 

```shell
boolean isMany = parallelStream
  .map(product - product.getAmount() * 10)
  .anyMatch(amount -> amount > 200);
```

다음은 배열을 이용해서 병렬 스트림을 생성하는 경우

``Arrays.stream(arr).parallel();
``

컬렉션과 배열이 아닌 경우는 다음과 같이 parallel 메소드를 이용해서 처리합니다. 

```shell
IntStream intStream = IntStream.range(1,150).parallel();
boolean isParallel = intStream.isParallel();
```

다시 시퀀셜(sequential) 모드로 돌리고 싶다면 다음처럼  sequential 메소드를 사용합니다. 뒤에서 한번 더 다루겠지만 반드시 병렬 스트림이 좋은 것은 아니다
```shell
IntStream intStream = intStream.sequential();
boolean isParallel = intStream.isParallel();
```

### 스트림 연결하기
Stream.concat 메소드를 이용해 두 개의 스트림을 연결해서 새로운 스트림을 만들어낼 수 있습니다. 
```shell
Stream<String> stream1 = Stream.of("java","Scala","Groovy");
Stream<String> stream2 = Stream.of("Python","Go","Swift");
Stream <Strin> concat = Stream.concat(stream1, stream2);
//[java,Scala,Groovy,Python,Go,Swift]
```

### 가공하기
- 전체 요소 중에서 다음과 같은 API를 이용해서 내가 원하는 것만 뽑아낼 수 있습니다.
   이러한 가공 단계를 중간 작업(intermediate operations)이라고 하는데 ,이러한 작업은 스트림을 리턴하기 때문에 여러 작업을 이어 붙여서(chaining) 작성할 수 있습니다. 
``List<String> names = Arrays.asList("Eric","Elena","Java")``
아래 나오는 예제 코드는 위와 같은 리스트를 대상으로 합니다. 

### Filtering
- 필터(filter)는 스트림 내 요소들을 하나씩 평가해서 걸려내는 작업입니다. 인자로 받는 Predicate는 boolean을 리턴하는 함수형 인터페이스로 평가식이 들어가게 됩니다. 
``Stream<T> filter(Predicate<? super T> prediecate);``

간단한 예제 입니다. 
```shell
Stream<String> stream = 
  names.stream()
  .filter(name -> name.contains("a"));
  //[Elena, Java]
```
스트림의 각 요소에 대해서 평가식을 실행하게 되고 'a'가 들어간 이름만 들어간 스트림이 리텁됩니다. 

### Mapping
맴(map)은 스트림 내 요소들을 하나씩 특정 값으로 변환해줍니다. 이 때 값을 변환하기 위한 람다를 인자로 받습니다.
``<R> Stream<R> map(Function<? super T, ? extends R> mapper);``

스트림에 들어가 있는 값이 input이 되어서 특정 로직을 거친 후 output 이 되어 (리턴도는) 개로운 스트림에 담기게 됩니다. 이러한 작업을 맴핑(mapping)이라고 합니다. 

간단한 예제 입니다. 스트림 내 String의 toUpperCase 메소드를 실행해서 대문자로 변환한 값들이 담긴 스트림을 리턴합니다. 

```shell
Stream<String> stream = 
  names.stream()
  .map(String::toUpperCase);
  //[ERIC, ELENA,JAVA]
```
다음처럼 요소 내 들어잇는 Product 개체의 수량을 꺼내올 수도 있습니다. 각 '상품'을 '상품의 수량'으로 맴핑하는 거죠
```shell
Stream<Intrger> stream = 
  productList.stream()
  .map(Product::getAmount);
  //[23,14,13,23,13]
```

map 이외에도 조금 더 복작한 flatMap 메소드도 있습니다. 

``<R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper);``

인자로 mapper를 받고 있는데 리턴 타입이 Stream 입니다. 즉 새로운 스트림을 생성해서 리텅하는 람다를 넘겨야 합니다. flatMap은 중첩 구조를 한 단계 제거하고
단일 컬렉션으로 만들어주는 역할을 합니다. 이러한 작업을 플래트닝(flattening)이라고 합니다. 

다음과 같은 중첩된 리스트가 있씁니다. 

```shell
List<List<String>> list = 
  Arrays.asList(Arrays.aslist("a"),
                Arrays.asList("b"));
                // [[a],[b]
```
이를 flatMap을 사용해서 중첩 구조를 제거한 후 작업을 할 수 있습니다.

```shell
List<String> flatList=
  list.stream()
  .flatMap(Collection::stream)
  .collect(Collectors.toList());
  //[a,b]
```

이번엔 객체에 적용해보겠습니다.
```shell
students.stream()
  .flatMapToInt(student ->
                IntStream.of(student.getKor(),
                             student.getEng(),
                             student.getMath()) )
  .average().ifPresent(avg ->
                      System.out.println(Math.round(avg * 10)/ 10.0)) ;  
```
위 예쩨에서는 학생 객체를 가진 스트림에서 학생의 국영수 점수를 뽑아 새로운 스트림을 만들어
평균을 구하는 코드입니다. 이는 map 메소드 자체만으로는 한번에 할 수 없는 기능입니다.