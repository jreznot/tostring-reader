package org.strangeway.tsr;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.strangeway.tsr.psi.TslMapKey;
import org.strangeway.tsr.psi.TslObjectId;
import org.strangeway.tsr.psi.TslPropertyKey;
import org.strangeway.tsr.psi.TslPropertyKeyValue;

import javax.management.ObjectName;
import java.util.regex.Pattern;

final class TslAnnotator implements Annotator {

  private final Pattern ALL_UPPERCASE = Pattern.compile("[A-Z]+");

  @Override
  public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
    if (element instanceof TslPropertyKey) {
      holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
          .textAttributes(TslSyntaxHighlighter.TSL_FIELD_NAME)
          .create();
    } else if (element instanceof TslObjectId) {
      if (ALL_UPPERCASE.matcher(element.getText()).matches()) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .textAttributes(TslSyntaxHighlighter.TSL_CONSTANT)
            .create();
      } else if (element.getParent() instanceof TslMapKey
          || element.getParent() instanceof TslPropertyKeyValue) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .textAttributes(TslSyntaxHighlighter.TSL_FIELD_NAME)
            .create();
      }
    } else if (element instanceof ObjectName) {
      holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
          .textAttributes(TslSyntaxHighlighter.TSL_CLASSNAME)
          .create();
    }
  }
}
