package com.gasolinera.gasolinera;

import java.util.LinkedList;
import java.util.Queue;

public class Semaphore {

    private int counter;
    private Queue<Threads> queue = new LinkedList<>();

    public Semaphore( int permits ){
        counter = permits;
    }

    public void acquire(String name, Threads obj){
        synchronized (this) {
            counter--;
        }
        if ( counter < 0  ){
            System.out.println(name + " Waiting in the Queue");

            try {
                queue.add(obj);
                obj.join();
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }

    public void release(){
        counter++;

        if ( !queue.isEmpty() ){
            Threads customer = queue.remove();
            customer.interrupt();
        }


    }

    public int getCounter() {
        return counter;
    }
}
