package tw.org.iii.tutor;

import java.util.LinkedList;

import javax.xml.stream.events.Namespace;

public class test58 {

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<>();
		names.add(0,"Brad");
		names.add(0,"eee");
		names.add(0,"ddd");
		names.add(0,"ccc");
		names.add(0,"bbb");
		names.add(0,"aaa");
		System.out.println(names.size());
		for(String name : names) {
			System.out.println(name);
		}
	}

}
