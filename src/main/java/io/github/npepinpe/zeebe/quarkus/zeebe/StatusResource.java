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

import io.smallrye.mutiny.Uni;
import io.zeebe.client.api.ZeebeFuture;
import io.zeebe.client.api.response.Topology;
import java.time.Duration;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
public class StatusResource {
  @Inject Client client;

  @GET
  public Uni<Response> get() {
    final ZeebeFuture<Topology> request =
        client.newTopologyRequest().requestTimeout(Duration.ofSeconds(5)).send();

    return Uni.createFrom()
        .completionStage(request)
        .onItem()
        .transform(Response::ok)
        .map(ResponseBuilder::build);
  }
}
