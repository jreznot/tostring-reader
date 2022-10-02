// This is a generated file. Not intended for manual editing.
package org.strangeway.tsr.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.strangeway.tsr.psi.impl.*;

public interface TslTokenTypes {

  IElementType BOOLEAN_LITERAL = new TslElementType("BOOLEAN_LITERAL");
  IElementType KEY = new TslElementType("KEY");
  IElementType KEY_VALUE_BRACE = new TslElementType("KEY_VALUE_BRACE");
  IElementType KEY_VALUE_PARENTH = new TslElementType("KEY_VALUE_PARENTH");
  IElementType LIST = new TslElementType("LIST");
  IElementType NULL_LITERAL = new TslElementType("NULL_LITERAL");
  IElementType NUMBER_LITERAL = new TslElementType("NUMBER_LITERAL");
  IElementType OBJECT_BRACE = new TslElementType("OBJECT_BRACE");
  IElementType OBJECT_ID = new TslElementType("OBJECT_ID");
  IElementType OBJECT_PARENTH = new TslElementType("OBJECT_PARENTH");
  IElementType OBJECT_REF = new TslElementType("OBJECT_REF");
  IElementType PROPERTIES_LIST_BRACE = new TslElementType("PROPERTIES_LIST_BRACE");
  IElementType PROPERTIES_LIST_PARENTH = new TslElementType("PROPERTIES_LIST_PARENTH");
  IElementType STRING_LITERAL = new TslElementType("STRING_LITERAL");
  IElementType VALUE = new TslElementType("VALUE");

  IElementType ASSIGN = new TslTokenType("=");
  IElementType COLON = new TslTokenType(":");
  IElementType COMMA = new TslTokenType(",");
  IElementType DOUBLE_NUMBER = new TslTokenType("DOUBLE_NUMBER");
  IElementType DOUBLE_QUOTED_STRING = new TslTokenType("DOUBLE_QUOTED_STRING");
  IElementType FALSE = new TslTokenType("false");
  IElementType IDENTIFIER = new TslTokenType("IDENTIFIER");
  IElementType INTEGER_NUMBER = new TslTokenType("INTEGER_NUMBER");
  IElementType LBRACE = new TslTokenType("{");
  IElementType LBRACKET = new TslTokenType("[");
  IElementType LPARENTH = new TslTokenType("(");
  IElementType NULL = new TslTokenType("null");
  IElementType RBRACE = new TslTokenType("}");
  IElementType RBRACKET = new TslTokenType("]");
  IElementType RPARENTH = new TslTokenType(")");
  IElementType SINGLE_QUOTED_STRING = new TslTokenType("SINGLE_QUOTED_STRING");
  IElementType STRUDEL = new TslTokenType("@");
  IElementType TRUE = new TslTokenType("true");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BOOLEAN_LITERAL) {
        return new TslBooleanLiteralImpl(node);
      }
      else if (type == KEY) {
        return new TslKeyImpl(node);
      }
      else if (type == KEY_VALUE_BRACE) {
        return new TslKeyValueBraceImpl(node);
      }
      else if (type == KEY_VALUE_PARENTH) {
        return new TslKeyValueParenthImpl(node);
      }
      else if (type == LIST) {
        return new TslListImpl(node);
      }
      else if (type == NULL_LITERAL) {
        return new TslNullLiteralImpl(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new TslNumberLiteralImpl(node);
      }
      else if (type == OBJECT_BRACE) {
        return new TslObjectBraceImpl(node);
      }
      else if (type == OBJECT_ID) {
        return new TslObjectIdImpl(node);
      }
      else if (type == OBJECT_PARENTH) {
        return new TslObjectParenthImpl(node);
      }
      else if (type == OBJECT_REF) {
        return new TslObjectRefImpl(node);
      }
      else if (type == PROPERTIES_LIST_BRACE) {
        return new TslPropertiesListBraceImpl(node);
      }
      else if (type == PROPERTIES_LIST_PARENTH) {
        return new TslPropertiesListParenthImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new TslStringLiteralImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
