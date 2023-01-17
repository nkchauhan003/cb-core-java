package concurrency.signaling;

public class ThreadSignaling {

    private static class WaitNotify {
        private MonitorObject monitorObject;

        public WaitNotify(MonitorObject monitorObject) {
            this.monitorObject = monitorObject;
        }

        public void doWait() {
            synchronized (monitorObject) {
                try {
                    monitorObject.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void doNotify() {
            synchronized (monitorObject) {
                monitorObject.notify();
            }
        }
    }

    private static class MonitorObject {
    }
}
