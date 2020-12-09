package domain;

public class Cliente {
	private String nome;
	private Integer idade;
	private Estilo estilo;
	
	public Cliente(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public Cliente(String nome, Integer idade, Estilo estilo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.estilo = estilo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDataNascimento() {
		return idade;
	}

	public void setDataNascimento(Integer idade) {
		this.idade = idade;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

}
