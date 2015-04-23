package gestionealbergo;

import java.util.*;

public class Albergo {
	private String nome;
	private Vector<Camera> camere;
	
	public Albergo(String nome) {
		if (nome != null)
			this.nome = nome;
		else
			throw new IllegalArgumentException("nome cannot be null");
		camere = new Vector<Camera>();
	}

	public String getNome() {
		return nome;
	}

	public Vector<Camera> getCamere() {
		return camere;
	}

	@Override
	public String toString() {
		return "Albergo [nome=" + nome + ", numeroCamere=" + camere.size() + "]";
	}
	
}
