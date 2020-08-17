package com.github.elibracha.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangedSecuritySchemeScopes extends ChangedList<String> {

  public ChangedSecuritySchemeScopes(List<String> oldValue, List<String> newValue) {
    super(oldValue, newValue, null);
  }

  @Override
  public DiffResult isItemsChanged() {
    return DiffResult.INCOMPATIBLE;
  }
}
