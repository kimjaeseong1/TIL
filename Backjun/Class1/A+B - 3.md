## A+B - 3

### 문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.


### 입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.

각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

### 출력

각 테스트 케이스마다 A+B를 출력한다.

### 예제 입력 1
>5 1 1 2 3 3 4 9 8 5 2



### 예제 출력 1

>2 5 7 17 7




```shell
a= int(input())


for i in range(a) :
    a,b= map(int,input().split())
    print(a+b)

```

#### 처음에 풀었던 코드

``` shell
a= int(input())
sum =0
li=[]

for i in range(5) :
   
    d,e= map(int,input().split())
    sum = d+e
    li.append(sum)

 
for i in range(5) :
    print(li[i])

```

파이썬을 오랜만에 하다보니 문제를 너무 복잡하게 푸는 경향이 있다 파이썬이 코테 괜찮다고 해서 풀고있는데

신박한 방법으로 파이썬으로 자바보다 더 어렵게 풀고있다 ㅋㅋㅋ

