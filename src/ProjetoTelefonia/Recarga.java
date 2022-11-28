package ProjetoTelefonia;

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
	}

