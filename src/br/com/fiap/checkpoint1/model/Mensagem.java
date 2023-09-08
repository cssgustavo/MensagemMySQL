package br.com.fiap.checkpoint1.model;

import java.time.LocalDate;
import java.sql.Date;

public class Mensagem {

	private long id;
	private String assunto;
	private String destinatario;
	private String remetente;
	private LocalDate data;
	private String conteudo;
	private int prioridade;

	public Mensagem(long id, String assunto, String destinatario, String remetente, LocalDate data, String conteudo,
			int prioridade) {

		super();
		this.id = id;
		this.assunto = assunto;
		this.destinatario = destinatario;
		this.remetente = remetente;
		this.data = data;
		this.conteudo = conteudo;
		this.prioridade = prioridade;

	}

	public Mensagem() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getRemetente() {
		return remetente;
	}

	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

}
