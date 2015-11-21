import java.util.ArrayList;
import java.util.HashMap;

class test {
    
    public static void main(String[] args) {
	HashMap<String,String> test = new HashMap<String,String>();
	test.put("test1","test2");
	test.put("test10","test20");
	test.put("test100","test200");
	System.out.println(test.size());
	System.out.println(test.get("test1"));
    }
    
}
