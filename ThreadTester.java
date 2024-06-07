
public class ThreadTester {

    public static void main(String[] args) {

        System.out.println("main is starting....");

        // 1- Using Thread Class
        // Thread thread1 = new Thread1("threadOne");

        /*
         * if all user threads are completed those execution. this daemon threads runs
         * on
         * the mercy of the JVM.
         */
        // thread.setDaemon(true);

        // Asynchronous
        // thread1.start();

        // using runnable interface
        // Thread thread2 = new Thread(new Thread2(),"thread2");
        // thread2.start();

        /*
         * Stack stack = new Stack(5);
         * 
         * new Thread(()->{
         * int counter = 0;
         * while(++counter<10){
         * System.out.println("Pushed: "+stack.push(100));
         * }
         * },"Pusher").start();
         * 
         * 
         * new Thread(()->{
         * int counter = 0;
         * while (++counter<10) {
         * System.out.println("Popped: "+stack.pop());
         * }
         * },"Popper").start();
         * 
         * 
         * 
         * System.out.println("main is existing...");
         * 
         */

        /*
         * Thread thread3 = new Thread(() -> {
         * try {
         * Thread.sleep(1);
         * for (int i = 1000; i > 0; i--) {
         * 
         * }
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * }, "States");
         * 
         * thread3.start();
         * 
         * while (true) {
         * 
         * Thread.State state = thread3.getState();
         * 
         * System.out.println(state);
         * 
         * if (state == Thread.State.TERMINATED) {
         * break;
         * }
         * 
         * }
         * 
         */

        /*
         * 
         * 
         * Thread thread = new Thread(()->{
         * 
         * System.out.println(Thread.currentThread());
         * 
         * },"Our Thread");
         * 
         * thread.start(); // by default it's asynchronous
         * 
         * // we can use join()
         * 
         * 
         * // it will wait current run on which we called join operation to complete
         * first.
         * // then your program starts executing.- ideally it blocks the main method to
         * stop execution parallel.
         * // after completion of current thread execution, main thread starts executing
         * 
         * // join - all the child threads completes first. then the program execution
         * flow continue(parent threads).
         * try {
         * thread.join();
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * 
         * 
         */

        // DEADLOCK CREATING PROGRAM
        // each thread holding the resource and waiting for other resources hold by
        // other threads . and these threads doing the same --> circular dependency.

        // create 2 threads --> assign lock objects in reverse order for each threads.

        String lock1 = "shiva";
        String lock2 = "arukonda";

        // 1st thread
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Lock Acquired...");
                }
            }
        }, "Thread1");

        // 2nd thread
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("lock acquired...");
                }
            }
        }, "Thread2");

        thread1.start();
        thread2.start();

        // System.out.println("main is exiting....");

    }

}
