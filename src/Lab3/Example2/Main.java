package Lab1.src.Lab3.Example2;

public class Main {

    public static void main(String[] args){

        Buffer b = new Buffer();

        Producer pro = new Producer(b);

        Consumer c = new Consumer(b);

        Consumer c2 = new Consumer(b);

        pro.start();

        c.start(); c2.start();

    }

}

// Write a plantuml script to create the state machine diagram for package Lab1.src.Lab3.Example2
// The diagram should contain the following classes:
// - Buffer
// - Producer
// - Consumer
// - Main
// The diagram should contain the following states:
// - Producer
// - Consumer
// - Buffer
// - Main
// The diagram should contain the following transitions:
// - Producer -> Buffer
// - Buffer -> Consumer
// - Consumer -> Buffer
// - Buffer -> Producer
// - Main -> Producer
// - Main -> Consumer
// - Main -> Buffer
// The diagram should contain the following events:
// - start
// - run
// - get
// - put
// - sleep
// - print
// The diagram should contain the following actions:
// - Producer -> Buffer: put
// - Buffer -> Consumer: get
// - Consumer -> Buffer: get
// - Buffer -> Producer: put
// - Main -> Producer: start
// - Main -> Consumer: start
// - Main -> Buffer: start
// The diagram should contain the following guards:
// - Producer -> Buffer: true
// - Buffer -> Consumer: true
// - Consumer -> Buffer: true
// - Buffer -> Producer: true
// - Main -> Producer: true
// - Main -> Consumer: true
// - Main -> Buffer: true
// The diagram should contain the following activities:
// - Producer -> Buffer: put
// - Buffer -> Consumer: get
// - Consumer -> Buffer: get
// - Buffer -> Producer: put
// - Main -> Producer: start
// - Main -> Consumer: start
// - Main -> Buffer: start
// The diagram should contain the following notes:
// - Producer: Producer
// - Consumer: Consumer
// - Buffer: Buffer
// - Main: Main
// The diagram should contain the following stereotypes:
// - Producer: <<Producer>>
// - Consumer: <<Consumer>>
// - Buffer: <<Buffer>>
// - Main: <<Main>>
// The diagram should contain the following tags:
// - Producer: {thread}
// - Consumer: {thread}
// - Buffer: {thread}
// - Main: {thread}
// The diagram should contain the following title:
// - Lab3 Example2
// The diagram should contain the following caption:
// - Lab3 Example2
// The diagram should contain the following legend:
// - Producer: A class that produces items.
// - Consumer: A class that consumes items.
// - Buffer: A class that stores items.