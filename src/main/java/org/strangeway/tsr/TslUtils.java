package org.strangeway.tsr;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.strangeway.tsr.psi.*;

import java.util.List;

public final class TslUtils {
  private TslUtils() {
  }

  public static boolean isCompactPropertyBlock(PsiElement psiElement) {
    if (psiElement instanceof TslMap) {
      var map = ((TslMap) psiElement);
      if (map.getMapItemList().size() > 1) {
        return false;
      }

      if (map.getMapItemList().isEmpty()) {
        return true;
      }

      TslMapItem mapItem = map.getMapItemList().get(0);
      if (mapItem.getValue() == null) {
        return true;
      }

      return isPrimitive(mapItem.getValue()) && isPrimitive(mapItem.getMapKey().getValue());
    } else if (psiElement instanceof TslObject) {
      var object = ((TslObject) psiElement);
      List<TslPropertyKeyValue> properties = object.getPropertyKeyValueList();

      if (properties.isEmpty()) {
        return true;
      }
      if (properties.size() > 1) {
        return false;
      }

      TslPropertyKeyValue property = properties.get(0);
      return property.getValue() == null || isPrimitive(property.getValue());
    } else if (psiElement instanceof TslList) {
      return ((TslList) psiElement).getValueList().isEmpty();
    }

    return false;
  }

  public static boolean isPrimitive(@NotNull TslValue value) {
    return value instanceof TslNullLiteral
        || value instanceof TslStringLiteral
        || value instanceof TslNumberLiteral
        || value instanceof TslBooleanLiteral
        || value instanceof TslObjectRef
        || value instanceof TslObjectId;
  }
}
