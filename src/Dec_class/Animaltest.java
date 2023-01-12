package Dec_class;

public class Animaltest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Animal ani = new Animal();
		
		String kind = ani.getKind("치와와","코기");
		ani.name = "또비";
		ani.age = 3;
		System.out.println(ani.getName());
		ani.sG();
		String sg =ani.getSg();
		System.out.println(sg);
		System.out.println(kind);

		Animal ani1 = new Animal();
		kind = ani1.getKind("치와와","코기22");
		System.out.println(kind);
		
	
		
	}

}
