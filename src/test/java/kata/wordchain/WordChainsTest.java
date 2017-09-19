package kata.wordchain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

/**
 * <strong>Requirements</strong>
 * <p>
 * <p>This feature tries to find a way to get from one word to another by changing only one letter per step.
 * The length of the word doesn't change and the word must be a valid and known english word and not some
 * fantasy creation.</p>
 * <p>
 * <p>In example you can get from cat to dog this way:</p>
 * <p>
 * <p>cat - cot - cog - dog</p>
 * <p>
 * <p><i>ps.</i> find a long list of words in {@code src/test/java/resources}</p>
 */
class WordChainsTest {

	private WordChainer wordChainer;

	@BeforeEach
	void setUp() throws Exception {
		wordChainer = new WordChainer(asList(
				"a", "b",
				"aa", "ab", "ac", "bb",
				"aaa", "baa", "bab"
		));
	}

	@Test
	void givenEmptyString_returnsListWithEmptyString() {
		assertThat(wordChainer.find("", "")).isEmpty();
	}

	@Test
	void givenFromToWithDifferentLength_returnsEmptyOptional() {
		assertThat(wordChainer.find("a", "bb")).isEmpty();
	}

	@Test
	void givenOneCharDifference_returnListWithFromTo() {
		Optional<WordChain> wordChain = wordChainer.find("aa", "ab");
		if (wordChain.isPresent()) {
			assertThat(wordChain.get().path()).containsExactly("aa", "ab");
		}
		else {
			fail("wordchain is empty");
		}
	}

	@Test
	void givenTwoWords_whenCountingCharMatches_shouldReturnNumberOfCharsEqualAtSamePosition() {
		assertThat(wordChainer.matchCount("a", "a")).isEqualTo(1);
		assertThat(wordChainer.matchCount("aa", "aa")).isEqualTo(2);
		assertThat(wordChainer.matchCount("aab", "aac")).isEqualTo(2);
		assertThat(wordChainer.matchCount("abc", "xyz")).isEqualTo(0);
	}

	@Test
	void givenOneWord_whenSearchingNextAvailables_shouldReturnWordsWithOnlyOneDifferentChar() {
		assertThat(findNextWordsFor("a")).containsExactly("b");
		assertThat(findNextWordsFor("aa")).containsExactly("ab", "ac");
	}

	@Test
	void givenListOfWords_whenSearchingNextAvailables_shouldNotReturnDuplicates() {
		assertThat(findNextWordsFor("ac", "aa")).containsExactly("ab");
	}

	private List<String> findNextWordsFor(String... words) {
		return wordChainer.findNextChainsFor(new WordChain(asList(words)))
				.map(WordChain::lastWord)
				.collect(toList());
	}

	@Test
	void givenWordList_whenFindPath_shouldReturnKnownPath() {
		Optional<WordChain> wordChain = wordChainer.find("aaa", "bab");
		if (wordChain.isPresent()) {
			assertThat(wordChain.get().path()).containsExactly("aaa", "baa", "bab");
		}
		else {
			fail("wordchain is empty");
		}
	}

	@Test
	void givenWordList_withTryingFindUnknownTargetWord_shouldReturnEmptyOptional() {
		assertThat(wordChainer.find("aaa", "xxx")).isEmpty();
	}

	@Test
	void givenAllEnglishWords_findExamples() {
		wordChainer = new WordChainer(loadWords());

		Optional<WordChain> wordChain = wordChainer.find("cat", "dog");
		if (wordChain.isPresent()) {
			assertThat(wordChain.get().path()).containsExactly("cat", "cot", "cog", "dog");
		}
		else {
			fail("wordchain is empty");
		}
	}

	private static final Logger log = Logger.getLogger("wordchain");

	/**
	 * Method to load list of all english words. Should not be used for TDD but useful for integration testing
	 * and a few 'real' examples.
	 *
	 * @return List of words.
	 */
	private List<String> loadWords() {
		try (BufferedReader wordResourceStream =
					 new BufferedReader(
							 new InputStreamReader(getClass().getResourceAsStream("/words")))) {
			return extractedWordsFrom(wordResourceStream);
		}
		catch (IOException e) {
			log.log(Level.SEVERE, "unable to load words", e);
			return emptyList();
		}
	}

	private List<String> extractedWordsFrom(BufferedReader wordResourceStream) throws IOException {
		List<String> words = new ArrayList<>();
		Optional<String> word;
		do {
			word = ofNullable(wordResourceStream.readLine());
			word.ifPresent(words::add);
		} while (word.isPresent());
		return words;
	}
}
