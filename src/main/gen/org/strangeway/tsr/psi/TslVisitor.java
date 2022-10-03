// This is a generated file. Not intended for manual editing.
package org.strangeway.tsr.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class TslVisitor extends PsiElementVisitor {

  public void visitBooleanLiteral(@NotNull TslBooleanLiteral o) {
    visitValue(o);
  }

  public void visitKey(@NotNull TslKey o) {
    visitPsiElement(o);
  }

  public void visitKeyValue(@NotNull TslKeyValue o) {
    visitPsiElement(o);
  }

  public void visitList(@NotNull TslList o) {
    visitValue(o);
  }

  public void visitNullLiteral(@NotNull TslNullLiteral o) {
    visitValue(o);
  }

  public void visitNumberLiteral(@NotNull TslNumberLiteral o) {
    visitValue(o);
  }

  public void visitObjectBrace(@NotNull TslObjectBrace o) {
    visitValue(o);
  }

  public void visitObjectId(@NotNull TslObjectId o) {
    visitValue(o);
  }

  public void visitObjectParenth(@NotNull TslObjectParenth o) {
    visitValue(o);
  }

  public void visitObjectRef(@NotNull TslObjectRef o) {
    visitValue(o);
  }

  public void visitPropertiesList(@NotNull TslPropertiesList o) {
    visitPsiElement(o);
  }

  public void visitStringLiteral(@NotNull TslStringLiteral o) {
    visitValue(o);
  }

  public void visitValue(@NotNull TslValue o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
