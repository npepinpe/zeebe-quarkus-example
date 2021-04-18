# Zeebe Quarkus Example 

A small toy example of using Zeebe with Quarkus, mostly to show how to compile a native image with a Zeebe client using
Quarkus.

## Supported Zeebe versions

Release versions follow the same versioning as Zeebe versions, with the same compatibility
guarantees.

## Quickstart

You can build the native image by using:

```sh
mvn -Pnative clean package -DskipTests -T1C
```

And run it using:

```sh
target/zeebe-quarkus-example-0.26.4-SNAPSHOT-runner
```

By default, it will look for a server at localhost:26500.

To test the topology, you can call:

```sh
curl -v http://localhost:9090/status
```

> Note that this currently breaks due to serialization issues, since the TopologyImpl stuff isn't registered. This
> example is more about showing native image compilation than anything else however, but a PR to fix that is more than
> welcome.

## Reusing

If you want to build a Quarkus application which interacts with Zeebe, the important bits to add are the resources under
[src/main/resources/META-INF/native-image](src/main/resources/META-INF/native-image) and the following dependencies to
your pom.xml:

```xml
    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-grpc-common-deployment</artifactId>
    </dependency>

    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-grpc-common</artifactId>
    </dependency>

    <dependency>
      <groupId>io.quarkus</groupId>
      <artifactId>quarkus-netty</artifactId>
    </dependency>
```

> NOTE: I'm not sure `quarkus-grpc-common-deployment` is actually necessary, but the other are definitely are. They
> include important SVM substitutions to allow you to AOT compile Netty/gRPC classes.

When adding the resources, remember that you should change the directory such that it follows the `groupId/artifactId`
pattern, e.g. `src/resources/META-INF/native-image/com.acme/my-cool-artifact`.

These resources specify some classes which should be initialized at build time, or delayed to be initialized at run time
only, as well as ensuring some necessary resources are included during compilation.
