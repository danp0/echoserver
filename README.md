# echoserver

A sample echo server.

## Building

You will need [lein](https://leiningen.org) to build this project.

## Usage

Echo back the messages received on a TCP socket. A dollar prompt '$'
is displayed. Enter *exit* to exit.

    $ java -jar echoserver-0.1.0-standalone.jar -p <PORT>

## Options

-p <PORT>  The port number for the server to listen on.

## Examples

    $ java -jar echoserver-0.1.0-standalone.jar -p 5000
    $ exit
    $

### Bugs

...

## License

Copyright © 2017 D. Pollind

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
