## TDD(Test Drivec Development) - 테스트 주도 개발

### TDD란?

Test란  Driven Development의 약자로 '테스트 주도 개발' 이라고 한다. 반복 테스트를 이용한 소프트웨어 방법론으로 작은 단위의 테스트 케이스를 작성하고 이를 통과하는 코드를 추가하는 단계를 반복하여 구현한다.

짧은 개발 주기의 반복에 의존한 개발 프로세스이며 애자일 방법론 중 하나인 eXtream Programming(XP)의 'Test-First' 개념에 기반을 둔 단속한 설계를 중요시한다. 

쉽게 말해서

- 기능 개발 이후 이 기능이 제대로 작동하는지 확인해 보는 것을 말한다.

- 테스트를 통해 작동하지 않는 기능을 확인하고 리팩토링하여 코드를 개선할 수 있다

```shell
eXtream Programming(XP) ?  
미래에 대한 예측을 최대한 하지 않고, 
지속적으로 프로토타입을 완성하는 애자일 방법론 중 하나이다.
이 방법론은 추가 요구사항이 생기더라도, 실시간으로 반영할 수 있다. 
```

```shell
단위 테스트(Unit Test) ? 
말 그대로 한 단위(일반적으로 class)만을 테스트하는 것이다. 
```
![image](https://user-images.githubusercontent.com/105026909/206399058-203e96e3-89ef-49a2-8dbc-d3184523bbb0.png)


### TDD 개발 주기 

<Red>단계에서는 실패하는 테스트 코드를 먼저 작성한다.

<Green> 단계에서는 테스트 코드를 성공시키기 위한 실제 코드를 작성한다. 

<Yellow> 단계에서는 중복 코드 제거, 일어 반환 등의 리팩토링을 수행한다. 



중요한 건  실패하는 테스트 코드를 작성할 때까지 실제 코드를 작성하지 않는 것과 실패하는 테스트를 통과할 정도의  최소 실제 코드를 작성해야 하는 것이다. 이를 통해 실제 코드에 대해 기대되는 바를 보다 명확하게 저으니 함으로써 불필요한 설계를 피할 수 있고 정확한 요구 사항에 집중할 수 있다. 

### 일반 개발 방식과 TDD 개발 방식의 비교

![image (1)](https://user-images.githubusercontent.com/105026909/206399303-a750c1a0-e312-4926-bd83-cab4867f158f.png)

#### 일반 개발 방식

- 보통의 개발 방식은 '요구사항 분석 -> 설계-> 개발 -> 테스트 -> 배포'의 형태의 개발 주기를 갖는데 이러한 방식은 소프트웨어 개발을 느리게 하는 잠재적 위험이 존재한다. 그 그 이유는

1.소비자의 요구사항이 처음부터 명확하지 않을 수 있다.

2.따라서 처음부터 완벽한 설계는 어렵다.

3.자체 버그 검출 능력 저하 또는 소스코드의 품질이 저하될 수 있다.

4.자체 테스트 비용이 증가할 수 있다. 

이러한 문제점들이 발생되는 이유는 간단하게 말해서 어느 프로젝트든 초기 설계가 완벽하다고 말할 수 없기 때문이다. 고객의 요구사항 또는 디자인의 오류 등 많은 외부 또는 내부 조건에 의해 재설계하여 점진적으로 완벽한 설계로 나아간다. 내걸 계로 인해 개발자는 코드를 삽입, 수정, 삭제하는 과정에서 불필요한 코드가 남거나 중복 처리될 가능성이 크다. 

<h3><span style="color:red">결론적으로 이러한 코드들은 재사용이 어렵고 관리가 어려워져 유지 보수를 어렵게 만든다. </span></h3>

작은 부분의 기능 수정에도 모든 부분을 테스트해야 하므로 전체적인 버그를 검출하기 어려워진다. 따라서 자체 버그 검출 능력이 저하된다. 그 결과 어디서 버그가 발생할지 모르기 때문에 잘못된 코드도 고치지 않으려 하는 현상이 나타나고 이 현상은 소스코드의 품질 저하와  직결된다. 이렇게 작ㅇ느 수정에도 모든 기능을 다시 테스트해야 하는 문제가 발생하여 자체 테스트 비용이 증가한다. 

![image (2)](https://user-images.githubusercontent.com/105026909/206400537-7cb664c6-316b-4a89-9134-7df0e2946b87.png)

### TDD 개발 방식

- TDD와 일반적인 개발 방식의 가장 큰 차이점은 테스트 코드를 작성한 뒤에 실제 코드를 작성한다는 점이다.

- 디자인(설계) 단계에서 프로그래밍 목적을 반드시 미리 정의해야만 하고, 또 무엇을 테스트해야 할지 미리 정의(테스트 케이스 작성) 해야만 한다.

- 테스트 코드를 작성하는 도중에 발생하는 예외 사항(버그, 수정사항)들은 테스트 케이스에 추가하고 설계를 개선한다. 이후 테스트가 통과된 코드만을 코드 개발 단계에서 실제 코드로 작성한다. 

<h3><span style="color:red">이러한 반복적인 단계가 진행되면서 자연스럽게 코드의 버그가 줄어들고 소스코드는 간결해진다. </span></h3>

또한 테스트 케이스 작성으로 인해 자연스럽게 설계가 개선됨으로 재설계 시간이 절감된다. 

### 테스트 기법의 종류

#### 1.테스트

- 시스템의 일부(하위 시스템)를 대산으로 기능을 검증하는 테스트

- 비용이 상대적으로 낮은 편이다.

- 단위 안에서 버그가 있음을 상대적으로 자세히 알 수 있다.

- 단위 테스트에서는 문제가 없더라도 전체 시스템이 유기적으로 연결되었을 때 오류가 날 수도 있다. 


#### 2. 수동 테스트

인수 테스트

- 회사에서는 보통 QA라고 부르는 테스트 전문 담당자들이 UI를 활용해 기능을 검증한다.

- 사람이 검증하기 때문에 사용자와 가까운 관점에서 테스트를 한다.

- 기능이 동작하기 위한 전체 코드가 준비되어야 한다

- 실행 비용이 높고 결과의 변동이 크다 

#### 3. 테스트 자동화

- 사람이 직접 테스트하지 않고 어떤 기능을 검증하는 코드를 작성하는 방식

- 실행 비용이 낮고 결과의 신뢰도가 높다

- 테스트 코드의 작성 및 관리가 프로그래머의 역량에 달려있다. 

#### 4. 인수 테스트

- 주로 클라이언트가 의뢰한 소프트웨어를 최종적으로 사용할 수 있는 수준인지 점검하는 테스트

- 배치된 시스템을 대상으로 검증

- 전체 시스템 이상 여부 신뢰도가 높다

- 높은 비용 (작성 비용 / 관리 비용 /실행 비용)

### TDD의 대표적인 Tool 'JUnit'

#### JUnit?

- JUnit은 현재 전 세계적으로 가장 널리 사용되는 'Java 단위 테스트 프레임 워크'이다. 에릭 감마와 켄트 벡이 탄생시켰다. JUnit을 시작으로 CUnit(C언어), CppUnit(C++), PyUnit(Python) 등 xUnit 프레임워크가 탄생하게 되었다. 

```shell
xUnit이 무엇입니까?
자바의 단위 테스팅 프레임 워크인 JUnit만 있는 것이 아니다. 
다른 언어도 단위 테스트를 위한 프레임워크가 존재하며보통 이름을 xUnit이라 지칭한다. 
xUnit의 종류는 아래 표와 같다
```
| xUnit 이름  | 해당 언어  | 관련 사이트|
|:---------:|:------:|:---:|
|   CUnit  | C  |http://cunit.sourceforge.net/|
|   CppUnit  | C++  |https://sourceforge.net/projects/cppunit/|
|  PHPUnit    | PHP |https://phpunit.de/|
|   PyUnit    |Python  |http://pyunit.sourceforge.net/|
|   JUnit | Java  |http://junit.org/|


### TDD 개발 방식의 장점

#### 보다 튼튼한 객체 지향적인 코드 생산

TDD는 코드의 재사용 보장은 명시하므로 TDD를 통한 소프트웨어 개발 시 기능 별 철저한 모듈화가 이뤄진다. 이는 종속성과 의존성이 낮은 모듈로 조합된 소프트웨어 개발을 가능하게 하며 필요에 따라 모듈을 추가하거나 제거해도 소프트웨어 전체 구조에 영향을 미치지 않게 된다. 

#### 재설계 시간의 단축

테스트 코드를 먼저 작성하기 때문에 개발자가 지금 무역을 해야 하는지 분명히 정의하고 개발을 시작하게 된다. 또한 테스트 시나리오를 작성하면서 다양한 예외사항에 대해 생각해 볼 수 있다. 이는 개발 진행 중 소프트웨어의 전반적인 설계가 변경되는 일을 방지할 수 있다. 

#### 디버깅 시간의 단축

이는 유닛 테스팅을 하는 이점이기도 하다. 예를 들면 사용자의 데이터가 잘 못 나온다면 DB의 문제인지, 비즈니스 레이어의 문제인지 UI의 문제인지 실제 모든 레이어들을 전부 디버깅해야 하지만 TDD의 경우 자동화된 유닛 테스팅을 전재하므로 특정 버그를 손쉽게  찾아낼 수 있다. 

####  테스트 문서의 대체 가능

주로 SI 프로젝트 진행 과정에서 어떤 요소들이 테스트 되었는지 테스트 정의 서릉 만든다. 이것은 단순 통합 테스트 문서에 지나지 않는다. 하지만 TDD를 하게 될 경우 테스팅을 자동화 시킴과 동시에 보다 정확한 테스트 근거를 산출할 수 있다. 

####  추가 구현의 용이함

개발이 완료된 소프트웨어에 어떤 기능을 추가할 때 가장 우려되는 점은 해당 기능이 기존 코드에 어떤 영향을 미칠지 안지 못한다는 것이다. 하지만 TDD의 경우 자동화 도니 유닛 테스팅을 전제하므로 테스트 기간을 획기적으로 단축시킬 수 있다. 


### TDD 개발 방식의 단점

#### 가장 큰 단점은 바로 생산성의 저하이다. 

- 개발 속도가 느려진다고 생각하는 사람이 많기 때문에 TDD에 대해 반신반의한다.

왜냐하면 처음부터 2개의 코드를 짜야 하고, 중간중간 테스트를 하면서 고쳐나가야 하기 때문이다.  TDD 방식의 개발 시간은 일반적인 개발 방식에 비해 대략 10 ~ 30% 정도로 늘어난다. 

- SI 프로젝트에서는 소프트웨어의 품질보다 납기일 준수가 훨씬 중요하기 때문에 TDD 방식을 잘 사용하지 않는다. 

### TDD를 하기 어려운 이유?

####  이제까지 자신이 개발하던 방식을 많이 바꿔야 한다. 

- 몸에 체득한 것이 많을수록 바꾸기가 어렵다.
 
- 오히려 개발을 별로 해보지 않은 사람들에겐 적용하기가 쉽다 

####  TDD는 이렇게 해아 된다는 이미지/틀이 있다. 

- 반드시 툴 테스트 프레임워크)을 써서 개발해야 된다고 생각한다.

- 이러한 규칙에 얽매이는 것은 애자일 방식이 아니다.

- 결국엔 규칙에 얽매여 똑같은 테스트를 copy&paste 한다.

- 도구/ 규칙에 집착하다 보니 TDD가 어려워지는 것이다. 