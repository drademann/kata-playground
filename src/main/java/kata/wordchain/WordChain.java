package kata.wordchain;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

class WordChain {

    private final List<String> path;

    WordChain(String start) {
        path = asList(start);
    }

    WordChain(List<String> path) {
        this.path = unmodifiableList(path);
    }

    List<String> path() {
        return path;
    }

    WordChain append(String word) {
        List<String> newPath = new ArrayList<>(path);
        newPath.add(word);
        return new WordChain(newPath);
    }

    boolean contains(String word) {
        return path.contains(word);
    }

    String lastWord() {
        return path.get(path.size() - 1);
    }

}
