package pruebas;

import java.util.ArrayList;
import java.util.List;

public class Programame {
	List<String> salida;
	String vocales[] = { "a", "A", "e", "E", "i", "I", "o", "O", "u", "U" };

	public List<String> problemaA(List<String> entrada) {
		salida = new ArrayList<>();
		if (entrada.size() < 1) {
			salida.add("ERROR");
			return salida;
		}
		int n_Operaciones = Integer.parseInt(entrada.get(0));
		for (int i = 1; i <= n_Operaciones; i++) {
			int z = entrada.get(i).indexOf(" ", 0);
			int x = 0;
			String num[];
			num = new String[3];
			int indi = 0;
			while (z != -1) {
				num[indi] = (entrada.get(i).substring(x, z));
				x = z + 1;
				z = x;
				z = entrada.get(i).indexOf(" ", z);
				indi++;
			}
			num[indi] = entrada.get(i).substring(x, entrada.get(i).length());
			if (num[1].equals("+"))
				salida.add("" + (Integer.parseInt(num[0]) + Integer.parseInt(num[2])));
			if (num[1].equals("-"))
				salida.add("" + (Integer.parseInt(num[0]) - Integer.parseInt(num[2])));
			if (num[1].equals("*"))
				salida.add("" + (Integer.parseInt(num[0]) * Integer.parseInt(num[2])));
			if (num[1].equals("/")) {
				if (num[0].equals("0") || num[2].equals("0"))
					salida.add("ERROR");
				else
					salida.add("" + (Integer.parseInt(num[0]) / Integer.parseInt(num[2])));
			}
		}
		return salida;
	}

	public List<String> problemaB(List<String> entrada) {
		salida = new ArrayList<>();
		if (entrada.size() < 1) {
			salida.add("ERROR");
			return salida;
		}
		int n_Operaciones = Integer.parseInt(entrada.get(0));
		for (int i = 1; i <= n_Operaciones; i++) {
			List<String> palabraLimpia = new ArrayList<>();
			int x = 0;
			int y = 1;
			for (int j = 0; j < entrada.get(i).length(); j++) {
				if (!comprovar(entrada.get(i).substring(x, y)))
					palabraLimpia.add((entrada.get(i).substring(x, y).toLowerCase()));
				x += 1;
				y += 1;

			}

			String letra = palabraLimpia.get(0);
			Boolean ordenada = true;
			if (palabraLimpia.size() > 1)
				for (int j = 1; j < palabraLimpia.size(); j++) {
					if (letra.compareTo(palabraLimpia.get(j)) > 0) {
						ordenada = false;
					}
					letra = palabraLimpia.get(j);

				}
			if (ordenada)
				salida.add("ERROR");
			else
				salida.add("OK");
		}
//			

		return salida;
	}

	public List<String> problemaC(List<String> entrada) {
		salida = new ArrayList<>();
		if (entrada.size() < 1) {
			salida.add("ERROR");
			return salida;
		}

		int n_Operaciones = Integer.parseInt(entrada.get(0));
		for (int i = 1; i <= n_Operaciones; i++) {
			List<String> almacenPrimos = new ArrayList<>();
			int numMax = Integer.parseInt(entrada.get(i));
			for (int j = numMax; j > 9; j--) {
				Boolean primo = true;
				for (int x = 2; x < j; x++)
					if (j % x == 0) {
						primo = false;
						break;
					}
				if (primo)
					almacenPrimos.add("" + j);
			}
			int cont = 0;
			for (int j = 0; j < almacenPrimos.size(); j++) {
				if (almacenPrimos.get(j).substring(0, 1).equals("1"))
					cont++;
			}
			salida.add("" + cont);
		}
		return salida;
	}

	public List<String> problemaD(List<String> entrada) {
		ArrayList salida = null;
		return salida;
	}

	public List<String> problemaE(List<String> entrada) {
		salida = new ArrayList<>();
		if (entrada.size() < 1) {
			salida.add("ERROR");
			return salida;
		}

		int n_Operaciones = Integer.parseInt(entrada.get(0));
		for (int i = 1, i2 = 1; i <= n_Operaciones; i++) {
			salida.add("Caso " + i + ":");
			int oxigeno = Integer.parseInt(entrada.get(i2));
			int n_Naves = Integer.parseInt(entrada.get(i2 + 1));
			int valores[][] = new int[n_Naves][2];
			for (int j = 0; j < n_Naves; j++) {
				valores[j][0] = Integer
						.parseInt(entrada.get(j + i2 + 2).substring(0, entrada.get(j + i2 + 2).indexOf(" ")));
				valores[j][1] = Integer.parseInt(entrada.get(j + i2 + 2)
						.substring(entrada.get(j + i2 + 2).indexOf(" ") + 1, entrada.get(j + i2 + 2).length()));
			}

			for (int x = 0; x < (valores.length - 1); x++) {
				for (int j = x + 1; j < valores.length; j++) {
					if (valores[x][1] > valores[j][1]) {
						int variableauxiliar1 = valores[x][1];
						int variableauxiliar0 = valores[x][0];
						valores[x][1] = valores[j][1];
						valores[x][0] = valores[j][0];
						valores[j][1] = variableauxiliar1;
						valores[j][0] = variableauxiliar0;
					}
				}
			}
			for (int x = valores.length - 1; x > 0; x--) {
				for (int j = x - 1; j > -1; j--) {
					if (valores[x][0] >= oxigeno && valores[x][0] > valores[j][0]) {
						int variableauxiliar1 = valores[x][1];
						int variableauxiliar0 = valores[x][0];
						valores[x][1] = valores[j][1];
						valores[x][0] = valores[j][0];
						valores[j][1] = variableauxiliar1;
						valores[j][0] = variableauxiliar0;
					}
				}
			}

			for (int j = 0; j < valores.length; j++)
				salida.add(valores[j][0] + " " + valores[j][1]);
			i2 += n_Naves + 2;

		}
		return salida;

	}

	private boolean comprovar(String letra) {
		for (int i = 0; i < vocales.length; i++) {
			if (letra.equals(vocales[i]))
				return true;
		}
		return false;

	}
}

