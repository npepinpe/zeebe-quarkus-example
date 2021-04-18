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
