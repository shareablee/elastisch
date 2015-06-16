# Elastisch, a Clojure client for ElasticSearch

Elastisch is a minimalistic [Clojure client for
ElasticSearch](http://clojureelasticsearch.info), a modern distributed search engine.

## Change Log

### Version 2.2.0-beta5
* Releasing the editited version of elastisch. Later features of the client have been backported to the older version of the client we use (for 0.9 compatibility reasons)

## Project Goals

 * Be reasonably feature complete
 * Be [well documented](http://clojureelasticsearch.info)
 * Be [well tested](https://github.com/clojurewerkz/elastisch/tree/master/test)
 * Closely follow [ElasticSearch API structure](http://www.elasticsearch.org/guide/reference/api/), no new abstractions introduced
 * Support multiple transports: HTTP, native ES client, possibly more (e.g. Memcached)
 * Follow recent ElasticSearch releases & developments


## Community

[Elastisch has a mailing
list](https://groups.google.com/forum/#!forum/clojure-elasticsearch). Feel
free to join it and ask any questions you may have.

To subscribe for announcements of releases, important changes and so
on, please follow [@ClojureWerkz](https://twitter.com/#!/clojurewerkz)
on Twitter.



## Project Maturity

Elastisch is a not a young project. Started in late 2011, it has been used
in production since the early days.  Elastisch API is stabilized. 1.0 has
been released in September 2012.



## Artifacts

Elastisch artifacts are [released to Clojars](https://clojars.org/clojurewerkz/elastisch).

If you are using Maven, add the following repository definition to your `pom.xml`:

``` xml
<repository>
  <id>clojars.org</id>
  <url>http://clojars.org/repo</url>
</repository>
```

### The Most Recent Release

With Leiningen:

    [clojurewerkz/elastisch "1.3.0"]


With Maven:

    <dependency>
      <groupId>clojurewerkz</groupId>
      <artifactId>elastisch</artifactId>
      <version>1.3.0</version>
    </dependency>



## Documentation & Examples

Please see our [documentation guides site](http://clojureelasticsearch.info/).

Our [test suite](https://github.com/clojurewerkz/elastisch/tree/master/test/clojurewerkz/elastisch) also has many code examples.



## Supported Clojure Versions

Elastisch requires Clojure 1.4.
The most recent stable release is highly recommended.


## REST and Native Clients

Elastisch provides HTTP and native (transport) clients with nearly
identical API as of `1.1.0`.



## Elastisch Is a ClojureWerkz Project

Elastisch is part of the group of [Clojure libraries](http://clojurewerkz.org) known as ClojureWerkz, together with

 * [Monger](https://clojuremongodb.info)
 * [Welle](https://clojureriak.info)
 * [Langohr](https://clojurerabbitmq.info)
 * [Neocons](https://clojureneo4j.info)
 * [Quartzite](https://clojurequartz.info)
 * [Titanium](https://titanium.clojurewerkz.org)

and several others.


## Continuous Integration

[![Continuous Integration status](https://secure.travis-ci.org/clojurewerkz/elastisch.png)](http://travis-ci.org/clojurewerkz/elastisch)


## Development

### ElasticSearch Setup

Elastisch needs ElasticSearch running locally (`127.0.0.1`). `ES_CLUSTER_NAME` need to be exported
with the name of the local cluster. To find it out, use

```
curl http://localhost:9200/_cluster/nodes
```

### Running Tests

To run Elastisch tests, make sure you have ElasticSearch running. It must be the same
version that Elastisch depends on due to binary protocol changes between releases.
[project.clj](project.clj) or [project page on Clojars](https://clojars.org/clojurewerkz/elastisch)
can help find that out.

Finally, run all tests with

    lein all test

To run only HTTP client tests, use

    lein all test :ci


### Leiningen

Elastisch uses [Leiningen 2](https://github.com/technomancy/leiningen/blob/master/doc/TUTORIAL.md). Make
sure you have it installed and then run tests against all supported Clojure versions using

    lein2 all test

Then create a branch and make your changes on it. Once you are done
with your changes and all tests pass, submit a pull request on GitHub.



## License

Copyright (C) 2011-2014 Alex Petrov, Michael S. Klishin

Distributed under the Eclipse Public License, the same as Clojure.


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/clojurewerkz/elastisch/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

