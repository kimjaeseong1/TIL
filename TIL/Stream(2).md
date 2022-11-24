## java Stream 총 정리 2

### Sorting

정렬의 밥법은 다른 정렬과 마찬가지로 Comparator 를 이용합니다.

```shell
Stream<T> sorted();
Stream<T> sorted(Comparator<? super T> comparator);

```

인자 없이 그냥 호출할 경우 오름차순으로 정렬합니다. 

```shell
IntStream.of(14, 11, 20, 39, 23)
  .sorted()
  .boxed()
  .collect(Collectors.toList());
  //[11,14,20,23,39]
```

인자를 넘기는 경우와 비교해보겠습니다. 스트링 리스트에서 알파벳 순으로 정렬한 코드와 Conparator를 넙겨서 역순으로 정렬한 코드입니다. 

```shell
List<String> lang =
  Arrays.asList("Java", "Scala", "Groovy", "Python", "Go", "Swift");
  
lang.stream()
  .sorted(Comparator.reverseOrder())
  .collec(Collectors.toList());
  //[Swift, Scala, Python, Java, Groovy, Go]
```

Comparator의compare 메소드는 두 인자를 비교해서 값을 리턴합니다. 

`int compare( T o1, T o2)`

기본적으로 Comparator 사용법과 동일합니다. 이를 이용해서 문자열 길이를 기준으로 정렬해보겠습니다. 
```shell
lang.stream()
  .sorted(Conparator.conparingInt(String::length))
  .collect(Collectors.toList());
  // [Go, Java, Scala, Swift, Groovy, Python]
  
lang.stream()
  .sotred((s1,s2) -> s2.length() - s1.length())
  .collect(Collectors.tolist());
  // [Groovy, Python, Scala, Swift, Java, Go]
```

Iterating
- 스트림 내 요소들 각각을 대상으로 특정 연산을 수행하는 메소드로는 peek이 있습니다. 'peek'은 그냥 확인해본다는 단어 뜻처럼 특정 결과를 반환하지 않는 함수형 인터페이스 Consumer를 인자로 받습니다. 
``Stream<T> peek(Consumer<? super T> action);``

따라서 스트림 내 요소들 각각에 특정 작업을 수행할 뿐 결과에 영향을 미치지 않습니다. 다음처럼 작업ㅇ르 처리하는 중간에 결과를 확인해볼 때 사용할 수 있습니다. 
```shell
int sum = IntStream.of(1,3,5,7,9)
  .peek(System.out::println)
  .sum();
```

### 결과 만들기
- 가공한 스트림을 가지고 내가 사용할 결과값으로 만들어내는 단계입니다. 따라서 스트림을 끝내는 최종 작업(terminal operations)입니다. 

### Calculating
- 스트림 API는 다양한 종료 작업을 제공합니다. 최고 ,최대 , 합 , 평균 등 기본형 타입으로 결과를 만들어낼 수 있습니다. 
```shell
long count = IntStream.of(1,3,5,7,9).min();
long sum  = LongStream.of(1,3,5,7,9).max();

```
만약 스트림이 비어 있는 경우 count와 sum은 0을 출력하면 됩니다. 하지만 평균, 최소, 최대의 경우에는 표현할 수 없기 때문에 Optional 을 이용해 ㅣ턴합니다. 
```shell
OptionalInt min = IntStream.of(1,3,5,7,9).min();
OptionalInt max = IntSTream.of(1,3,5,7,9).max();
```
스트림에서 바로 ifPresent 메소드를 이용해서 Optional을 처리할 수 있습니다. 
```shell
DoubleStream.of(1.1,2.2,3.3,4.4,5.5)
  .average()
  .ifPresent(System.out::println);
```

이 외에도 사용자가 원하는 대로 결과를 만들어내기 위해 reduce와 collect메소드를 제공합니다. 이 두 가지 메소드를 좀 더 알아보겠습니다. 

### Reduction

- 스트림은 reduce라는 메소드를 이용해서 결과를 만들어냅니다. 람다 예제에서 살펴봤듯이 스트림에 있는 여러 요소의 총합을 낼 수도 있습니다. 

다음은 reduce 메소드는 총 세 가지의 파라미터를 받을 수 있습니다. 

- accumulator : 각 요소를 처리하는 계산 로직, 각 요소가 올 때마다 중간 결과를 생성하는 로직
- identity : 계산을 위한 초기값으로 스트림이 비어서 계산할 내용이 없더라도 이 값은 리턴 
- combiner: 병렬(parallel) 스트림에서 나눠 계산한 결과로 하나로 합치는 동작하는 로직 

