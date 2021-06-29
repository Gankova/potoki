package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
       // по умолчанию для каждого процесса запускается однин поток по умолчанию (0-threa)
       // при завершении 0-го потока завершается весь процесс
        /*long t =System.currentTimeMillis(); - один поток
        doSomething();
        System.out.println(Systemло.currentTimeMillis()-t);*/

        Thread t1 = new Thread(Main::doSomething1);
        Thread t2 = new Thread(Main::doSomething2);
        // Создание объекта потока не равно его запуску
        long t =System.currentTimeMillis(); //oдин поток
        t1.start();// запуск потока с помощью метода start
        t2.start();
        t1.join();// приостанавливает 0- поток, пок ане завершится данный
        t2.join();
        System.out.println(System.currentTimeMillis()-t);



    }
    public static void doSomething(){
        for (int i = 0; i < 100000000; i++){
            double d = Math.acos(12*i)/Math.sin(Math.sqrt(525.0)+Math.log10(5));
        }
    }
    public static void doSomething1(){
        for (int i = 0; i < 50000000; i++){
            double d = Math.acos(12*i)/Math.sin(Math.sqrt(525.0)+Math.log10(5));
        }
    }
    public static void doSomething2(){
        for (int i = 50000000; i < 100000000; i++){
            double d = Math.acos(12*i)/Math.sin(Math.sqrt(525.0)+Math.log10(5));
        }
    }
}
