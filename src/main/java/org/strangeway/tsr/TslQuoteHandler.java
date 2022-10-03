package org.strangeway.tsr;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import org.strangeway.tsr.psi.TslTokenSets;

final class TslQuoteHandler extends SimpleTokenSetQuoteHandler {
  public TslQuoteHandler() {
    super(TslTokenSets.STRINGS);
  }
}
