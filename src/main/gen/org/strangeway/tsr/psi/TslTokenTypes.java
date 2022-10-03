// This is a generated file. Not intended for manual editing.
package org.strangeway.tsr.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import org.strangeway.tsr.psi.impl.*;

public interface TslTokenTypes {

  IElementType BOOLEAN_LITERAL = new TslElementType("BOOLEAN_LITERAL");
  IElementType KEY_VALUE = new TslElementType("KEY_VALUE");
  IElementType LIST = new TslElementType("LIST");
  IElementType MAP = new TslElementType("MAP");
  IElementType MAP_ITEM = new TslElementType("MAP_ITEM");
  IElementType MAP_KEY = new TslElementType("MAP_KEY");
  IElementType NULL_LITERAL = new TslElementType("NULL_LITERAL");
  IElementType NUMBER_LITERAL = new TslElementType("NUMBER_LITERAL");
  IElementType OBJECT_BRACE = new TslElementType("OBJECT_BRACE");
  IElementType OBJECT_ID = new TslElementType("OBJECT_ID");
  IElementType OBJECT_NAME = new TslElementType("OBJECT_NAME");
  IElementType OBJECT_PARENTH = new TslElementType("OBJECT_PARENTH");
  IElementType OBJECT_REF = new TslElementType("OBJECT_REF");
  IElementType PROPERTIES_LIST = new TslElementType("PROPERTIES_LIST");
  IElementType PROPERTY_KEY = new TslElementType("PROPERTY_KEY");
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
  IElementType STRUDEL_HEX = new TslTokenType("STRUDEL_HEX");
  IElementType TRUE = new TslTokenType("true");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BOOLEAN_LITERAL) {
        return new TslBooleanLiteralImpl(node);
      }
      else if (type == KEY_VALUE) {
        return new TslKeyValueImpl(node);
      }
      else if (type == LIST) {
        return new TslListImpl(node);
      }
      else if (type == MAP) {
        return new TslMapImpl(node);
      }
      else if (type == MAP_ITEM) {
        return new TslMapItemImpl(node);
      }
      else if (type == MAP_KEY) {
        return new TslMapKeyImpl(node);
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
      else if (type == OBJECT_NAME) {
        return new TslObjectNameImpl(node);
      }
      else if (type == OBJECT_PARENTH) {
        return new TslObjectParenthImpl(node);
      }
      else if (type == OBJECT_REF) {
        return new TslObjectRefImpl(node);
      }
      else if (type == PROPERTIES_LIST) {
        return new TslPropertiesListImpl(node);
      }
      else if (type == PROPERTY_KEY) {
        return new TslPropertyKeyImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new TslStringLiteralImpl(node);
      }
      else if (type == VALUE) {
        return new TslValueImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
