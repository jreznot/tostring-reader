/*
 * Copyright © 2022 Yuriy Artamonov
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the “Software”), to deal in the Software without
 * restriction, including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.strangeway.tsr;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.strangeway.tsr.psi.*;

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
    } else if (element instanceof TslObjectName) {
      holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
          .textAttributes(TslSyntaxHighlighter.TSL_CLASSNAME)
          .create();
    } else if (element instanceof TslFallbackStringLiteral) {
      holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
          .textAttributes(TslSyntaxHighlighter.TSL_STRING)
          .create();
    }
  }
}
