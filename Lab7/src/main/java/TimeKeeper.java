public class TimeKeeper implements Runnable {
    private int timeLimit;

    private int nrSec = 0;
    private long start;
    private boolean gameIsOver = false;

    public TimeKeeper(int timeLimit) {
        this.timeLimit = timeLimit;
        start = System.currentTimeMillis();
    }

    @Override
    public void run() {
        while(!gameIsOver) {
            long end = System.currentTimeMillis();
            if ((end - start) / 1e3 > nrSec) {
                nrSec++;
                System.out.println("Au trecut " + nrSec + " secunde.");
            }

            if(nrSec >= timeLimit) {
                System.out.println("A trecut timpul alocat");
                System.exit(0);
            }
        }
    }

    public int getNrSec() {
        return nrSec;
    }

    public void setNrSec(int nrSec) {
        this.nrSec = nrSec;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }
}
