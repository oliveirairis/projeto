package ProjetoTelefonia;

import java.util.Calendar;
import java.util.Date;
import java.text.DecimalFormat;

public class PosPago extends Assinante{
	private float assinatura;
	

	public PosPago(int numero, long cpf, String nome, float assinatura) {
		super(numero, cpf, nome);
		this.assinatura = assinatura;
	}
	
	public void fazerChamada(Date data, int duracao) { 
		numChamadas++;
		
		for(int i = 0; i < numChamadas; i++) {
			if (this.chamadas[i] == null) {
				Chamada chamada = new Chamada(data, duracao);
				this.chamadas[i] = chamada;
			}	
		}
	}
	
	@SuppressWarnings("deprecation")
	public void imprimirFatura(int mes) {
		DecimalFormat formatador = new DecimalFormat("0.00");
		float valor = 0;
		float somaValor = 0;
		float fatura = 0;
		for(int i = 0; i < numChamadas; i ++) {
			if(this.chamadas[i].getData().getMonth() == mes) {
				valor = this.chamadas[i].getDuracao() * 1.04f;
				somaValor = valor + somaValor;
				System.out.println(this.toString());
				System.out.println("Valor da ligação: R$" + formatador.format(valor));
				System.out.println(this.chamadas[i]);
			}
			fatura = somaValor + assinatura;
		}
		System.out.println("Assinatura: R$" + formatador.format(this.assinatura));
		System.out.println("Valor da fatura: R$" + formatador.format(fatura));
	}
	
	
	public static void main(String[] args) {
		PosPago p = new PosPago(3, 41394876823L, "Iris", 10);
		PosPago c = new PosPago(3, 41394876823L, "Juliana", 20);
		
		Calendar ca = Calendar.getInstance();
		ca.set(2022,02,18);
		Date d = ca.getTime();
		 
		Calendar cu = Calendar.getInstance();
		cu.set(2022,12,18);
		Date du = cu.getTime(); 
		
		p.fazerChamada(d,10);
		c.fazerChamada(d,10);
		c.fazerChamada(d,30);
		
		
		//p.imprimirFatura(02);
		c.imprimirFatura(02);
		p.imprimirFatura(02);
		//System.out.println(p.toString());
		
	}
	
}
