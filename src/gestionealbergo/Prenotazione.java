package gestionealbergo;

import java.time.*;

public class Prenotazione {
	private LocalDateTime dal;
	private LocalDateTime al;
	private Camera camera;
	private Cliente cliente;
	private double costoGiornaliero;
	
	public Prenotazione(LocalDateTime dal, LocalDateTime al, Cliente cliente) {
		if ((dal != null) && (al != null)) {
			if (dal.isBefore(al)) {
				this.dal = dal;
				this.al = al;
			}
			else
				throw new IllegalArgumentException("al must follow dal");
		}
		else
			throw new IllegalArgumentException("al and dal cannot be null");
		
		if (cliente != null)
			this.cliente = cliente;
		else
			throw new IllegalArgumentException("cliente cannot be null");
		
		costoGiornaliero = 0;
	}
	
	public Prenotazione(LocalDateTime dal, LocalDateTime al, Cliente cliente, double costoGiornaliero) {
		this(dal, al, cliente);
		if (costoGiornaliero > 0)
			this.costoGiornaliero = costoGiornaliero;
		else
			throw new IllegalArgumentException("costoGiornaliero cannot be null");
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		if (camera != null)  {
			this.camera = camera;
			if (this.costoGiornaliero == 0) {
				// Se il costo giornaliero è a 0, non è stato impostato esplicitamente
				this.costoGiornaliero = camera.getCostoGiornaliero();
			}
		}
		else
			throw new IllegalArgumentException("camera cannot be set to null");
	}

	public LocalDateTime getDal() {
		return dal;
	}

	public LocalDateTime getAl() {
		return al;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public int getNumeroNotti() {
		return Period.between(dal.toLocalDate(), al.toLocalDate()).getDays();
	}
	
	public double getCostoGiornaliero() {
		return costoGiornaliero;
	}
	
	public double getCostoTotale() {
		return costoGiornaliero * getNumeroNotti();
	}

	@Override
	public String toString() {
		return "Prenotazione [dal=" + dal + ", al=" + al + ", camera=" + camera
				+ ", cliente=" + cliente + ", getNumeroNotti()="
				+ getNumeroNotti() + "]";
	}
}
