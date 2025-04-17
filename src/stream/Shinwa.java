package stream;

import server.ShinwaManager;
import template.ShinwaTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class Shinwa extends Thread {

    @Override
    public void run() {
        try {
            while (Server.running) {
                synchronized (ShinwaManager.entrys) {
                    for (int i = 0; i <= 11; i++) {
                        List<ShinwaTemplate> list = ShinwaManager.entrys.get(i);
                        if (list != null) {
                            List<ShinwaTemplate> listExpired = list.stream().filter(item -> item.isExpired()).collect(Collectors.toList());
                            for (ShinwaTemplate item : listExpired) {
                                ShinwaManager.update(item, i);
                            }
                        }
                    }
                    ShinwaManager.flush();
                }
                Thread.sleep(360000);
            }
            return;
        } catch (Exception e) {
        }
    }
}
