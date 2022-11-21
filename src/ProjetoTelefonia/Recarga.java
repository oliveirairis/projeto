package ProjetoTelefonia;

import java.util.Calendar;

import java.util.Date;

public class Recarga {
	private float valor;
	private Date data;
	
	public Recarga(Date data, float valor) {
		this.data = data;
		this.valor = valor;
	}
	
	public Date getData() {
		return data;
	}
	
	public float getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return "Recarga [data=" + data + ", valor=" + valor + " reais]";
	}
	
	public static void main(String[] args) {
		Calendar ca = Calendar.getInstance();
		 //ca.set(2022,03,18);
		 Date d = ca.getTime();
		 
		 Recarga r = new Recarga(d, 50);
		 System.out.println(r.toString());
	}
	}

