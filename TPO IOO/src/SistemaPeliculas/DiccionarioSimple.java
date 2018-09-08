package SistemaPeliculas;

public class DiccionarioSimple {
	class Nodo {
		String clave;
		boolean valor;
		Nodo sig;
	}
	Nodo cabeza;

	public DiccionarioSimple() {
		cabeza = null;
	}

	public void agregar(String cl, boolean v) {
		Nodo act = cabeza;
		while (act != null && !act.clave.equals(cl))
			act = act.sig;
		if (act == null) {
			Nodo nuevo = new Nodo();
			nuevo.clave = cl;
			nuevo.valor = v;
			nuevo.sig = cabeza;
			cabeza = nuevo;
		}
		else
			act.valor = v;
	}

	public void eliminar(String cl) {
		Nodo act = cabeza, ant = null;
		while (act != null && !act.clave.equals(cl)) {
			ant = act;
			act = act.sig;
		}
		if (act != null && ant != null)
			ant.sig = act.sig;
		else if (act != null)
			cabeza = cabeza.sig;
	}

	public boolean recuperar(String cl) {
		Nodo act = new Nodo();
		act = cabeza;
		while (act != null && !act.clave.equals(cl))
			act = act.sig;
		return act.valor;
	}

	public Conjunto claves() {
		Nodo act = new Nodo();
		Conjunto aux = new Conjunto();
		act = cabeza;
		while (act != null) {
			aux.agregar(act.clave);
			act = act.sig;
		}
		return aux;
	}
}
