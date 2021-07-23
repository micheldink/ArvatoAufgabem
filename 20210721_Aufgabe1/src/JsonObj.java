import java.util.ArrayList;
import java.util.List;

public class JsonObj {
	

	private List<String> onlyInList1  = new ArrayList<String>();
	private List<String> onlyInList2  = new ArrayList<String>();
	private List<String> InBothLists  = new ArrayList<String>();

	JsonObj(){	
	}
	
	public void setValues(List<String> pList1, List<String> pList2) {
		setOnlyInList1(GetValuesFromList1(pList1, pList2));
		setOnlyInList2(GetValuesFromList2(pList1, pList2));
		setInBothLists(GetValuesFromList3(pList1, pList2));
	}
	
	/*
	 * returns the words which are only in file one
	 * 
	 * @Param List1, List2 file with all values
	 */
	private List<String> GetValuesFromList1(List<String> pList1, List<String> pList2) {
		List<String> onlyList1 = new ArrayList<String>();
		pList1.forEach(x -> {
			if(pList2.indexOf(x) == -1) {
				onlyList1.add(x);
			}
		});
		return onlyList1;
	}
	
	/*
	 * returns the words which are only in file two
	 * 
	 * @Param List1, List2 file with all values
	 */
	private List<String> GetValuesFromList2(List<String> pList1, List<String> pList2) {
		List<String> onlyList2 = new ArrayList<String>();
		pList2.forEach(x -> {
			if(pList1.indexOf(x) == -1) {
				onlyList2.add(x);
			}
		});
		return onlyList2;
	}
	
	/*
	 * returns the words which are in both files
	 * 
	 * @Param List1, List2 file with all values
	 */
	private List<String> GetValuesFromList3(List<String> pList1, List<String> pList2) {
		List<String> inBothLists = new ArrayList<String>();
		pList2.forEach(x -> {
			pList1.forEach( y -> {
				if(x.equals(y)) {
					inBothLists.add(x);
				}
			});
		});
		return inBothLists;
	}

	public List<String> getOnlyInList1() {
		return onlyInList1;
	}

	public void setOnlyInList1(List<String> onlyInList1) {
		this.onlyInList1 = onlyInList1;
	}

	public List<String> getOnlyInList2() {
		return onlyInList2;
	}

	public void setOnlyInList2(List<String> onlyInList2) {
		this.onlyInList2 = onlyInList2;
	}

	public List<String> getInBothLists() {
		return InBothLists;
	}

	public void setInBothLists(List<String> inBothLists) {
		InBothLists = inBothLists;
	}
}
