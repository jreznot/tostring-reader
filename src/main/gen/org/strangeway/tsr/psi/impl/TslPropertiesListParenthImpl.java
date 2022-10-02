// This is a generated file. Not intended for manual editing.
package org.strangeway.tsr.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.strangeway.tsr.psi.TslTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.strangeway.tsr.psi.*;

public class TslPropertiesListParenthImpl extends ASTWrapperPsiElement implements TslPropertiesListParenth {

  public TslPropertiesListParenthImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TslVisitor visitor) {
    visitor.visitPropertiesListParenth(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TslVisitor) accept((TslVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TslKeyValueParenth> getKeyValueParenthList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TslKeyValueParenth.class);
  }

}
