package ese105;

import java.time.LocalDateTime;

import gestionealbergo.*;

public class Ese105 {

	public static void main(String[] args) throws Exception {
		Albergo overlook = new Albergo("Overlook Hotel");
		
		Tripla suitePresidenziale = new Tripla("901");
		Doppia cameraNormale = new Doppia("203");
		Singola unBuco = new Singola("107");
		
		overlook.getCamere().add(suitePresidenziale);
		overlook.getCamere().add(cameraNormale);
		overlook.getCamere().add(unBuco);
		
		Cliente barack = new Cliente("Barack", "Obama", "+01 123456789");
		Cliente ugo = new Cliente("Ugo", "Fantozzi", "+39 123456789", "ugo@fantozzi.com");
		Cliente rita = new Cliente("Rita", "Coccia", "+39 987654321", "dirigente@avolta.pg.it");
		
		Prenotazione p = null;
		
		// ------------------------------------------------------
		
		System.out.print("Test 01...");
		try {
			p = new Prenotazione(
					LocalDateTime.of(2015, 04, 23, 00, 00, 00),
					LocalDateTime.of(2015, 04, 22, 00, 00, 00),
					barack);
			throw new Exception("Eccezione non lanciata");
		}
		catch(Exception e) {
			if (e.getMessage().equals("Eccezione non lanciata"))
				System.out.println("ERROR");
			else
				System.out.println("OK");
		}
		
		// ------------------------------------------------------
		
		p = new Prenotazione(
				LocalDateTime.of(2015, 04, 23, 00, 00, 00),
				LocalDateTime.of(2015, 04, 25, 00, 00, 00),
				barack);
		System.out.print("Test 02...");
		if(p.getNumeroNotti() == 2)
			System.out.println("OK");
		else
			throw new Exception("Numero notti non conforme");
		
		suitePresidenziale.addPrenotazione(p);
		
		System.out.print("Test 02a..");
		if (p.getCamera() == suitePresidenziale)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		
		// ------------------------------------------------------
		
		System.out.print("Test 03...");
		p = new Prenotazione(
				LocalDateTime.of(2015, 04, 23, 00, 00, 00),
				LocalDateTime.of(2015, 04, 25, 00, 00, 00),
				rita);
		try {
			suitePresidenziale.addPrenotazione(p);
			throw new Exception("Eccezione non lanciata");
		}
		catch(Exception e) {
			if (e.getMessage().equals("Eccezione non lanciata"))
				System.out.println("ERROR");
			else
				System.out.println("OK");
		}
		
		System.out.print("Test 03a..");
		if (p.getCamera() == null)
			System.out.println("OK");
		else
			System.out.println("ERROR");
		
	}

}
