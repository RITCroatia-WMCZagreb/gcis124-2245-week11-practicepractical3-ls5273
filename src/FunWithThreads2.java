/*
@ASSESSME.USERID: ls5273
@ASSESSME.AUTHOR: Lana Sorak
@ASSESSME.LANGUAGE: JAVA
@ASSESSME.ANALYZE: YES
*/


public class FunWithThreads2 {

    //Constructor of FunWithThreads
    public FunWithThreads2() throws InterruptedException {
        System.out.println("MAIN START");

        Thread t1 = new Thread(new MyThread(1));
        Thread t2 = new Thread(new MyThread(2));	

        t1.start();
        
        Thread.sleep(4000);

        t2.start();

        t1.join();
    
        System.out.println("MAIN END");

    }

    //Inner class
    class MyThread implements Runnable {
        private int name;

        public MyThread(int name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Thread start: Thread " + this.name);
    
            for(int i=0; i<10; i++) {
                System.out.println("Thread " + this.name + " " + i);
                try {
                    Thread.sleep(1000);
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Thread end: Thread " + this.name);
        }
    }

    
    public static void main(String[] args) throws Exception {
        
        new FunWithThreads2();

    }
}

/*
    Main Thread START
    Thread start:Thread 1
    Thread 1 0
    Thread 1 1
    Thread 1 2
    Thread 1 3
    Thread start:Thread 2
    Thread 1 4
    Thread 2 0
    Thread 1 5
    Thread 2 1
    Thread 2 2
    Thread 1 7
    Thread 2 3
    Thread 1 8
    Thread 2 4
    Thread 1 9
    Thread end:Thread 1
    Main Thread END
    Thread 2 5
    Thread 2 6
    Thread 2 7
    Thread 2 8
    Thread 2 9
    Thread end:Thread 2
 */