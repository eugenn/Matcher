package org.match.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by eugennekhai on 07/07/16.
 */
public class NGrams implements Content {
    private List<String> tokens;
    private List<String> ngrams = new ArrayList<>();

    public NGrams(String input) {
        this.tokens = new Tokens(input).toList();
    }

    @Override
    public List<String> content() {
        int ngramSize;
        int maxGramSize = tokens.size();

        StringBuilder sb;

        for (ListIterator<String> it = tokens.listIterator(); it.hasNext(); ) {
            String word = it.next();

            sb = new StringBuilder(word);
            ngrams.add(word);
            ngramSize = 1;
            it.previous();

            while (it.hasPrevious() && ngramSize < maxGramSize) {
                sb.insert(0, ' ');
                sb.insert(0, it.previous());
                ngrams.add(sb.toString());
                ngramSize++;
            }

            while (ngramSize > 0) {
                ngramSize--;
                it.next();
            }
        }
        return ngrams;
    }

}
