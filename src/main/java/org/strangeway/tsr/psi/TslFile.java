package org.strangeway.tsr.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.strangeway.tsr.TslFileType;
import org.strangeway.tsr.TslLanguage;

public final class TslFile extends PsiFileBase {
  public TslFile(@NotNull FileViewProvider viewProvider) {
    super(viewProvider, TslLanguage.INSTANCE);
  }

  @Override
  public @NotNull FileType getFileType() {
    return TslFileType.INSTANCE;
  }

  @Override
  public String toString() {
    return "TslFile";
  }
}
