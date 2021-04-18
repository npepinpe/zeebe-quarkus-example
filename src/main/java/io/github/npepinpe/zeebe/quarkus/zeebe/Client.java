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

import io.quarkus.runtime.Startup;
import io.zeebe.client.ZeebeClient;
import io.zeebe.client.ZeebeClientConfiguration;
import io.zeebe.client.api.command.ActivateJobsCommandStep1;
import io.zeebe.client.api.command.CancelWorkflowInstanceCommandStep1;
import io.zeebe.client.api.command.CompleteJobCommandStep1;
import io.zeebe.client.api.command.CreateWorkflowInstanceCommandStep1;
import io.zeebe.client.api.command.DeployWorkflowCommandStep1;
import io.zeebe.client.api.command.FailJobCommandStep1;
import io.zeebe.client.api.command.PublishMessageCommandStep1;
import io.zeebe.client.api.command.ResolveIncidentCommandStep1;
import io.zeebe.client.api.command.SetVariablesCommandStep1;
import io.zeebe.client.api.command.ThrowErrorCommandStep1;
import io.zeebe.client.api.command.TopologyRequestStep1;
import io.zeebe.client.api.command.UpdateRetriesJobCommandStep1;
import io.zeebe.client.api.worker.JobWorkerBuilderStep1;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Startup
@ApplicationScoped
public class Client implements ZeebeClient {
  @Inject Config config;

  private ZeebeClient client;

  @PostConstruct
  public void constructor() {
    client =
        ZeebeClient.newClientBuilder().usePlaintext().gatewayAddress(config.getTarget()).build();
  }

  @PreDestroy
  public void destructor() {
    client.close();
  }

  @Override
  public TopologyRequestStep1 newTopologyRequest() {
    return client.newTopologyRequest();
  }

  @Override
  public ZeebeClientConfiguration getConfiguration() {
    return client.getConfiguration();
  }

  @Override
  public void close() {
    client.close();
  }

  @Override
  public DeployWorkflowCommandStep1 newDeployCommand() {
    return client.newDeployCommand();
  }

  @Override
  public CreateWorkflowInstanceCommandStep1 newCreateInstanceCommand() {
    return client.newCreateInstanceCommand();
  }

  @Override
  public CancelWorkflowInstanceCommandStep1 newCancelInstanceCommand(
      final long workflowInstanceKey) {
    return client.newCancelInstanceCommand(workflowInstanceKey);
  }

  @Override
  public SetVariablesCommandStep1 newSetVariablesCommand(final long elementInstanceKey) {
    return client.newSetVariablesCommand(elementInstanceKey);
  }

  @Override
  public PublishMessageCommandStep1 newPublishMessageCommand() {
    return client.newPublishMessageCommand();
  }

  @Override
  public ResolveIncidentCommandStep1 newResolveIncidentCommand(final long incidentKey) {
    return client.newResolveIncidentCommand(incidentKey);
  }

  @Override
  public UpdateRetriesJobCommandStep1 newUpdateRetriesCommand(final long jobKey) {
    return client.newUpdateRetriesCommand(jobKey);
  }

  @Override
  public JobWorkerBuilderStep1 newWorker() {
    return client.newWorker();
  }

  @Override
  public ActivateJobsCommandStep1 newActivateJobsCommand() {
    return client.newActivateJobsCommand();
  }

  @Override
  public CompleteJobCommandStep1 newCompleteCommand(final long jobKey) {
    return client.newCompleteCommand(jobKey);
  }

  @Override
  public FailJobCommandStep1 newFailCommand(final long jobKey) {
    return client.newFailCommand(jobKey);
  }

  @Override
  public ThrowErrorCommandStep1 newThrowErrorCommand(final long jobKey) {
    return client.newThrowErrorCommand(jobKey);
  }
}
