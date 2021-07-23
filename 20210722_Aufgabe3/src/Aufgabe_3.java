
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aufgabe_3 {

	static List<Flear> Flears = new ArrayList<>();

	public static void main(String[] args) {

		fillList();
		getOptimalValue(8, Flears);
	}

	
	/*
	 * fills the list with random values
	 */
	public static void fillList() {

		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			Flears.add(new Flear("Test" + i, rand.nextFloat() * i, i));
		}
	}

	
	/*
	 * @Param money  -> Value that indicates the maximum limit of the combination price
	 * @Param flears -> List of all elements
	 */
	public static int getOptimalValue(float money, List<Flear> flears) {
		int res = 0;

		List<Flear> combinations = new ArrayList<>();

		for (int i = 0; i < flears.size(); i++) {
			combinations.clear();
			combinationUtil(flears, combinations, 0, flears.size()-1, 0 , i);
			System.out.println(combinations);
		}

		
		/*Berechnung der optimalen Kombination fehlt.
		  Idee war es, alle möglichen Kombinationen zu generieren und jeweils
		  die Kombination (bzw. das zugehörige Result) abzuspeichern und am Ende auszugeben.
		  Leider bin ich hier zu keiner passenden Lösung gekommen, um alle Kombinationen zu generieren,
		  somit fehlt mir hier der Teil der Berechnung.
		 */
		
		return res;
	}

	static void combinationUtil(List<Flear> arr, List<Flear> data, int start, int end, int index, int r) {

		if (index == r) {
			return;
		}

		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data.add(arr.get(i));
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
	}
}
