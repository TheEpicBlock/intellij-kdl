package nl.theepicblock.intellijkdl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import nl.theepicblock.intellijkdl.psi.KdlTypes;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.ElementType;


public class KdlParserDefinition implements ParserDefinition {
    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENTS = TokenSet.create();
    public static final TokenSet STRINGS = TokenSet.create(KdlTypes.STRING);
    public static final TokenSet VALUES = TokenSet.create(KdlTypes.STRING, KdlTypes.DECIMAL, KdlTypes.HEX, KdlTypes.BINARY, KdlTypes.OCTAL);

    public static final IFileElementType FILE = new IFileElementType(KdlLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new KdlLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return STRINGS;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new KdlParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new KdlFile(viewProvider);
    }
    @Override
    public @NotNull SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
        if (left.getElementType().equals(KdlTypes.BACKSLASH)) {
            return SpaceRequirements.MUST_LINE_BREAK;
        }
        if (left.getElementType().equals(KdlTypes.EQUALS) || right.getElementType().equals(KdlTypes.EQUALS)) {
            return SpaceRequirements.MUST_NOT;
        }
        if (right.getElementType().equals(KdlTypes.BAREIDENTIFIER) || VALUES.contains(right.getElementType())) {
            return SpaceRequirements.MUST;
        }
        return SpaceRequirements.MAY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return KdlTypes.Factory.createElement(node);
    }
}
