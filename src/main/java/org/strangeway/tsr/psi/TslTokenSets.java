package org.strangeway.tsr.psi;

import com.intellij.psi.tree.TokenSet;

public final class TslTokenSets {
  private TslTokenSets() {
  }

  public static final TokenSet STRINGS = TokenSet.create(TslTokenTypes.DOUBLE_QUOTED_STRING, TslTokenTypes.SINGLE_QUOTED_STRING);
}
