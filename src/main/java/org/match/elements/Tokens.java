package org.match.elements;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugennekhai on 07/07/16.
 */
public class Tokens {
    private String text = "";
    public Tokens(String input) {
        this.text = input;
    }

    public List<String> toList() {
        List<String> words = new ArrayList<>();

        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);

        int lastIndex = breakIterator.first();

        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }

        return words;
    }
}
