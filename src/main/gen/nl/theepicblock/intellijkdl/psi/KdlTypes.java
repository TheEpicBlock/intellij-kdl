// This is a generated file. Not intended for manual editing.
package nl.theepicblock.intellijkdl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.theepicblock.intellijkdl.KdlElementType;
import nl.theepicblock.intellijkdl.KdlTokenType;
import nl.theepicblock.intellijkdl.psi.impl.*;

public interface KdlTypes {

  IElementType PROPERTY = new KdlElementType("PROPERTY");

  IElementType COMMENT = new KdlTokenType("COMMENT");
  IElementType CRLF = new KdlTokenType("CRLF");
  IElementType KEY = new KdlTokenType("KEY");
  IElementType SEPARATOR = new KdlTokenType("SEPARATOR");
  IElementType VALUE = new KdlTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new KdlPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
