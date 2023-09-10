package no.hvl.dat108;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Oppg3 {
	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Charles", "Dickens", Kjonn.MANN, "stillingsjef", 1400000 ),
				new Ansatt("Per", "Person", Kjonn.MANN, "stilling", 1000000 ),
				new Ansatt("Annette", "Annettesdottir", Kjonn.DAME, "stillingsjef", 800000 ),
				new Ansatt("Jon", "Jonson", Kjonn.MANN, "stilling", 500000 ),
				new Ansatt("Sara", "Jonson", Kjonn.DAME, "stilling", 400000 )
				);
		
		//a)
		
		List<String> etternavn = ansatte.stream()
				.map(Ansatt::getEtternavn)
				.toList();
		
		System.out.println(etternavn);
		
		//b)
		
		long antallkvinner = ansatte.stream()
				.filter(x -> x.getKjonn() == Kjonn.DAME)
				.count();
		
		System.out.println(antallkvinner);
		
		//c)
		
		int sumlonnkvinner = ansatte.stream()
				.filter(x -> x.getKjonn() == Kjonn.DAME)
				.map(a -> a.getAarslonn())
				.reduce(0, (gjlonn, b) -> gjlonn + b);
				
		System.out.println(sumlonnkvinner/antallkvinner);
		
		//d)
		
		ansatte.stream()
		.filter(x -> x.getStilling().contains("sjef"))
		.forEach(p -> p.setAarslonn((int)Math.round(p.getAarslonn()*1.07)));
		
		ansatte.stream().forEach(x -> System.out.println(x));
		
		//e)
		
		boolean hoylonn = ansatte.stream()
				.anyMatch(x -> x.getAarslonn() > 800000);
		
		System.out.println(hoylonn);
		
		//f)
		
		ansatte.stream().forEach(x -> System.out.println(x));
		
		//g)
		
		Optional<Ansatt> an = ansatte.stream()
                .min((a, b) -> a.getAarslonn() -b.getAarslonn() );
		
		System.out.println(an);
		
		//h)
		
		int del5el3 = IntStream.range(1,1000).filter(x -> x % 5 == 0 || x % 3 == 0).reduce(0, (a,b) -> a + b);
			
		System.out.println(del5el3);
	}
}
