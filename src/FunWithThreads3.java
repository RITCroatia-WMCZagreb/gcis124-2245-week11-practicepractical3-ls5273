/*
@ASSESSME.USERID: ls5273
@ASSESSME.AUTHOR: Lana Sorak
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.ANALYZE: YES
*/

//One common counter, 2 threads are adding 1 40,000 times
//The final result should be 80,000

public class FunWithThreads3 {
    private int counter;
    private Object lock;


    //Constructor of FunWithThreads
    public FunWithThreads3() throws InterruptedException {
        System.out.println("MAIN START");

        counter = 0;
        this.lock = new Object();

        //Creating threads
        Thread t1 = new Thread(new MyThread("1"));
        Thread t2 = new Thread(new MyThread("2"));

        //They start and work at the smae time 
        //The lock is making them increment one at a time
        t1.start();
        t2.start();

        //Threads must finish before we can print the result
        t1.join();
        t2.join();
       
        System.out.println("COUNTER:" + this.counter);
       
        System.out.println("MAIN END");
    }


    //Inner Thread
    class MyThread implements Runnable{
        private String name;

        public MyThread(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Thread " + this.name + " starts looping 40000.");

            for(int i=0;i<40000;i++) {
               synchronized(lock) {
                 counter++; //RACE CONDITION
               }
            }

            System.out.println("Thread " + this.name + " ends.");
        }
    }


    //MAIN
    public static void main(String[] args) throws Exception {
        
        new FunWithThreads3();

    }
}

