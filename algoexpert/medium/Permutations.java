import java.util.*;

public class Permutations {

    public static ArrayList<ArrayList<Integer>> getPermutations(List<Integer> array) {
		ArrayList<ArrayList<Integer>> listas = new ArrayList<ArrayList<Integer>>();
		if (array.size() == 0) {
			return listas;
		};
		int n = array.size();
		listas.add(
				new ArrayList<Integer>(Arrays.asList(array.get(0)))
		);
		while (true) {
				System.out.println(listas);
				ArrayList<Integer> lista_actual = listas.get(0);
				listas.remove(0);
				int len_actual = lista_actual.size();

				if (len_actual >= n) {
						listas.add(0, lista_actual);
						break;
				};

				for (int i = 0; i < len_actual + 1; i++) {
						ArrayList<Integer> nueva_lista = new ArrayList<>(lista_actual);
						nueva_lista.add(i, array.get(len_actual));
						listas.add(listas.size(), nueva_lista);
				}
		};
		return listas;
    }
    
    public static void main(String[] args) {

        ArrayList<Integer> ex = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<ArrayList<Integer>> res = getPermutations(ex);
        
        System.out.println(res);
    }
}
