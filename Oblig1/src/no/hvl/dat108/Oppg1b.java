package no.hvl.dat108;

import java.util.function.BinaryOperator;

public class Oppg1b {
	
	
	public static int beregn(int a, int b, BinaryOperator<Integer> funksjon) {
		
		int resultat = funksjon.apply(a, b);
		
		return resultat;
	}

	public static void main(String[] args) {
		
		BinaryOperator<Integer> Summerfunksjon = (a,b) -> Math.addExact(a,b);
		BinaryOperator<Integer> Storstefunksjon = (a,b) -> Math.max(a,b);
		BinaryOperator<Integer> Avstandfunksjon = (a,b) -> Math.abs(Math.subtractExact(a,b));
		
		int sum = beregn(12,13,Summerfunksjon);
		int storste = beregn(-5,3,Storstefunksjon);
		int differanse = beregn(54,45,Avstandfunksjon);
		
		System.out.println("Sum: " + sum);
		System.out.println("Storste: " + storste);
		System.out.println("Avstand: " + differanse);

	}
	
	

}