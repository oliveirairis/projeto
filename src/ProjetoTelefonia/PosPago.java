package ProjetoTelefonia;

import java.util.Date;

public class PosPago extends Assinante{
	private float assinatura;
	private int contChamadas;

	public PosPago(int numero, long cpf, String nome, float assinatura) {
		super(numero, cpf, nome);
		this.assinatura = assinatura;
		this.contChamadas = 0;
	}
	
	public void fazerChamada(Date data, int duracao) {
		this.assinatura =  duracao * 1.04f; 
		
		if (chamadas.length > 0) {
		this.chamadas[this.numChamadas - 1] = new Chamada(data, duracao);
		this.numChamadas = this.numChamadas - 1;
		this.contChamadas += 1;
		
		//System.out.println(this.numChamadas);
		}
	}
	
	public void imprimirFatura() {
		//System.out.println(this.chamadas[0].toString());
		System.out.println(contChamadas);
		for(int i =0; i <= contChamadas; i ++) {
			System.out.println("Data: " + this.chamadas[i].getData());
			System.out.println("Duração: " +this.chamadas[i].getDuracao());
		}
	}
	
	
	public static void main(String[] args) {
		PosPago p = new PosPago(3, 41394876823L, "Iris", 10f);
		
		p.fazerChamada(new Date(),10);
		p.fazerChamada(new Date(),100);
		
		p.imprimirFatura();
		System.out.println(p.toString());
		
	}
	
}
