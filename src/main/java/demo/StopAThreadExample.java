package demo;

public class StopAThreadExample implements Runnable {

    private boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    private synchronized boolean keepRunning() {
        return this.doStop == false;
    }

    public void run() {
        while(keepRunning()) {
            // keep doing what this thread should do.
            System.out.println("Running");

            try {
                Thread.sleep(3L * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    
}

class MyRunnableMain {

    public static void main(String[] args) {
    	StopAThreadExample stopAThread = new StopAThreadExample();

        Thread thread = new Thread(stopAThread);

        thread.start();

        try {
            Thread.sleep(10L * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stopAThread.doStop();
    }
    
    /*
     * This example first creates a MyRunnable instance,
     *  then passes that instance to a thread and starts the thread. 
     *  Then the thread executing the main() method (the main thread) sleeps for 10 seconds, 
     *  and then calls the doStop() method of the MyRunnable instance. 
     *  This will cause the thread executing the MyRunnable method to stop, 
     *  because the keepRunning() will return true after doStop() is called.
     */
}
