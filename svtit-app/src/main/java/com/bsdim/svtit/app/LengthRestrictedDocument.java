package com.bsdim.svtit.app;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * The length restricted document.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 */
public class LengthRestrictedDocument extends PlainDocument {
    private final int limit;

    /**
     * Parametrized constructor.
     *
     * @param limit the limit of length.
     */
    public LengthRestrictedDocument(int limit) {
        this.limit = limit;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {
        if (str == null) {
            return;
        }
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offs, str, a);
        }
    }
}
