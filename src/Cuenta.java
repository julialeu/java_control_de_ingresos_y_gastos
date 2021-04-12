import java.util.List;

public class Cuenta {

	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos;
	private List<Ingreso> ingresos;

	public Cuenta(Usuario usuario) {

		this.saldo = 0;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Gasto> getGastos() {
		return gastos;
	}

	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	public double addIngresos(String description, double cantidad) {

		this.saldo = saldo + cantidad;
		return saldo;
	}

}
