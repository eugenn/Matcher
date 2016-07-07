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
public class NGramsTest {
    @Test
    public void shouldGenerateNGramsValues() {
        String input = "A B C";
        List<String> output = Arrays.asList("A", "B", "A B", "C", "B C", "A B C");

        NGrams ngrams = new NGrams(input);

        assertThat(ngrams.content(), is(output));
    }

    @Test
    public void shouldReturnEmpty() {
        String input = "";

        NGrams ngrams = new NGrams(input);

        assertThat(ngrams.content(), is(Collections.emptyList()));
    }
}
