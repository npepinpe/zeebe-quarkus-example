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
import io.zeebe.client.api.response.BrokerInfo;
import io.zeebe.client.api.response.PartitionInfo;
import java.util.List;
import java.util.stream.Collectors;

@RegisterForReflection
public final class ReflectedBrokerInfo implements BrokerInfo {
  private final BrokerInfo delegate;

  public ReflectedBrokerInfo(final BrokerInfo delegate) {
    this.delegate = delegate;
  }

  @Override
  public int getNodeId() {
    return delegate.getNodeId();
  }

  @Override
  public String getHost() {
    return delegate.getHost();
  }

  @Override
  public int getPort() {
    return delegate.getPort();
  }

  @Override
  public String getAddress() {
    return delegate.getAddress();
  }

  @Override
  public String getVersion() {
    return delegate.getVersion();
  }

  @Override
  public List<PartitionInfo> getPartitions() {
    return delegate.getPartitions().stream()
        .map(ReflectedPartitionInfo::new)
        .collect(Collectors.toList());
  }
}
