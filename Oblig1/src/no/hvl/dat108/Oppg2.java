package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Oppg2 {
	
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> funksjon) {
		
		for(Ansatt x : ansatte) {
			x.setAarslonn(funksjon.apply(x));
		}
	}
	
	private static void skrivUtAlle(List<Ansatt> ansatte) {
		
		for(Ansatt x : ansatte) {
			System.out.println(x.toString());
		}
	}
	
	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Charles", "Dickens", Kjonn.MANN, "stillingsjef", 1400000 ),
				new Ansatt("Per", "Person", Kjonn.MANN, "stilling", 1000000 ),
				new Ansatt("Annette", "Annettesdottir", Kjonn.DAME, "stillingsjef", 800000 ),
				new Ansatt("Jon", "Jonson", Kjonn.MANN, "stilling", 400000 ),
				new Ansatt("Sara", "Jonson", Kjonn.DAME, "stilling", 400000 )
				);
		
		Function<Ansatt,Integer> fastkrone = (a) -> a.getAarslonn()+10000;
		Function<Ansatt,Integer> prosentkrone = (a) -> (int)Math.round(a.getAarslonn()*1.01);
		Function<Ansatt,Integer> fastkronelav = (a) -> {return a.getAarslonn() < 500000 ? a.getAarslonn() + 100000 : a.getAarslonn(); };
		Function<Ansatt,Integer> fastkronemann = (a) -> {return a.getKjonn() == Kjonn.MANN ? (int)Math.round(a.getAarslonn()*1.01) : a.getAarslonn();};
		
		skrivUtAlle(ansatte);
		lonnsoppgjor(ansatte,fastkrone);
		skrivUtAlle(ansatte);
		lonnsoppgjor(ansatte,prosentkrone);
		skrivUtAlle(ansatte);
		lonnsoppgjor(ansatte,fastkronelav);
		skrivUtAlle(ansatte);
		lonnsoppgjor(ansatte,fastkronemann);
		skrivUtAlle(ansatte);
	}
}
