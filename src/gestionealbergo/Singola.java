package gestionealbergo;

public class Singola extends Camera {
	static private double costoGiornalieroStandard = 0;
	
	static public void setCostoGiornalieroStandard(double v) {
		if (v > 0)
			costoGiornalieroStandard = v;
		else
			throw new IllegalArgumentException("costoGiornalieroStandard must be postive");
	}
	
	static public double getCostoGiornalieroStandard() {
		return costoGiornalieroStandard;
	}
	
	public Singola(String numero) {
		super(numero, 1, costoGiornalieroStandard);
	}

}
