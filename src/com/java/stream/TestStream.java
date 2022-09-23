package com.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

	/**
	 * resource -> https://www.codingame.com/playgrounds/31592/java-8-stream-tutorial
	 * */
	
	
	public static void main(String[] args) {
		
		/**
		 * Stream operations
		 * 
		 * 1.intermidiate
		 * Return: a stream
		 * Ex: filter, map, sorted
		 * 
		 * 2.terminal
		 * Return: void
		 * Ex: for each
		 * 
		 * */
		
		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
		
		List<String> l1 = myList.stream()
		.filter(s->s.startsWith("c"))
		.map(String::toUpperCase)
		.sorted().collect(Collectors.toList());
		
		System.out.println(l1);
		
		
		//Processing order
		
		/**
		 * this do not have terminal operation so no outpput will be displayed
		 * */
		
		Stream.of("d2", "a2", "b1", "b3", "c")
		.filter(s -> {
			System.out.println("filter " + s);
			return true;
		});
		
		
		System.out.println();
		/**
		 * having a terminal operation
		 * */
		
		Stream.of("d2", "a2", "b1", "b3", "c")
		.filter(s -> {
			System.out.println("filter " + s);
			return true;
		})
		.forEach(s -> System.out.println("forEach: " + s));
		
		
		
		System.out.println();
		/**
		 * to avoid unnessesary calls, instead of executing the operations horizontally
		 * we can do it vertically
		 * */
		
		boolean l3 = Stream.of("d2", "s2", "b1", "a3", "c")
		.map(s -> s.toUpperCase())
		.anyMatch(s -> s.startsWith("A"));
		
		
		
		//Reusing Streams
		
		/**
		 * Java 8 streams can not be reused. As soon you call any terminal operation the stream is closed:
		 * Calling noneMatch after anyMatch on the same stream results in exception
		 * */
		
		Stream<String> s1 = Stream.of("d2", "s2", "b1", "a3", "c")
				.filter(s -> s.startsWith("a"));
		
		s1.anyMatch(s -> true);
		//stream.noneMatch(s -> true); // java.lang.IllegalStateException
		
		
		
		/**
		 * To overcome this limitation we have to create a new stream chain for every terminal
		 * operation we want to execute
		 * */
		
		Supplier<Stream<String>>  streamSupplier = () -> Stream.of("d2", "s2", "b1", "a3", "c")
				.filter(s->s.startsWith("a"));
		
		boolean s3 = streamSupplier.get().anyMatch(s -> true);
		boolean s4 = streamSupplier.get().anyMatch(s -> true);
		
		System.out.println(s3);
		System.out.println(s4);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
