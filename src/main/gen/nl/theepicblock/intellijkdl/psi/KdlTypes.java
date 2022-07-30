// This is a generated file. Not intended for manual editing.
package nl.theepicblock.intellijkdl.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import nl.theepicblock.intellijkdl.KdlElementType;
import nl.theepicblock.intellijkdl.KdlTokenType;
import nl.theepicblock.intellijkdl.psi.impl.*;

public interface KdlTypes {

  IElementType ESCLINE = new KdlElementType("ESCLINE");
  IElementType IDENTIFIER = new KdlElementType("IDENTIFIER");
  IElementType KEYWORD = new KdlElementType("KEYWORD");
  IElementType LINESPACE = new KdlElementType("LINESPACE");
  IElementType NODES = new KdlElementType("NODES");
  IElementType NODE_ = new KdlElementType("NODE_");
  IElementType NODE_CHILDREN = new KdlElementType("NODE_CHILDREN");
  IElementType NODE_PROP_OR_ARG = new KdlElementType("NODE_PROP_OR_ARG");
  IElementType NODE_SPACE = new KdlElementType("NODE_SPACE");
  IElementType NODE_TERMINATOR = new KdlElementType("NODE_TERMINATOR");
  IElementType NUMBER = new KdlElementType("NUMBER");
  IElementType PROP = new KdlElementType("PROP");
  IElementType TYPE = new KdlElementType("TYPE");
  IElementType VALUE = new KdlElementType("VALUE");
  IElementType WS = new KdlElementType("WS");

  IElementType BACKSLASH = new KdlTokenType("backslash");
  IElementType BAREIDENTIFIER = new KdlTokenType("bareidentifier");
  IElementType BINARY = new KdlTokenType("binary");
  IElementType BOM = new KdlTokenType("bom");
  IElementType BOOLEAN = new KdlTokenType("boolean");
  IElementType CTXCOMMENT = new KdlTokenType("ctxcomment");
  IElementType DECIMAL = new KdlTokenType("decimal");
  IElementType ENDNODE = new KdlTokenType("endnode");
  IElementType ENDTYPE = new KdlTokenType("endtype");
  IElementType EQUALS = new KdlTokenType("equals");
  IElementType HEX = new KdlTokenType("hex");
  IElementType NEWLINE = new KdlTokenType("newline");
  IElementType NULL = new KdlTokenType("null");
  IElementType OCTAL = new KdlTokenType("octal");
  IElementType SEMICOLON = new KdlTokenType("semicolon");
  IElementType STARTNODE = new KdlTokenType("startnode");
  IElementType STARTTYPE = new KdlTokenType("starttype");
  IElementType STRING = new KdlTokenType("string");
  IElementType UNICODESPACE = new KdlTokenType("unicodespace");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ESCLINE) {
        return new KdlEsclineImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new KdlIdentifierImpl(node);
      }
      else if (type == KEYWORD) {
        return new KdlKeywordImpl(node);
      }
      else if (type == LINESPACE) {
        return new KdlLinespaceImpl(node);
      }
      else if (type == NODES) {
        return new KdlNodesImpl(node);
      }
      else if (type == NODE_) {
        return new KdlNode_Impl(node);
      }
      else if (type == NODE_CHILDREN) {
        return new KdlNodeChildrenImpl(node);
      }
      else if (type == NODE_PROP_OR_ARG) {
        return new KdlNodePropOrArgImpl(node);
      }
      else if (type == NODE_SPACE) {
        return new KdlNodeSpaceImpl(node);
      }
      else if (type == NODE_TERMINATOR) {
        return new KdlNodeTerminatorImpl(node);
      }
      else if (type == NUMBER) {
        return new KdlNumberImpl(node);
      }
      else if (type == PROP) {
        return new KdlPropImpl(node);
      }
      else if (type == TYPE) {
        return new KdlTypeImpl(node);
      }
      else if (type == VALUE) {
        return new KdlValueImpl(node);
      }
      else if (type == WS) {
        return new KdlWsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
