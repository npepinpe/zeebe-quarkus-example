/*
 * Copyright © 2021 camunda services GmbH (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.npepinpe.zeebe.quarkus.zeebe;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "zeebe")
public final class Config {
  private static final String DEFAULT_TARGET = "localhost:26500";

  String target = DEFAULT_TARGET;

  public String getTarget() {
    return target;
  }

  public void setTarget(final String target) {
    this.target = target;
  }
}
