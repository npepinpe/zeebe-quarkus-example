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

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.zeebe.client.impl.response.BrokerInfoImpl;
import io.zeebe.client.impl.response.PartitionInfoImpl;
import io.zeebe.client.impl.response.TopologyImpl;

@RegisterForReflection(
    targets = {TopologyImpl.class, BrokerInfoImpl.class, PartitionInfoImpl.class})
public class Reflection {}
