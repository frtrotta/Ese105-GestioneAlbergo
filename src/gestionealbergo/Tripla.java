package gestionealbergo;

public class Tripla extends Camera {
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
	
	public Tripla(String numero) {
		super(numero, 3, costoGiornalieroStandard);
	}

}
