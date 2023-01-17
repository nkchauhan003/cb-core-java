package concurrency.signaling;

public class BetterThreadSignaling {

    private static class WaitNotify {
        private static MonitorObject monitorObject;
        boolean isSignalled = false;

        public WaitNotify(MonitorObject monitorObject) {
            this.monitorObject = monitorObject;
        }

        public void doWait() {
            synchronized (monitorObject) {
                if (!isSignalled) {
                    try {
                        monitorObject.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //clear signal
                isSignalled = false;
            }
        }

        public void doNotify() {
            synchronized (monitorObject) {
                isSignalled = true;
                monitorObject.notify();
            }
        }
    }

    private static class MonitorObject {
    }
}
