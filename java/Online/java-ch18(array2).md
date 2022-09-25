## 2차원 배열 사용하기


### 다차원 배열
- 이차원 이상으로 구현 된 배열
- 평면 (이차원 배열) 이나 공간(삼차원 배열)을 활용한 프로그램 구현

### 이차원 배열 예제

![image (49)](https://user-images.githubusercontent.com/105026909/192150188-de6570de-b743-495a-bfa8-2ec031890adf.png)

`int[][] arr = {{1,2,3}, {4,5,6}}`

``
public class TwoDimensionTest {

	public static void main(String[] args) {
		int[][] arr = { {1,2,3}, {4,5,6,7}};
		int i, j;

		for(i =0; i<arr.length; i++) {
			for(j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(", \t" + arr[i].length);
			System.out.println();
		}
	}
}
``

![image (50)](https://user-images.githubusercontent.com/105026909/192150211-56d03638-b572-4acd-8c2d-29ef0376cf68.png)


### 객체 배열을 구현한 클래스 ArrayList


#### java.util 패키지에서 제공되는 ArrayList

- 기존의 배열 선언과 사용 방식은 배열의 길이를 정하고 요소의 개수가 배열의 길이보다 커지면 배열을 재할 당하고 복사해야 했음
- 배열의 요소를 추가하거나 삭제하면 다른 요소들의 이동에 대한 구현을 해야함 
- ArrayList는 객체 배열을 좀더 효율적으로 관리하기 위해 자바에서 제공해 주는 클래스
- 이미 많은 메서드들이 최적의 알고리즘으로 구현되어 있어 각 메서드의 사용 방법만 익히면 유용하게 사용할 수 있음

### ArrayList의 주요 메서드

![image (51)](https://user-images.githubusercontent.com/105026909/192150252-2253cf8e-b14e-46c1-84a5-10a8d17af871.png)

### ArrayList를 활용한 간단한 예제
``import java.util.ArrayList;
import ch21.Book;

public class ArrayListTest {

	public static void main(String[] args) {

		ArrayList<Book> library = new ArrayList<Book>();
		
		library.add(new Book("태백산맥1", "조정래"));
		library.add(new Book("태백산맥2", "조정래"));
		library.add(new Book("태백산맥3", "조정래"));
		library.add(new Book("태백산맥4", "조정래"));
		library.add(new Book("태백산맥5", "조정래"));
		
		for(int i =0; i<library.size(); i++) {
			library.get(i).showBookInfo();
		}
	}
}
``

### ArrayList를 활용한 간단한 성적 산출 프로그램

예제 시나리오
``1001학번 Lee와 1002학번 Kim, 두 학생이 있습니다. 
Lee 학생은 국어와 수학 2과목을 수강했고, Kim 학생은 국어, 수학, 영어 3 과목을 수강하였습니다.
Lee 학생은 국어 100점, 수학 50점입니다. 
Kim 학생은 국어 70점, 수학 85점, 영어 100점입니다. 
Student와 Subject 클래스를 만들고 ArrayList를 활용하여 두 학생의 과목 성적과 총점을 출력하세요
``

Student 클래스
``import java.util.ArrayList;

public class Student {
	
	int studentID;
	String studentName;
	ArrayList<Subject> subjectList;
		
	public Student(int studentID, String studentName){
		this.studentID = studentID;
		this.studentName = studentName;
		
		subjectList = new ArrayList<Subject>();
	}
	
	public void addSubject(String name, int score){
		Subject subject = new Subject();
		
		subject.setName(name);
		subject.setScorePoint(score);
		subjectList.add(subject);
	}
	
	public void showStudentInfo()
	{
		int total = 0;
		
		for(Subject s : subjectList){
			
			total += s.getScorePoint();
			System.out.println("학생 " + studentName + "의 " + s.getName() + " 과목 성적은 " + 
			        s.getScorePoint() + "입니다.");
		}
			
		System.out.println("학생 " + studentName + "의 총점은 " + total + " 입니다.");
	}
}
``
Subject 클래스
``public class Subject {
	
	private String name;
	private int scorePoint;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScorePoint() {
		return scorePoint;
	}
	public void setScorePoint(int scorePoint) {
		this.scorePoint = scorePoint;
	}
}
``

실행하기

``
public class StudentTest {

	public static void main(String[] args) {
		Student studentLee = new Student(1001, "Lee");

		studentLee.addSubject("국어", 100);
		studentLee.addSubject("수학", 50);

		Student studentKim = new Student(1002, "Kim");

		studentKim.addSubject("국어", 70);
		studentKim.addSubject("수학", 85);
		studentKim.addSubject("영어", 100);

		studentLee.showStudentInfo();
		System.out.println("======================================");
		studentKim.showStudentInfo();
	}
}
``
![image (52)](https://user-images.githubusercontent.com/105026909/192150330-31ecb196-ab1b-4a7f-b287-ae86b7c1714c.png)





