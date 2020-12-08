package domain;

public class Cliente {
	private String nome;
	private Integer dataNascimento;
	private Estilo estilo;

	public Cliente(String nome, Integer dataNascimento, Estilo estilo) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.estilo = estilo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Integer dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

}
