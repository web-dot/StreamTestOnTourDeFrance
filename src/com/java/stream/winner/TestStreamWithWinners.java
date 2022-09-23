package com.java.stream.winner;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStreamWithWinners {

	
	public static void main(String args[]) {
		
		 List<Winner> tdfWinners = Arrays.asList(
				new Winner(2006, "Spain", "Óscar Pereiro", "Caisse d'Epargne–Illes Balears", 3657, Duration.parse("PT89H40M27S"), 8),
				new Winner(2007, "Spain", "Alberto Contador", "Discovery Channel", 3570, Duration.parse("PT91H00M26S"), 4),
				new Winner(2008, "Spain", "Carlos Sastre", "Team CSC", 3559, Duration.parse("PT87H52M52S"), 5),
				new Winner(2009, "Spain", "Alberto Contador", "Astana", 3459, Duration.parse("PT85H48M35S"), 7),
				new Winner(2010, "Luxembourg", "Andy Schleck", "Team Saxo Bank", 3642, Duration.parse("PT91H59M27S"), 12),
				new Winner(2011, "Australia", "Cadel Evans", "BMC Racing Team", 3430, Duration.parse("PT86H12M22S"), 2),
				new Winner(2012, "Great Britain", "Bradley Wiggins", "Team Sky", 3496, Duration.parse("PT87H34M47S"), 14),
				new Winner(2013, "Great Britain", "Chris Froome", "Team Sky", 3404, Duration.parse("PT83H56M20S"), 14),
				new Winner(2014, "Italy", "Vincenzo Nibali", "Astana", 3661, Duration.parse("PT89H59M06S"), 19),
				new Winner(2015, "Great Britain", "Chris Froome", "Team Sky", 3360, Duration.parse("PT84H46M14S"), 16),
				new Winner(2016, "Great Britain", "Chris Froome", "Team Sky", 3529, Duration.parse("PT89H04M48S"), 14 )
				);
		 
		 
		 
		 /**
		  * Filter and Map
		  * 
		  * Winners of Tours Greater Than or Less Than 3500km long
		  * 
		  * */
		 
		 
		 //Filter and Map
		 List<String> winnersOfToursLessThan3500km =  tdfWinners
														 .stream()
														 .filter(d -> d.getLengthKm() < 3500)
														 .map(Winner::getName)
														 .collect(Collectors.toList());
		 
		 System.out.println("Winners of tours less than 3500 km - " + winnersOfToursLessThan3500km);
		 
		 
		 List<String> winnersOfToursGreaterThan3500km = tdfWinners
				 											.stream()
				 											.filter(d -> d.getLengthKm() >= 3500)
				 											.map(Winner::getName)
				 											.collect(Collectors.toList());
		 
		 System.out.println("Winners of tours more than 3500 km - " + winnersOfToursGreaterThan3500km);
		 
		 
		 //Limit, Distinct and Skip
		 List<Winner> winnerObjectsOfToursLessThan3500kmLimit2 =  tdfWinners
																	 .stream()
																	 .filter(d -> d.getLengthKm() < 3500)
																	 .limit(2)
																	 .collect(Collectors.toList());
		 
		 System.out.println("winnerObjectsOfToursLessThan3500kmLimit2 -" + winnerObjectsOfToursLessThan3500kmLimit2.toString().toString());
		 
		 
		 List<String> firstThreeWinnersOfToursLessThan3500KM =  tdfWinners
																 .stream()
																 .filter(d -> d.getLengthKm() < 3500)
																 .map(Winner::getName)
																 .limit(3)
																 .collect(Collectors.toList());
		 
		 System.out.println("firstThreeWinnersOfToursLessThan3500KM -" + firstThreeWinnersOfToursLessThan3500KM);
		 
		 //Filter by distinct
		 List<String> distinctTDFWinners = tdfWinners
											 .stream()
											 .map(Winner::getName)
											 .distinct()
											 .collect(Collectors.toList());
		 
		 System.out.println("distinctTDFWinners -" + distinctTDFWinners);
		 
	}
}
