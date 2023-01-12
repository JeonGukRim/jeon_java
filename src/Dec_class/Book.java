package Dec_class;

public class Book {

	String title;
	String author;
	int year;
	
	public Book() {
		this("","");
		System.out.println("생성자 호출됨");
	}
	
	public Book(String title) {
		this(title,"작자미상");
		
		//		title =t;
//		author = "작자미상";
	}
	public Book(String t,String a) {
		title = t ; author = a;
	}
	public Book(String t,String a,int year) {
		title =t;
		author =a;
		this.year = year;
	}
}
