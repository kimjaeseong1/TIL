## JSON이란

- Java Script Object Notation  - 자바 스크립트 객체 표기법 
```shell
// 자바스크립트에서 객체 표기 방법
{속성명1 : 속성값1, 속성명2: 속성값2,..}


배열로 표시하는 방법
[{속성명:속성값,...}.{속성명:속성값,..},...] // 객체 배열

MAP
{키1:{속성명: 속성값, ...}, 키2:{속성명: 속성값,...},...} // Map

```
- 데이터를 저장하거나 전송할 때 많이 사용되는 경량의 DATA 교환 형식
- JSON 표현식은 사람과 기계 모두 이해하기 쉬우며 용량이 작아서, 최근에는 JSON이 XML을 대체해서 데이터 전송 등에 많이 사용한다. 
- JSON은 데이터 포멧일 뿐이며 어떠한 통신 방법도 프로그래밍 문법도 아닌 단순히 데이터를 표시하는 방법일 뿐이다.


### 특징

 - 서버와 클라이언트 간의 교류에서 일반적으로 많이 사용된다. 
 - 자바스크립트 객체 표기법과 아주 유사하다
 - 자바스크립트를 이용하여 JSON 형식의 문서를 쉽게 자바스크립트 객체로 변환할 수 있는 이점이 있다.
 - JSON 문서 형식은 자바스크립트 객체의 형식을 기반으로 만들어졌다. 
 - 자바스크립트의 문법과 굉장히 유사하지만 텍스트 형시일 뿐이다. 
 - 다른 프로그래밍 언어를 이용해서도 쉽게 만들 수 있다. 
 - 특정 언어에 종속되지 않으며 대부분의 프로그래밍 언어에서 JSON 포맷의 데이터를 핸들링 할 수 있는 라이브러리를 제공한다. 


### XML vs JSON
- 데이터를 나타낼 수 있는 방식은 여러가지가 있지만, 대표적인 것이 XML이고, 이후 가장 많이 사용되는 것이 아마도 JSON일 것이다.
- XML은 JSON보다 복잡하고 실제 데이터보다 Tag가 더 많은 단점이 있다. 

### JSON 문법
```shell
{
  "employees": [
    {
      "name": "Surim",
      "lastName": "Son"
    },
    {
      "name": "Someone",
      "lastName": "Huh"
    },
    {
      "name": "Someone else",
      "lastName": "Kim"
    } 
  ]
}
```

- JSON 형식은 자바스크립트 객체와 마찬가지로 key/value가 존재 할 수 있으며 key값이나 문자열은 항상 쌍따옴표를 이용하여 표기해야한다. 
- 객체, 배열 등의 표기를 사용할 수 있다. 
- 일단 자바스크립트의 객체처럼 원하는 만큼 중첩시켜서 사용할 수도 있다. 
- JSON형식에서는 null, number,string,array,object,boolean을 사용할 수 있다. 

### JSON 형식

#### 1. name-value형식의 쌍
- 여러가지 언어들에서 object등으로 실형되었다. 
- {String key : String value}
```shell
{
  "firstName": "Kwon",
  "lastName": "YoungJae",
  "email": "kyoje11@gmail.com"
}
```


#### 2. 값들의 순서화된 리스트 형식
- 여러가지 언어들에서 배열(Array) 등으로 실현되었다. 
- [value1, value2,...]

```shell
{
  "firstName": "Kwon",
  "lastName": "YoungJae",
  "email": "kyoje11@gmail.com",
  "hobby": ["puzzles","swimming"]
}
```

#### JSON의 문제점
AJAX는 단순히 데이터만이 아니라 JavaScript 그 자체도 전달 할 수 있다. 이 말은 JSON 데이터라고 해서 받았는데 단순 데이터가 아니라 JavaScript가 될 수도 있고, 그게 실행 될 수 있다는 것이다. (데이터인 중 알고 받았는데 악성 스크립트가 될 수 있다. )


위와 같은 이유로 받은 내용에서 순수하게 데이터만 추출하기 위한 JSON 관련 라이브러리를 따로 사용하기도 한다. 


#### JSON이 가져올 수 있는 데이터

JSON으로 가져올 수 있는 데이터는 해당 자바스크립트가 로드된 서버의 데이터에 한정된다. 

예를 들어 , http://kwz.kr/json.js에서 불렁로 수 있는 데이터는 kwz.kr 서버에 존재하는 것만 가능하다 (구글 데이터를 불러온다거나 네이버 데이터를 불러온다거나 할 수 없다.)


JSON은 단순히 데이터 포맷일 뿐이며 그 데이터를 불러오기 위해선 XMLHttpRequest()라는 JavaScript 함수를 사용해야 하는데 이 함수가 동일 서버에 대한 것만 지원하기 때문이다. (JSONP) 또는 프락시 역할을 하는 서버쪽 Script 파일로 가능하게도 할 수 있다. )


#### JSON 형식 텍스트를 JavaScript Object로 변환하기

stringify()
- JS 객체를 서버로 전송하려면 ,직렬화 (문자열로 변환) 가 필요
- 객체를 JSON 문자열로 변환 (직렬화, JS 객체 -> 문자열)

parse()
- 서버가 보낸 데이터(JSON 문자열)를 JS객체로 변환 할 때 역직렬화가 필요

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FFYuTA%2FbtrmK0xCUQo%2FGKjBIgErDE6rqyh75k4dd0%2Fimg.png">


- JSON.parse()-JSON 문자열을 객체로 변환 (역직렬화, 문자열 -> JS 객체)

<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fb1U3oe%2FbtrmKDWLDpD%2FwqXNOAPaB1KkheNRHZ4zwK%2Fimg.png">
