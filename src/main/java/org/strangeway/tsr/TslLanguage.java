package org.strangeway.tsr;

import com.intellij.lang.Language;

public final class TslLanguage extends Language {
  public static final TslLanguage INSTANCE = new TslLanguage();

  public TslLanguage() {
    super("ToString");
  }

  @Override
  public boolean isCaseSensitive() {
    return true;
  }
}
