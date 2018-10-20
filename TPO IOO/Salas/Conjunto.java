package Salas;

public class Conjunto {
	class Nodo {
		String val;
		Nodo sig;
	}
	Nodo cabeza;
	int cant;

	public Conjunto() {
		cabeza = null;
		cant = 0;
	}

	public void agregar(String dato) {
		if (!this.pertenece(dato)) {
			Nodo nuevo = new Nodo();
			nuevo.val = dato;
			nuevo.sig = cabeza;
			cabeza = nuevo;
			cant++;
		}
	}

	public void sacar(String dato) {
		Nodo act = cabeza, ant = null;
		while (act != null && !act.val.equals(dato)) {
			ant = act;
			act = act.sig;
		}
		if (ant == null && act != null) {
			act = act.sig;
			cabeza = act;
			cant--;
		}
		else if (act != null) {
			ant.sig = act.sig;
			cant--;
		}
	}

	public String elegir() {
		int num, cont = 0;
		num = (int) (Math.random() * cant);
		Nodo act = cabeza;
		while (act != null && cont < num) {
			act = act.sig;
			cont++;
		}
		if (act != null)
			return act.val;
		else
			return null;
	}

	public boolean conjuntoVacio() {
		return cabeza == null;
	}

	public boolean pertenece(String dato) {
		Nodo act = cabeza;
		while (act != null && !act.val.equals(dato))
			act = act.sig;
		if (act != null)
			return true;
		else
			return false;
	}
}
