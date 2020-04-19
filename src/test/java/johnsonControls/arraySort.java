package johnsonControls;

import java.util.Comparator;

public class arraySort implements Comparator<JohnsonControls>{

	public int compare(JohnsonControls a, JohnsonControls b) {
		
		return a.section - b.section;
	}

}
