package com.github.elibracha.model.schema;

import com.github.elibracha.model.ChangedList;
import com.github.elibracha.model.DiffContext;
import com.github.elibracha.model.DiffResult;
import lombok.Getter;


import java.util.List;


@Getter
public class ChangedEnum<T> extends ChangedList<T> {

  public ChangedEnum(List<T> oldValue, List<T> newValue, DiffContext context) {
    super(oldValue, newValue, context);
  }

  @Override
  public DiffResult isItemsChanged() {
    if (context.isRequest() && getMissing().isEmpty()
        || context.isResponse() && getIncreased().isEmpty()) {
      return DiffResult.COMPATIBLE;
    }
    return DiffResult.INCOMPATIBLE;
  }
}
