// Copyright (c) 2009 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.jetbrains.debugger;

import com.intellij.openapi.util.ActionCallback;
import org.jetbrains.annotations.NotNull;

/**
 * An object that represents a browser JavaScript VM variable value (compound or atomic).
 * <p>In some backends values (currently only strings) are loaded with a size limit.
 * The value part that exceeds the limit is truncated. The full value
 * can be loaded by {@link #reloadHeavyValue} method.
 */
public interface Value extends EvaluateContextAdditionalParameter {
  @NotNull
  ValueType getType();

  /**
   * @return a string representation of this value
   */
  String getValueString();

  boolean isTruncated();

  int getActualLength();

  /**
   * Asynchronously reloads object value with extended size limit
   */
  ActionCallback reloadHeavyValue();
}
