package kata.wordchain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.iterate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

/*
 * Requirements
 *
 * This feature tries to find a way to get from one word to another by changing only one letter per step.
 * The length of the word doesn't change and the word must be a valid and known english word and not some
 * weird creation.
 *
 * In example you can get from cat to dog this way:
 *
 * cat - cot - cog - dog
 *
 * ps. find a long list of words in "src/test/java/resources"
 */
final class WordChainsTest {

    private WordChainer wordChainer;

    @BeforeEach
    void setUp() {
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
        } else {
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
    void givenOneWord_whenSearchingNextAvailable_shouldReturnWordsWithOnlyOneDifferentChar() {
        assertThat(findNextWordsFor("a")).containsExactly("b");
        assertThat(findNextWordsFor("aa")).containsExactly("ab", "ac");
    }

    @Test
    void givenListOfWords_whenSearchingNextAvailable_shouldNotReturnDuplicates() {
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
        } else {
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
        } else {
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
                             new InputStreamReader(requireNonNull(getClass().getResourceAsStream("/words")), StandardCharsets.UTF_8))) {
            return extractedWordsFrom(wordResourceStream);
        }
        catch (IOException e) {
            log.log(Level.SEVERE, "unable to load words", e);
            return emptyList();
        }
    }

    private List<String> extractedWordsFrom(BufferedReader wordResourceStream) throws IOException {
        return iterate(wordResourceStream.readLine(), Objects::nonNull, previous -> {
            try {
                return wordResourceStream.readLine(); // next
            }
            catch (IOException ioe) {
                fail("failed to read words", ioe);
                return null;
            }
        }).toList();
    }

}
