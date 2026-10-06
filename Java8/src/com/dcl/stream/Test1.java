package com.dcl.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {
		
		//Creation of Stream s
		//Approach-1
		Stream s1=Stream.of(Arrays.asList(2,4,5,7,3,9,0,2,5,6,1,1,3,8,8,5,4));
		s1.forEach(System.out::println);
		
		System.out.println("========");
		//Approach-2
		List<Integer> iList=Arrays.asList(1,4,7,6,3,5,6,8,9);
		Stream s2=iList.stream();
		s2.forEach(System.out::println);
		
		

	}
}
