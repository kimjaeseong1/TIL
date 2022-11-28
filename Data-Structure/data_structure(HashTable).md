## 해쉬 테이블 (Hash Table)

### 1. 해쉬 테이블 
- 키(Key)에 데이터(Value)를 매핑 할 수 있는 데이터 구조
-  해쉬 함수를 통해 배열에 키에 대한 데이터를 저장 할 수 있는 주소(인덱스 번호)를 계산
- Key를 통해 바로 데이터가 저장되어 있는 주소를 알 수 있으므로 저장 및 탐색 속도가 획기적으로 빨라짐
- 미리 해쉬 함수가 생성 할 수 있는 주소(인덱스 번호)에 대한 공간을 배열로 할당한 후 , 키에 따른 데이터 저장 및 탐색 지원 

### 2. 알아둘 용어
- 해쉬 함수(Hash FUnction): 임의의 데이터를 고정된 길이의 값으로 리턴해주는 함수 
  - 해쉬(Hash), 해쉬 값(Hash Value) 또는 해쉬 주소(Hash Address): 해싱 함수를 통해 리턴된 고정된 길이의 값 
- 해쉬 테이블(Hash Table): 키 값의 연산에 의해 직접 접근이 가능한 데이터 구조
  - 슬롯(slot): 해쉬 테이블에서 한 개의 데이터를 저장 할 수 있는 공간 
  ![화면 캡처 2022-10-13 192924](https://user-images.githubusercontent.com/105026909/195573629-e7837485-cefb-4153-9aa8-76aa8952094c.png)

### 3. 간단한 해쉬 예

#### 3.1 hash table 클래스 만들기 
```shell
public class MyHash {
    public Slot[] hashTable;
    
    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    public class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }
}
```
#### 3.2 초간단 해쉬 함수를 만들어보기 
- key 가 문자열일 때, 문자열의 앞 글자를 숫자로 변환해서 ,Division 기법을 사용하여 Key에 대한 주소(인덱스 번호) 계산
  - Division 기법 : 가장 간단한 해쉬 함수 중 하나로 , 나루기를 통해 나머지 값을 사용하는 기법 

```shell
String name = "DaveLee";
name.charAt(0);
// D
```

```shell
    (int)(name.charAt(0));
    // 68
```

```shell
String name  = "DaveLee"
(int)(name.charAt(0)) % 20
// 8
```

#### 3.3 해쉬 테이블 클래스에 해쉬 함수 추가
```shell
public class MyHash {
    public Slot[] hashTable;
    
    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    public class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }
    
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
}
```

#### 3.4 해쉬 테이블 클래스에 데이터 저장 메서드 추가 

참고 : 객체 배열
- 객체 배열 선언시 ,각 배열의 아이템은 각 객체를 참조할 수 있는 주소를 담을 수 있는 공간만 할당 
  - 각 아이템 생성시 별도로 각 객체를 생성해줘야 함 
  - 즉 객체 배열 선언시 각 생성할 객체를 가리킬 주소만 저장 할 공간을 배열로 만드는 것임 
```shell
public class Slot {
    String value;
    Slot(String value) {
        this.value = value;
    }
}

Slot[] hashTable = new Slot[20];
System.out.println(hashTable[0]);
// null 별도로 각 객체를 생성하지 않았기 때문에 null
```

```shell
public class Slot {
    String value;
    Slot(String value) {
        this.value = value;
    }
}

Slot[] hashTable = new Slot[20];
hashTable[0] = new Slot("test");
System.out.println(hashTable[0]);
System.out.println(hashTable[0].value);

// REPL.$JShell$40$Slot@5a20858a
// test
```


해쉬 테이블 클래스에 saveData() 메서드 추가 
```shell
public class MyHash {
    public Slot[] hashTable;
    
    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    public class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }
    
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
    
    publci boolean saveData(String key, String value){
      Integer address = this.hashFunc(key);
      if(this.hashTable[address] != null){
        this.hashTable[address].value = value;
        }else{
          this.hashTable[address]= new Slot(value);
        }  
        return true;
  }
}
```

#### 3.4 해쉬 테이블 클래스에 Key 에 대한 데이터를 가져오는 메서드 추가 
```shell
public class MyHash {
    public Slot[] hashTable;
    
    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    public class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }
    
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
    
    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }
    
    public String getData(String key){
      Integer address = this.hashFunc(key);
      if(this.hashTable[address] != null){
        return this.hashTable[address].value;
      
      }else{
        return null;
      }  
    }
}
```

```shell
MyHash mainObject = new Myhash(20);
mainObject.save.Data("DaveLee","01022223333");
mainObject.save.Data("fun-coding", "01033334444");
mainObject.getData("fun-coding");
// 01033334444
```

### 4. 자료구조 해쉬 테이브의 장단점과 주요 용도
- 장점
  - 데이터 저장/읽기 속도가 빠르다.(검색 속도가 빠르다.)
  - 해쉬는 키에 대한 데이터가 있는지(중복)확인이 쉬움
- 단점
  - 일반적으로 저장공간이 좀 더 많이 필요하다.
  - 여러 키에 해당하는 주소가 동일한 경우 충돌을 해결하기 위한 별도 자료구조가 필요함
- 주요 용도
  - 검색이 많이 필요한 경우
  - 저장, 삭제 , 읽기가 빈번한 경우
  - 캐쉬 구현시 (중복 확인이 쉽기 때문 )
### 5. 충동(Collsion)해결 알고리즘 (좋은 해쉬 함수 사용하기)
  > 해쉬 테이블의 가장 큰 문제는 충동(Collision)의 경우입니다. 이 문제를 충돌 또는 해쉬 충돌(Hash Collision)이라고 부릅니다.

#### 5.1 Chaining 기법
 - 개방 해슁 또는 Open Hashing 기법 중 하나: 해쉬 테이블 저장곤간 외의 공간을 활용하는 기법
 - 충돌이 일어나면, 링크드 리스트라는 자료 구조를 ㅏ용해서 링크드 리스트로 데이터를 추가로 뒤에 연결시켜서 저장하는 기법

```shell
public class MyHash {
    public Slot[] hashTable;
    
    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    public class Slot {
        String value;
        String key;
        Slot next;
        Slot(String value) {
            this.value = value;
            this.key = key;
            this.next = next;
        }
    }
    
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
    
    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            Sloe prevSlot = this.hashTable[address];
            while(findSlot != null){
              if(findSlot.key == key){
                  findSlot.value = value;
                  return true;  
              }else {
                  prevSlot = findSlot;
                  findSlot = findSlot.next;
                }
              }
              prevSlot.next = new Slot(key, value);
                 
        } else {
            this.hashTable[address] = new Slot(key,value);
        }
        return true;
    }
    
    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while(findSlot != null){
                if(findSlot.key == key){
                    return findSlot.value;
                  }else{
                      findSlot = findSlot.next;
                    }
                  }
                  return null;
        } else {
            return null;
        }
    }

```
### Linear Probing 기법
- 폐쇄 해슁 또는 Close Hashing 기법 중 하나: 해쉬 테이블 저장공간 안에서 충돌 문제를 해결하는 기법
- 충돌이 일어나면, 해당 hash address의 다음 address부터 맨 처음 나오는 빈공간에 저장하는 기법
   - 저장공간 활용도를 높이기 위한 기법

```shell
public class MyHash {
    public Slot[] hashTable;
    
    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }
    
    public class Slot {
        String key;
        String value;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }
    
    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address + 1;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }                        
                    }
                }
                this.hashTable[currAddress] = new Slot(key, value);
                return true;
            }
        } else {
            this.hashTable[address] = new Slot(key, value);
        }
        return true;
    }
    
    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                // 참고: 다음 코드를 수정합니다.
                // Integer currAddress = address + 1;                 
                // 예외 케이스로, 키에 해당하는 주소가 가장 마지막 슬롯일 경우, 
                // this.hashTable[address + 1] 에 해당하는 배열은 없기 때문에, 
                // 예외 케이스에서도 동작하도록 currAddress 는 address 만 대입하고 진행합니다
                Integer currAddress = address; // 수정 
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        return this.hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    }
}
```

### 빈번한 충돌을 개선하는 기법
- 해쉬 테이블 저장곤간을 확대 및 해쉬 함수 재정의
```shell
String name = "Dave";
int key = 0;
for (int i = 0; i < name.length(); i++) {
    key += name.charAt(i);
}

(int)(key) % 200
```

