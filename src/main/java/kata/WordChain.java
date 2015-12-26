package kata;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

public class WordChain {

	private final List<String> path;

	public WordChain(String start) {
		this.path = asList(start);
	}

	public WordChain(List<String> path) {
		this.path = unmodifiableList(path);
	}

	public List<String> path() {
		return path;
	}

	public WordChain append(String word) {
		List<String> newPath = new ArrayList<>(path);
		newPath.add(word);
		return new WordChain(newPath);
	}

	public boolean contains(String word) {
		return path.contains(word);
	}

	public String lastWord() {
		return path.get(path.size() - 1);
	}
}
