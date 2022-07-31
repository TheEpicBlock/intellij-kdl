package nl.theepicblock.intellijkdl.highlighting;

import com.intellij.codeInsight.daemon.RainbowVisitor;
import com.intellij.codeInsight.daemon.impl.HighlightVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import nl.theepicblock.intellijkdl.KdlFile;
import nl.theepicblock.intellijkdl.psi.*;
import org.jetbrains.annotations.NotNull;

public class KdlRainbowVisitor extends RainbowVisitor {
    @Override
    public boolean suitableForFile(@NotNull PsiFile file) {
        return file instanceof KdlFile;
    }

    @Override
    public void visit(@NotNull PsiElement element) {
        // TODO better alternatives for getText
        if (element instanceof KdlNode_) {
            KdlNode_ node = (KdlNode_)element;
            PsiFile file = element.getContainingFile();
            String name = "node"+node.getIdentifier().getText();
            addInfo(getInfo(file, node.getIdentifier(), name, KdlSyntaxHighlighter.NODE_NAME));
            if (node.getNodeChildren() != null) {
                addInfo(getInfo(file, node.getNodeChildren().getStartnodeWrapper(), name, KdlSyntaxHighlighter.BRACE));
                addInfo(getInfo(file, node.getNodeChildren().getLastChild(), name, KdlSyntaxHighlighter.BRACE));
            }
            if (node.getNodeTerminator() != null) {
                addInfo(getInfo(file, node.getNodeTerminator(), name, KdlSyntaxHighlighter.BRACE));
            }

        }
        if (element instanceof KdlProp) {
            KdlProp prop = (KdlProp)element;
            PsiFile file = element.getContainingFile();
            String name = "prop"+prop.getIdentifier().getText();
            addInfo(getInfo(file, prop.getIdentifier(), name, KdlSyntaxHighlighter.KEY));
            if (prop.getValue().getNumber() != null) {
                addInfo(getInfo(file, prop.getValue().getNumber(), name, KdlSyntaxHighlighter.NUMBER));
            } else if (prop.getValue().getStringLiteral() != null) {
                addInfo(getInfo(file, prop.getValue().getStringLiteral(), name, KdlSyntaxHighlighter.STRING));
            } else if (prop.getValue().getKeyword() != null) {
                if (prop.getValue().getKeyword().textMatches("null")) {
                    addInfo(getInfo(file, prop.getValue().getKeyword(), name, KdlSyntaxHighlighter.NULL));
                } else {
                    addInfo(getInfo(file, prop.getValue().getKeyword(), name, KdlSyntaxHighlighter.BOOLEAN));
                }

            }
        }
        if (element instanceof KdlType) {
            KdlType type = (KdlType)element;
            PsiFile file = element.getContainingFile();
            addInfo(getInfo(file, type.getIdentifier(), "node"+type.getIdentifier().getText(), KdlSyntaxHighlighter.TYPE_SPECIFIER));
        }
    }

    @Override
    public @NotNull HighlightVisitor clone() {
        return new KdlRainbowVisitor();
    }
}
