package stream;

import assembly.Char;
import assembly.Map;
import server.Manager;
import server.Service;

import java.util.*;

public class ChienTruong {

    public static ChienTruong chienTruong = null;

    public static boolean chienTruong50 = false;
    public static boolean chienTruong100 = false;
    public static int pointBachGia = 0;
    public static int pointHacGia = 0;
    public static boolean finish;
    public static boolean start;
    public static String review;
    public static HashMap<Char, Integer> bxhCT = new HashMap<>();
    public static int pheWin = -1;

    public static HashMap sortBXH(HashMap map) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((java.util.Map.Entry) (o2)).getValue())
                        .compareTo(((java.util.Map.Entry) (o1)).getValue());
            }
        });

        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static int checkTOP(Char nj) {
        Char _char;
        int i = 1;
        for (java.util.Map.Entry<Char, Integer> entry : ChienTruong.bxhCT.entrySet()) {
            i++;
            if (i > 4) {
                break;
            }
            _char = entry.getKey();
            if (_char != null && _char.id == nj.id && _char.pointCT > 0) {
                return i;
            }

        }
        return 0;
    }

    public Map[] map;
    public long time;
    public int level = 0;
    public ArrayList<Char> bachGia;
    public ArrayList<Char> hacGia;
    public boolean rest;
    public Object LOCK = new Object();
    Server server;

    public ChienTruong() {
        this.server = Server.gI();
        this.bachGia = new ArrayList();
        this.hacGia = new ArrayList();
        this.map = new Map[7];
        this.rest = false;

        this.initMap();
        for (byte i = 0; i < this.map.length; ++i) {
            this.map[i].timeMap = this.time;
            this.map[i].start();
        }

    }

    private void initMap() {
        this.map[0] = new Map(98, null, null, this, null, null);
        this.map[1] = new Map(99, null, null, this, null, null);
        this.map[2] = new Map(100, null, null, this, null, null);
        this.map[3] = new Map(101, null, null, this, null, null);
        this.map[4] = new Map(102, null, null, this, null, null);
        this.map[5] = new Map(103, null, null, this, null, null);
        this.map[6] = new Map(104, null, null, this, null, null);
    }

    public void rest() {
        if (!this.rest) {
            this.rest = true;
            try {
                synchronized (this) {
                    Char _char;
                    while (this.bachGia.size() > 0) {
                        _char = this.bachGia.remove(0);
                        if (_char != null) {
                            if (ChienTruong.pheWin == 0 && _char.pointCT > 0) {
                                _char.isTakePoint = 1;
                            }
                            int checkTOP = ChienTruong.checkTOP(_char);
                            if (checkTOP > 0) {
                                _char.isTakePoint = checkTOP;
                            }
                            _char.typepk = 0;
                            _char.pointCT = 0;
                            Service.ChangTypePkId(_char, (byte) 0);
                            _char.tileMap.leave(_char.p);
                            _char.p.restCave();
                            _char.p.changeMap(_char.mapLTD);
                        }
                    }
                    while (this.hacGia.size() > 0) {
                        _char = this.hacGia.remove(0);
                        if (_char != null) {
                            if (ChienTruong.pheWin == 1 && _char.pointCT > 0) {
                                _char.isTakePoint = 1;
                            }
                            int checkTOP = ChienTruong.checkTOP(_char);
                            if (checkTOP > 0) {
                                _char.isTakePoint = checkTOP;
                            }
                            _char.typepk = 0;
                            _char.pointCT = 0;
                            Service.ChangTypePkId(_char, (byte) 0);
                            _char.tileMap.leave(_char.p);
                            _char.p.restCave();
                            _char.p.changeMap(_char.mapLTD);
                        }
                    }
                }

                byte i;
                for (i = 0; i < this.map.length; ++i) {
                    this.map[i].close();
                    this.map[i] = null;
                }
                ChienTruong.chienTruong = null;

            } catch (Exception e) {
                byte i;
                for (i = 0; i < this.map.length; ++i) {
                    if (this.map[i] != null) {
                        this.map[i].close();
                        this.map[i] = null;
                    }
                }
                ChienTruong.chienTruong = null;
            }
        }
    }

    public void finish() {
        synchronized (this) {
            if (!ChienTruong.finish) {
                ChienTruong.finish = true;
                ChienTruong.start = false;
                Service.updateCT();
                int i;
                String check = "";
                if (ChienTruong.pheWin == 0) {
                    check = "Phe Bạch Giả đã giành chiến thắng chiến trường.";
                } else if (ChienTruong.pheWin == 1) {
                    check = "Phe Hắc Giả đã giành chiến thắng chiến trường.";
                }

                Manager.serverChat("Chiến trường", check);

                synchronized (this.bachGia) {
                    for (i = 0; i < this.bachGia.size(); i++) {
                        if (this.bachGia.get(i) != null) {
                            this.bachGia.get(i).p.sendAddchatYellow("Chiến trường đã kết thúc. " + check);
                        }
                    }
                }
                synchronized (this.bachGia) {
                    for (i = 0; i < this.hacGia.size(); i++) {
                        if (this.hacGia.get(i) != null) {
                            this.hacGia.get(i).p.sendAddchatYellow("Chiến trường đã kết thúc. " + check);
                        }
                    }
                }
                this.rest();
            }
        }
    }

    public static void SetTimeResetHangNgay() {
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(11);
        int min = rightNow.get(12);
        int sec = rightNow.get(13);
        if (hour % 24 == 0 && min == 0 && sec == 0) {
            if (ChienTruong.chienTruong != null) {
                ChienTruong.chienTruong.finish();
            }
            ChienTruong.chienTruong50 = false;
            ChienTruong.chienTruong100 = false;
            ChienTruong.finish = false;
            ChienTruong.start = false;
            ChienTruong.pointHacGia = 0;
            ChienTruong.pointBachGia = 0;
            ChienTruong.pheWin = -1;
            ChienTruong.bxhCT.clear();
            ChienTruong.chienTruong = null;
        }
    }

    public static void SetTimeChienTruongLv50() {
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(11);
        int min = rightNow.get(12);
        int sec = rightNow.get(13);
        if (hour == 19 && min == 00 && sec == 0) {
            if (ChienTruong.chienTruong != null) {
                ChienTruong.chienTruong.finish();
            }
            if (ChienTruong.chienTruong == null) {
                Manager.serverChat("Server", "Chiến Trường Dưới Hoặc Bằng Lv50 Chính Thức Mở Cửa Báo Danh Hãy Nhanh Tay Báo Danh Tại NPC Rikudou.");
                ChienTruong.chienTruong50 = true;
                ChienTruong.chienTruong100 = false;
                ChienTruong.chienTruong = new ChienTruong();
                ChienTruong.finish = false;
                ChienTruong.start = false;
                ChienTruong.pointHacGia = 0;
                ChienTruong.pointBachGia = 0;
                ChienTruong.pheWin = -1;
                ChienTruong.bxhCT.clear();
            }
        }
        if (ChienTruong.chienTruong != null && hour == 19 && min == 30 && sec == 0) {
            ChienTruong.start = true;
            Manager.serverChat("Thông Báo", "Chiến Trường Đã Bắt Đầu");
        }
        if (ChienTruong.chienTruong != null && hour == 20 && min == 30 && sec == 0 && ChienTruong.start) {
            ChienTruong.chienTruong.finish();
            Manager.serverChat("Thông Báo", "Chiến Trường Đã Kết Thúc");
        }
    }

    public static void SetTimeChienTruongLv100() {
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(11);
        int min = rightNow.get(12);
        int sec = rightNow.get(13);
        if (hour == 21 && min == 00 && sec == 0) {
            if (ChienTruong.chienTruong != null) {
                ChienTruong.chienTruong.finish();
            }
            if (ChienTruong.chienTruong == null) {
                Manager.serverChat("Thông Báo", "Chiến Trường Trên Lv100 Chính Thức Mở Cửa Báo Danh Hãy Nhanh Tay Báo Danh Tại NPC Rikudou");
                ChienTruong.chienTruong100 = true;
                ChienTruong.chienTruong50 = false;
                ChienTruong.chienTruong = new ChienTruong();
                ChienTruong.finish = false;
                ChienTruong.start = false;
                ChienTruong.pointHacGia = 0;
                ChienTruong.pointBachGia = 0;
                ChienTruong.pheWin = -1;
                ChienTruong.bxhCT.clear();
            }
        }
        if (ChienTruong.chienTruong != null && hour == 21 && min == 30 && sec == 0) {
            ChienTruong.start = true;
            Manager.serverChat("Thông Báo", "Chiến Trường Đã Bắt Đầu");
        }

        if (ChienTruong.chienTruong != null && hour == 22 && min == 30 && sec == 0 && ChienTruong.start) {
            ChienTruong.chienTruong.finish();
            Manager.serverChat("Thông Báo", "Chiến Trường Đã Kết Thúc");
        }
    }

}
