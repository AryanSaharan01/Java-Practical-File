public class ThreadMethodsDemo {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();

        System.out.println("Thread Name: " + mainThread.getName());
        System.out.println("Thread Priority: " + mainThread.getPriority());
        System.out.println("Thread ID: " + mainThread.getId());
        System.out.println("Thread State: " + mainThread.getState());
        System.out.println("Thread isDaemon: " + mainThread.isDaemon());
        System.out.println("Thread isAlive: " + mainThread.isAlive());

        // Creating a new thread
        Thread newThread = new Thread(() -> {
            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });

        newThread.setName("NewThread");
        newThread.setPriority(Thread.MIN_PRIORITY);

        System.out.println("Thread Name (newThread): " + newThread.getName());
        System.out.println("Thread Priority (newThread): " + newThread.getPriority());
        System.out.println("Thread ID (newThread): " + newThread.getId());
        System.out.println("Thread State (newThread): " + newThread.getState());
        System.out.println("Thread isDaemon (newThread): " + newThread.isDaemon());
        System.out.println("Thread isAlive (newThread): " + newThread.isAlive());
    }
}
