package com.github.elibracha.model.schema;

import java.util.List;

import com.github.elibracha.model.ChangedList;
import com.github.elibracha.model.DiffContext;
import com.github.elibracha.model.DiffResult;

import lombok.Getter;

@Getter
public class ChangedRequired extends ChangedList<String> {

  public ChangedRequired(List<String> oldValue, List<String> newValue, DiffContext context) {
    super(oldValue, newValue, context);
  }

  @Override
  public DiffResult isItemsChanged() {
    if (context.isRequest() && getIncreased().isEmpty()
        || context.isResponse() && getMissing().isEmpty()) {
      return DiffResult.COMPATIBLE;
    }
    return DiffResult.INCOMPATIBLE;
  }
}
