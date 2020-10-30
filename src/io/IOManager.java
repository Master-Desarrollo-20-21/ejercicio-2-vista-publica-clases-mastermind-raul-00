package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOManager {

	private static BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

	public String inString() {
		String entrada = null;
		try {
			entrada = b.readLine();
		} catch (Exception e) {
			this.salir();
		}
		return entrada;
	}

	public void out(String salida) {
		System.out.print(salida);
	}

	public void outln(String salida) {
		System.out.println(salida);
	}

	public void outln() {
		System.out.println("");
	}

	private void salir() {
		System.out.println("ERROR I/O");
		System.exit(0);
	}
}