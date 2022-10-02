// This is a generated file. Not intended for manual editing.
package org.strangeway.tsr.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.strangeway.tsr.psi.TslTokenTypes.*;
import org.strangeway.tsr.psi.*;

public class TslObjectIdImpl extends TslValueImpl implements TslObjectId {

  public TslObjectIdImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull TslVisitor visitor) {
    visitor.visitObjectId(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TslVisitor) accept((TslVisitor)visitor);
    else super.accept(visitor);
  }

}
