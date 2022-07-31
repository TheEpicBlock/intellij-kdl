package nl.theepicblock.intellijkdl.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import nl.theepicblock.intellijkdl.KdlLexerAdapter;
import nl.theepicblock.intellijkdl.psi.KdlTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class KdlSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey NODE_NAME =
            createTextAttributesKey("KDL_NODE_NAME", DefaultLanguageHighlighterColors.CLASS_NAME);
    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("KDL_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    // Added by annotators
    public static final TextAttributesKey PROPERTY_KEY =
            createTextAttributesKey("KDL_PROPERTY_KEY", getKeyColor());
    public static final TextAttributesKey PARENTHESES =
            createTextAttributesKey("KDL_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACE =
            createTextAttributesKey("KDL_BRACE", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey SEMICOLON =
            createTextAttributesKey("KDL_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    // Added by annotators
    public static final TextAttributesKey TYPE_SPECIFIER =
            createTextAttributesKey("KDL_TYPE_SPECIFIER", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("KDL_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("KDL_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey BOOLEAN =
            createTextAttributesKey("KDL_BOOLEAN", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey NULL =
            createTextAttributesKey("KDL_NULL", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("KDL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("KDL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new KdlLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(KdlTypes.BOOLEAN)) return new TextAttributesKey[]{BOOLEAN};
        if (tokenType.equals(KdlTypes.NULL)) return new TextAttributesKey[]{NULL};
        if (tokenType.equals(KdlTypes.DECIMAL)) return new TextAttributesKey[]{NUMBER};
        if (tokenType.equals(KdlTypes.HEX)) return new TextAttributesKey[]{NUMBER};
        if (tokenType.equals(KdlTypes.OCTAL)) return new TextAttributesKey[]{NUMBER};
        if (tokenType.equals(KdlTypes.BINARY)) return new TextAttributesKey[]{NUMBER};
        if (tokenType.equals(KdlTypes.STRING)) return new TextAttributesKey[]{STRING};
        if (tokenType.equals(KdlTypes.EQUALS)) return new TextAttributesKey[]{SEPARATOR};
        if (tokenType.equals(KdlTypes.STARTNODE)) return new TextAttributesKey[]{BRACE};
        if (tokenType.equals(KdlTypes.ENDNODE)) return new TextAttributesKey[]{BRACE};
        if (tokenType.equals(KdlTypes.STARTTYPE)) return new TextAttributesKey[]{PARENTHESES};
        if (tokenType.equals(KdlTypes.ENDTYPE)) return new TextAttributesKey[]{PARENTHESES};
        if (tokenType.equals(KdlTypes.SEMICOLON)) return new TextAttributesKey[]{SEMICOLON};
        if (tokenType.equals(KdlTypes.NODE_BAREIDENTIFIER)) return new TextAttributesKey[]{NODE_NAME};
        if (tokenType.equals(KdlTypes.NODE_IDENTIFIER_STRING)) return new TextAttributesKey[]{NODE_NAME};
        if (tokenType.equals(TokenType.BAD_CHARACTER)) return new TextAttributesKey[]{BAD_CHARACTER};
        return new TextAttributesKey[0];
    }

    private static TextAttributesKey getKeyColor() {
        try {
            return com.intellij.json.highlighting.JsonSyntaxHighlighterFactory.JSON_PROPERTY_KEY;
        } catch (Throwable e) { // Just in case json support somehow isn't loaded
            return DefaultLanguageHighlighterColors.INSTANCE_FIELD;
        }
    }
}
