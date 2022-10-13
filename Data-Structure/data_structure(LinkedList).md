## 링크드 리스트(Linkde List)

### 1. 링크드 리스트(Linked List) 구조
- 연결 리스트라고도 함
-  배열은 순차적으로 연결된 공간에 데이터를 나열하는 데이터 구조
- 링크드 리스트는 떨어진 곳에 존재하는 데이터를 화살표로 연결해서 관리하는 데이터 구조


- 링크드 리스트 기본 구조와 용어
- 노드(Node) : 데이터 저장 단위(데이터값, 포인터)로 구성
- 포인터(pointer) : 각 노드 안에서 다음이나 이전의 노드와의 연결 정보를 가지고 있는 공간


- 일반적인 링크드 리스트 형태

![화면 캡처 2022-10-12 133515](https://user-images.githubusercontent.com/105026909/195250949-38c9c475-d1bb-4dd3-8dff-116d2ba3a176.png)

### 2. 간단한 링크드 리스트 예
 - 최대한 간단한 형태로 코드로 작성해보며 링크드 리스트를 이해해보기 

(1) Node 클래스 구현
```shell
public class Node<T>{
    T data;
    Node<T> next = null;
    
    public Node(T data){
      this.data = data;
    }
}
```
(2) Node와 Node 연결하기 : Node 인스턴스간 연결
```shell
Node<Integer> node1 = new Node<Integer>(1);
Node<Integer> node2 = new Node<Integer>(2);
```

```shell
node1.next = node2;
Node<Integer> head = node1;
```
(3) 링크드 리스트에 데이터 추가하기
```shell
public class SingleLinkedList<T>{
  public Node<T> head = null;
  
  public class Node<T>{
    T data;
    Node<T> next = null;
    
    public Node(T data){
      this.data = data;
    }
  }
  
  public void addNode(T data){
    if(head == null){
      head = new Node<T>(data);
  } else{
    Node<T> node = this.head;
    while(node.next != null){  // 끝 node까지 도달하게 함 
      node = node.next;

       } 
       node.next = new Node<T>(data);
     } 
  }
}
```
(4) 링크드 리스트 데이터 출력하기
```shell
public class SingleLinkedList<T> {
    public Node<T> head = null;
    
    public class Node<T> {
        T data;
        Node<T> next = null;
        
        public Node(T data) {
            this.data = data;
        }
    }
    
    public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
        }
    }
    public void printAll(){
       if(head != null){
         Node<T> node = this.head;
         System.out.println(node.data);
         while(node.next != null){
           node = node.next;
           System.out.println(node.data);

      }    
    }      
   } 
 }
```

```shell
SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<Integer>();
MyLinkedList.addNode(1);
MyLinkedList.addNode(2);
MyLinkedList.addNode(3);

MyLinkedList.printAll();
// 1
// 2
// 3
```
### 3.링크드 리스트의 장단점 (전통적인 C언어에서의 배열과 링크드 리스트)
- 장점
  - 미리 데이터 공간을 미리 할당하지 않아도 됨
    - 배열은 미리 데이터 공간을 할당 해야 함
- 단점
   - 연결을 위한 별도 데이터 공간이 필요하므로, 저장공간 효율이 높지 않음
   - 연결 정보를 찾는 시간이 필요하므로 접근 속도가 느림
   - 중간 데이터 삭제시, 앞뒤 데이터의 연결을 재구성해야 하는 부가적인 작업 필요

### 4. 링크드 리스트의 복잡한 기능1( 링크드 리스트 데이터 사이에 데이터를 추가)
- 링크드 리스트는 유지 관리에 부가적인 구현이 필요함

  
  ![화면 캡처 2022-10-12 230228](https://user-images.githubusercontent.com/105026909/195364007-a7fd2ed1-fb9f-4ab9-afc0-f5fabb5198a3.png)

```shell
public class SingleLinkedList<T> {
    public Node<T> head = null;
    
    public class Node<T> {
        T data;
        Node<T> next = null;
        
        public Node(T data) {
            this.data = data;
        }
    }
    
    public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
        }
    }
    
    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }
    
    public Node<T> search(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while(node != null) {
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }
    
    public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = this.search(isData);
        
        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            searchedNode.next.next = nextNode;
        }
    }
}
```
링크드 리스트 생성하고 1,2,3 데이터 넣기
```shell
SingleLinkedList<Integer> MyLinkedLIst = new SingleLinkedList<Integer>();

MylLinkedList.addNode(1);
MylLinkedList.addNode(2);
MylLinkedList.addNode(3);


MyLinkedList.printAll();
// 1
// 2
// 3
```
 - 1 데이터 뒤에 5 넣어보기 
```shell
MyLinkedList.addNodeInside(5, 1);
MyLinkedList.printAll();
// 1
// 5
// 2
// 3

```
- 3 데이터 뒤에 6 넣어보기 
```shell
MyLinkedList.addNodeInside(6, 3);
MyLinkedList.printAll();
// 1
// 5
// 2
// 3
```
 - 없는 데이터를 찾도록 해서 맨 마지막에 데이터 넣기
```shell
MyLinkedList.addNodeInside(7, 20);
MyLinkedList.printAll();
// 1
// 5
// 2
// 3
// 6
// 7
```
### 5. 링크드 리스트의 복잡한 기능2 (특정 노드를 삭제)
   - 다음 코드는 위의 코드에서 delete 메서드만 추가한 것이므로 해당 메서드만 확인하면 됨

```shell
public class SingleLinkedList<T> {
    public Node<T> head = null;
    
    public class Node<T> {
        T data;
        Node<T> next = null;
        
        public Node(T data) {
            this.data = data;
        }
    }
    
    public void addNode(T data) {
        if (head == null) {
            head = new Node<T>(data);
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
        }
    }
    
    public void printAll() {
        if (head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }
    
    public Node<T> search(T data) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) { 
                if (node.data == data) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }
    
    public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = this.search(isData);
        
        if (searchedNode == null) {
            this.addNode(data);
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data);
            searchedNode.next.next = nextNode;
        }
    }
    
    public boolean delNode(T isData) { // 삭제기능
        if (this.head == null) { // head가 없으면 null을 반환 
            return false;
        } else {
            Node<T> node = this.head;
            if (node.data == isData) {
                this.head = this.head.next;
                return true;
            } else {
                while (node.next != null) {
                    if (node.next.data == isData) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }
}
```
- 테스트1: 5개의 노드 생성¶
```shell
SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<Integer>();

MyLinkedList.addNode(1);
MyLinkedList.addNode(2);
MyLinkedList.addNode(3);
MyLinkedList.addNode(4);
MyLinkedList.addNode(5);

MyLinkedList.printAll();
// 1
// 2
// 3
// 4
// 5
```
- 테스트2: 중간 노드 삭제
```shell
MyLinkedList.delNode(3);
MyLinkedList.printAll();
// 1
// 2
// 4
// 5
```
- 테스트3: 맨 앞의 노드(헤드) 삭제
```shell
MyLinkedList.delNode(1);
MyLinkedList.printAll();
// 2
// 4
// 5 
```
- 테스트4: 맨 마지막 노드 삭제
```shell
MyLinkedList.delNode(5);
MyLinkedList.printAll();
// 2 
// 4
```
- 테스트5: 없는 노드 삭제 시도
```shell
MyLinkedList.delNode(20);
// false
```

### 6. 다양한 링크드 리스트 구조: 더블 링크드 리스트(Doubly linked list)
- 더블 링크드 리스트(Doubly linked list) 기본 구조
   - 이중 연결 리스트라고도 함
   - 장점: 양방향으로 연결되어 있어서 노드 탐색이 양쪽으로 모두 가능
![화면 캡처 2022-10-12 235455](https://user-images.githubusercontent.com/105026909/195376749-bc19c3bb-5f9c-4836-8605-857669abb663.png)

```shell
public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;
    
    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;
        
        public Node(T data) {
            this.data = data;
        }
    }
    
    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }
    
    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }
}
```
```shell
DoubleLinkedList<Integer> MyLinkedList = new DoubleLinkedList<Integer>();

MyLinkedList.addNode(2);
MyLinkedList.addNode(4);
MyLinkedList.addNode(5);
MyLinkedList.addNode(8);
MyLinkedList.addNode(3);

MyLinkedList.printAll()
// 2
// 4 
// 5
 // 8
 // 3
```

- head 부터 특정 노드를 찾는 메서드 추가하기
- tail 부터 특정 노드를 찾는 메서드 추가하기
```shell
public class DoubleLinkedList<T> {
    public Node<T> head = null;
    public Node<T> tail = null;
    
    public class Node<T> {
        T data;
        Node<T> prev = null;
        Node<T> next = null;
        
        public Node(T data) {
            this.data = data;
        }
    }
    
    public void addNode(T data) {
        if (this.head == null) {
            this.head = new Node<T>(data);
            this.tail = this.head;
        } else {
            Node<T> node = this.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }
    
    public void printAll() {
        if (this.head != null) {
            Node<T> node = this.head;
            System.out.println(node.data);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.data);
            }
        }
    }
    
    public T searchFromHead(T isData) { // head부터 찾는 메서드
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.head;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
        
    }
    
    public T searchFromTail(T isData) { // Tail부터 찾는 메서드
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = this.tail;
            while (node != null) {
                if (node.data == isData) {
                    return node.data;
                } else {
                    node = node.prev;
                }
            }
            return null;
        }
    }
}
```