package gestionealbergo;

public class Cliente {
	private String nome;
	private String cognome;
	private String cellulare;
	private String email;
	
	public Cliente(String nome, String cognome, String cellulare) {
		if(nome != null)
			this.nome = nome;
		else
			throw new IllegalArgumentException("nome cannot be null");
		
		if(cognome != null)
			this.cognome = cognome;
		else
			throw new IllegalArgumentException("cognome cannot be null");
		
		if (cellulare != null)
			this.cellulare = cellulare;
		else
			throw new IllegalArgumentException("cellulare cannot be null");
	}
	
	public Cliente(String nome, String cognome, String cellulare, String email) {
		if(nome != null)
			this.nome = nome;
		else
			throw new IllegalArgumentException("nome cannot be null");
		
		if(cognome != null)
			this.cognome = cognome;
		else
			throw new IllegalArgumentException("cognome cannot be null");
		
		if (cellulare != null)
			this.cellulare = cellulare;
		else
			throw new IllegalArgumentException("cellulare cannot be null");
		
		if(email != null)
			this.email = email;
		else
			throw new IllegalArgumentException("email cannot be null");
	} 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email != null)
			this.email = email;
		else
			throw new IllegalArgumentException("email cannot be null");
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getCellulare() {
		return cellulare;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cognome=" + cognome
				+ ", cellulare=" + cellulare + ", email=" + email + "]";
	}
	
	
}
