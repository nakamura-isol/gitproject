package gitproject.ConvertFile;

//変換済みエントリを一時保持する簡単なコンテナ
public class EntryBuffer {
	final String name;
	final byte[] data;

	EntryBuffer(String name, byte[] data) {
		this.name = name;
		this.data = data;
	}

	
}
