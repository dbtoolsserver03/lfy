package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class LamdaTest {

	@Test
	public void run1() {
		List<String> list = Arrays.asList("apple","banana","watermelon","orange");

		for (String s : list) {
			System.out.println(s);
		}
		list.forEach(System.out::println);
		list.forEach(s->System.out.println(s));
		list.forEach(s->{
			System.out.println(s);
		});
	}
	@Test
	public void run2() {
		List<String> list = Arrays.asList("apple","banana","watermelon","orange");

		Collections.sort(list,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		Collections.sort(list,(o1,o2)->o1.compareTo(o2));
		Collections.sort(list,(o1,o2)->{
			return o1.compareTo(o2);
		});

		list.forEach(System.out::println);
	}
	@Test
	public void run3() {
		List<String> list = Arrays.asList("apple","banana","watermelon","orange");

		List<String> list2 = new ArrayList<>();
		for (String s : list) {
			if (s.startsWith("a")) {
				list2.add(s);
			}
		}

		List<String> list3 = list.stream().filter(s->s.startsWith("a")).collect(Collectors.toList());
		list3.forEach(System.out::println);
	}
	@Test
	public void run4() {
		List<String> list = Arrays.asList("apple","banana","watermelon","orange");

		List<Integer> list2 = new ArrayList<>();
		for (String s : list) {
			list2.add(s.length());
		}

		// 每个元素做一下转换操作
		List<Integer> list3 = list.stream().map(s->s.length()).collect(Collectors.toList());
		list3.forEach(System.out::println);
	}
	@Test
	public void run5() {
		List<Integer> list = Arrays.asList(1,2,3,4,5);

		List<Integer> list2 = new ArrayList<>();
		int sum=0;
		for (Integer v : list) {
			sum+=v;
		}
		System.out.println(sum);

		int sum2 = list.stream().reduce(0, (a,b)->a+b);
		System.out.println(sum2);
	}
	@Test
	public void run6() {
		List<String> list = Arrays.asList("apple","banana","watermelon","orange");

		Map<Integer,List<String>> groups = new HashMap<>();
		for (String s : list) {
			int length = s.length();
			if (!groups.containsKey(length)) {
				groups.put(length, new ArrayList<>());
			}
			groups.get(length).add(s);
		}

		System.out.println(groups);

		Map<Integer,List<String>> groups2 = list.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(groups2);

		Map<Integer,List<String>> groups3 = list.stream().collect(Collectors.groupingBy(s->s.length()));
		System.out.println(groups3);
	}

	@Test
	public void run7() {
		MyInterface myInterface = new MyInterface() {

			@Override
			public void doSomething(String s) {
				System.out.println(s);
			}
		};
		myInterface.doSomething("hello world");


		MyInterface myInterface1 = (s)->System.out.println(s);
		myInterface1.doSomething("hello world");


	}


	@Test
	public void run8() {
		Thread thread = new Thread( new Runnable() {
			@Override
			public void run() {
				System.out.println("hello world");
			}
		});
		thread.start();

		Thread thread1 = new Thread(()->System.out.println("hello world"));
		thread1.start();
	}

	@Test
	public void run9() {
		String str = "hello world";
		if (str!=null) {
			System.out.println(str.toUpperCase());
		}
		Optional.ofNullable(str).map(String::toUpperCase).ifPresent(System.out::println);
	}

	@Test
	public void run10() {
		List<String> list = Arrays.asList("apple","banana","watermelon","orange","aaange");

		List<String> list2 = new ArrayList<>();
		for (String s : list) {
			if (s.startsWith("a")) {
				list2.add(s.toUpperCase());
			}
		}
		Collections.sort(list2);
		list2.forEach(System.out::println);

		List<String> list3 =list.stream().filter(s->s.startsWith("a")).map(String::toUpperCase).sorted().collect(Collectors.toList());
		list3.forEach(System.out::println);
	}

}
interface MyInterface {

	void doSomething(String s);

}