```shell
// 1개 (accumulator)
Optional<T> reduce(BinaryOperator<T> accumulator);

//2개 (identity)
T reduce(T identity, BinartOperator<t> accumulator)'

//3개 (combiner)
<U> U reduce(U identity,
  BiFunction<U, ? super T,U> accumulator,
  BinaryOperator<U> combiner);
 
```

먼저 인자가 하나만 있는 경우입니다. 여기서 BinaryOperator<T>는 같은 타입의 인자 두 개를 받아 같은 타입의 결과를 반환하는 함수형 인터페이스 입니다. 다음 예제에서는 두 값을 더하는 람다를 넘겨주고 있습니다. 따라서 결과는 6(1+2+3)이 됩니다.

```shell
OptionalInt reduced = 
  IntStream.range(1,4) //[1,2,3]
  .reduce((a,b) -> {
    return Integer.sum(a,b);
  });
```

이번엔 두 개의 인자를 받는 경우입니다. 여기서 10은 초기값이고 스트림 내 값을 더해서 결과는 16(10 +1+2+3)이 됩니다. 여기서 람다는 메소드 참조(method reference)를 이용해서 넘길 수 있습니다. 

```shell
int reducedTwoParams = 
  IntStream.range(1,4)// [1,2,3,]
  .reduce(10,Integer::Sum);// method reference
```

마지막으로 세 개의 인자를 받는 경우입니다. Combiner가 하는 역할을 설명을 봤을 때는 잘 이해가 안갈 수 있는데 코드를 다시 한번 살펴 봅시다. 그런데 다음 코드를 실행해보면 이상하게 마지막 인자인 combiner는 실행되지 않습니다. 

```shell

Integer reducedParams = Stream.of(1, 2, 3)
  .reduce(10, // identity
          Integer::sum, // accumulator
          (a, b) -> {
            System.out.println("combiner was called");
            return a + b;
          });
```
결과는 다음과 같이 36이 나옵니다. 먼저 accumulator 는 총 세 번 동작합니다. 
초기값 10에 각 스트림 값을 더한 세 개의 값(10 + 1 = 11, 10 + 2 = 12, 10 + 3 = 13)을 계산합니다. 
Combiner 는 identity 와 accumulator 를 가지고 여러 쓰레드에서 나눠 계산한 결과를 합치는 역할입니다.
12 + 13 = 25, 25 + 11 = 36 이렇게 두 번 호출됩니다.

```shell
combiner was called
combiner was called
36
```
병렬 스트림이 무조건 시퀀셜보다 좋은 것은 아닙니다. 오히려 간단한 경우에는 이렇게 부가적인 처리가 필요하기 때문에 오히려 느릴 수도 있습니다.

### Collecting
collect 메소드는 또 다른 종료 작업입니다. Collector 타입의 인자를 받아서 처리를 하는 데요 ,자주 사용하는 작업은 Collectors 객체에서 제공하고 있습니다. 

이번 예제에서는 다음과 같은 같단한 리스트를 사용합니다. Product 객체는 수량{amout}과 이름{name}을 가지고 있습니다. 

```shell
List<Product> productList = 
  Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"),
                new Product(13, "lemon"),
                new Product(23, "bread"),
                new Product(13, "sugar"));
```

### Collectors.toList()
스트림에서 작업한 결과를 담은 리스트로 반환합니다. 다음 예제에서는 map 으로 각 요소의 이름을 가져온 후 Collectors.toList 를 이용해서 리스트로 결과를 가져옵니다.

```shell
List<String> collectorCollection =
  productList.stream()
    .map(Product::getName)
    .collect(Collectors.toList());
// [potatoes, orange, lemon, bread, sugar]

```

### Collectors.joining()

스트림에서 작업한 결과를 하나의 스트링으로 이어 붙일 수 있습니다.

```shell
String listToString = 
 productList.stream()
  .map(Product::getName)
  .collect(Collectors.joining());
// potatoesorangelemonbreadsugar
```

Collectors.joining 은 세 개의 인자를 받을 수 있습니다. 이를 이용하면 간단하게 스트링을 조합할 수 있습니다.

- delimiter : 각 요소 중간에 들어가 요소를 구분시켜주는 구분자.
- prefix : 결과 맨 앞에 붙는 문자.
- suffix : 결과 맨 뒤에 붙는 문자 

```shell
String listToString = 
 productList.stream()
  .map(Product::getName)
  .collect(Collectors.joining(", ", "<", ">"));
// <potatoes, orange, lemon, bread, sugar>
```




