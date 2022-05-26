package com.yedam.java.ch0703;

public class AnimalTest {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.sound();
		cat.sound();
		
		System.out.println();
		
		
		//추상클래스도 상속관계이기 때문에 그 타입에 의한 강제형변환이 일어남
		
		Animal animal = dog;
		animal.sound();
		animal = cat;	 //cat 따로 정의해 주지 않았음에도 적용 ㅇㅋ
		animal.sound();
		
	}
}