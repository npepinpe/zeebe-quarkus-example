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
package io.github.npepinpe.zeebe.quarkus.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.zeebe.client.api.response.PartitionBrokerHealth;
import io.zeebe.client.api.response.PartitionBrokerRole;
import io.zeebe.client.api.response.PartitionInfo;

@RegisterForReflection
public final class ReflectedPartitionInfo implements PartitionInfo {
  private final PartitionInfo delegate;

  public ReflectedPartitionInfo(final PartitionInfo delegate) {
    this.delegate = delegate;
  }

  public int getPartitionId() {
    return delegate.getPartitionId();
  }

  public PartitionBrokerRole getRole() {
    return delegate.getRole();
  }

  public boolean isLeader() {
    return delegate.isLeader();
  }

  public PartitionBrokerHealth getHealth() {
    return delegate.getHealth();
  }
}
