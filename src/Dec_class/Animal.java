package Dec_class;

public class Animal {

	String name;
	String kind;
	String weight;
	String sg;
	int age;
	
	public Animal() {
		System.out.println("동물세계");
	}
	public void sG() {
		sg = "난폭함";
	}
	public String getSg() {
		return sg;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getKind(String kind1,String kind2) {
		return this.kind=kind1+ " 와 "+kind2;
	}
	
	
	
	
}
