package TimerApp;

public class TimerApp {

    public static void main(String[] args) {
        Timer timer = new Timer();
        Thread timerThread = new Thread(timer);
        timerThread.start();
    }
}

class Timer implements Runnable {
    private final long startTime = System.currentTimeMillis();

    @Override
    public void run() {
        while (true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = (currentTime - startTime) / 1000;

            if (elapsedTime % 5 == 0) {
                System.out.println("Минуло " + elapsedTime + " секунд");
            } else {
                System.out.println("Пройшло " + elapsedTime + " секунд");
            }

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}