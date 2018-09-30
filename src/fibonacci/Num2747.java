package fibonacci;

import java.util.ArrayList;
import java.util.List;

public class Num2747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Num> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(new Num(i));
		}
		
		System.out.println(list);
	}

}

class Num {
	private int num;
	
	public Num (int n) {
		this.num = n;
	}
	
	@Override
	public String toString() {
		return "Num: " + this.num;
	}
}
