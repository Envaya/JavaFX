package ch.fhnw.oop2.module03.bottleanddrink;

/**
 * @author Dieter Holz
 */
public class Bottle<T> {
	T content;

	public Bottle() {
	}

	public void fill(T content) {
		this.content = content;
	}

	public T empty() {
		T c = content;
		content = null;

		return c;
	}

}
