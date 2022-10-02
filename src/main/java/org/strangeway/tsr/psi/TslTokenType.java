// Copyright 2000-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.strangeway.tsr.psi;

import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.strangeway.tsr.TslLanguage;

public final class TslTokenType extends IElementType {
  TslTokenType(@NotNull @NonNls String debugName) {
    super(debugName, TslLanguage.INSTANCE);
  }
}
