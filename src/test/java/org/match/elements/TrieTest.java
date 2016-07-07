package org.match.elements;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by eugennekhai on 07/07/16.
 */
public class TrieTest {
    @Test
    public void shouldFindValues() {
        Trie trie = new Trie();

        trie.insert("A");
        trie.insert("A B");
        trie.insert("A B C");
        trie.insert("B");
        trie.insert("C D");

        assertThat(trie.search("A"), is(true));
        assertThat(trie.search("B C"), is(false));
        assertThat(trie.search(""), is(false));
    }
}
