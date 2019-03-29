/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.exec.vector.expressions;

import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor;
import org.apache.hadoop.hive.ql.exec.vector.VectorExpressionDescriptor.Descriptor;

/**
 * Vectorized implementation of trunc(number) function for decimal input
 */
public class TruncDecimalNoScale extends TruncDecimal {
  private static final long serialVersionUID = 1L;

  public TruncDecimalNoScale() {
    super();
    colNum = -1;
  }

  public TruncDecimalNoScale(int colNum, int outputColumnNum) {
    super(colNum, 0, outputColumnNum);
  }

  @Override
  public Descriptor getDescriptor() {
    VectorExpressionDescriptor.Builder b = new VectorExpressionDescriptor.Builder();
    b.setMode(VectorExpressionDescriptor.Mode.PROJECTION).setNumArguments(1)
        .setArgumentTypes(getInputColumnType())
        .setInputExpressionTypes(VectorExpressionDescriptor.InputExpressionType.COLUMN);
    return b.build();
  }
}