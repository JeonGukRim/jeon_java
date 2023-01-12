package Dec_class;

public class Booktest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book littlePrince =new Book("어린왕자","생택쥐페리");
		Book lovestory = new Book("춘향전");
		Book oldstory = new Book("심청","모름",1000);
		Book newstory = new Book("ㄴㄴ","ㄹㄹ");
	
		
		System.out.println(littlePrince.title + " " + littlePrince.author);
	
		System.out.println(lovestory.title + " " + lovestory.author);
		
		System.out.println(oldstory.title + " " + oldstory.author+ " 발행년도 " + oldstory.year);
		
		System.out.println(newstory.title);
	}

}
