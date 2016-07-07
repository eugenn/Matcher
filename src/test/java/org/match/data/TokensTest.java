package org.match.data;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by eugennekhai on 07/07/16.
 */
public class TokensTest {
    private String sentence = "a, 2, 3.";
    private List<String> values = Arrays.asList("a", "2", "3");

    @Test
    public void shouldSplitSentenceToTokenList() {
        Tokens tokens = new Tokens(sentence);

        List<String> result = tokens.toList();

        assertThat(result, is(values));
    }

    @Test
    public void shouldReturnEmptyListForNothing() {
        Tokens empty = new Tokens("");

        List<String> result = empty.toList();

        assertThat(result, is(Collections.emptyList()));
    }
}
