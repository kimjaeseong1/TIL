## 인터페이스 2

###인터페이스를 활용한 다형성 구현 (dao 구현하기)

### 인터페이스와 다형성
- 하나의 인터페이스를 여러 객체가 구현하게 되면 클라이언트 프로그램은 인터페이스의 메서드를 활용하여 여러 객체의 구현을 사용할 수 있음 ( 다형성)
- 여러가지 예

![image (73)](https://user-images.githubusercontent.com/105026909/192317026-6dddd23b-d7ec-4ac4-90d0-54beabb67afa.png)


### 인터페이스를 활용한 dao 구현하기
- DB에 회원 정보를 넣는 dao(data access object)를 여러 DB 제품이 지원될 수 있게 구현함
- 환경파일(db.properties) 에서 database의 종류에 대한 정보를 읽고 그 정보에 맞게 dao 인스턴스를 생성하여 실행될 수 있게 함


source hierachy

![image (74)](https://user-images.githubusercontent.com/105026909/192317232-4124bf9e-99e4-44b7-93c3-20ac720c0234.png)

UserInfo.java (사용자 정보 클래스)

```shell
public class UserInfo {

	private String userId;
	private String passwd;
	private String userName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
```
UserInfoDao.java ( dao 에서 제공되어야 할 메서드를 선언한 인터페이스 )

```shell
public interface UserInfoDao {

	void insertUserInfo(UserInfo userInfo);
	void updateUserInfo(UserInfo userInfo);
	void deleteUserInf(UserInfo userInfo);
}
```
UserInfoMySqlDao.java (UserInfoDao 인터페이스를 구현한 MySql 버전 dao)

```shell
public class UserInfoMySqlDao implements UserInfoDao{

	@Override
	public void insertUserInfo(UserInfo userInfo) {
		System.out.println("insert into MYSQL DB userId =" + userInfo.getUserId() );
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		System.out.println("update into MYSQL DB userId = " + userInfo.getUserId());
	}

	@Override
	public void deleteUserInf(UserInfo userInfo) {
		System.out.println("delete from MYSQL DB userId = " + userInfo.getUserId());

	}

}
```
UserInfoOracleDao.java (UserInfoDao 인터페이스를 구현한 Oracle 버전 dao)

```shell
public class UserInfoOracleDao implements UserInfoDao{

	public void insertUserInfo(UserInfo userInfo){
		System.out.println("insert into ORACLE DB userId =" + userInfo.getUserId() );
	}

	public void updateUserInfo(UserInfo userInfo){
		System.out.println("update into ORACLE DB userId = " + userInfo.getUserId());
	}

	public void deleteUserInf(UserInfo userInfo){
		System.out.println("delete from ORACLE DB userId = " + userInfo.getUserId());
	}
}
```
UserInfoClient.java (UserInfoDao 인터페이스를 활용하는 클라이언트 프로그램)

```shell
public class UserInfoClient {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("db.properties");

		Properties prop = new Properties();
		prop.load(fis);

		String dbType = prop.getProperty("DBTYPE");

		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("12345");
		userInfo.setPasswd("!@#$%");
		userInfo.setUserName("이순신");


		UserInfoDao userInfoDao = null;

		if(dbType.equals("ORACLE")){
			userInfoDao = new UserInfoOracleDao();
		}
		else if(dbType.endsWith("MYSQL")){
			userInfoDao = new UserInfoMySqlDao();
		}
		else{
			System.out.println("db support error");
			return;
		}

		userInfoDao.insertUserInfo(userInfo);
		userInfoDao.updateUserInfo(userInfo);
		userInfoDao.deleteUserInf(userInfo);
	}
}
```
db.properties 환경파일이 MYSQL 일때
`DBTYPE=MYSQL`

![image (75)](https://user-images.githubusercontent.com/105026909/192317817-0f947a53-17ca-4a8b-9856-c853e57b4e69.png)

db.properties 환경파일이 ORACLE 일때

`DBTYPE=ORACLE`

![image (76)](https://user-images.githubusercontent.com/105026909/192317937-6a11129f-5cd5-4391-a863-7ec67b30e4b0.png)

### 인터페이스의 여러가지 요소

### 상수

모든 변수는 상수로 변환 됨 public static final

`double PI = 3.14;
int ERROR = -999999999;
`

### 추상 메서드

- 모든 선언된 메서드는 추상 메서드 public abstract


### 디폴트 메서드 (자바 8이후)

- 구현을 가지는 메서드, 인터페이스를 구현하는 클래스들에서 공통으로 사용할 수 있는 기본 메서드

- default 키워드 사용

``
default void description() {
	System.out.println("정수 계산기를 구현합니다.");
	myMethod();
}
``

구현 하는 클래스에서 재정의 할 수 있음
```shell
@Override
public void description() {
	System.out.println("CompleteCalc에서 재정의한 default 메서드");
	//super.description();
}
```
인터페이스를 구현한 클래스의 인스턴스가 생성 되어야 사용 가능함

### 정적 메서드 (자바 8이후)

인스턴스 생성과 상관 없이 인터페이스 타입으로 사용할 수 있는 메서드

```shell
static int total(int[] arr) {
	int total = 0;

	for(int i: arr) {
		total += i;
	}
	mystaticMethod();
	return total;
}
```

### private 메서드 (자바 9이후)

- 인터페이스를 구현한 클래스에서 사용하거나 재정의 할 수 없음

- 인터페이스 내부에서만 사용하기 위해 구현하는 메서드

- default 메서드나 static 메서드에서 사용함

```shell
private void myMethod() {
	System.out.println("private method");
}

private static void mystaticMethod() {
	System.out.println("private static method");
}
```

