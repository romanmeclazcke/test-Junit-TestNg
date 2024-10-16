package org.example.restaurant;
import java.util.Date;
import java.util.regex.Pattern;

public class Usuario {
static int nextID;
int id;
String nombreYApellido;
int tipoUsuario;
float saldoCuenta;
Date ultimaRecarga;
String email;
public Usuario(String nombreYApellido, int tipoUsuario, float saldoCuenta,String email) {
	super();
	this.nombreYApellido = nombreYApellido;
	this.tipoUsuario = tipoUsuario;
	this.saldoCuenta = saldoCuenta;
	this.email=email;
}

public void cargarCredito(float cuanto) {
	saldoCuenta+=cuanto;
	
}
float descontarSaldo(float cuanto) throws SinSaldoException {
	if((saldoCuenta-cuanto)<0) throw new SinSaldoException();
	else
		saldoCuenta-= cuanto;
	return saldoCuenta;
	
}
float getSaldo() {
	return saldoCuenta;
}

	// Sobrescribimos equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true; // Si es el mismo objeto, son iguales
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false; // Si el objeto es null o de una clase diferente, no son iguales
		}
		Usuario usuario = (Usuario) obj;
		return email.equals(usuario.email); // Comparamos por el campo email
	}

	public boolean emailEsValido() {
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(this.email).matches();
	}

}



