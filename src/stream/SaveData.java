package stream;

import assembly.ClanManager;
import assembly.Player;
import server.Manager;
import thiendiabang.ThienDiaBangManager;

public class SaveData implements Runnable {

    public Player player = null;

    @Override
    public void run() {
        try {
            Manager.isSaveData = true;
            if (Manager.isSaveData) {
                int i;
                synchronized (Client.gI().conns) {
                    for (i = 0; i < Client.gI().conns.size(); i++) {
                        if (Client.gI().conns.get(i) != null && Client.gI().conns.get(i).player != null) {
                            player = Client.gI().conns.get(i).player;
                            player.flush();
                        }
                    }
                }
                synchronized (ClanManager.entrys) {
                    for (i = 0; i < ClanManager.entrys.size(); i++) {
                        if (ClanManager.entrys.get(i) != null) {
                            ClanManager.entrys.get(i).flush();
                        }
                    }
                }
                synchronized (ThienDiaBangManager.thienDiaBangManager) {
                    ThienDiaBangManager.thienDiaBangManager[0].flush();
                    ThienDiaBangManager.thienDiaBangManager[1].flush();
                }
                Manager.isSaveData = false;
            }
            System.out.println("SaveData");
        } catch (Exception e) {
            Manager.isSaveData = false;
            System.out.println("...LoiCapNhat...");
            return;
        }
    }
}
