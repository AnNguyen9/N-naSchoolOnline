/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import History.LichSu;
import assembly.Char;
import assembly.Level;
import assembly.Player;
import io.Message;
import io.SQLManager;
import io.Util;
import java.io.IOException;
import java.sql.ResultSet;
import server.Manager;
import server.Menu;
import server.Service;
import server.Session;
import stream.Admin;
import stream.Client;
import stream.SaveData;
import stream.Server;

/**
 *
 * @author voqua
 */
public class MenuAdmin {

    public static void menuAdmin(Player p, byte menuId) {
        Player player;
        int i;
        switch (menuId) {
            case 0: {
                Service.sendInputDialog(p, (short) 9998, "Nhập số phút muốn bảo trì 0->10 (0: ngay lập tức)");
                break;
            }
            case 1: {
                Service.KhoaTaiKhoan(p);
                break;
            }
            case 2: {
                Service.AutoSaveData();
                p.sendAddchatYellow("Update thành công");
                break;
            }
            case 3: {
                String chat = "MapID: " + p.c.mapid + " - X: " + p.c.get().x + " - Y: " + p.c.get().y;
                p.conn.sendMessageLog(chat);
                break;
            }
            case 4: {
                Service.sendInputDialog(p, (short) 9996, "Nhập số xu muốn cộng (có thể nhập số âm)");
                break;
            }
            case 5: {
                Service.sendInputDialog(p, (short) 9995, "Nhập số lượng muốn cộng (có thể nhập số âm)");
                break;
            }
            case 6: {
                Service.sendInputDialog(p, (short) 9997, "Nhập số yên muốn cộng (có thể nhập số âm)");
                break;
            }
            case 7: {
                Service.sendInputDialog(p, (short) 9994, "Nhập số level muốn tăng (có thể nhập số âm)");
                break;
            }
            case 8: {
                Service.sendInputDialog(p, (short) 9993, "Nhập số tiềm năng muốn tăng (có thể nhập số âm)");
                break;
            }
            case 9: {
                Service.sendInputDialog(p, (short) 9992, "Nhập số kỹ năng muốn tăng (có thể nhập số âm)");
                break;
            }
            case 10: {
                SaveData saveData = new SaveData();
                saveData.player = p;
                Thread t1 = new Thread(saveData);
                t1.start();
                if (!Manager.isSaveData) {
                    player = null;
                    t1 = null;
                    saveData = null;
                }
                break;
            }
            case 11: {
                Service.sendInputDialog(p, (short) 9991, "Nhập nội dung");
                break;
            }
            case 12: {
                try {
                    Server.manager.sendTB(p, "Kiểm tra",
                            "- Tổng số kết nối: " + Client.gI().conns_size()
                            + "\n\n- Số người đăng nhập: " + Client.gI().players_size()
                            + "\n\n- TỔNG SỐ NGƯỜI CHƠI THỰC TẾ: " + Client.gI().ninja_size()
                    );
                } catch (Exception var11) {
                    var11.printStackTrace();
                }
                break;
            }
            case 13: {
                synchronized (Client.gI().conns) {
                    for (i = 0; i < Client.gI().conns.size(); ++i) {
                        Session conn = (Session) Client.gI().conns.get(i);
                        if (conn != null) {
                            player = conn.player;
                            if (player != null) {
                                if (player.c == null) {
                                    Client.gI().kickSession(conn);
                                }
                            } else if (player == null) {
                                Client.gI().kickSession(conn);
                            } 
                        }
                    }
                }
                p.conn.sendMessageLog("Dọn clone thành công!");
                break;
            }
            case 14: {
                synchronized (Client.gI().conns) {
                    for (i = 0; i < Client.gI().conns.size(); ++i) {
                        player = ((Session) Client.gI().conns.get(i)).player;
                        if (player != null && player != p) {
                            Client.gI().kickSession(player.conn);
                        }
                    }
                }
                p.conn.sendMessageLog("Dọn Session thành công!");
                break;
            }
            case 15: {
                Service.sendInputDialog(p, (short) 9990, "Nhập giá trị cần thay đổi");
                break;
            }
            case 16: {
                break;
            }
            case 17: {
                try {
                    ResultSet red = SQLManager.stat.executeQuery("SELECT * FROM `alert` WHERE `id` = 1;");
                    if (red != null && red.first()) {
                        String alert = red.getString("content");
                        Manager.alert.setAlert(alert);
                        red.close();
                    }
                    p.sendAddchatYellow("Cập nhật thông báo thành công");
                    Manager.alert.sendAlert(p);
                } catch (Exception e) {
                    p.conn.sendMessageLog("Lỗi cập nhật!");
                }
                break;
            }
        }
    }

