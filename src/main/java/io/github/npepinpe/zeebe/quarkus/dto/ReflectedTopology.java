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
import io.zeebe.client.api.response.Topology;
import java.util.List;
import java.util.stream.Collectors;

@RegisterForReflection
public final class ReflectedTopology implements Topology {
  private final Topology topology;

  public ReflectedTopology(final Topology topology) {
    this.topology = topology;
  }

  @Override
  public List<BrokerInfo> getBrokers() {
    return topology.getBrokers().stream()
        .map(ReflectedBrokerInfo::new)
        .collect(Collectors.toList());
  }

  @Override
  public int getClusterSize() {
    return topology.getClusterSize();
  }

  @Override
  public int getPartitionsCount() {
    return topology.getPartitionsCount();
  }

  @Override
  public int getReplicationFactor() {
    return topology.getReplicationFactor();
  }

  @Override
  public String getGatewayVersion() {
    return topology.getGatewayVersion();
  }
}
