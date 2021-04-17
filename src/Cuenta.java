import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	
	//Los atributos de la clase
	private double saldo;
	private Usuario usuario;
	private List<Gasto> gastos;
	private List<Ingreso> ingresos;

	//Constructor. En el mismo inicializo los arrayList
	public Cuenta(Usuario usuario) {
        this.usuario = usuario;
		this.saldo = 0;
		this.ingresos = new ArrayList<Ingreso>();
		this.gastos = new ArrayList<Gasto>();
	}
	
	//getters y setters de los atributos de la clase
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
		//añado un ingreso
		Ingreso nuevoIngreso = new Ingreso(cantidad, description);
	    this.ingresos.add(nuevoIngreso);
		
	    //se actualiza el importe del saldo y lo devolvemos en el return
		this.saldo = this.saldo + cantidad;

		return this.saldo;
	}
	
	public double addGastos(String description, double cantidad) throws GastoException {
		
		/*comprobamos si hay saldo suficiente, sino hay saldo
		 suficiente, se lanza la excepción. */
		
	    if (this.saldo < cantidad) {
	    	
	    	throw new GastoException();
	    }
	    
	    Gasto nuevoGasto = new Gasto(cantidad, description);
	    this.gastos.add(nuevoGasto);
	    
		this.saldo = this.saldo - cantidad;
		return this.saldo;
	}
	
	public String toString() { 
		//no se especifica nada más en la pac y solo pongo que devuelva el nombre del usuario
		return "Nombre: " + getUsuario().getNombre() + ", Saldo: " + getSaldo() + " €";
	}
	
	

}
