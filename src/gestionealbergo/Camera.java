package gestionealbergo;

import java.util.*;
import java.time.*;

public abstract class Camera {
	
	private String numero;
	private int postiLetto;
	private Vector<Prenotazione> prenotazioni;
	private double costoGiornaliero;
	
	Camera(String numero, int postiLetto, double costoGiornaliero) {
		if (numero != null)
			this.numero = numero;
		else
			throw new IllegalArgumentException("numero cannot be null");
		
		if (postiLetto > 0)
			this.postiLetto = postiLetto;
		else
			throw new IllegalArgumentException("postiLetto must be positive");
		
		if (costoGiornaliero > 0)
			this.costoGiornaliero = costoGiornaliero;
		else
			throw new IllegalArgumentException("costoGiornaliero must be positive");
		
		this.prenotazioni = new Vector<Prenotazione>();
	}

	public String getNumero() {
		return numero;
	}

	public int getPostiLetto() {
		return postiLetto;
	}
	
	public Vector<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	
	public boolean isDisponibile(LocalDateTime dal, LocalDateTime al) {
		boolean r = true;
		for(Prenotazione p : prenotazioni) {
//			if(		(!dal.isBefore(p.getDal()) && !dal.isAfter(p.getAl()))
//					|| (!al.isBefore(p.getDal()) && !al.isAfter(p.getAl()))
//					|| (!p.getDal().isBefore(dal) && !p.getDal().isAfter(al))
//					|| (!p.getAl().isBefore(dal) && !p.getAl().isAfter(al))) 
			if ( !dal.isAfter(p.getAl()) && !al.isBefore(p.getDal()))
			{
				r = false;
				// break;
			}
		}
		return r;
	}
	
	public void addPrenotazione(Prenotazione p) throws Exception {
		if( p != null) {
			if (this.isDisponibile(p.getDal(), p.getAl())) {
				p.setCamera(this);
				prenotazioni.add(p);
			}
			else
				throw new Exception("camera not disponibile");
		}
		else
			throw new IllegalArgumentException("prenotazione cannot be null");
	}
	
	public double getCostoGiornaliero() {
		return this.costoGiornaliero;
	}

	@Override
	public String toString() {
		return "Camera [numero=" + numero + ", postiLetto=" + postiLetto + ", prenotazioni = " + prenotazioni.size() +"]";
	}
}
