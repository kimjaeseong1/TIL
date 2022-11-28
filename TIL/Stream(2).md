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

Collectors.averageInt()
숫자 값(Integer value)의 평균(arithmetic mean)을 냅니다. 

```shell
Double averageAmount = 
 productList.stream()
  .collect(Collectors.averagingInt(Product::getAmount));
// 17.2
```
Collectors.summingInt()
숫가값의 합(sum)을 냅니다. 
```shell
Integer summingAmount = 
 productList.stream()
  .collect(Collectors.summingInt(Product::getAmount));
// 86
```

IntStream 으로 바꿔주는 mapToInt메소드를 사용해서 좀 더 간단하게 표현 할 수 있습니다. 
```shell
Integer summingAmount = 
  productList.stream()
  .mapToInt(Product::getAmount)
  .sum(); // 86
```

Collectors.summarizingInt()
만약 합계와 평균 모두 필요하다면 스트림을 두 번 생성해야 할까요?? 이런 정보를 한번에 얻을 수 있는 방법으로는 summarizingInt 메소드가 있습니다. 
```shell
IntSummaryStatistics statistics = 
 productList.stream()
  .collect(Collectors.summarizingInt(Product::getAmount));

```

이렇게 받아온 IntSummaryStatistics 객체에는 다음과 같은 정보가 담겨 있습니다. 
``IntSummaryStatistics {count=5, sum=86, min=13, average=17.200000, max=23}``

- 개수 getCount()
- 합계 getSum()
- 평균 getAverage()
- 최소 getMin()
- 최대 getMax()

이를 이용하면 collect 전에 이런 통계 작업을 위함 map을 호출할 필요가 없게 됩니다. 위에서 살펴본 averagin, summing, summarizing 메소드는 각 기본 타입(int,long,double)별로 제공됩니다. 

Collectors.groupingBy()
특정 조건으로 요소들을 그룹지을 수 있습니다. 수량을 기준으로 그룹핑해보겠습ㄴ디ㅏ. 여기서 받는 인자는 함수형 인터페이스 Function 입니다. 

```shell
Map<Integer, List<Product>> collectorMapOfLists =
 productList.stream()
  .collect(Collectors.groupingBy(Product::getAmount));

```

결과는 Map 타입으로 나오는데요 같은 수량이면 리스트로 묶어서 보여줍니다. 

```shell
{23=[Product{amount=23, name='potatoes'}, 
     Product{amount=23, name='bread'}], 
 13=[Product{amount=13, name='lemon'}, 
     Product{amount=13, name='sugar'}], 
 14=[Product{amount=14, name='orange'}]}

```

Collectors.partitioningBy()
위의 groupingBy 함수형 인터페이스 Function을 이용해서 특정 값을 기준으로 스트림 내 요소들을 묶었다면 , partitioningBy 은 함수형 인터페이스 Predicate를 받습니다. Predicate는 인자를 받아서 boolean 값을 리턴합니다. 
```shell
Map<Boolean, List<Product>> mapPartitioned = 
  productList.stream()
  .collect(Collectors.partitioningBy(el -> el.getAmount() > 15));

```

따라서 평가를 하는 함수를 통해서 스트림 내 요소들을 true와 false 두 가지로 나룰 수 있습니다. 
```shell
{false=[Product{amount=14, name='orange'}, 
        Product{amount=13, name='lemon'}, 
        Product{amount=13, name='sugar'}], 
 true=[Product{amount=23, name='potatoes'}, 
       Product{amount=23, name='bread'}]}
```

Collectors.collectionAndThen()
특정 타입으로 결과를 collect 한 이후에 추가 작업이 필요한 경우에 사용 할 수 있습니다. 이 메소드의 시그니쳐는 다음과 같습니다. finisher가 추가된 모양인데 이 피니셔는 collect를 한 후 에 실행할 작업을 의미합니다. 
```shell
public static<T,A,R,RR> Collector<T,A,RR> collectingAndThen(
  Collector<T,A,R> downstream,
  Function<R,RR> finisher) { ... }
```

다음 예쩨는 Collectors.toSet을 이용해서 결과를 Set 으로 collect 한 후 수정 불가한 Set으로 변환하는 작업을 추가로 실행하는 코드입니다. 

```shell
Set<Product> unmodifiableSet = 
 productList.stream()
  .collect(Collectors.collectingAndThen(Collectors.toSet(),
                                        Collections::unmodifiableSet));

```

Collector.of()
여러가지 상황에서 사용할 수 있는 메소드들을 살펴봤습니다. 이 외에 필요한 로직이 있다면 직접 collector를 만들 수 있습니다. accumulator 와 combiner는 reduce에서 살펴본 내용과 동일합니다. 
```shell
public static<T, R> Collector<T, R, R> of(
  Supplier<R> supplier, // new collector 생성
  BiConsumer<R, T> accumulator, // 두 값을 가지고 계산
  BinaryOperator<R> combiner, // 계산한 결과를 수집하는 함수.
  Characteristics... characteristics) { ... }

```

코드를 보시면 더 이해가 쉬우실 겁니다. 다음 코드에서는 collector를 하나 생성합니다. 컬렌터를 생성하는 supplier 에 LInkedList의 생성자를 넘겨줍니다. 그리고 accumulator에는 리스트에 추가하는 add 메소드를 넘겨주고 있습니다. 따라서 이 컬렛터는 스트림의  각 요소에 대해서 LinkedList를 만들고 요소를 추가하게 됩니다. 마지막으로 combiner를 ㅣ이용해 결과를 조합하는데 생성된 리스트들을 하나의 리스트로 합치고 있습니다. 

```shell
Collector<Product, ?, LinkedList<Product>> toLinkedList = 
  Collector.of(LinkedList::new, 
               LinkedList::add, 
               (first, second) -> {
                 first.addAll(second);
                 return first;
               });
```

따라서 다음과 같이 collect 메소드에 우리가 만든 커스텀 컬렉터를 넘겨줄 수 있고 결과가 담긴 Linkedlist가  반환됩니다. 

```shell
LinkedList<Product> linkedListOfPersons = 
  productList.stream()
  .collect(toLinkedList);
```

Matching
 매칭은 조건식 람다 Predicate를 받아서 해당 조건을 만족하는 요소가 있는지 체크한 결과를 리턴합니다. 
다음과 같은 세 가지 메소드가 있습니다. 

- 하나라도 조건을 만족하는 요소가 있는지(anyMatch)
- 모두 조건을 만족하는지(allMatch)
- 모두 조건을 만족하지 않느지(noneMatch)

```shell
boolean anyMatch(Predicate<? super T> predicate);
boolean allMatch(Predicate<? super T> predicate);
boolean noneMatch(Predicate<? super T> predicate);

```

간단한 예제 입니다. 다음 매칭 결과는 모두 true 입니다. 
```shell
List<String> names = Arrays.asList("Eric", "Elena", "Java");

boolean anyMatch = names.stream()
  .anyMatch(name -> name.contains("a"));
boolean allMatch = names.stream()
  .allMatch(name -> name.length() > 3);
boolean noneMatch = names.stream()
  .noneMatch(name -> name.endsWith("s"));
```

Iterating
foreach는 요소를 돌면서 실행되는 최종 작업입니다. 보통 System.out.println 메소드를 넘겨서 결과를 출력할 때 사용하곤 합니다. 앞서 살펴본 peek 과는 중간 작업과 최종 작업의 차이가 있습니다. 
``names.stream().forEach(System.out::println);
``






