package com.github.elibracha.utils;

import java.util.Optional;

import com.github.elibracha.model.Changed;

public class ChangedUtils {

  public static boolean isUnchanged(Changed changed) {
    return changed == null || changed.isUnchanged();
  }

  public static boolean isCompatible(Changed changed) {
    return changed == null || changed.isCompatible();
  }

  public static <T extends Changed> Optional<T> isChanged(T changed) {
    if (isUnchanged(changed)) {
      return Optional.empty();
    }
    return Optional.of(changed);
  }
}
