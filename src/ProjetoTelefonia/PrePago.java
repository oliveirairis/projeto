package ProjetoTelefonia;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class PrePago extends Assinante{
	private int numRecargas;
	private Recarga[] recargas;
	private float creditos;
	
	public PrePago(long cpf, String nome, int numero) {
		super(numero, cpf, nome);
		this.recargas = new Recarga[10];
	}
	
	
	public void fazerChamada(Date data, int duracao) {
		float semCredito = duracao * 1.45f;
		this.numChamadas++;
		for (int i = 0; i < numChamadas; i++) {
			if (this.chamadas[i] == null && this.creditos > semCredito) {
				Chamada chamada = new Chamada(data, duracao);
				this.chamadas[i] = chamada;
				this.creditos = this.creditos - semCredito;
			}
			else {
				System.out.println("Você não possui créditos para realizar essa chamada.");
			}
		}
	}
	
	public void  recarregar(Date  data,  float valor) {
		this.numRecargas++;
		for (int i = 0; i < numRecargas; i++) {
			if (this.recargas[i] == null) {
				Recarga rec = new Recarga(data, valor);
				this.recargas[i] = rec;
				this.creditos = this.creditos + valor;
				//tirar depois
				System.out.println(this.creditos);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void imprimirFatura(int mes) {
		DecimalFormat formatador = new DecimalFormat("0.00");
		float valor = 0;
		float somaValor = 0;
		float rec = 0;
		for (int i = 0; i < numChamadas; i++) {
			if (this.chamadas[i].getData().getMonth() == mes) {
				valor = this.chamadas[i].getDuracao() * 1.45f;
				somaValor = valor + somaValor;
				rec = this.recargas[i].getValor() + rec;
				System.out.println(this.toString() + this.chamadas[i]);
				System.out.println("Valor da ligação: R$" + formatador.format(valor));
			}
		}
		System.out.println("Valor total das ligações: R$" + formatador.format(somaValor));
		for (int i = 0; i < numRecargas; i++) {
			if (this.recargas[i].getData().getMonth() == mes) {
				System.out.println(this.recargas[i]);
			}
		}
		System.out.println("Valor total de recargas: R$" + formatador.format(rec));
	}
	
	public static void main(String[] args) {
		PrePago p = new PrePago(41394876823L, "Iris", 997877240);
		
		
		
		Calendar ca = Calendar.getInstance();
		ca.set(2022,02,18);
		Date d = ca.getTime();
		 
		Calendar cu = Calendar.getInstance();
		cu.set(2022,12,18);
		Date du = cu.getTime(); 
		
		p.recarregar(d, 100);
		p.recarregar(du, 150);
		
		p.fazerChamada(du,10);
		p.fazerChamada(d,20);
		
		
		
		p.imprimirFatura(02);
		
	}
}
