package com.tangshilong.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorAndPredicateTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("白杨是个好人");
		list.add("白杨很可爱");
		/*
		 * iterator 遍历
		 */
		Iterator<String> iterator = list.iterator();

		iterator.forEachRemaining(b -> System.out.println(b + "\n"));// Lambda表达式forEachRemaining()

		Iterator<String> iterator2 = list.iterator();
		while (iterator2.hasNext()) {
			String str = iterator2.next();
			System.out.println(str + "\n");
			if (str.equals("白杨很可爱")) {
				iterator2.remove();// iterator.remove();只有iterator对象可以remove集合元素，用其他对象remove会报错。
			}
        }
		System.out.println(list);

		/*
		 * predicate 谓词 removeIf()
		 */
		list.removeIf(a -> a.length() < 5);// Lambda表达式 removeIf()
		System.out.println("\n" + list);
	}
}
