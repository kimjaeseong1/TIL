## 트리

### 트리(Tree)구조
- 트리: Node 와 Branch를 이용해서, 사이클을 이루지 않도록 구성한 데이터 구조
- 실제로 어디에 많이 사용되나?
  - 트리 중 이진 트리(Binary Tree) 형태의 구조로, 탐색(검색) 알고리즘 구현을 위해 많이 사용됨 

### 알아둘 용어
- Node: 트리에서 데이터를 저장하는 기본 요소 (데이터와 다른 연결된 노드에 대한 Branch 정보 포함)
- Root Node: 트리 맨 위에 있는 노드
- Level: 최상위 노드를 Level 0으로 하였을 때, 하위 Branch로 연결된 노드의 깊이를 나타냄
- Parent Node: 어떤 노드의 다음 레벨에 연결된 노드
- Child Node: 어떤 노드의 상위 레벨에 연결된 노드
- Leaf Node (Terminal Node): Child Node가 하나도 없는 노드
- Sibling (Brother Node): 동일한 Parent Node를 가진 노드
- Depth: 트리에서 Node가 가질 수 있는 최대 Level

  ![화면 캡처 2022-10-16 211322](https://user-images.githubusercontent.com/105026909/196034854-6b735588-d735-4280-886a-436c7b035b04.png)

### 이진 트리와 이진 탐색 트리(Binary Search Tree)
- 이진 트리: 노드의 최대 Branch가 2일 트리
- 이진 탐색 트리(Binary Search Tree, BST): 이진 트리에 다음과 같은 추가적인 조건이 있는 트리 
  - 왼쪽 노드는 해당 노드보다 작은 값, 오른쪽 노드는 해당 노드보다 큰 값을 가지고 있음!
    <img src="https://www.mathwarehouse.com/programming/images/binary-search-tree/binary-search-tree-insertion-animation.gif" />  

### 자료 구조 이진 탐색 트리의 장점과 주요 용도
- 주요 용도: 데이터 검색(탐색)
- 장점: 탐색 속도를 개선할 수 있음

#### 이진트리와 정렬된 배열간의 탐색 비교


  ![binary-search-tree-sorted-array-animation](https://user-images.githubusercontent.com/105026909/196034957-f5e79159-f99c-462f-abce-31c00afac059.gif)
  
### 파이썬 객체지향 프로그래밍으로 링크드 리스트 구현하기

#### 노드 클래스 만들기
```shell
public class NodeMgmt {
    public class Node {
        Node left;
        Node right;
        int value;
        public Node (int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }
}
```

#### 이진 탐색 트리에 데이터 넣기
- 이진 탐색 트리 조건에 부합하게 데이터를 넣어야 함
```shell
public class NodeMgmt {
    Node head = null;
    
    public class Node {
        Node left;
        Node right;
        int value;
        public Node (int data) {
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public boolean insertNode(int data) {
        // CASE1: Node 가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            // CASE2: Node 가 하나 이상 들어가 있을 때
            Node findNode = this.head;
            while (true) {
                // CASE2-1: 현재 Node 의 왼쪽에 Node 가 들어가야할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                // CASE2-2: 현재 Node 의 오른쪽에 Node 가 들어가야할 때                    
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;        
    }
}
```

### 이진 탐색 트리 탐색
```shell
public class Node {
    Node left;
    Node right;
    int value;
    public Node (int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}

public class NodeMgmt {
    Node head = null;
    
    public boolean insertNode(int data) {
        // CASE1: Node 가 하나도 없을 때
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            // CASE2: Node 가 하나 이상 들어가 있을 때
            Node findNode = this.head;
            while (true) {
                // CASE2-1: 현재 Node 의 왼쪽에 Node 가 들어가야할 때
                if (data < findNode.value) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(data);
                        break;
                    }
                // CASE2-2: 현재 Node 의 오른쪽에 Node 가 들어가야할 때                    
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;        
    }
    
    public Node search(int data) {
        // CASE1: Node 가 하나도 없을 때
        if (this.head == null) {
            return null;
        // CASE2: Node 가 하나 이상 있을 때            
        } else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.value == data) {
                    return findNode;
                } else if (data < findNode.value) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }
}
```

### 이진 탐색 트리 삭제

#### Leaf Node 삭제
- Leaf Node: Child Node 가 없는 Nod
- 삭제할 node의 Parent Node가 삭제할 Node를 가리키지 않도록 한다. ㄴ

![화면 캡처 2022-10-23 233330](https://user-images.githubusercontent.com/105026909/197398033-13ec90be-be5d-4961-b5a4-6c9867e29eb2.png)

Child Node가 하나인 Node 삭제
- 삭제할 Node의 Parent Node가 삭제할 Node의 Child Node를 가리키도록 한다.

![화면 캡처 2022-10-23 233535](https://user-images.githubusercontent.com/105026909/197398117-5618d4c4-14d9-47e3-87b9-6093f6e4d619.png)


Child Node가 두 개인 Node 삭제
- 삭제할 Node의 오른쪽 자식 중 가장 작은 값을 삭제할  Node의 Parent Node가 가리키도록한다.
- 삭제할 Node의 왼쪽 자식 중, 가장 큰 값을 삭제할 Node의 Parent Node가 가리키도록 한다.

![화면 캡처 2022-10-23 233944](https://user-images.githubusercontent.com/105026909/197398392-2b3958a3-d3ca-4968-8068-8ffb0d00efb6.png)

- 삭제할 Node의 오른쪽 자식 중 가장 작은 값을 삭제할 Node의 Parent Node가 가리키게 할 경우
- 삭제할 Node의 오른쪽 자식 선택
- 오른쪽 자식의 가장 왼쪽에 있는 Node를 선택
- 해당 Node를 삭제할 Node의 Parent Node의 왼쪽 Branch가 가리키게 함
- 해당 Node의 왼쪽 Branch가 삭제할 Node의 왼쪽 Child Node를 가리키게 함
- 해당 Node의 오른쪽 Branch가 삭제할 Node의 오른쪽 Child Node를 가리키게 함
- 만약 해당 Node가 오른쪽 Child Node를 가지고 있었을 경우에는, 해당 Node의 본래 Parent Node의 왼쪽 Branch가 해당 오른쪽 Child Node를 가리키게 함

### 이진 탐색 트리 삭제 코드 구현과 분석

삭제할 Node 탐색
- 삭제할 Node가 없는 경우도 처리해야 함
  - 이를 위해 삭제할 Node가 없는 경우 False를 리턴하고 함수를 종료 시킴
```shell
 public boolean delete(int value) {
        boolean searched = false;
        
        Node currParentNode = this.head;
        Node currNode = this.head;
        
        // 코너 케이스1: Node 가 하나도 없을 때
        if (this.head == null) {
            return false;
        } else {
            // 코너 케이스2: Node 가 단지 하나만 있고, 해당 Node 가 삭제할 Node 일 때
            if (this.head.value == value && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }
            
            while (currNode != null) {
                if (currNode.value == value) {
                    searched = true;
                    break;
                } else if (value < currNode.value) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;                    
                }
            }
            
            if (searched == false) {
                return false;
            }
        }

        // 여기까지 실행되면,
        // currNode 에는 해당 데이터를 가지고 있는 Node,
        // currParentNode 에는 해당 데이터를 가지고 있는 Node 의 부모 Node 
        
    }
```