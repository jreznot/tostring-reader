package org.strangeway.tsr;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class TslFileType extends LanguageFileType {

  public static final TslFileType INSTANCE = new TslFileType();

  public TslFileType() {
    super(TslLanguage.INSTANCE);
  }

  @Override
  public @NonNls @NotNull String getName() {
    return "ToString";
  }

  @Override
  public @NotNull String getDescription() {
    return "Java toString output";
  }

  @Override
  public @NotNull String getDefaultExtension() {
    return "toString";
  }

  @Override
  public Icon getIcon() {
    return TslIcons.FILE_ICON;
  }
}
