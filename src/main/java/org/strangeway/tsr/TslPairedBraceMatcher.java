package org.strangeway.tsr;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.strangeway.tsr.psi.TslTokenTypes;

final class TslPairedBraceMatcher implements PairedBraceMatcher {
  public static final BracePair[] PAIRS = new BracePair[]{
      new BracePair(TslTokenTypes.LPARENTH, TslTokenTypes.RPARENTH, true),
      new BracePair(TslTokenTypes.LBRACKET, TslTokenTypes.RBRACKET, true),
      new BracePair(TslTokenTypes.LBRACE, TslTokenTypes.RBRACE, true)
  };

  @Override
  public BracePair @NotNull [] getPairs() {
    return PAIRS;
  }

  @Override
  public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
    return true;
  }

  @Override
  public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
    return openingBraceOffset;
  }
}