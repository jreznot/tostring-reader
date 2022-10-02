package org.strangeway.tsr;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.strangeway.tsr.psi.TslTokenTypes;

import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public final class TslSyntaxHighlighter extends SyntaxHighlighterBase {
  public static final TextAttributesKey TSL_KEYWORD =
      createTextAttributesKey("TSL.KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

  public static final TextAttributesKey TSL_IDENTIFIER =
      createTextAttributesKey("TSL.IDENTIFIER", DefaultLanguageHighlighterColors.CLASS_NAME);

  public static final TextAttributesKey TSL_NUMBER =
      createTextAttributesKey("TSL.NUMBER", DefaultLanguageHighlighterColors.NUMBER);

  public static final TextAttributesKey TSL_BOOLEAN =
      createTextAttributesKey("TSL.BOOLEAN", DefaultLanguageHighlighterColors.NUMBER);

  public static final TextAttributesKey TSL_STRING =
      createTextAttributesKey("TSL.STRING", DefaultLanguageHighlighterColors.STRING);

  public static final TextAttributesKey TSL_PARENTHESES =
      createTextAttributesKey("TSL.PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);

  public static final TextAttributesKey TSL_BRACKETS =
      createTextAttributesKey("TSL.BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);

  public static final TextAttributesKey TSL_COMMA =
      createTextAttributesKey("TSL.COMMA", DefaultLanguageHighlighterColors.COMMA);

  public static final TextAttributesKey TSL_FIELD_NAME =
      createTextAttributesKey("TSL.FIELD_NAME", DefaultLanguageHighlighterColors.INSTANCE_FIELD);

  public static final TextAttributesKey TSL_CONSTANT =
      createTextAttributesKey("TSL.CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);

  private static final Map<IElementType, TextAttributesKey> ourMap;

  static {
    ourMap = new HashMap<>();

    fillMap(ourMap, TSL_KEYWORD, TslTokenTypes.NULL, TslTokenTypes.STRUDEL);
    fillMap(ourMap, TSL_BOOLEAN, TslTokenTypes.TRUE, TslTokenTypes.FALSE);
    fillMap(ourMap, TSL_NUMBER, TslTokenTypes.INTEGER_NUMBER, TslTokenTypes.DOUBLE_NUMBER);
    fillMap(ourMap, TSL_STRING, TslTokenTypes.DOUBLE_QUOTED_STRING, TslTokenTypes.SINGLE_QUOTED_STRING);

    fillMap(ourMap, TSL_BRACKETS, TslTokenTypes.LBRACKET, TslTokenTypes.RBRACKET);
    fillMap(ourMap, TSL_PARENTHESES, TslTokenTypes.LPARENTH, TslTokenTypes.RPARENTH);
    fillMap(ourMap, TSL_COMMA, TslTokenTypes.COMMA);
  }

  @Override
  public @NotNull Lexer getHighlightingLexer() {
    return new TslLexer();
  }

  @Override
  public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
    return pack(ourMap.get(tokenType));
  }
}
