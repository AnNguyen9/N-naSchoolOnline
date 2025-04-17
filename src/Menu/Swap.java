/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import History.LichSu;
import assembly.Char;
import assembly.ClanManager;
import assembly.Item;
import assembly.Language;
import assembly.Player;
import io.Message;
import io.SQLManager;
import io.Util;
import java.sql.ResultSet;
import java.time.Instant;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import server.GameSrc;
import server.Manager;
import server.Service;
import stream.Client;
import stream.Dun;
import stream.GiaTocChien;
import stream.Server;
import template.ItemTemplate;

/**
 *
 * @author voqua
 */
public class Swap {

    public static void DoiCoinRaLuong(Player p, Message m, String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 1000000 || num % 10 != 0) {
                //thông báo
                p.conn.sendMessageLog("Số Coin Đổi Phải Chia Hết Cho 10 . Tối Đa 1.000.000 1 Lượt Đổi");
                return;
            }
            long coin = Integer.parseInt(str);
            ResultSet red = SQLManager.stat.executeQuery("SELECT `coin` FROM `player` WHERE `id` = " + p.id + ";");
            if (red != null && red.first()) {
                int coinP = Integer.parseInt(red.getString("coin"));
                int pre_gold = p.luong;
                int pre_xu = p.c.xu;
                int pre_yen = p.c.yen;
                long pre_diamond = coinP;
                if (coin <= coinP) {
                    coinP -= coin;
                    LichSu.LichSuLuong(p.c.name, p.luong, (int) (p.luong + coin), " Đổi " + coin + " coin ra lượng ", +coin);
                    p.upluongMessage(coin);
                    SQLManager.stat.executeUpdate("UPDATE `player` SET `coin`=" + coinP + " WHERE `id`=" + p.id + " LIMIT 1;");
                    SQLManager.stat.executeUpdate("INSERT INTO transfer(`userid`,`cointruoc`,`coinsau`,`luongtruoc`,`luongsau`,`xutruoc`,`xusau`,`yentruoc`,`yensau`,`soluong`,`time`,`created_at`) VALUES (" + p.id + "," + pre_diamond + "," + coinP + "," + pre_gold + "," + p.luong + "," + pre_xu + "," + p.c.xu + "," + pre_yen + "," + p.c.yen + "," + coin + "," + (System.currentTimeMillis() / 1000L) + ",'" + Util.toDateString(Date.from(Instant.now())) + "');");
                     p.conn.sendMessageLog("Đổi Coin Thành Công Bạn Nhận Được " + coin + " Lượng");
                } else {
                    p.conn.sendMessageLog("Bạn không đủ coin để đổi ra lượng.");
                }
                p.flush();
                red.close();
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }
    }

    public static void DoiCoinRaXu(Player p, Message m, String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 1000000 || num % 10 != 0) {
                //thông báo
                p.conn.sendMessageLog("Số Coin Đổi Phải Chia Hết Cho 10 . Tối Đa 1.000.000 1 Lượt Đổi");
                return;
            }
            long coin = Integer.parseInt(str);
            ResultSet red = SQLManager.stat.executeQuery("SELECT `coin` FROM `player` WHERE `id` = " + p.id + ";");
            if (red != null && red.first()) {
                int coinP = Integer.parseInt(red.getString("coin"));
                int pre_gold = p.luong;
                int pre_xu = p.c.xu;
                int pre_yen = p.c.yen;
                long pre_diamond = coinP;
                if (coin <= coinP) {
                    coinP -= coin;
                    LichSu.LichSuXu(p.c.name, p.c.xu, (int) (p.c.xu + coin * 10000), " Đổi " + coin + " coin ra Xu ", p.c.xu + coin * 10000);
                    p.c.upxuMessage(coin * 10000);
                    SQLManager.stat.executeUpdate("UPDATE `player` SET `coin`=" + coinP + " WHERE `id`=" + p.id + " LIMIT 1;");
                    SQLManager.stat.executeUpdate("INSERT INTO transfer(`userid`,`cointruoc`,`coinsau`,`luongtruoc`,`luongsau`,`xutruoc`,`xusau`,`yentruoc`,`yensau`,`soluong`,`time`,`created_at`) VALUES (" + p.id + "," + pre_diamond + "," + coinP + "," + pre_gold + "," + p.luong + "," + pre_xu + "," + p.c.xu + "," + pre_yen + "," + p.c.yen + "," + coin + "," + (System.currentTimeMillis() / 1000L) + ",'" + Util.toDateString(Date.from(Instant.now())) + "');");
                    p.conn.sendMessageLog("Đổi Coin Thành Công Bạn Nhận Được " + coin * 10000 + " Xu");
                } else {
                    p.conn.sendMessageLog("Bạn không đủ coin để đổi ra lượng.");
                }
                p.flush();
                red.close();
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }
    }

