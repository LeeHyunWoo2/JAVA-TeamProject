package hotelProject.crime;

import java.util.ArrayList;
import java.util.List;

public class SuspectDTO {

	String suspectName;
	boolean killer;
	boolean liar;
	List<String> scripts;

	public SuspectDTO(String suspectName, boolean killer, boolean liar) {
		super();
		this.suspectName = suspectName;
		this.killer = killer;
		this.liar = liar;
		this.scripts = new ArrayList<>();
	}
	
	void makeScript(String script) {
		scripts.add(script);
	}

}
