package br.com.bersoncrios.matchers;

import java.util.Calendar;

public class MatchersProprios {
	
	public static DiaSemanaMatchers caiEm(Integer diaSemana) {
		return new DiaSemanaMatchers(diaSemana);
	}
	
	public static DiaSemanaMatchers caiNumaSegunda() {
		return new DiaSemanaMatchers(Calendar.SUNDAY);
	}
}