//    public static void DoiLuongRaXu(Player p, Message m, String str) {
//        try {
//            int num = Integer.parseInt(str);
//            if (num < 1 || num > 1000000 || num % 10 != 0) {
//                //thông báo
//                p.conn.sendMessageLog("Số Coin Đổi Phải Chia Hết Cho 10 . Tối Đa 1.000.000 1 Lượt Đổi");
//                return;
//            }
//            int luongdoi = Integer.parseInt(str);
//            if (luongdoi > p.luong) {
//                p.sendAddchatYellow("Không đủ lượng");
//                return;
//            } else {
//                LichSu.LichSuXu(p.c.name, p.c.xu, (int) (p.c.xu + 500 * luongdoi), " Đổi " + luongdoi + " lượng ra xu ", 500 * luongdoi);
//                p.c.upxuMessage(luongdoi * 500);
//                LichSu.LichSuLuong(p.c.name, p.luong, (p.luong - luongdoi), " Đổi Lượng Ra Xu : ", -luongdoi);
//                p.upluongMessage(-luongdoi);
//            }
//        } catch (Exception e) {
//            p.conn.sendMessageLog("Không hợp lệ");
//        }
//    }
    public static void DoiLuongRaYen(Player p, Message m, String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 1000000 || num % 10 != 0) {
                //thông báo
                p.conn.sendMessageLog("Số Coin Đổi Phải Chia Hết Cho 10 . Tối Đa 1.000.000 1 Lượt Đổi");
                return;
            }
            int yendoi = Integer.parseInt(str);
            if (yendoi > p.luong) {
                p.sendAddchatYellow("Không đủ lượng");
                return;
            } else {
                p.c.upyenMessage(yendoi * 10000);
                LichSu.LichSuLuong(p.c.name, p.luong, (p.luong - yendoi), " Đổi " + yendoi + " lượng ra yên ", -yendoi);
                p.upluongMessage(-yendoi);
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }
    }

    public static void DatCuocGiaTocChien(Player p, Message m, String str) {
        try {
            String check = str.replaceAll("\\s+", "");
            if (!Util.isNumericLong(str) || check.equals("") || !Util.isNumericInt(str)) {
                Service.chatNPC(p, (short) 37, "Giá trị tiền cược nhập vào không đúng");
                return;
            }
            long tienCuoc = Long.parseLong(str);
            ClanManager clanManager = ClanManager.getClanName(p.c.clan.clanName);
            if (tienCuoc > clanManager.coin || clanManager.coin < 1000) {
                Service.chatNPC(p, (short) 40, "Gia tộc của con không đủ ngân sách để đặt cược.");
                return;
            }
            if (tienCuoc < 1000 || tienCuoc % 50 != 0) {
                Service.chatNPC(p, (short) 40, "Xu cược phải lớn hơn 1000 xu và chia hết cho 50");
                return;
            }
            GiaTocChien gtc = null;
            if (clanManager.gtcID != -1) {
                if (GiaTocChien.gtcs.containsKey(clanManager.gtcID)) {
                    gtc = GiaTocChien.gtcs.get(clanManager.gtcID);
                }
            }
            if (gtc != null) {
                if (gtc.clan1.id == clanManager.id) {
                    if (gtc.tienCuoc2 != 0 && gtc.tienCuoc2 != tienCuoc) {
                        Service.chatNPC(p, (short) 40, "Gia tộc đối thủ của con đã đặt cược " + Util.getFormatNumber(gtc.tienCuoc2) + " xu con hãy đặt lại đi!");
                        return;
                    }
                    if (gtc.tienCuoc1 != 0) {
                        Service.chatNPC(p, (short) 37, "Gia tộc của con đã đặt cược trước đó rồi.");
                        return;
                    }

                    gtc.tienCuoc1 = tienCuoc;
                    clanManager.coin -= tienCuoc;
                    Service.chatNPC(p, (short) 40, "Con đã đặt cược " + gtc.tienCuoc1 + " xu");
                    if (gtc.gt2.size() > 0) {
                        for (int i = 0; i < gtc.gt2.size(); i++) {
                            gtc.gt2.get(i).p.sendAddchatYellow("Gia tộc " + clanManager.name + " đã đặt cược " + Util.getFormatNumber(gtc.tienCuoc1) + " xu.");
                        }
                    }

                } else if (gtc.clan2.id == clanManager.id) {
                    if (gtc.tienCuoc1 != 0 && gtc.tienCuoc1 != tienCuoc) {
                        Service.chatNPC(p, (short) 40, "Gia tộc đối thủ của con đã đặt cược " + Util.getFormatNumber(gtc.tienCuoc1) + " xu con hãy đặt lại đi!");
                        return;
                    }
                    if (gtc.tienCuoc2 != 0) {
                        Service.chatNPC(p, (short) 40, "Con đã đặt cược trước đó rồi.");
                        return;
                    }
                    gtc.tienCuoc2 = tienCuoc;
                    clanManager.coin -= tienCuoc;
                    Service.chatNPC(p, (short) 40, "Con đã đặt cược " + gtc.tienCuoc2 + " xu");
                    if (gtc.gt1.size() > 0) {
                        for (int i = 0; i < gtc.gt1.size(); i++) {
                            gtc.gt1.get(i).p.sendAddchatYellow("Gia tộc " + clanManager.name + " đã đặt cược " + Util.getFormatNumber(gtc.tienCuoc2) + " xu.");
                        }
                    }
                }
                if (gtc.tienCuoc1 != 0 && gtc.tienCuoc2 != 0 && gtc.tienCuoc1 == gtc.tienCuoc2 && gtc.gt1.size() > 0 && gtc.gt2.size() > 0) {
                    gtc.invite();
                }
            } else {
                return;
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }
    }

    public static void GiftCode(Player p, Message m, String str) {
        String check = str.replaceAll("\\s+", "");
        if (check.equals("")) {
            p.conn.sendMessageLog("Mã Gift code nhập vào không hợp lệ.");
            return;
        }
        if (!Util.CheckString(check, "^[a-zA-Z0-9]+$")) {
            p.conn.sendMessageLog("Mã Gift code nhập vào không hợp lệ.");
            return;
        }
        check = check.toUpperCase();
        try {
            synchronized (Server.LOCK_MYSQL) {
                ResultSet red = SQLManager.stat.executeQuery("SELECT * FROM `gift_code` WHERE `code` LIKE '" + check + "';");
                if (red != null && red.first()) {
                    int id = red.getInt("id");
                    String code = red.getString("code");
                    JSONArray jar = (JSONArray) JSONValue.parse(red.getString("item_id"));
                    if (p.c.getBagNull() < jar.size()) {
                        p.conn.sendMessageLog(Language.NOT_ENOUGH_BAG);
                        return;
                    }
                    int j;
                    int[] itemId = new int[jar.size()];
                    for (j = 0; j < jar.size(); j++) {
                        itemId[j] = Integer.parseInt(jar.get(j).toString());
                    }
                    jar = (JSONArray) JSONValue.parse(red.getString("item_quantity"));
                    long[] itemQuantity = new long[jar.size()];
                    for (j = 0; j < jar.size(); j++) {
                        itemQuantity[j] = Long.parseLong(jar.get(j).toString());
                    }
                    jar = (JSONArray) JSONValue.parse(red.getString("item_isLock"));
                    byte[] itemIsLock = new byte[jar.size()];
                    for (j = 0; j < jar.size(); j++) {
                        itemIsLock[j] = Byte.parseByte(jar.get(j).toString());
                    }
                    jar = (JSONArray) JSONValue.parse(red.getString("item_expires"));
                    long[] itemExpires = new long[jar.size()];
                    for (j = 0; j < jar.size(); j++) {
                        itemExpires[j] = Long.parseLong(jar.get(j).toString());
                    }

                    int isPlayer = red.getInt("isPlayer");
                    int isTime = red.getInt("isTime");
                    if (isPlayer == 1) {
                        jar = (JSONArray) JSONValue.parse(red.getString("player"));
                        boolean checkUser = false;
                        for (j = 0; j < jar.size(); j++) {
                            if (jar.get(j).toString().equals(p.username)) {
                                checkUser = true;
                                break;
                            }
                        }
                        if (!checkUser) {
                            p.conn.sendMessageLog("Bạn không thể sử dụng mã Gift Code này.");
                            red.close();
                            return;
                        }
                    }
                    if (isTime == 1) {
                        if (Date.from(Instant.now()).compareTo(Util.getDate(red.getString("time"))) > 0) {
                            p.conn.sendMessageLog("Mã Gift code này đã hết hạn sử dụng.");
                            red.close();
                            return;
                        }
                    }
                    red.close();
                    red = SQLManager.stat.executeQuery("SELECT * FROM `history_gift` WHERE `player_id` = " + p.id + " AND `code` = '" + code + "';");
                    if (red != null && red.first()) {
                        p.conn.sendMessageLog("Bạn đã sử dụng mã Gift code này rồi.");
                    } else {
                        if (itemId.length == itemQuantity.length) {
                            ItemTemplate data2;
                            int i;
                            for (i = 0; i < itemId.length; i++) {
                                switch (itemId[i]) {
                                    case -3:
                                        p.c.upyenMessage(itemQuantity[i]);
                                        break;
                                    case -2:
                                        LichSu.LichSuXu(p.c.name, p.c.xu, (p.c.xu + (int) itemQuantity[i]), "Nhập GIFTCODE " + check, itemQuantity[i]);
                                        p.c.upxuMessage(itemQuantity[i]);
                                        break;
                                    case -1:
                                        LichSu.LichSuLuong(p.c.name, p.luong, (int) (p.luong + itemQuantity[i]), "Nhập GIFTCODE " + code, itemQuantity[i]);
                                        p.upluongMessage(itemQuantity[i]);
                                        break;
                                    default:
                                        data2 = ItemTemplate.ItemTemplateId(itemId[i]);
                                        if (data2 != null) {
                                            Item itemup;
                                            if (data2.type < 10) {
                                                if (data2.type == 1) {
                                                    itemup = ItemTemplate.itemDefault(itemId[i]);
                                                    itemup.sys = GameSrc.SysClass(data2.nclass);
                                                } else {
                                                    byte sys = (byte) Util.nextInt(1, 3);
                                                    itemup = ItemTemplate.itemDefault(itemId[i], sys);
                                                }
                                            } else {
                                                itemup = ItemTemplate.itemDefault(itemId[i]);
                                            }
                                            itemup.quantity = (int) itemQuantity[i];
                                            if (itemIsLock[i] == 0) {
                                                itemup.isLock = false;
                                            } else {
                                                itemup.isLock = true;
                                            }
                                            if (itemExpires[i] != -1) {
                                                itemup.isExpires = true;
                                                itemup.expires = System.currentTimeMillis() + itemExpires[i];
                                            } else {
                                                itemup.isExpires = false;
                                            }
                                            p.c.addItemBag(true, itemup);
                                        }
                                        break;
                                }
                            }
                            String sqlSET = "(" + p.id + ", '" + code + "', '" + Util.toDateString(Date.from(Instant.now())) + "', '" + Util.toDateString(Date.from(Instant.now())) + "', '" + Util.toDateString(Date.from(Instant.now())) + "');";
                            SQLManager.stat.executeUpdate("INSERT INTO `history_gift` (`player_id`,`code`,`time`, `created_at`, `updated_at`) VALUES " + sqlSET);
                        } else {
                            p.conn.sendMessageLog("Lỗi xác nhận mã Gift code. Hãy liên hệ Admin để biết thêm chi tiết.");
                        }
                    }
                    jar.clear();
                    red.close();
                    return;
                } else {
                    p.conn.sendMessageLog("Mã Gift code này đã được sử dụng hoặc không tồn tại.");
                    red.close();
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void DatCuocLoiDai(Player p, Message m, String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 1000000) {
                //thông báo
                p.conn.sendMessageLog("Tối Đa 1 Triệu Xu");
                return;
            }
            long tienCuoc = Long.parseLong(str);
            if (tienCuoc > p.c.xu || p.c.xu < 1000) {
                Service.chatNPC(p, (short) 37, "Con không đủ xu để đặt cược");
                return;
            }
            if (tienCuoc < 1000 || tienCuoc % 50 != 0) {
                Service.chatNPC(p, (short) 37, "Xu cược phải lớn hơn 1000 xu và chia hết cho 50");
                return;
            }
            Dun dun = null;
            if (p.c.dunId != -1) {
                if (Dun.duns.containsKey(p.c.dunId)) {
                    dun = Dun.duns.get(p.c.dunId);
                }
            }
            if (dun != null) {
                if (dun.c1.id == p.c.id) {
                    if (dun.tienCuocTeam2 != 0 && dun.tienCuocTeam2 != tienCuoc) {
                        Service.chatNPC(p, (short) 37, "Đối thủ của con đã đặt cược " + Util.getFormatNumber(dun.tienCuocTeam2) + " xu con hãy đặt lại đi!");
                        return;
                    }
                    if (dun.tienCuocTeam1 != 0) {
                        Service.chatNPC(p, (short) 37, "Con đã đặt cược trước đó rồi.");
                        return;
                    }
                    dun.tienCuocTeam1 = tienCuoc;
                    LichSu.LichSuXu(p.c.name, p.c.xu, (p.c.xu - (int) tienCuoc), "Đặt cược lôi đài", -tienCuoc);
                    p.c.upxuMessage(-tienCuoc);
                    Service.chatNPC(p, (short) 37, "Con đã đặt cược " + dun.tienCuocTeam1 + " xu");
                    dun.c2.p.sendAddchatYellow("Người chơi " + dun.c1.name + " đã được cược " + Util.getFormatNumber(dun.tienCuocTeam1) + " xu.");
                } else if (dun.c2.id == p.c.id) {
                    if (dun.tienCuocTeam1 != 0 && dun.tienCuocTeam1 != tienCuoc) {
                        Service.chatNPC(p, (short) 37, "Đối thủ của con đã đặt cược " + Util.getFormatNumber(dun.tienCuocTeam1) + " xu con hãy đặt lại đi!");
                        return;
                    }
                    if (dun.tienCuocTeam2 != 0) {
                        Service.chatNPC(p, (short) 37, "Con đã đặt cược trước đó rồi.");
                        return;
                    }
                    dun.tienCuocTeam2 = tienCuoc;
                    LichSu.LichSuXu(p.c.name, p.c.xu, (p.c.xu - (int) tienCuoc), "Đặt cược lôi đài", -tienCuoc);
                    p.c.upxuMessage(-tienCuoc);
                    Service.chatNPC(p, (short) 37, "Con đã đặt cược " + Util.getFormatNumber(dun.tienCuocTeam2) + " xu");
                    dun.c1.p.sendAddchatYellow("Người chơi " + dun.c2.name + " đã được cược " + Util.getFormatNumber(dun.tienCuocTeam2) + " xu.");
                }
                if (dun.tienCuocTeam1 != 0 && dun.tienCuocTeam2 != 0 && dun.tienCuocTeam1 == dun.tienCuocTeam2 && dun.team1.size() > 0 && dun.team2.size() > 0) {
                    if (dun.tienCuocTeam1 >= 1000000L) {
                        Manager.serverChat("Server: ", "Người chơi " + dun.c1.name + " (" + dun.c1.level + ")"
                                + " đang thách đấu với " + dun.c2.name + " (" + dun.c2.level + "): " + Util.getFormatNumber(dun.tienCuocTeam1) + " xu tại lôi đài, hãy mau mau đến xem và cổ vũ.");
                    }
                    dun.startDun();

                }
            } else {
                return;
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }
    }

    public static void MoiLoiDai(Player p, Message m, String str) {
        try {
            Char temp = Client.gI().getNinja(str);
            if (temp != null) {
                Char friendNinja = p.c.tileMap.getNinja(temp.id);
                if (friendNinja != null && friendNinja.id == p.c.id) {
                    Service.chatNPC(p, (short) 0, Language.NAME_LOI_DAI);
                } else if (friendNinja != null && friendNinja.id != p.c.id) {
                    p.sendRequestBattleToAnother(friendNinja, p.c);
                    Service.chatNPC(p, (short) 0, Language.SEND_MESS_LOI_DAI);
                } else {
                    Service.chatNPC(p, (short) 0, Language.NOT_IN_ZONE);
                }
            } else {
                Service.chatNPC(p, (short) 0, "Người chơi này không ở trong cùng khu với con hoặc không tồn tại, ta không thể gửi lời mời!");
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }
    }

    public static void VanBienLenh(Player p, Message m, String str) {
        byte n;
        try {
            if (p.c.quantityItemyTotal(279) <= 0) {
                return;
            }
            Char c = Client.gI().getNinja(str);
            if (c != null && c.tileMap != null && c.tileMap.map != null && !c.tileMap.map.LangCo() && c.tileMap.map.getXHD() == -1 && c.mapid != 111 && c.mapid != 133 && c.mapid != 160 && !c.tileMap.map.mapChienTruong() && !c.tileMap.map.mapLDGT() && !c.tileMap.map.mapBossTuanLoc() && !c.tileMap.map.mapGTC() && !c.tileMap.map.VungDatBiAn() && !c.tileMap.map.Langshiba() && c.mapid != 188 && !c.tileMap.map.MapVIP() && c.mapid != 113) {
                if (p.c.level < 60 && c.tileMap.map.VDMQ()) {
                    p.conn.sendMessageLog("Trình độ của bạn chưa đủ để di chuyển tới đây");
                    return;
                }
                if (p.c.level < 130 && c.tileMap.map.id == 160) {
                    p.conn.sendMessageLog("Trình độ của bạn chưa đủ để di chuyển tới đây");
                    return;
                }
                for (n = 0; n < p.c.get().ItemMounts.length; n++) {
                    if (p.c.get().ItemMounts[n] != null && p.c.get().ItemMounts[n].isExpires && p.c.get().ItemMounts[n].expires < System.currentTimeMillis()) {
                        p.conn.sendMessageLog("Thú cưỡi đã hết hạn , không thể sử dụng chức năng này");
                        return;
                    }
                }
                if (p.c.tileMap.map.mapGTC() || p.c.tileMap.map.mapChienTruong() || p.c.tileMap.map.id == 111) {
                    p.c.typepk = 0;
                    Service.ChangTypePkId(p.c, (byte) 0);
                }
                p.c.tileMap.leave(p);
                p.c.get().x = c.get().x;
                p.c.get().y = c.get().y;
                c.tileMap.Enter(p);
                return;
            }
            p.sendAddchatYellow("Vị trí người này không thể đi tới hoặc không online");
        } catch (Exception e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }

    }

    public static void MoiGiaTocChien(Player p, Message m, String str) {
        try {
            ClanManager temp = ClanManager.getClanName(str);
            ClanManager temp2 = ClanManager.getClanName(p.c.clan.clanName);
            if (temp != null) {
                String tocTruong = temp.getmain_name();
                Char _charTT = Client.gI().getNinja(tocTruong);
                if (_charTT != null && _charTT.id == p.c.id) {
                    Service.chatNPC(p, (short) 32, "Ngươi muốn thách đấu gia tộc của chính mình à.");
                } else if (_charTT != null && _charTT.id != p.c.id) {
//                                if (temp.gtcID != -1 && temp.gtcClanName != null) {
//                                    Service.chatNPC(p, (short) 32, "Gia tộc này đang có lời mời từ gia tộc khác");
//                                    return;
//                                }
                    Service.startYesNoDlg(_charTT.p, (byte) 4, "Gia tộc " + p.c.clan.clanName + " muốn thách đấu với gia tộc của bạn. Bạn có đồng ý?");
                    GiaTocChien giaTocChien = new GiaTocChien();
                    temp.gtcID = giaTocChien.gtcID;
                    temp.gtcClanName = p.c.clan.clanName;
                    temp2.gtcID = giaTocChien.gtcID;
                    temp2.gtcClanName = str;
                    Service.chatNPC(p, (short) 32, "Ta đã gửi lời mời thách đấu tới gia tộc " + str);
                } else {
                    Service.chatNPC(p, (short) 32, "Tộc trưởng gia tộc đối phương không online hoặc không tồn tại. Không thể gửi lời mời.");
                }
            } else {
                Service.chatNPC(p, (short) 32, "Gia tộc này không tồn tại, ta không thể gửi lời mời!");
            }
        } catch (Exception e) {
            p.conn.sendMessageLog("Không hợp lệ");
        }
    }
}
