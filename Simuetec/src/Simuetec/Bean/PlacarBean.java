package Simuetec.Bean;

public class PlacarBean {

	
	int id,corretas,erradas,sessao;
	
	public int getSessao() {
		return sessao;
	}
	public void setSessao(int sessao) {
		this.sessao = sessao;
	}
	String nome,questao;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCorretas() {
		return corretas;
	}
	public void setCorretas(int corretas) {
		this.corretas = corretas;
	}
	public int getErradas() {
		return erradas;
	}
	public void setErradas(int erradas) {
		this.erradas = erradas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQuestao() {
		return questao;
	}
	public void setQuestao(String questao) {
		this.questao = questao;
	}
}
