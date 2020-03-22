/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import thread.MyRunnable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import thread.MyCallable;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) throws Exception {
        
        //run edende sira ile chapa verilir
        ExecutorService service = Executors.newSingleThreadExecutor();
        MyCallable[] arr = new MyCallable[3];
        arr[0] = new MyCallable(1);
        arr[1] = new MyCallable(2);
        arr[2] = new MyCallable(3);
//        MyRunnable[] arr = new MyRunnable[3];
//        arr[0]=new MyRunnable(1);
//        arr[1]=new MyRunnable(2);
//        arr[2]=new MyRunnable(3);
//        service.invokeAll(arr.length);
        service.invokeAny(Arrays.asList(arr));
        System.out.println("terminated");

    }

    //budilnik evezidir
    public static void schelu() {
        ScheduledExecutorService e = Executors.newScheduledThreadPool(1);
        e.schedule(new MyRunnable(1), 10, TimeUnit.SECONDS);
    }

    //nece thread yaransin nece saniye islesin ves.
    public static void chachedthreadpool() {
        ExecutorService service = new ThreadPoolExecutor(10, 15, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20));
    }
    //ilk 5 threadi ise salir sonrakilar ise qarisir

    public static void fixedex() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            service.submit(new MyRunnable(i));
        }
    }

    public static void singleThreadExecutor() {
        //threadleri ardicilligla ise salir join edir
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(new MyRunnable(2));
        service.submit(new MyRunnable(3));
        service.submit(new MyRunnable(4));
        service.submit(new MyRunnable(5));
        service.submit(new MyRunnable(6));
    }

}
