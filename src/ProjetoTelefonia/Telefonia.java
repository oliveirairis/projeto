package ProjetoTelefonia;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Telefonia {
	private PrePago[] prepagos;
	private int numPrePagos;
	private PosPago[] pospagos;
	private int numPosPagos;
	PrePago creditos;

	public Telefonia() {
		super();
		this.prepagos = new PrePago[100];
		this.pospagos = new PosPago[100];
	}

	public void cadastrarAssinante(int opcao, String nome, long cpf, int numero, float assinatura) {
		if(opcao == 1) {
			this.numPosPagos++;
			for (int i = 0; i < numPosPagos; i++) {
				if (this.pospagos[i] == null) {
					PosPago posp = new PosPago(numero, cpf, nome, assinatura);
					this.pospagos[i] = posp;
				} 
			}
			
		} else if (opcao == 2) {
			this.numPrePagos++;
			for (int i = 0; i < numPrePagos; i++) {
				if (this.prepagos[i] == null) {
					PrePago prep = new PrePago(cpf, nome, numero);
					this.prepagos[i] = prep;
				} 
			}
		}
	}
	
	public void listarAssinantes() {
		for (int i = 0; i < numPrePagos; i++) {
			if (this.prepagos[i] != null){
			System.out.println(this.prepagos[i].toString());
			}
		}
		System.out.println();
		for (int i = 0; i < numPosPagos; i++) {
			if(this.pospagos[i] != null) {
			System.out.println(this.pospagos[i].toString());
			}
		}
	}
	
	public void fazerChamada(int opcao, long cpf, Date data, int duracao) {
		System.out.println(opcao);
		if (opcao == 1) { 
			if (this.localizarPosPago(cpf) != null) {
				PosPago cham = this.localizarPosPago(cpf);
				cham.fazerChamada(data, duracao);
				System.out.println("A chamada foi realizada.");
			} else {
				System.out.println("O assinante não foi encontrado no sistema.");
			}
		} else if (opcao == 2) {
			if (this.localizarPrePago(cpf) != null && creditos != null) {
				PrePago cham = this.localizarPrePago(cpf);
				cham.fazerChamada(data, duracao);
				System.out.println("A chamada foi realizada.");
			} else if(this.localizarPrePago(cpf) == null){
				System.out.println("O assinante não foi encontrado no sistema."); 
			} else {
				System.out.println("Você não possui crédito para realizar essa chamada.");
			}
		} else {
			System.out.println("Escolha outra opção.");
		}
	}
	
	public void fazerRecarga(long cpf, float valor, Date data) {
		if (this.localizarPrePago(cpf) != null) {
			PrePago rec = this.localizarPrePago(cpf);
			rec.recarregar(data, valor);
			System.out.println("Recarga realizada."); 
		} else {
			System.out.println("O assinante não foi encontrado no sistema."); 
		}
	}
	
	public PrePago localizarPrePago(long cpf) {
		for (int i = 0; i < numPrePagos; i++) {
			if (this.prepagos[i] != null) {
				if (this.prepagos[i].getCpf() == cpf) {
					//System.out.println("estou no localizar prepago");
					return this.prepagos[i];
			}
			} else {
				System.out.println("to aqui");
				return null;
			}
		}
		return null;
	}

	public PosPago localizarPosPago(long cpf) {
		for (int i = 0; i < numPosPagos; i++) {
			if (this.pospagos[i].getCpf() == cpf) {
				return this.pospagos[i];
			} else {
				return null;
			}
		}
		return null;
	}
	
	public void imprimirFaturas(int mes) {
		for (int i = 0; i < numPrePagos; i++) {
			if (this.prepagos[i] != null){
				//mudar isso
			long cpf =	this.prepagos[i].getCpf();
			PrePago prep = new PrePago(cpf, "Iris", 123);
			prep.imprimirFatura(mes);
			}
		}
		System.out.println();
		for (int i = 0; i < numPosPagos; i++) {
			if(this.pospagos[i] != null) {
				//mudar isso
				PosPago posp = new PosPago(321, 321, "Julia", 10);
				posp.imprimirFatura(mes);
			}
		}
	}
	
	public static void main(String[] args) {
		Telefonia t = new Telefonia();
		
		
		Calendar ca = Calendar.getInstance();
		ca.set(2022,02,18);
		Date d = new Date();
		 
		Calendar cu = Calendar.getInstance();
		cu.set(2022,12,18);
		Date du = cu.getTime(); 
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		int op = 0;
		int x = 0;
		String nome = "";
		long cpf = 0;
		int numero = 0;
		int duracao = 0;
		int pp = 0;
		float assinatura = 0;
		float rec = 0;
		int mes = 0;
		Chamada[] chamada = new Chamada[10];
		while (op != 6) {
			System.out.println("Digite uma opção: ");
			System.out.println("1 - Cadastrar assinante");
			System.out.println("2 - Listar assinantes");
			System.out.println("3 - Fazer chamada");
			System.out.println("4 - Fazer recarga");
			System.out.println("5 - Imprimir faturas");
			System.out.println("6 - Sair");
			op = s.nextInt();
			if (op == 1) {
				//Cadastrar assinante
				System.out.println("A assinatura será de: ");
				System.out.println("1 - Pós Pago");
				System.out.println("2 - Pré Pago");
				pp = s.nextInt();
				if (pp == 1) {
					System.out.println("Nome: ");
					nome = s.next();
					System.out.println("CPF: ");
					cpf = s.nextLong();
					System.out.println("Número: ");
					numero = s.nextInt();
					System.out.println("Assinatura: ");
					assinatura = s.nextFloat();
					
				} else if (pp == 2) {
					//Listar assinantes
					System.out.println("Nome: ");
					nome = s.next();
					System.out.println("CPF: ");
					cpf = s.nextLong();
					System.out.println("Número: ");
					numero = s.nextInt();
				} else {
					System.out.println("Escolha outra opção.");
				}
				t.cadastrarAssinante(pp, nome, cpf, numero, assinatura);
			}
			else if (op == 2) {
				t.listarAssinantes();
			}
			else if (op == 3) {
				//Fazer chamada
				System.out.println("Sua assinatura é: ");
				System.out.println("1 - Pós Pago");
				System.out.println("2 - Pré Pago");
				pp = s.nextInt();
				System.out.println("Digite seu CPF: ");
				cpf = s.nextLong();
				System.out.println("Digite a duração da ligação: ");
				duracao = s.nextInt();
				t.fazerChamada(pp, cpf, d, duracao);
			}
			else if (op == 4) {
				//Fazer recarga
				System.out.println("Digite seu CPF: ");
				cpf = s.nextLong();
				System.out.println("Digite o valor da recarga, em reais: ");
				rec = s.nextFloat();
				t.fazerRecarga(cpf, rec, d);
			}
			else if(op == 5) {
				//Imprimir faturas
				System.out.println("Digite o mês em que deseja visualizar as faturas: ");
				mes = s.nextInt();
				t.imprimirFaturas(mes);
			}
		}
		
	}
}
