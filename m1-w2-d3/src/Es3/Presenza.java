package Es3;

public class Presenza {

	private String nome;
	private int nGiorniPresenza;
	public Presenza(String nome, int nGiorniPresenza) {
		
		this.nome = nome;
		this.nGiorniPresenza = nGiorniPresenza;
	}
	public Presenza(String nome) {
		
		this.nome = nome;
		this.nGiorniPresenza=0;
	}
	public String getNome() {
		return nome;
	}
	public int getnGiorniPresenza() {
		return nGiorniPresenza;
	}
	
		
	
}
