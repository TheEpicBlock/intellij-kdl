// This is a generated file. Not intended for manual editing.
package nl.theepicblock.intellijkdl;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static nl.theepicblock.intellijkdl.psi.KdlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class KdlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return kdlFile(b, l + 1);
  }

  /* ********************************************************** */
  // backslash ws* (/*single-line-comment |*/ newline)
  public static boolean escline(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "escline")) return false;
    if (!nextTokenIs(b, BACKSLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BACKSLASH);
    r = r && escline_1(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, ESCLINE, r);
    return r;
  }

  // ws*
  private static boolean escline_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "escline_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ws(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "escline_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // string | bareidentifier
  public static boolean identifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifier")) return false;
    if (!nextTokenIs(b, "<identifier>", BAREIDENTIFIER, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, BAREIDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // nodes
  static boolean kdlFile(PsiBuilder b, int l) {
    return nodes(b, l + 1);
  }

  /* ********************************************************** */
  // boolean | null
  public static boolean keyword(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyword")) return false;
    if (!nextTokenIs(b, "<keyword>", BOOLEAN, NULL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEYWORD, "<keyword>");
    r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, NULL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // newline | ws
  public static boolean linespace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "linespace")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LINESPACE, "<linespace>");
    r = consumeToken(b, NEWLINE);
    if (!r) r = ws(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (ctxcomment node-space*)? startnode nodes endnode
  public static boolean node_children(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_children")) return false;
    if (!nextTokenIs(b, "<node children>", CTXCOMMENT, STARTNODE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NODE_CHILDREN, "<node children>");
    r = node_children_0(b, l + 1);
    r = r && consumeToken(b, STARTNODE);
    r = r && nodes(b, l + 1);
    r = r && consumeToken(b, ENDNODE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ctxcomment node-space*)?
  private static boolean node_children_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_children_0")) return false;
    node_children_0_0(b, l + 1);
    return true;
  }

  // ctxcomment node-space*
  private static boolean node_children_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_children_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CTXCOMMENT);
    r = r && node_children_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // node-space*
  private static boolean node_children_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_children_0_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!node_space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node_children_0_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (ctxcomment node-space*)? (prop | value)
  public static boolean node_prop_or_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_prop_or_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NODE_PROP_OR_ARG, "<node prop or arg>");
    r = node_prop_or_arg_0(b, l + 1);
    r = r && node_prop_or_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ctxcomment node-space*)?
  private static boolean node_prop_or_arg_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_prop_or_arg_0")) return false;
    node_prop_or_arg_0_0(b, l + 1);
    return true;
  }

  // ctxcomment node-space*
  private static boolean node_prop_or_arg_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_prop_or_arg_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CTXCOMMENT);
    r = r && node_prop_or_arg_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // node-space*
  private static boolean node_prop_or_arg_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_prop_or_arg_0_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!node_space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node_prop_or_arg_0_0_1", c)) break;
    }
    return true;
  }

  // prop | value
  private static boolean node_prop_or_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_prop_or_arg_1")) return false;
    boolean r;
    r = prop(b, l + 1);
    if (!r) r = value(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ws* escline ws* | ws+
  public static boolean node_space(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_space")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NODE_SPACE, "<node space>");
    r = node_space_0(b, l + 1);
    if (!r) r = node_space_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ws* escline ws*
  private static boolean node_space_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_space_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_space_0_0(b, l + 1);
    r = r && escline(b, l + 1);
    r = r && node_space_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ws*
  private static boolean node_space_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_space_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ws(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node_space_0_0", c)) break;
    }
    return true;
  }

  // ws*
  private static boolean node_space_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_space_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ws(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node_space_0_2", c)) break;
    }
    return true;
  }

  // ws+
  private static boolean node_space_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_space_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ws(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!ws(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node_space_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // semicolon | newline | <<eof>>
  public static boolean node_terminator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_terminator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NODE_TERMINATOR, "<node terminator>");
    r = consumeToken(b, SEMICOLON);
    if (!r) r = consumeToken(b, NEWLINE);
    if (!r) r = eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (ctxcomment node-space*)? type? identifier (node-space+ node-prop-or-arg)* (node-space* node-children ws*)? node-space* node-terminator
  public static boolean node_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NODE_, "<node>");
    r = node__0(b, l + 1);
    r = r && node__1(b, l + 1);
    r = r && identifier(b, l + 1);
    r = r && node__3(b, l + 1);
    r = r && node__4(b, l + 1);
    r = r && node__5(b, l + 1);
    r = r && node_terminator(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ctxcomment node-space*)?
  private static boolean node__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__0")) return false;
    node__0_0(b, l + 1);
    return true;
  }

  // ctxcomment node-space*
  private static boolean node__0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CTXCOMMENT);
    r = r && node__0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // node-space*
  private static boolean node__0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__0_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!node_space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node__0_0_1", c)) break;
    }
    return true;
  }

  // type?
  private static boolean node__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__1")) return false;
    type(b, l + 1);
    return true;
  }

  // (node-space+ node-prop-or-arg)*
  private static boolean node__3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!node__3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node__3", c)) break;
    }
    return true;
  }

  // node-space+ node-prop-or-arg
  private static boolean node__3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node__3_0_0(b, l + 1);
    r = r && node_prop_or_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // node-space+
  private static boolean node__3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_space(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!node_space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node__3_0_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // (node-space* node-children ws*)?
  private static boolean node__4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__4")) return false;
    node__4_0(b, l + 1);
    return true;
  }

  // node-space* node-children ws*
  private static boolean node__4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node__4_0_0(b, l + 1);
    r = r && node_children(b, l + 1);
    r = r && node__4_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // node-space*
  private static boolean node__4_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__4_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!node_space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node__4_0_0", c)) break;
    }
    return true;
  }

  // ws*
  private static boolean node__4_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__4_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ws(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node__4_0_2", c)) break;
    }
    return true;
  }

  // node-space*
  private static boolean node__5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node__5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!node_space(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "node__5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // linespace* (node_ nodes?)? linespace*
  public static boolean nodes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nodes")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, NODES, "<nodes>");
    r = nodes_0(b, l + 1);
    r = r && nodes_1(b, l + 1);
    r = r && nodes_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // linespace*
  private static boolean nodes_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nodes_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!linespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nodes_0", c)) break;
    }
    return true;
  }

  // (node_ nodes?)?
  private static boolean nodes_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nodes_1")) return false;
    nodes_1_0(b, l + 1);
    return true;
  }

  // node_ nodes?
  private static boolean nodes_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nodes_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = node_(b, l + 1);
    r = r && nodes_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // nodes?
  private static boolean nodes_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nodes_1_0_1")) return false;
    nodes(b, l + 1);
    return true;
  }

  // linespace*
  private static boolean nodes_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nodes_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!linespace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nodes_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // decimal | hex | octal | binary
  public static boolean number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = consumeToken(b, DECIMAL);
    if (!r) r = consumeToken(b, HEX);
    if (!r) r = consumeToken(b, OCTAL);
    if (!r) r = consumeToken(b, BINARY);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // identifier equals value
  public static boolean prop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prop")) return false;
    if (!nextTokenIs(b, "<prop>", BAREIDENTIFIER, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROP, "<prop>");
    r = identifier(b, l + 1);
    r = r && consumeToken(b, EQUALS);
    r = r && value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // starttype identifier endtype
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    if (!nextTokenIs(b, STARTTYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STARTTYPE);
    r = r && identifier(b, l + 1);
    r = r && consumeToken(b, ENDTYPE);
    exit_section_(b, m, TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // type? (string | number | keyword)
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = value_0(b, l + 1);
    r = r && value_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // type?
  private static boolean value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_0")) return false;
    type(b, l + 1);
    return true;
  }

  // string | number | keyword
  private static boolean value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_1")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = number(b, l + 1);
    if (!r) r = keyword(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // bom | unicodespace
  public static boolean ws(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ws")) return false;
    if (!nextTokenIs(b, "<ws>", BOM, UNICODESPACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, WS, "<ws>");
    r = consumeToken(b, BOM);
    if (!r) r = consumeToken(b, UNICODESPACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
