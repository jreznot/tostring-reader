package org.strangeway.tsr;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.strangeway.tsr.psi.TslKey;

public final class TslAnnotator implements Annotator {
  @Override
  public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
    if (element instanceof TslKey) {
      holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
          .textAttributes(TslSyntaxHighlighter.TSL_FIELD_NAME)
          .create();
    }
  }
}
