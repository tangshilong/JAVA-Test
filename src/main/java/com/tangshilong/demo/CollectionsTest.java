package com.tangshilong.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 操作集合的工具类 Collections
 * 
 * @author tangshilong
 *
 */
public class CollectionsTest {

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(2);
		nums.add(-1);
		nums.add(5);
		nums.add(6);
		System.out.println("当前数列为 ： " + nums);
		Collections.reverse(nums);
		System.out.println("数列翻转后为 ： " + nums);
		Collections.shuffle(nums);
		System.out.println("数列随机排序后为 ： " + nums);
		Collections.sort(nums);
		System.out.println("数列按自然顺序升序排序后为 ： " + nums);
		// 二分法索引搜索，前提数列必须是有序的
		System.out.println("数列二分法索引搜索结果为 ： " + Collections.binarySearch(nums, 6));
		Collections.swap(nums, 1, 3);
		System.out.println("数列交换指定元素后为 ： " + nums);
		System.out.println("数列最大元素为 ： " + Collections.max(nums));
		System.out.println("数列最小元素为 ： " + Collections.min(nums));
		System.out.println("返回指定元素在数列中出现次数 ： " + Collections.frequency(nums, 6));
		System.out.println("使用新值替换数列中的旧值 ： " + Collections.replaceAll(nums, 6, 7));
		// 线程安全集合
		System.out.println("建立线程安全集合，解决多线程并发线程安全问题：");
		Collections collectiwons = (Collections) Collections.synchronizedCollection(new ArrayList());
		List list = Collections.synchronizedList(new ArrayList<>());
		Set set = Collections.synchronizedSet(new HashSet<>());
		Map map = Collections.synchronizedMap(new HashMap<>());
	}
}
