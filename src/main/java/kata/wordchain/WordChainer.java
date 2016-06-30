package kata.wordchain;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

class WordChainer {

	private final Map<Integer, List<String>> availableWordsByCharCount;

	WordChainer(Collection<String> wordList) {
		availableWordsByCharCount = wordList.stream().collect(groupingBy(String::length));
	}

	Optional<WordChain> find(String from, String to) {
		return ifValidInput(from, to)
				? findChain(asList(new WordChain(from)), to)
				: Optional.empty();
	}

	private boolean ifValidInput(String from, String to) {
		return !from.isEmpty() && !to.isEmpty() && from.length() == to.length();
	}

	private Optional<WordChain> findChain(List<WordChain> chains, String to) {
		chains = findNextChainsFor(chains);
		if (chains.isEmpty())
			return Optional.empty();
		Optional<WordChain> match = matches(chains, to);
		return match.isPresent()
				? match
				: findChain(chains, to);
	}

	private List<WordChain> findNextChainsFor(List<WordChain> chains) { // visible for testing
		return chains.stream()
				.flatMap(this::findNextChainsFor)
				.collect(toList());
	}

	Stream<WordChain> findNextChainsFor(WordChain chain) { // visible for testing
		String word = chain.lastWord();
		List<String> candidates = availableWordsByCharCount.get(word.length());
		return candidates.stream()
				.filter(candidate -> byCorrespondingCharsIn(word, candidate))
				.filter(candidate -> byIgnoringDuplicates(chain, candidate))
				.map(chain::append);
	}

	private Optional<WordChain> matches(List<WordChain> chains, String to) {
		return chains.stream().filter(candidate -> candidate.lastWord().equals(to)).findFirst();
	}

	private boolean byIgnoringDuplicates(WordChain chain, String candidate) {
		return !chain.contains(candidate);
	}

	private boolean byCorrespondingCharsIn(String word1, String word2) {
		return matchCount(word1, word2) == word1.length() - 1;
	}

	// visible for testing
	int matchCount(String word1, String word2) {
		return range(0, word1.length()).map(i -> word1.charAt(i) == word2.charAt(i) ? 1 : 0).sum();
	}
}
