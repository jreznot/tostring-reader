package org.strangeway.tsr.psi;

import com.intellij.psi.tree.TokenSet;

public final class TslTokenSets {
  private TslTokenSets() {
  }

  public static final TokenSet STRINGS = TokenSet.create(TslTokenTypes.DOUBLE_QUOTED_STRING, TslTokenTypes.SINGLE_QUOTED_STRING);
  public static final TokenSet BRACES = TokenSet.create(
      TslTokenTypes.LBRACE, TslTokenTypes.RBRACE,
      TslTokenTypes.LBRACKET, TslTokenTypes.RBRACKET,
      TslTokenTypes.LPARENTH, TslTokenTypes.RPARENTH
  );
  public static final TokenSet BLOCK_IDENTIFIERS = TokenSet.create(
      TslTokenTypes.OBJECT_NAME
  );
  public static final TokenSet OPEN_BRACES = TokenSet.create(
      TslTokenTypes.LBRACE,
      TslTokenTypes.LBRACKET,
      TslTokenTypes.LPARENTH
  );

  public static final TokenSet CLOSE_BRACES = TokenSet.create(
      TslTokenTypes.RBRACE,
      TslTokenTypes.RBRACKET,
      TslTokenTypes.RPARENTH
  );
}
