package javadrill.exercise015.question007;

public class Main {

	public static void main(String[] args) {
		Instrument instrument = new Instrument();
		Piano piano = new Piano();
		instrument.play();
		piano.play();
		
		instrument = piano;
		instrument.play();
		
	}

}
