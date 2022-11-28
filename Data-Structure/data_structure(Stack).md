## 스택(Stack)
 - 데이터를 제한적으로 접근 할 수 있는 구조
   - 한쪽 끝에서만 자료를 넣거나 뺄 수 있는 구조 
 - 가장 나중에 쌓은 데이터를 가장 먼저 빼낼 수 있는 데이터 구조 
   - 큐 : FIFO 정책
   - 스택 : LIFO 정책

#### 1. 스택 구조
- 스택은 LIFO(Last In, Fisrt Out) 또는 FILO(First In, Last Out) 데이터 관리 방식을 따름

    - LIFO: 마지막에 넣은 데이터를 가장 먼저 추출하는 데이터 관리 정책
    - FILO: 처음에 넣은 데이터를 가장 마지막에 추출하는 데이터 관리 정책
- 대표적인 스택의 활용
    - 컴퓨터 내부의 프로세스 구조의 함수 동작 방식
- 주요 기능
   - push(): 데이터를 스택에 넣기
   - pop(): 데이터를 스택에서 꺼내기

![화면 캡처 2022-10-12 130839](https://user-images.githubusercontent.com/105026909/195247817-55d0e3c4-3c27-4eab-9b92-507a328c9ebf.png)

#### 2. 자료 구조 스택의 장단점
- 장점 
   - 구조가 단순해서, 구현이 쉽다.
   - 데이터 저장/읽기 속도가 빠르다.
- 단점 (일반적인 스택 구현시)
   - 데이터 최대 갯수를 미리 정해야 한다.
   - 저장 공간의 낭비가 발생할 수 있음
   - 미리 최대 갯수만큼 저장 공간을 확보해야 함

#### 3. JAVA 에서의 스택 자료 구조 사용하기
- 자료구조와 알고리즘은 주요 개념을 이해하고, 알고리즘은 변수,조건,반복문으로 직접 구현할 수 있어야 합니다.
- 각 언어별로 이미 작성된 자료구조/알고리즘 함수/클래스를 익히는 것은 본 강의의 목적과는 다르지만, 참고로 설명드리는 것입니다.
##### JAVA Stack 클래스
- java.util 패키지에서 Stack 클래스 제공
- push(아이템) 메서드 : 아이템을 Stack 에 추가
- pop() 메서드 : Stack 에서 마지막에 넣은 아이템을 리턴하고, 해당 아이템은 Stack 에서 삭제

### 연습
- JAVA ArrayList 클래스를 활용해서 스택을 다루는 push, pop 기능 구현해보기
- pop 기능 호출 시, 스택에 데이터가 없을 경우, null 을 리턴하도록 함
- 다양한 데이터 타입을 다룰 수 있도록, Java Genric 타입 문법을 활용해보기
```shell
import java.util.ArrayList;

public class MyStack<T> {
    private ArrayList<T> stack = new ArrayList<T>();
    
    public void push(T item) {
        stack.add(item);
    }
    
    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }
    
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<Integer>();
        ms.push(1);
        ms.push(2);
        System.out.println(ms.pop());//2
        ms.push(3);
        System.out.println(ms.pop()); //3
        System.out.println(ms.pop());  //1      
    }
}


```