package nl.theepicblock.intellijkdl.typing;

import com.intellij.codeInsight.editorActions.MultiCharQuoteHandler;
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class KdlQuoteHandler extends SimpleTokenSetQuoteHandler implements MultiCharQuoteHandler {
    @Override
    public @Nullable CharSequence getClosingQuote(@NotNull HighlighterIterator iterator, int offset) {
        return "\""; // TODO support for raw strings
    }
}
