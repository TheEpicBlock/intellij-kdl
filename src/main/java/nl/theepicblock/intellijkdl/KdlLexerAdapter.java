package nl.theepicblock.intellijkdl;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;
import org.jetbrains.annotations.NotNull;

public class KdlLexerAdapter extends FlexAdapter {
    public KdlLexerAdapter() {
        super(new KdlLexer(null));
    }
}