    public static void ShowAdmin(Player p) throws IOException {
        p.typemenu = 9999;
        Menu.doMenuArray(p, new String[]{"Bảo trì Server", "Khoá tài khoản người chơi", "Cập nhật BXH cao thủ", "Xem info map, vị trí", "Cộng Xu", "Cộng Lượng", "Cộng Yên", "Tăng level", "Tăng điểm tiềm năng", "Tăng kỹ năng", "Cập nhật DATA", "Đăng thông báo", "Kiểm tra số người chơi", "Clear Clone Login", "Clear Session", "Thay đổi tăng exp", "CHECK Item", "Cập nhật Thông báo", "Lưu dữ liệu"});
    }

//    public static void Backup_User() throws SQLException, IOException {
//        Date date = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        String timestamp = dateFormat.format(date);
//        String fileName = "LichSu/BackUpData/BackupUser_" + timestamp + ".csv";
//        ResultSet rs = SQLManager.stat.executeQuery("SELECT ItemBody ItemBody Xu XuBox FROM ninja");
//        ResultSetMetaData metaData = rs.getMetaData();
//        int columnCount = metaData.getColumnCount();
//        String[] columnNames = new String[columnCount];
//        for (int i = 0; i < columnCount; i++) {
//            columnNames[i] = metaData.getColumnName(i + 1);
//        }
//        FileWriter writer = new FileWriter(fileName);
//        for (int i = 0; i < columnCount; i++) {
//            writer.append(columnNames[i]);
//            if (i < columnCount - 1) {
//                writer.append(',');
//            }
//        }
//        writer.append('\n');
//        while (rs.next()) {
//            for (int i = 0; i < columnCount; i++) {
//                writer.append(rs.getString(columnNames[i]));
//                if (i < columnCount - 1) {
//                    writer.append(',');
//                }
//            }
//            writer.append('\n');
//        }
//        writer.flush();
//        writer.close();
//        rs.close();
//    }
    public static void Cpanel(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0: {
                Service.sendInputDialog(p, (short) 1010, "Tên nhân vật:");
                break;
            }
            case 1: {
                Service.sendInputDialog(p, (short) 1012, "Tên nhân vật:");
                break;
            }
        }
    }

    public static void ThayDoiExp(Player p, Message m, String str) {
        try {
            if (p.role != 10102003) {
                p.lockAcc();
                return;
            }
            if (!Util.isNumeric(str) || str.equals("")) {
                p.conn.sendMessageLog("Giá trị nhập vào không hợp lệ");
                return;
            }
            String check = str.replaceAll("\\s+", "");
            check = str.replaceAll(" ", "").trim();
            int expup = Integer.parseInt(check);
            if (expup <= 0) {
                expup = 1;
            }
            Manager.up_exp = expup;
            p.sendAddchatYellow("Thay đổi tăng giá trị exp thành công");
        } catch (Exception e) {
            p.conn.sendMessageLog("Không Xác Định.");
        }
    }

    public static void DangThongBao(Player p, Message m, String str) {
        try {
            if (p.role != 10102003) {
                p.lockAcc();
                return;
            }
            if (str.equals("")) {
                p.conn.sendMessageLog("Giá trị nhập vào không hợp lệ");
                return;
            }
            Manager.serverChat("Server", str);
            p.sendAddchatYellow("Đăng thông báo thành công");
        } catch (Exception e) {
            p.conn.sendMessageLog("Không Xác Định.");
        }
    }

    public static void CongKyNang(Player p, Message m, String str) {
        try {
            if (p.role != 10102003) {
                p.lockAcc();
                return;
            }
            if (!Util.isNumeric(str) || str.equals("")) {
                p.conn.sendMessageLog("Giá trị nhập vào không hợp lệ");
                return;
            }
            String check = str.replaceAll(" ", "").trim();
            int kynang = Integer.parseInt(check);
            p.c.spoint += kynang;
            p.loadSkill();
            if (kynang >= 0) {
                p.sendAddchatYellow("Đã tăng thêm " + kynang + " điểm kỹ năng.");
            } else {
                p.sendAddchatYellow("Đã giảm đi " + kynang + " điểm kỹ năng.");
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không Xác Định.");
        }
    }

    public static void CongTiemNang(Player p, Message m, String str) {
        try {
            if (p.role != 10102003) {
                p.lockAcc();
                return;
            }
            if (!Util.isNumeric(str) || str.equals("")) {
                p.conn.sendMessageLog("Giá trị nhập vào không hợp lệ");
                return;
            }
            String check = str.replaceAll(" ", "").trim();
            int tiemnang = Integer.parseInt(check);
            p.c.get().ppoint += tiemnang;
            p.loadPpoint();
            if (tiemnang >= 0) {
                p.sendAddchatYellow("Đã tăng thêm " + tiemnang + " điểm tiềm năng.");
            } else {
                p.sendAddchatYellow("Đã giảm đi " + tiemnang + " điểm tiềm năng.");
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không Xác Định.");
        }
    }

    public static void TangLevel(Player p, Message m, String str) {
        try {
            if (p.role != 10102003) {
                p.lockAcc();
                return;
            }
            if (!Util.isNumeric(str) || str.equals("")) {
                p.conn.sendMessageLog("Giá trị nhập vào không hợp lệ");
                return;
            }
            String check = str.replaceAll(" ", "").trim();
            int levelup = Integer.parseInt(check);
            int oldLv = p.c.get().level;
            p.c.get().level = 1;
            p.c.get().exp = 0;
            p.c.get().expdown = 0;
            p.updateExp(Level.getMaxExp(oldLv + levelup));
            if (p.c.get().isHuman) {
                p.c.setXPLoadSkill(p.c.get().exp);
            } else {
                p.c.clone.setXPLoadSkill(p.c.get().exp);
            }
            p.restPpoint();
            p.restSpoint();
            if (levelup >= 0) {
                p.sendAddchatYellow("Đã tăng thêm " + levelup + " cấp độ.");
            } else {
                p.sendAddchatYellow("Đã giảm đi " + levelup + " cấp độ.");
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không Xác Định.");
        }
    }

    public static void TangLuong(Player p, Message m, String str) {
        try {
            if (p.role != 10102003) {
                p.lockAcc();
                return;
            }
            if (!Util.isNumeric(str) || str.equals("")) {
                p.conn.sendMessageLog("Giá trị nhập vào không hợp lệ");
                return;
            }
            String check = str.replaceAll(" ", "").trim();
            int luongup = Integer.parseInt(check);
            if (luongup >= 0) {
                p.sendAddchatYellow("Đã tăng thêm " + Util.getFormatNumber(luongup) + " lượng.");
            } else {
                p.sendAddchatYellow("Đã giảm đi " + Util.getFormatNumber(luongup) + " lượng.");
            }
            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + luongup), "ADMIN Cộng Lượng", +luongup);
            p.upluongMessage(luongup);
        } catch (Exception e) {
            p.conn.sendMessageLog("Không Xác Định.");
        }
    }

    public static void TangXu(Player p, Message m, String str) {
        try {
            if (p.role != 10102003) {
                p.lockAcc();
                return;
            }
            if (!Util.isNumeric(str) || str.equals("")) {
                p.conn.sendMessageLog("Giá trị nhập vào không hợp lệ");
                return;
            }
            String check = str.replaceAll(" ", "").trim();
            int xuup = Integer.parseInt(str);
            if (xuup >= 0) {
                p.sendAddchatYellow("Đã tăng thêm " + Util.getFormatNumber(xuup) + " xu.");
            } else {
                p.sendAddchatYellow("Đã giảm đi " + Util.getFormatNumber(xuup) + " xu.");
            }
            LichSu.LichSuXu(p.c.name, p.c.xu, (p.c.xu + xuup), "ADMIN Cộng Xu : ", +xuup);
            p.c.upxuMessage(xuup);
        } catch (Exception e) {
            p.conn.sendMessageLog("Không Xác Định.");
        }
    }

    public static void TangYen(Player p, Message m, String str) {
        try {
            if (p.role != 10102003) {
                p.lockAcc();
                return;
            }
            if (!Util.isNumeric(str) || str.equals("")) {
                p.conn.sendMessageLog("Giá trị nhập vào không hợp lệ");
                return;
            }
            String check = str.replaceAll(" ", "").trim();
            int yenup = Integer.parseInt(check);
            if (yenup >= 0) {
                p.sendAddchatYellow("Đã tăng thêm " + Util.getFormatNumber(yenup) + " yên.");
            } else {
                p.sendAddchatYellow("Đã giảm đi " + Util.getFormatNumber(yenup) + " yên.");
            }
            p.c.upyenMessage(yenup);
        } catch (Exception e) {
            p.conn.sendMessageLog("Không Xác Định.");
        }
    }

    public static void BaoTri(Player p, Message m, String str) {
        try {
            if (p.role != 10102003) {
                p.lockAcc();
                return;
            }
            if (!Util.isNumeric(str) || str.equals("")) {
                p.conn.sendMessageLog("Giá trị nhập vào không hợp lệ");
                return;
            }
            String check = str.replaceAll(" ", "").trim();
            int minues = Integer.parseInt(check);
            if (minues < 0 || minues > 10) {
                p.conn.sendMessageLog("Giá trị nhập vào từ 0 -> 10 phút");
                return;
            }
            p.sendAddchatYellow("Đã kích hoạt bảo trì Server sau " + minues + " phút.");
            Thread t1 = new Thread(new Admin(minues, Server.gI()));
            t1.start();
        } catch (Exception e) {
            p.conn.sendMessageLog("Không Xác Định.");
        }
    }

    public static void KhoaTaiKhoan(Player p, Message m, String str) {
        try {
            if (p.role != 10102003) {
                p.lockAcc();
                return;
            }
            Char temp = Client.gI().getNinja(str);
            if (temp != null) {
                Player banPlayer = Client.gI().getPlayer(temp.p.username);
                if (banPlayer != null && banPlayer.role != 10102003) {
                    Client.gI().kickSession(banPlayer.conn);
                    try {
                        SQLManager.stat.executeUpdate("UPDATE `player` SET `ban`=1 WHERE `id`=" + banPlayer.id + " LIMIT 1;");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    p.conn.sendMessageLog("Đã khoá tài khoản: " + banPlayer.username + " - nhân vật: " + temp.name);
                } else {
                    p.conn.sendMessageLog("Tài khoản này là ADMIN hoặc không tìm thấy tài khoản này!");
                }
            } else {
                p.conn.sendMessageLog("Người chơi này không tồn tại hoặc không online!");
            }
            temp = null;
        } catch (Exception e) {
            p.conn.sendMessageLog("Không Xác Định.");
        }
    }
}
