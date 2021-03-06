package com.github.elibracha.model.schema;

import java.util.Objects;

import com.github.elibracha.model.Changed;
import com.github.elibracha.model.DiffContext;
import com.github.elibracha.model.DiffResult;

public class ChangedMaxLength implements Changed {
  private final Integer oldValue;
  private final Integer newValue;
  private final DiffContext context;

  public ChangedMaxLength(Integer oldValue, Integer newValue, DiffContext context) {
    this.oldValue = oldValue;
    this.newValue = newValue;
    this.context = context;
  }

  @Override
  public DiffResult isChanged() {
    if (Objects.equals(oldValue, newValue)) {
      return DiffResult.NO_CHANGES;
    }
    if (context.isRequest() && (newValue == null || oldValue != null && oldValue <= newValue)
        || context.isResponse() && (oldValue == null || newValue != null && newValue <= oldValue)) {
      return DiffResult.COMPATIBLE;
    }
    return DiffResult.INCOMPATIBLE;
  }
}
