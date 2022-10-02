// This is a generated file. Not intended for manual editing.
package org.strangeway.tsr.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static org.strangeway.tsr.psi.TslTokenTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class TslParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return root(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(BOOLEAN_LITERAL, LIST, NULL_LITERAL, NUMBER_LITERAL,
      OBJECT_BRACE, OBJECT_ID, OBJECT_PARENTH, OBJECT_REF,
      STRING_LITERAL, VALUE),
  };

  /* ********************************************************** */
  // TRUE | FALSE
  public static boolean booleanLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "booleanLiteral")) return false;
    if (!nextTokenIs(b, "<boolean literal>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_LITERAL, "<boolean literal>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, KEY, r);
    return r;
  }

  /* ********************************************************** */
  // key ASSIGN value (COMMA|&RBRACE)
  public static boolean keyValueBrace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValueBrace")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, KEY_VALUE_BRACE, "<key value brace>");
    r = key(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    p = r; // pin = 2
    r = r && report_error_(b, value(b, l + 1));
    r = p && keyValueBrace_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, TslParser::notRBraceOrNextValue);
    return r || p;
  }

  // COMMA|&RBRACE
  private static boolean keyValueBrace_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValueBrace_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = keyValueBrace_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &RBRACE
  private static boolean keyValueBrace_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValueBrace_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // key ASSIGN value (COMMA|&RPARENTH)
  public static boolean keyValueParenth(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValueParenth")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, KEY_VALUE_PARENTH, "<key value parenth>");
    r = key(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    p = r; // pin = 2
    r = r && report_error_(b, value(b, l + 1));
    r = p && keyValueParenth_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, TslParser::notRParenthOrNextValue);
    return r || p;
  }

  // COMMA|&RPARENTH
  private static boolean keyValueParenth_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValueParenth_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = keyValueParenth_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &RPARENTH
  private static boolean keyValueParenth_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValueParenth_3_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RPARENTH);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LBRACKET listItem* RBRACKET
  public static boolean list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LIST, null);
    r = consumeToken(b, LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, list_1(b, l + 1));
    r = p && consumeToken(b, RBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // listItem*
  private static boolean list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!listItem(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // value (COMMA|&RBRACKET)
  static boolean listItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listItem")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = value(b, l + 1);
    p = r; // pin = 1
    r = r && listItem_1(b, l + 1);
    exit_section_(b, l, m, r, p, TslParser::notBracketOrNextValue);
    return r || p;
  }

  // COMMA|&RBRACKET
  private static boolean listItem_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listItem_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    if (!r) r = listItem_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &RBRACKET
  private static boolean listItem_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listItem_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = consumeToken(b, RBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(RBRACKET|value)
  static boolean notBracketOrNextValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notBracketOrNextValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !notBracketOrNextValue_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RBRACKET|value
  private static boolean notBracketOrNextValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notBracketOrNextValue_0")) return false;
    boolean r;
    r = consumeToken(b, RBRACKET);
    if (!r) r = value(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !(RBRACE|value)
  static boolean notRBraceOrNextValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notRBraceOrNextValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !notRBraceOrNextValue_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RBRACE|value
  private static boolean notRBraceOrNextValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notRBraceOrNextValue_0")) return false;
    boolean r;
    r = consumeToken(b, RBRACE);
    if (!r) r = value(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // !(RPARENTH|value)
  static boolean notRParenthOrNextValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notRParenthOrNextValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !notRParenthOrNextValue_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RPARENTH|value
  private static boolean notRParenthOrNextValue_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "notRParenthOrNextValue_0")) return false;
    boolean r;
    r = consumeToken(b, RPARENTH);
    if (!r) r = value(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // NULL
  public static boolean nullLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nullLiteral")) return false;
    if (!nextTokenIs(b, NULL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NULL);
    exit_section_(b, m, NULL_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_NUMBER | INTEGER_NUMBER
  public static boolean numberLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numberLiteral")) return false;
    if (!nextTokenIs(b, "<number literal>", DOUBLE_NUMBER, INTEGER_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_LITERAL, "<number literal>");
    r = consumeToken(b, DOUBLE_NUMBER);
    if (!r) r = consumeToken(b, INTEGER_NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER LBRACE propertiesListBrace RBRACE
  public static boolean objectBrace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectBrace")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_BRACE, null);
    r = consumeTokens(b, 2, IDENTIFIER, LBRACE);
    p = r; // pin = 2
    r = r && report_error_(b, propertiesListBrace(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean objectId(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectId")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, OBJECT_ID, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER LPARENTH propertiesListParenth RPARENTH
  public static boolean objectParenth(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectParenth")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_PARENTH, null);
    r = consumeTokens(b, 2, IDENTIFIER, LPARENTH);
    p = r; // pin = 2
    r = r && report_error_(b, propertiesListParenth(b, l + 1));
    r = p && consumeToken(b, RPARENTH) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // IDENTIFIER STRUDEL INTEGER_NUMBER
  public static boolean objectRef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectRef")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, OBJECT_REF, null);
    r = consumeTokens(b, 2, IDENTIFIER, STRUDEL, INTEGER_NUMBER);
    p = r; // pin = 2
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // keyValueBrace*
  public static boolean propertiesListBrace(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertiesListBrace")) return false;
    Marker m = enter_section_(b, l, _NONE_, PROPERTIES_LIST_BRACE, "<properties list brace>");
    while (true) {
      int c = current_position_(b);
      if (!keyValueBrace(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "propertiesListBrace", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // keyValueParenth*
  public static boolean propertiesListParenth(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertiesListParenth")) return false;
    Marker m = enter_section_(b, l, _NONE_, PROPERTIES_LIST_PARENTH, "<properties list parenth>");
    while (true) {
      int c = current_position_(b);
      if (!keyValueParenth(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "propertiesListParenth", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // value
  static boolean root(PsiBuilder b, int l) {
    return value(b, l + 1);
  }

  /* ********************************************************** */
  // DOUBLE_QUOTED_STRING | SINGLE_QUOTED_STRING
  public static boolean stringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteral")) return false;
    if (!nextTokenIs(b, "<string literal>", DOUBLE_QUOTED_STRING, SINGLE_QUOTED_STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERAL, "<string literal>");
    r = consumeToken(b, DOUBLE_QUOTED_STRING);
    if (!r) r = consumeToken(b, SINGLE_QUOTED_STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // stringLiteral | numberLiteral | booleanLiteral | nullLiteral | objectRef | objectBrace | objectParenth | objectId | list
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, VALUE, "<value>");
    r = stringLiteral(b, l + 1);
    if (!r) r = numberLiteral(b, l + 1);
    if (!r) r = booleanLiteral(b, l + 1);
    if (!r) r = nullLiteral(b, l + 1);
    if (!r) r = objectRef(b, l + 1);
    if (!r) r = objectBrace(b, l + 1);
    if (!r) r = objectParenth(b, l + 1);
    if (!r) r = objectId(b, l + 1);
    if (!r) r = list(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
