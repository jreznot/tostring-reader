package org.strangeway.tsr;

import com.intellij.lexer.FlexAdapter;
import org.strangeway.tsr.lexer._TslLexer;

public final class TslLexer extends FlexAdapter {
  public TslLexer() {
    super(new _TslLexer(null));
  }
}