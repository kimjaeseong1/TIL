## 큐(Queue)

1. 큐 구조
 - 줄은 서는 행위와 유사
 - 가장 먼저 넣은 데이터를 가장 먼저 꺼낼 수 있는 구조
   - 음식점에서 가장 먼저 줄을 선 사람이 제일 먼저 음식점에 입장하는 것과 동일 
   - FIFO(First-in, First-Out) 또는  LILO(Last-in, Last-Out)방식으로 스택과 꺼내는 순서가 반대 

![화면 캡처 2022-10-12 004908](https://user-images.githubusercontent.com/105026909/195139421-c25dbc5b-dcf4-4446-ad8b-a3e11e6fc257.png)

2. 알아둘 용어
  - Enqueue: 큐에 데이터를 넣는 기능
  - Dequeue: 큐에서 데이터를 꺼내는 기능
  
3. JAVA 에서의 큐 자료 구조 사용하기
  -  JAVA 에서는 기본적으로 java.util 패키지에 Queue 클래스를 제공하고 있음
     -  Enqueue 에 해당하는 기능으로 Queue 클래스에서는 add(value) 또는 offer(value) 메서드를 제공함
     -  Dequeue 에 해당하는 기능으로 Queue 클래스에서는 poll() 또는 remove() 메서드를 제공함
     -  아쉽게도, Queue 클래스에 데이터 생성을 위해서는 java.util 패키지에 있는 LinkedList 클래스를 사용해야 함
        - LinkedList 클래스는 자료구조의 링크드리스트 와 연관이 있으며, 관련 내용은 큐보다 복잡하므로 이후 챕터에서 상세히 익히도록 함


Queue 클래스 사용해보기

```shell
// Queue 사용을 위해, LinkedList 클래스를 사용하므로, 두 클래스 모두 import 해야 함
import java.util.LinkedList; 
import java.util.Queue; 

// 자료형 매개변수를 넣어서, 큐에 들어갈 데이터의 타입을 지정해야 함
Queue<Integer> queue_int = new LinkedList<Integer>(); // Integer 형 queue 선언
Queue<String> queue_str = new LinkedList<String>(); // String 형 queue 선언
```

```shell
// 데이터 추가는 add(value) 또는 offer(value) 를 사용함
queue_int.add(1);
queue_int.offer(2);
// 출력에 true 라고 출력되는 부분은 offer() 메서드가 리턴한 값으로, 
// 셀의 맨 마지막에 함수를 넣을 경우, 변수가 변수값이 출력되는 것처럼 함수는 함수 리턴값이 출력되는 것임
//true
```

```shell
// Queue 인스턴스를 출력하면, 해당 큐에 들어 있는 아이템 리스트가 출력됨
System.out.println(queue_int)
// [1,2]
```

```shell
// poll() 은 큐의 첫 번째 값 반환, 해당 값은 큐에서 삭제
queue_int.poll();
1
```

```shell
// 바로 현재 큐의 아이템을 확인해보면, poll() 을 통해 반환된 값은 삭제되었음을 알 수 있음
queue_int
[2]
```
```shell
// poll() 과 마찬가지로, 첫 번째 값 반환하고, 해당 값은 큐에서 삭제
queue_int.remove()
2
```
```shell
// 현재 큐의 아이템을 확인해보면, 결국 모두 삭제되었음을 확인할 수 있음
queue_int
[]
```