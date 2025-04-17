package stream;

import server.Manager;

public class Admin implements Runnable {

    private int timeCount;
    private final Server server;

    public Admin(int minues, Server server) {
        this.timeCount = minues;
        this.server = server;
    }
    @Override
    public void run() {
        try {
            while (timeCount > 0) {
                Manager.serverChat("Thông Báo Sever", "Máy Chủ Sẽ Bảo Trì Sau " + timeCount + " Phút Nữa! Vui Lòng Thoát Game Để Tránh Mất Dữ Liệu");
                timeCount--;
                Thread.sleep(60000);
            }
            if (timeCount == 0) {
                Server.close(100L);
            }
        } catch (Exception e) {
            System.err.println("ERROR");
            e.printStackTrace();
        }
    }

}
