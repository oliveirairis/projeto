package ProjetoTelefonia;

import java.util.Calendar;
import java.util.Date;

public class PosPago extends Assinante{
	private float assinatura;

	public PosPago(int numero, long cpf, String nome, float assinatursa) {
		super(numero, cpf, nome);
		this.assinatura = assinatura;
	}
	
	public void fazerChamada(Date data, int duracao) {
		float valor =  duracao * 1.04f; 
		
		for(int i = 0; i < this.chamadas.length; i++) {
			if (this.chamadas[i] == null) {
				Chamada chamada = new Chamada(data, duracao);
				this.chamadas[i] = chamada;
			}
		}
	}
	
	public void imprimirFatura(int mes) {
		//System.out.println(this.chamadas[0].toString());
		for(int i =0; i < this.chamadas.length; i ++) {
			if(this.chamadas[i].getData().getMonth() == mes) {
			System.out.println("Data: " + this.chamadas[i].getData());
			System.out.println("Duração: " +this.chamadas[i].getDuracao());
			System.out.println(this.chamadas[i]);
			}
		}
	}
	
	
	public static void main(String[] args) {
		PosPago p = new PosPago(3, 41394876823L, "Iris", 1f);
		
		Calendar ca = Calendar.getInstance();
		ca.set(2022,02,18);
		Date d = ca.getTime();
		 
		p.fazerChamada(d,10);
		p.fazerChamada(new Date(),100);
		
		
		p.imprimirFatura(02);
		//System.out.println(p.toString());
		
	}
	
}
