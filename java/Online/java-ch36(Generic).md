## 제네릭(Generic)

### 제네릭 자료형 정의

- 클래스에서 사용하는 변수의 자료형이 여러개 일수 있고, 그 기능(메서드)은 동일한 경우 클래스의 자료형

을 특정하지 않고

- 추후 해당 클래스를 사용할 때 지정 할 수 있도록 선언

- 실제 사용되는 자료형의 변환은 컴파일러에 의해 검증되므로 안정적인 프로그래밍 방식

- 컬렉션 프레임워크에서 많이 사용되고 있음

- 제네릭 타입을 사용하지 않는 경우의 예


재료가 Powder인 경우

```shell
public class ThreeDPrinter1{
	private Powder material;
	
	public void setMaterial(Powder material) {
		this.material = material;
	}
	
	public Powder getMaterial() {
		return material;
	}
}
```
재료가 Plastic인 경우

```shell
public class ThreeDPrinter2{
	private Plastic material;
	
	public void setMaterial(Plastic material) {
		this.material = material;
	}
	
	public Plastic getMaterial() {
		return material;
	}

}
```
여러 타입을 대체하게 위해 Object를 사용할 수 있음
```shell
public class ThreeDPrinter{

	private Object material;
	
	public void setMaterial(Object material) {
		this.material = material;
	}
	
	public Object getMaterial() {
		return material;
	}
}

```

Object를 사용하는 경우는 형 변환을 하여야 함

```shell
ThreeDPrinter printer = new ThreeDPrinter();

Powder powder = new Powder();
printer.setMaterial(powder);

Powder p = (Powder)printer.getMaterial();

```

- 제네릭 클래스 정의

GenericPrinter.java
```shell
public class GenericPrinter<T> {
	private T material;
	
	public void setMaterial(T material) {
		this.material = material;
	}
	
	public T getMaterial() {
		return material;
	}
	
	public String toString(){
		return material.toString();
	}
}
```


- 자료형 매개변수 T(type parameter) : 이 클래스를 사용하는 시점에 실제 사용할 자료형을 지정, static 변수는 사용할 수 없음

- GenericPrinter : 제네릭 자료형

- E : element, K: key, V : value 등 여러 알파벳을 의미에 따라 사용 가능

### 제네릭 클래스 사용하기 

Powder.java
```shell
public class Powder {
	
	public String toString() {
		return "재료는 Powder 입니다";
	}
}
```

Plastic.java
```shell
public class Plastic {

	public String toString() {
		return "재료는 Plastic 입니다";
	}
}

```

GenericPrinter.java
```shell
public class GenericPrinter<T> {
	private T material;   //T 자료형으로 선언한 변수
	
	public void setMaterial(T material) {
		this.material = material;
	}
	
	public T getMaterial() {   //T 자료형을 반환하는 제네릭 메서드
		return material;
	}
	
	public String toString(){
		return material.toString();
	}
}

```
GenericPrinterTest.java
```shell
public class GeneriPrinterTest {

	public static void main(String[] args) {

		GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();
		powderPrinter.setMaterial(new Powder());
		System.out.println(powderPrinter);
		
		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
		plasticPrinter.setMaterial(new Plastic());
		System.out.println(plasticPrinter);
		
	}

}

```
### 다이아몬드 연산자 <>


- 에서 <>를 다이아몬드 연산자라 함

- ArrayList list = new ArrayList<>(); //다이아몬든 연산자 내부에서 자료형은 생략가능 함

- 제네릭에서 자료형 추론(자바 10부터)

ArrayList list = new ArrayList() => var list = new ArrayList();

### 제네릭 메서드 활용하기


### 제네릭 메서드란?

- 자료형 매개변수를 메서드의 매개변수나 반환 값으로 가지는 메서드는

- 자료형 매개 변수가 하나 이상인 경우도 있음

- 제네릭 클래스가 아니어도 내부에 제네릭 메서드는 구현하여 사용 할 수 있음

- public <자료형 매개 변수> 반환형 메서드 이름(자료형 매개변수.....) { }


### 제네릭 메서드의 활용 예

- 두 점(top, bottom)을 기준으로 사각형을 만들 때 사각형의 너비를 구하는 메서드를 만들어 보자

- 두 점은 정수인 경우도 있고, 실수인 경우도 있으므로 제네릭 타입을 사용하여 구현한다.


Point.java
```shell
public class Point<T, V> {
	
	T x;
	V y;
	
	Point(T x, V y){
		this.x = x;
		this.y = y;
	}
	
	public  T getX() {
			return x;
	}

	public V getY() {
		return y;
    }
}

```
GenericMethod.java
```shell
public class GenericMethod {

	public static <T, V> double makeRectangle(Point<T, V> p1, Point<T, V> p2) {
		double left = ((Number)p1.getX()).doubleValue();
		double right =((Number)p2.getX()).doubleValue();
		double top = ((Number)p1.getY()).doubleValue();
		double bottom = ((Number)p2.getY()).doubleValue();
		
		double width = right - left;
		double height = bottom - top;
		
		return width * height;
	}
	
	public static void main(String[] args) {
		
		Point<Integer, Double> p1 = new Point<Integer, Double>(0, 0.0);
		Point<Integer, Double> p2 = new Point<>(10, 10.0);
		
		double rect = GenericMethod.<Integer, Double>makeRectangle(p1, p2);
		System.out.println("두 점으로 만들어진 사각형의 넓이는 " + rect + "입니다.");
	}
}

```