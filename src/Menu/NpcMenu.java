/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import History.LichSu;
import Item.ItemName;
import TaiXiu.SoiCau;
import Task.Talk;
import Upgrade.Mat;
import assembly.Admission;
import assembly.Char;
import assembly.ClanManager;
import assembly.DunListWin;
import assembly.Item;
import assembly.Language;
import assembly.Map;
import assembly.Option;
import assembly.Player;
import assembly.TileMap;
import io.Message;
import io.SQLManager;
import io.Util;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import server.Manager;
import server.Menu;
import server.Rank;
import server.Service;
import server.ShinwaManager;
import stream.Cave;
import stream.ChienTruong;
import stream.GiaTocChien;
import stream.LanhDiaGiaToc;
import stream.Server;
import template.DanhVongTemplate;
import template.ItemTemplate;
import template.MapTemplate;
import template.MobTemplate;
import template.ShinwaTemplate;
import thiendiabang.ThienDiaBangManager;
import thiendiabang.ThienDiaData;

/**
 *
 * @author voqua
 */
public class NpcMenu {

    public static void npcKanata(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0: {
                p.requestItem(2);
                break;
            }
            case 1: {
                switch (b3) {
                    case 0: {
                        if (!p.c.clan.clanName.isEmpty()) {
                            Service.chatNPC(p, (short) npcid, "Hiện tại con đã có gia tộc, không thể thành lập gia tộc được nữa.");
                            return;
                        }
                        if (p.luong < 100000) {
                            Service.chatNPC(p, (short) npcid, "Để thành lập gia tộc, con phải có ít nhất 100.000 lượng trong người.");
                            return;
                        }
                        Menu.sendWrite(p, (short) 50, "Tên gia tộc");
                        return;
                    }
                    case 1: {
                        if (p.c.clan.clanName.isEmpty()) {
                            Service.chatNPC(p, (short) npcid, "Hiện tại con chưa có gia tộc, không thể mở Lãnh địa gia tộc.");
                            return;
                        }
                        LanhDiaGiaToc lanhDiaGiaToc = null;
                        if (p.c.ldgtID != -1) {
                            if (LanhDiaGiaToc.ldgts.containsKey(p.c.ldgtID)) {
                                lanhDiaGiaToc = LanhDiaGiaToc.ldgts.get(p.c.ldgtID);
                                if (lanhDiaGiaToc != null && lanhDiaGiaToc.map[0] != null && lanhDiaGiaToc.map[0].area[0] != null) {
                                    if (lanhDiaGiaToc.ninjas.size() <= 50) {
                                        p.c.mapKanata = p.c.mapid;
                                        p.c.tileMap.leave(p);
                                        lanhDiaGiaToc.map[0].area[0].EnterMap0(p.c);
                                        return;
                                    } else {
                                        p.sendAddchatYellow("Số thành viên tham gia Lãnh Địa Gia Tộc đã đạt tối đa.");
                                    }
                                }
                            }
                        }
                        if (lanhDiaGiaToc == null) {
                            if (p.c.clan.typeclan < 3) {
                                Service.chatNPC(p, (short) npcid, "Con không phải tộc trưởng hoặc tộc phó, không thể mở Lãnh địa gia tộc.");
                                return;
                            }
                            if (p.c.getBagNull() < 1) {
                                Service.chatNPC(p, (short) npcid, "Hành trang của con không đủ chỗ trống để nhận Chìa khoá LDGT");
                                return;
                            }
                            ClanManager clan = ClanManager.getClanName(p.c.clan.clanName);
                            if (clan != null && p.c.clan.typeclan >= 3) {
                                if (clan.openDun <= 0) {
                                    Service.chatNPC(p, (short) npcid, "Số lần vào LDGT tuần này đã hết.");
                                    return;
                                }
                                if (clan.ldgtID != -1) {
                                    Service.chatNPC(p, (short) npcid, "Lãnh địa gia tộc của con đang được mở rồi.");
                                    return;
                                }
                                clan.openDun--;
                                clan.flush();
                                lanhDiaGiaToc = new LanhDiaGiaToc();

                                Item itemup = ItemTemplate.itemDefault(260);
                                itemup.quantity = 1;
                                itemup.expires = System.currentTimeMillis() + 600000L;
                                itemup.isExpires = true;
                                itemup.isLock = true;
                                if (p.c.quantityItemyTotal(260) > 0) {
                                    p.c.removeItemBags(260, p.c.quantityItemyTotal(260));
                                }
                                p.c.addItemBag(false, itemup);
                                p.c.ldgtID = lanhDiaGiaToc.ldgtID;
                                clan.ldgtID = lanhDiaGiaToc.ldgtID;
                                lanhDiaGiaToc.clanManager = clan;
                                p.c.mapKanata = p.c.mapid;
                                p.c.tileMap.leave(p);
                                lanhDiaGiaToc.map[0].area[0].EnterMap0(p.c);
                                return;
                            }

                        }
                        break;
                    }
                    case 2: {
//                        if (p.c.isNhanban) {
//                            p.conn.sendMessageLog("Chức năng này không dành cho phân thân");
//                            return;
//                        }
//                        if (p.c.quantityItemyTotal(262) < 500) {
                        Service.chatNPC(p, (short) npcid, "Chức Năng Đang Nâng Cấp.");
//                            return;
//                        }
//                        if (p.c.getBagNull() < 1) {
//                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
//                            return;
//                        }
//                        p.c.removeItemBags(262, 500);
//                        Item itemup = ItemTemplate.itemDefault(263);
//                        itemup.quantity = 1;
//                        itemup.isLock = true;
//                        p.c.addItemBag(true, itemup);
                        break;
                    }
                    case 3: {
                        if (p.c.clan.clanName.isEmpty()) {
                            Service.chatNPC(p, (short) npcid, "Con cần phải có gia tộc thì mới có thể điểm danh được nhé");
                            break;
                        }
                        if (p.c.ddClan) {
                            Service.chatNPC(p, (short) npcid, "Hôm nay con đã điểm danh rồi nhé, hãy quay lại đây vào ngày mai");
                            break;
                        }
                        p.c.ddClan = true;
                        final ClanManager clan = ClanManager.getClanName(p.c.clan.clanName);
                        if (clan == null) {
                            Service.chatNPC(p, (short) npcid, "Lỗi");
                            return;
                        }
                        p.upExpClan(Util.nextInt(1, 10 + clan.level));
                        LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 10 * clan.level), "Điểm Danh Gia Tộc", +10 * clan.level);
                        p.upluongMessage(10 * clan.level);
                        Service.chatNPC(p, (short) npcid, "Điểm danh thành công. Chúc con chơi game vui vẽ");
                        break;
                    }

                }
                break;
            }
            case 2: {
                if (p.c.isNhanban) {
                    p.conn.sendMessageLog("Chức năng này không dành cho phân thân");
                    return;
                }
                if (b3 == 0) {
                    Service.evaluateCave(p.c);
                    return;
                }
                Cave cave = null;
                if (p.c.caveID != -1) {
                    if (Cave.caves.containsKey(p.c.caveID)) {
                        cave = Cave.caves.get(p.c.caveID);
                        if (cave != null && cave.map[0] != null && cave.map[0].area[0] != null) {
                            p.c.mapKanata = p.c.mapid;
                            p.c.tileMap.leave(p);
                            cave.map[0].area[0].EnterMap0(p.c);
                        }
                    }
                } else if (p.c.party != null && p.c.party.cave == null && p.c.party.charID != p.c.id) {
                    p.conn.sendMessageLog("Chỉ có nhóm trưởng mới được phép mở cửa hang động");
                    return;
                }
                if (cave == null) {
                    if (p.c.nCave <= 0) {
                        Service.chatNPC(p, (short) npcid, "Số lần vào hang động của con hôm nay đã hết, hãy quay lại vào ngày mai.");
                        return;
                    }
                    if (b3 == 1) {
                        if (p.c.level < 30 || p.c.level > 39) {
                            p.conn.sendMessageLog("Trình độ không phù hợp");
                            return;
                        }
                        if (p.c.party != null) {
                            synchronized (p.c.party.aChar) {
                                for (byte i = 0; i < p.c.party.aChar.size(); ++i) {
                                    if (p.c.party.aChar.get(i).level < 30 || p.c.party.aChar.get(i).level > 39) {
                                        p.conn.sendMessageLog("Thành viên trong nhóm có trình độ không phù hợp");
                                        return;
                                    }
                                }
                            }
                        }
                        if (p.c.party != null) {
                            if (p.c.party.cave == null) {
                                cave = new Cave(3);
                                p.c.party.openCave(cave, p.c.name);
                            } else {
                                cave = p.c.party.cave;
                            }
                        } else {
                            cave = new Cave(3);
                        }
                        p.c.caveID = cave.caveID;
                        p.c.isHangDong6x = 0;
                    }
                    if (b3 == 2) {
                        if (p.c.level < 40 || p.c.level > 49) {
                            p.conn.sendMessageLog("Trình độ không phù hợp");
                            return;
                        }
                        if (p.c.party != null) {
                            synchronized (p.c.party.aChar) {
                                for (byte i = 0; i < p.c.party.aChar.size(); ++i) {
                                    if (p.c.party.aChar.get(i).level < 40 || p.c.party.aChar.get(i).level > 49) {
                                        p.conn.sendMessageLog("Thành viên trong nhóm có trình độ không phù hợp");
                                        return;
                                    }
                                }
                            }
                        }
                        if (p.c.party != null) {
                            if (p.c.party.cave == null) {
                                cave = new Cave(4);
                                p.c.party.openCave(cave, p.c.name);
                            } else {
                                cave = p.c.party.cave;
                            }
                        } else {
                            cave = new Cave(4);
                        }
                        p.c.caveID = cave.caveID;
                        p.c.isHangDong6x = 0;
                    }
                    if (b3 == 3) {
                        if (p.c.level < 50 || p.c.level > 59) {
                            p.conn.sendMessageLog("Trình độ không phù hợp");
                            return;
                        }
                        if (p.c.party != null) {
                            synchronized (p.c.party.aChar) {
                                for (byte i = 0; i < p.c.party.aChar.size(); ++i) {
                                    if (p.c.party.aChar.get(i).level < 50 || p.c.party.aChar.get(i).level > 59) {
                                        p.conn.sendMessageLog("Thành viên trong nhóm có trình độ không phù hợp");
                                        return;
                                    }
                                }
                            }
                        }
                        if (p.c.party != null) {
                            if (p.c.party.cave == null) {
                                cave = new Cave(5);
                                p.c.party.openCave(cave, p.c.name);
                            } else {
                                cave = p.c.party.cave;
                            }
                        } else {
                            cave = new Cave(5);
                        }
                        p.c.caveID = cave.caveID;
                    }
                    if (b3 == 4) {
                        if (p.c.level < 60 || p.c.level > 69) {
                            p.conn.sendMessageLog("Trình độ không phù hợp");
                            return;
                        }
                        if (p.c.party != null && p.c.party.aChar.size() > 1) {
                            p.conn.sendMessageLog("Hang động này chỉ được phép 1 mình.");
                            return;
                        }
                        cave = new Cave(6);
                        p.c.caveID = cave.caveID;
                        p.c.isHangDong6x = 1;
                        p.c.IsLevel6x = 1;
                    }
                    if (b3 == 5) {
                        if (p.c.level < 70 || p.c.level > 89) {
                            p.conn.sendMessageLog("Trình độ không phù hợp");
                            return;
                        }
                        if (p.c.party != null) {
                            synchronized (p.c.party.aChar) {
                                for (byte i = 0; i < p.c.party.aChar.size(); ++i) {
                                    if (p.c.party.aChar.get(i).level < 70 || p.c.party.aChar.get(i).level > 89) {
                                        p.conn.sendMessageLog("Thành viên trong nhóm có trình độ không phù hợp");
                                        return;
                                    }
                                }
                            }
                        }
                        if (p.c.party != null) {
                            if (p.c.party.cave == null) {
                                cave = new Cave(7);
                                p.c.party.openCave(cave, p.c.name);
                            } else {
                                cave = p.c.party.cave;
                            }
                        } else {
                            cave = new Cave(7);
                        }
                        p.c.caveID = cave.caveID;
                        p.c.isHangDong6x = 0;
                    }
                    if (b3 == 6) {
                        if (p.c.level < 90 || p.c.level > 130) {
                            p.conn.sendMessageLog("Trình độ không phù hợp");
                            return;
                        }
                        if (p.c.party != null) {
                            synchronized (p.c.party.aChar) {
                                for (byte i = 0; i < p.c.party.aChar.size(); ++i) {
                                    if (p.c.party.aChar.get(i).level < 90 || p.c.party.aChar.get(i).level > 130) {
                                        p.conn.sendMessageLog("Thành viên trong nhóm có trình độ không phù hợp");
                                        return;
                                    }
                                }
                            }
                        }
                        if (p.c.party != null) {
                            if (p.c.party.cave == null) {
                                cave = new Cave(9);
                                p.c.party.openCave(cave, p.c.name);
                            } else {
                                cave = p.c.party.cave;
                            }
                        } else {
                            cave = new Cave(9);
                        }
                        p.c.caveID = cave.caveID;
                        p.c.isHangDong6x = 1;
                    }
                    // sửa
                    if (b3 == 7) {
                        if (p.c.level < 130) {
                            p.conn.sendMessageLog("Trình độ không phù hợp");
                            return;
                        }
                        if (p.c.party != null) {
                            synchronized (p.c.party.aChar) {
                                for (byte i = 0; i < p.c.party.aChar.size(); ++i) {
                                    if (p.c.party.aChar.get(i).level > 130) {
                                        p.conn.sendMessageLog("Thành viên trong nhóm có trình độ không phù hợp");
                                        return;
                                    }
                                }
                            }
                        }
                        if (p.c.party != null) {
                            if (p.c.party.cave == null) {
                                cave = new Cave(2);
                                p.c.party.openCave(cave, p.c.name);
                            } else {
                                cave = p.c.party.cave;
                            }
                        } else {
                            cave = new Cave(2);
                        }
                        p.c.caveID = cave.caveID;
                        p.c.isHangDong6x = 0;
                    }
                    // LIÊN HANG
                    if (b3 == 8) {
                        if (p.c.level < 130) {
                            p.conn.sendMessageLog("Trình độ không phù hợp");
                            return;
                        }
                        if (p.c.dameMax() < 100000) {
                            p.conn.sendMessageLog("Tấn công phải đạt đủ 100.000 Mới có thể tham gia liên hang động");
                            return;
                        }
                        if (p.c.party != null) {
                            synchronized (p.c.party.aChar) {
                                for (byte i = 0; i < p.c.party.aChar.size(); ++i) {
                                    if (p.c.party.aChar.get(i).level < 130) {
                                        p.conn.sendMessageLog("Thành viên trong nhóm có trình độ không phù hợp");
                                        return;
                                    }
                                    if (p.c.party.aChar.get(i).dameMax() < 100000) {
                                        p.conn.sendMessageLog("Thành viên trong nhóm có lực chiến quá thấp");
                                        return;
                                    }
                                }
                            }
                        }
                        if (p.c.party != null) {
                            if (p.c.party.cave == null) {
                                cave = new Cave(1);
                                p.c.party.openCave(cave, p.c.name);
                            } else {
                                cave = p.c.party.cave;
                            }
                        } else {
                            cave = new Cave(1);
                        }
                        p.c.caveID = cave.caveID;
                        p.c.isHangDong6x = 2;
                    }
                    //
                    if (cave != null) {
                        p.c.nCave--;
                        p.c.pointCave = 0;
                        if (p.c.party != null && p.c.party.charID == p.c.id) {
                            if (p.c.party.aChar != null && p.c.party.aChar.size() > 0) {
                                synchronized (p.c.party.aChar) {
                                    Char _char;
                                    for (int i = 0; i < p.c.party.aChar.size(); i++) {
                                        if (p.c.party.aChar.get(i) != null) {
                                            _char = p.c.party.aChar.get(i);
                                            if (_char.id != p.c.id && p.c.tileMap.getNinja(_char.id) != null && _char.nCave > 0 && _char.caveID == -1 && _char.level >= 30 && (int) _char.level / 10 == cave.x) {
                                                _char.nCave--;
                                                _char.pointCave = 0;
                                                _char.caveID = p.c.caveID;
                                                _char.isHangDong6x = p.c.isHangDong6x;
                                                _char.IsLevel6x = p.c.IsLevel6x;
                                                _char.mapKanata = _char.mapid;
                                                _char.countHangDong++;
                                                if (_char.pointUydanh < 5000) {
                                                    _char.pointUydanh += 5;
                                                }
                                                _char.tileMap.leave(_char.p);
                                                cave.map[0].area[0].EnterMap0(_char);
                                                _char.p.setPointPB(_char.pointCave);
                                            }
                                        }
                                    }
                                }
                            }

                        }
                        p.c.mapKanata = p.c.mapid;
                        p.c.countHangDong++;
                        if (p.c.pointUydanh < 5000) {
                            p.c.pointUydanh += 5;
                        }
                        p.c.tileMap.leave(p);
                        cave.map[0].area[0].EnterMap0(p.c);
                    }
                }
                p.setPointPB(p.c.pointCave);
                break;
            }
            case 3: {
                switch (b3) {
                    case 0: {
                        if (p.c.isNhanban) {
                            p.conn.sendMessageLog(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.pk > 0) {
                            p.sendAddchatYellow("Không thể mời lôi đài khi hiếu chiến lớn hơn 0");
                            return;
                        }
                        if (p.c.party != null && p.c.party.charID != p.c.id) {
                            Service.chatNPC(p, (short) npcid, "Con không phải trưởng nhóm, không thể thực hiện gửi lời mời lôi đài cho người/nhóm khác");
                            return;
                        }
                        Service.sendInputDialog(p, (short) 2, "Nhập tên đối thủ của con");
                        return;
                    }
                    case 1: {
                        Service.sendLoiDaiList(p.c);
                        return;
                    }
                    case 2: {
                        String alert = "";
                        for (int i = 0; i < DunListWin.dunList.size(); ++i) {
                            int temp = i + 1;
                            alert = alert + temp + ". Phe " + ((DunListWin) DunListWin.dunList.get(i)).win + " thắng Phe " + ((DunListWin) DunListWin.dunList.get(i)).lose + ".\n";
                        }
                        Server.manager.sendTB(p, "Kết quả", alert);
                        return;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 4: {
                Service.chatNPC(p, (short) npcid, "Vũ khí của ta cực sắc bén. Nếu muốn tỷ thí thì cứ đến chỗ ta!");
                break;
            }

        }
    }

    public static void npcFuroya(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0:
                switch (b3) {
                    case 0:
                        p.requestItem(21 - p.c.gender);
                        return;
                    case 1:
                        p.requestItem(23 - p.c.gender);
                        return;
                    case 2:
                        p.requestItem(25 - p.c.gender);
                        return;
                    case 3:
                        p.requestItem(27 - p.c.gender);
                        return;
                    case 4:
                        p.requestItem(29 - p.c.gender);
                        return;

                }
            case 1:
                Service.chatNPC(p, (short) npcid, "Tan bán quần áo, mũ nón, găng tay và giày siêu bền, siêu rẻ!");
                break;
        }
    }

    public static void npcAmeji(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0: {
                switch (b3) {
                    case 0: {
                        p.requestItem(16);
                        break;
                    }
                    case 1: {
                        p.requestItem(17);
                        break;
                    }
                    case 2: {
                        p.requestItem(18);
                        break;
                    }
                    case 3: {
                        p.requestItem(19);
                        break;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 1: {
                ItemTemplate data;
                switch (b3) {
                    case 0: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }

                        if (p.c.level < 50) {
                            Service.chatNPC(p, (short) npcid, "Cấp độ của con không đủ để nhận nhiệm vụ này");
                            return;
                        }

                        if (p.c.countTaskDanhVong < 1) {
                            Service.chatNPC(p, (short) npcid, "Số lần nhận nhiệm vụ của con hôm nay đã hết");
                            return;
                        }

                        if (p.c.isTaskDanhVong == 1) {
                            Service.chatNPC(p, (short) npcid, "Trước đó con đã nhận nhiệm vụ rồi, hãy hoàn thành đã nha");
                            return;
                        }

                        int type = DanhVongTemplate.randomNVDV();
                        p.c.taskDanhVong[0] = type;
                        p.c.taskDanhVong[1] = 0;
                        p.c.taskDanhVong[2] = DanhVongTemplate.targetTask(type);
                        p.c.isTaskDanhVong = 1;
                        p.c.countTaskDanhVong--;
                        if (p.c.isTaskDanhVong == 1) {
                            String nv = "Nhiệm vụ lần này: \n"
                                    + String.format(DanhVongTemplate.nameNV[p.c.taskDanhVong[0]],
                                            p.c.taskDanhVong[1],
                                            p.c.taskDanhVong[2])
                                    + "\n\n- Số lần nhận nhiệm vụ còn lại là: " + p.c.countTaskDanhVong;
                            Server.manager.sendTB(p, "Nhiệm vụ", nv);
                        }
                        break;
                    }
                    case 1: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }

                        if (p.c.isTaskDanhVong == 0) {
                            Service.chatNPC(p, (short) npcid, "Con chưa nhận nhiệm vụ nào cả!");
                            return;
                        }

                        if (p.c.taskDanhVong[1] < p.c.taskDanhVong[2]) {
                            Service.chatNPC(p, (short) npcid, "Con chưa hoàn thành nhiệm vụ ta giao!");
                            return;
                        }

                        if (p.c.getBagNull() < 2) {
                            Service.chatNPC(p, (short) npcid, "Hành trang của con không đủ chỗ trống để nhận thưởng");
                            return;
                        }

                        int point = 10; // điểm mỗi nhiệm vụ
                        if (p.c.taskDanhVong[0] == 9) {
                            point = 10;
                        }
                        p.c.isTaskDanhVong = 0;
                        p.c.taskDanhVong = new int[]{-1, -1, -1, 0, p.c.countTaskDanhVong};
                        Item item = ItemTemplate.itemDefault(DanhVongTemplate.randomDaDanhVong(), false);
                        item.quantity = 1;
                        item.isLock = false;
                        if (p.c.pointUydanh < 5000) {
                            ++p.c.pointUydanh;
                        }

                        p.c.addItemBag(true, item);
                        int type = Util.nextInt(10);
                        if (p.c.avgPointDanhVong(p.c.getPointDanhVong(type))) {
                            for (int i = 0; i < 10; i++) {
                                type = i;
                                if (!p.c.avgPointDanhVong(p.c.getPointDanhVong(type))) {
                                    break;
                                }
                            }
                        }
                        p.c.plusPointDanhVong(type, point);
                        Service.chatNPC(p, (short) npcid, "Con hãy nhận lấy phần thưởng của mình.");
                        break;
                    }
                    case 2: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.isTaskDanhVong == 0) {
                            Service.chatNPC(p, (short) 2, "Con chưa nhận nhiệm vụ nào cả!");
                            return;
                        }
                        p.c.isTaskDanhVong = 0;
                        //  p.c.countTaskDanhVong++;
                        p.c.taskDanhVong = new int[]{-1, -1, -1, 0, p.c.countTaskDanhVong};
                        Service.chatNPC(p, (short) 2, "Con đã huỷ nhiệm vụ lần này.");
                        break;
                    }
                    case 3: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }

                        if (p.c.checkPointDanhVong(1)) {
                            if (p.c.getBagNull() < 1) {
                                Service.chatNPC(p, (short) npcid, "Hành trang của con không đủ chỗ trống để nhận thưởng");
                                return;
                            }
                            Item item = ItemTemplate.itemDefault(685, true);
                            item.quantity = 1;
                            item.upgrade = 1;
                            item.isLock = true;
                            item.options.add(new Option(6, 1000));
                            item.options.add(new Option(87, 1000));
                            item.options.add(new Option(80, 50));
                            item.options.add(new Option(94, 10));
                            item.options.add(new Option(100, 10));
                            p.c.addItemBag(false, item);
                        } else {
                            Service.chatNPC(p, (short) npcid, "Con chưa đủ điểm để nhận mắt");
                        }
                        break;
                    }
                    case 4: {

                        Item item = p.c.ItemBody[14];
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (item == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy đeo mắt vào người trước rồi nâng cấp nhé.");
                            return;
                        }
                        if (p.c.ItemBody[14].upgrade >= 10) {
                            Service.chatNPC(p, (short) npcid, "Mắt của con đã đạt cấp tối đa");
                            return;
                        }

                        if (!p.c.checkPointDanhVong(p.c.ItemBody[14].upgrade)) {
                            Service.chatNPC(p, (short) npcid, "Con chưa đủ điểm danh vọng để thực hiện nâng cấp");
                            return;
                        }
                        if (p.c.quantityItemyTotal(694 + item.upgrade) < 10) {
                            data = ItemTemplate.ItemTemplateId(694 + item.upgrade);
                            p.conn.sendMessageLog("Bạn không đủ 10 viên " + data.name + " để nâng cấp");
                            return;
                        }
                        data = ItemTemplate.ItemTemplateId(p.c.ItemBody[14].id);
                        Service.startYesNoDlg(p, (byte) 0,
                                "Bạn có muốn nâng cấp " + data.name
                                + " với " + Mat.coinUpMat[item.upgrade]
                                + " yên hoặc xu với tỷ lệ thành công là "
                                + Mat.percentUpMat[item.upgrade] + "% không?");
                        break;
                    }
                    case 5: {
                        Item item = p.c.ItemBody[14];
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }

                        if (item == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy đeo mắt vào người trước rồi nâng cấp nhé.");
                            return;
                        }

                        if (item.upgrade >= 10) {
                            Service.chatNPC(p, (short) npcid, "Mắt của con đã đạt cấp tối đa");
                            return;
                        }

                        if (!p.c.checkPointDanhVong(p.c.ItemBody[14].upgrade)) {
                            Service.chatNPC(p, (short) npcid, "Con cần đủ 100 điểm mỗi loại để nâng cấp");
                            return;
                        }
                        if (p.c.quantityItemyTotal(694 + item.upgrade) < 10) {
                            data = ItemTemplate.ItemTemplateId(694 + item.upgrade);
                            p.conn.sendMessageLog("Bạn không đủ 10 viên " + data.name + " để nâng cấp");
                            return;
                        }
                        data = ItemTemplate.ItemTemplateId(p.c.ItemBody[14].id);
                        Service.startYesNoDlg(p, (byte) 1,
                                "Bạn có muốn nâng cấp " + data.name
                                + " với " + Mat.coinUpMat[p.c.ItemBody[14].upgrade]
                                + " yên hoặc xu và " + Mat.goldUpMat[p.c.ItemBody[14].upgrade]
                                + " lượng với tỷ lệ thành công là "
                                + Mat.percentUpMat[p.c.ItemBody[14].upgrade] * 2 + "% không?");
                        break;
                    }
                    case 6: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        String nv = "- Hoàn thành nhiệm vụ. Hãy gặp Ameji để trả nhiệm vụ.\n "
                                + "- Hôm nay có thể nhận thêm " + p.c.countTaskDanhVong + " nhiệm vụ trong ngày.\n"
                                + "- Hôm nay có thể sử dụng thêm " + p.c.useDanhVongPhu + " Danh Vọng Phù để nhận thêm lần làm nhiệm vụ.\n"
                                + "- Hoàn thành nhiệm vụ sẽ nhận ngẫu nhiên 1 viên đá danh vọng cấp 1-5.\n"
                                + "- Khi đủ mốc 100 điểm mỗi loại có thể nhận mắt và nâng cấp mắt.";
                        if (p.c.isTaskDanhVong == 1) {
                            nv = "Nhiệm vụ lần này: \n" + String.format(DanhVongTemplate.nameNV[p.c.taskDanhVong[0]], p.c.taskDanhVong[1], p.c.taskDanhVong[2]) + "\n\n\n" + nv;
                        }
                        Server.manager.sendTB(p, "Nhiệm Vụ", nv);
                        break;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 2: {
                Service.chatNPC(p, (short) npcid, "Tan bán các loại trang sức lấp lánh!");
                break;
            }

        }
    } // NPC 2

    public static void npcKiriko(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0: {
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                p.requestItem(7);
                break;
            }
            case 1: {
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                p.requestItem(6);
                break;
            }
            case 2: {
                if (p.c.taskId == 0 && p.c.taskIndex == 0) {
                    p.c.uptaskMaint();
                    Service.openUISay(p.c, npcid, Talk.getTask(0, 1));
                    break;
                }
                Service.openUISay(p.c, npcid, Talk.get(0, npcid));
                break;
            }

        }

    } // NPC 3

    public static void npcTabemono(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0:
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                p.requestItem(9);
                break;
            case 1:
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                p.requestItem(8);
                break;
            case 2: {
                if (p.c.taskId == 0 && p.c.taskIndex == 1) {
                    p.c.uptaskMaint();
                    Service.openUISay(p.c, npcid, Talk.getTask(0, 2));
                    break;
                }
                Service.openUISay(p.c, npcid, Talk.get(0, npcid));
                break;
            }
            case 3: {
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                switch (b3) {
                    case 0: {
                        if (!ThienDiaBangManager.register) {
                            Service.chatNPC(p, (short) npcid, "Đang trong thời gian tổng kết. Hiện tại không thể đăng ký.");
                            return;
                        }
                        if (ThienDiaBangManager.diaBangList.containsKey(p.c.name) || ThienDiaBangManager.thienBangList.containsKey(p.c.name)) {
                            Service.chatNPC(p, (short) npcid, "Con đã đăng ký trước đó rồi");
                            return;
                        }
                        if (p.c.get().level >= 50 && p.c.get().level < 70) {
                            ThienDiaBangManager.diaBangList.put(p.c.name, new ThienDiaData(p.c.name, ThienDiaBangManager.rankDiaBang++, 1));
                            Service.chatNPC(p, (short) npcid, "Con đã đăng ký tham gia trang tài Địa bảng thành công.");
                        } else if (p.c.get().level >= 70) {
                            ThienDiaBangManager.thienBangList.put(p.c.name, new ThienDiaData(p.c.name, ThienDiaBangManager.rankThienBang++, 1));
                            Service.chatNPC(p, (short) npcid, "Con đã đăng ký tham gia tranh tài Thiên bảng thành công.");
                        } else {
                            Service.chatNPC(p, (short) npcid, "Trình độ của con không phù hợp để đăng ký tham gia tranh tài.");
                        }
                        break;
                    }
                    case 1: {
                        if (!ThienDiaBangManager.register) {
                            Service.chatNPC(p, (short) npcid, "Đang trong thời gian tổng kết. Hiện tại không thể thi đấu.");
                            return;
                        }
                        ArrayList<ThienDiaData> list = new ArrayList<>();
                        if (ThienDiaBangManager.diaBangList.containsKey(p.c.name)) {
                            ThienDiaData rank = ThienDiaBangManager.diaBangList.get(p.c.name);
                            for (ThienDiaData data : ThienDiaBangManager.getListDiaBang()) {
                                if (data != null) {
                                    if (rank.getRank() < 10 && (data.getRank() - rank.getRank()) < 20) {
                                        list.add(data);
                                    } else if (data.getRank() < rank.getRank() & (rank.getRank() - data.getRank()) < 10) {
                                        list.add(data);
                                    }
                                }
                            }
                        } else if (ThienDiaBangManager.thienBangList.containsKey(p.c.name)) {
                            ThienDiaData rank = ThienDiaBangManager.thienBangList.get(p.c.name);
                            for (ThienDiaData data : ThienDiaBangManager.getListThienBang()) {
                                if (data != null) {
                                    if (rank.getRank() < 10 && (data.getRank() - rank.getRank()) < 20) {
                                        list.add(data);
                                    } else if (data.getRank() <= rank.getRank() & (rank.getRank() - data.getRank()) < 10) {
                                        list.add(data);
                                    }
                                }
                            }
                        } else {
                            Service.chatNPC(p, (short) npcid, "Con chưa đăng ký tham gia thi đấu.");
                            return;
                        }
                        Service.SendChinhPhuc(p, list);
                        return;
                    }
                    case 2: {
                        String res = "";
                        int count = 1;
                        for (ThienDiaData data : ThienDiaBangManager.getListSortAsc(new ArrayList<ThienDiaData>(ThienDiaBangManager.thienBangList.values()))) {
                            if (count < 11) {
                                res += "Hạng " + count + ": " + data.getName() + ".\n";
                                count++;
                            }
                        }
                        Server.manager.sendTB(p, "Thiên bảng", res);
                        return;
                    }
                    case 3: {
                        String res = "";
                        int count = 1;
                        for (ThienDiaData data : ThienDiaBangManager.getListSortAsc(new ArrayList<ThienDiaData>(ThienDiaBangManager.diaBangList.values()))) {
                            if (count < 11) {
                                res += "Hạng " + count + ": " + data.getName() + ".\n";
                                count++;
                            }
                        }
                        Server.manager.sendTB(p, "Địa bảng", res);
                        break;
                    }
//                    case 5: {
//                        Server.manager.sendTB(p, "Hướng dẫn", "- Thiên Địa Bảng sẽ được mở hàng tuần. Bắt đầu từ thứ 2 và tổng kết vào chủ nhật.\n"
//                                + "- Thiên Địa Bảng sẽ được mở đăng ký và chính phục từ 00h05' đến 23h45' hàng ngày. Mỗi ngày sẽ có 20p để tổng kết ngày, trong thời gian này sẽ không thể đăng ký và chinh phục\n"
//                                + "- Trong thời gian tổng kết nếu chiến thắng trong Chinh phục sẽ không được tính rank."
//                                + "- Vào ngày thường sẽ không giới hạn lượt thách đấu.\n"
//                                + "- Vào Thứ 7 và Chủ Nhật mỗi Ninja sẽ có 5 lượt thách đấu, Thắng sẽ không bị mất lượt, thua sẽ bị trừ 1 lần thách đấu."
//                                + "- Địa Bảng dành cho ninja từ cấp độ 50-69.\n"
//                                + "- Thiên Bảng dành cho ninja từ cấp độ trên 70\n"
//                                + "- Sau khi đăng ký thành công, hãy Chinh Phục ngay để giành lấy vị trí top đầu.\n"
//                                + "- Mỗi lần chiến thắng, nếu vị trí của đối thủ trước bạn, bạn sẽ đổi vị trí của mình cho đối thủ, còn không vị trí của bạn sẽ được giữ nguyên.\n"
//                                + "- Phần thưởng sẽ được trả thưởng vào mỗi tuần mới (Lưu ý: Hãy nhận thưởng ngay trong tuần mới đó, nếu sang tuần sau phần thưởng sẽ bị reset).\n\n"
//                                + "- PHẦN THƯỞNG: \n"
//                                + "Top 1: Hào quang Rank 1 + 2 Bánh Phong Lôi, 2 Bánh Băng Hoả, 2 Nấm x4, 3 Nấm x3, 1 Rương bạch ngân, 2 Bát bảo, 20,000 Lượng, 20,000,000 xu.\n\n"
//                                + "Top 2: Hào quang Rank 2 + 1 Bánh Phong Lôi, 1 Bánh Băng Hoả, 1 Nấm x4, 2 Nấm x3, 1 Rương bạch ngân, 1 Bát bảo, 10,000 Lượng, 10,000,000 xu.\n\n"
//                                + "Top 3: Hào quang Rank 3 + 1 Nấm x4, 1 Nấm x3, 2 Bát bảo, 5,000 Lượng, 5,000,000 xu.\n\n"
//                                + "Top 4-10: 1 Nấm x3, 1 Bát bảo, 3,000 Lượng, 3,000,000 xu.\n\n"
//                                + "Top 11-20: 1,000 Lượng, 1,000,000 xu.\n\n"
//                                + "Còn lại: 500 Lượng, 500,000 xu.");
//                        break;
//                    }
                    default: {
                        break;
                    }
                }
                break;
            }
//            case 4:
//                switch (b3) { // làng truyền thuyết
//                    case 0:
//                        if (p.c.level < 49 || p.c.level > 79) {
//                            p.conn.sendMessageLog("Chức năng này chỉ cho phép trình độ từ Level 49 Tới Level 79");
//                            return;
//                        }
//                        if (p.luong < 500) {
//                            p.conn.sendMessageLog("Cần 500 Lượng");
//                            return;
//                        }
//                        Service.startYesNoDlg(p, (byte) -3, "Bạn có muốn đi đến Làng Shiba với " + 500 + " Lượng " + " không?");
//                        break;
//                    case 1:
//                        Service.chatNPC(p, (short) npcid, "Để vào Làng Shiba cần đạt trình độ cấp 49 Đến Cấp 79.\n Khi tham gia đánh quái trong Làng Shiba có thể rơi ra nhiều vật phẩm đặc biệt ");
//                        break;
//                    default:
//                        break;
//                }
//                break;
        }
    }  // NPC 4

    public static void npcKamakura(Player p, byte npcid, byte menuId, byte b3) {
        try {
            if (p.c.isNhanban) {
                p.conn.sendMessageLog("Chức năng này không dành cho phân thân.");
                return;
            }
            switch (menuId) {
                case 0:
                    switch (b3) {
                        case 0: {
                            Service.openMenuBox(p);
                            break;
                        }
                        case 1: {
                            Service.openMenuBST(p);
                            break;
                        }
                        case 2: {
                            Service.openMenuCaiTrang(p);
                            break;
                        }
                        case 3: {
                            //Tháo cải trang
                            p.c.caiTrang = -1;
                            Message m = new Message(11);
                            m.writer().writeByte(-1);
                            m.writer().writeByte(p.c.get().speed());
                            m.writer().writeInt(p.c.get().getMaxHP());
                            m.writer().writeInt(p.c.get().getMaxMP());
                            m.writer().writeShort(p.c.get().eff5buffHP());
                            m.writer().writeShort(p.c.get().eff5buffMP());
                            m.writer().flush();
                            p.conn.sendMessage(m);
                            m.cleanup();
                            Service.CharViewInfo(p, false);
                            p.endLoad(true);
                            break;
                        }
                    }
                    break;
                case 1:
                    if (p.c.tileMap.map.getXHD() != -1 || p.c.tileMap.map.LangCo() || p.c.tileMap.map.mapChienTruong() || p.c.tileMap.map.mapBossTuanLoc() || p.c.tileMap.map.mapLDGT() || p.c.tileMap.map.mapGTC() || p.c.tileMap.map.id == 111 || p.c.tileMap.map.id == 113) {
                        p.c.mapLTD = 22;
                    } else {
                        p.c.mapLTD = p.c.tileMap.map.id;
                    }
                    Service.chatNPC(p, (short) npcid, "Lưu toạ độ thành công! Khi chết con sẽ được vác xác về đây.");
                    break;
                case 2:
                    switch (b3) {
                        case 0:
                            if (p.c.level < 60) {
                                p.conn.sendMessageLog("Chức năng này yêu cầu trình độ 60");
                                return;
                            }
                            Map ma = Manager.getMapid(139);
                            TileMap area;
                            int var8;
                            for (var8 = 0; var8 < ma.area.length; ++var8) {
                                area = ma.area[var8];
                                if (area.numplayers < ma.template.maxplayers) {
                                    p.c.tileMap.leave(p);
                                    area.EnterMap0(p.c);
                                    return;
                                }
                            }
                            return;
                        case 1:
                            Service.chatNPC(p, (short) npcid, "Để phiêu lưu Vùng Đất Ma Quỷ các ninja cần đạt trình độ cấp 60. \n Phân thân có thể vào Vùng Đất Ma Quỷ khi sở hữu Thí Luyện Thiếp \n Khi tham gia đánh quái ở Vùng Đất Ma Quỷ kèm theo vật phẩm Thiên Nhãn Phù khi đánh quái có thể rơi ra nhiều vật phẩm đặc biệt");
                            return;
                        default:
                            return;
                    }
                case 4: {
                    if (p.c.taskId == 0 && p.c.taskIndex == 4) {
                        p.c.uptaskMaint();
                        Service.openUISay(p.c, npcid, Talk.getTask(0, 5));
                        break;
                    }
                    Service.openUISay(p.c, npcid, Talk.get(0, npcid));
                    break;

                }
                case 3: {
                    if (p.c.maxluggage >= 126) {
                        Service.chatNPC(p, (short) npcid, "Bạn Chỉ Có Thể Nâng Tối Đa 126 Ô Hành Trang");
                        return;
                    }
                    if (p.c.maxluggage < 54) {
                        Service.chatNPC(p, (short) npcid, "Phải Sử Dụng Túi Vải Cấp 3 Mới Có Thể Nâng Cấp");
                        return;
                    }
                    if (p.luong < 1000) {
                        Service.chatNPC(p, (short) npcid, "Bạn Cần 1000 Lượng");
                        return;
                    }
                    Service.startYesNoDlg(p, (byte) -1, "Bạn Có Muốn Nâng 6 Ô Hành Trang Với Giá 1000 Lượng Không?");
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // NPC 5

    public static void npcKenshinto(Player p, byte npcid, byte menuId, byte b3) {
        if (p.c.isNhanban) {
            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
            return;
        }
        switch (menuId) {
            case 0: {
                switch (b3) {
                    case 0:
                        p.requestItem(10);
                        break;
                    case 1:
                        p.requestItem(31);
                        break;
                    case 2:
                        Server.manager.sendTB(p, "Hướng dẫn", "Đang Cập Nhật");
                        break;
                    default:
                        break;
                }
                break;
            }
            case 1: {
                if (b3 == 0) {
                    p.requestItem(12);
                }
                if (b3 == 1) {
                    p.requestItem(11);
                }
                break;
            }
            case 2: {
                p.requestItem(13);
                break;
            }
            case 3: {
                p.requestItem(33);
                break;
            }
            case 4: {
                p.requestItem(46);
                break;
            }
            case 5: {
                p.requestItem(47);
                break;
            }
            case 6: {
                p.requestItem(49);
                break;
            }
            case 7: {
                p.requestItem(50);
                break;
            }
            case 8: {
                if (p.c.taskId == 0 && p.c.taskIndex == 2) {
                    p.c.uptaskMaint();
                    Service.openUISay(p.c, npcid, Talk.getTask(0, 3));
                    break;
                }
                Service.openUISay(p.c, npcid, Talk.get(0, npcid));
                break;
            }

        }
    } // NPC 6

    public static void npcUmayaki_Lang(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0:
                if (p.c.taskId == 0 && p.c.taskIndex == 5) {
                    p.c.uptaskMaint();
                    Service.openUISay(p.c, npcid, Talk.getTask(0, 6));
                    break;
                }
                Service.openUISay(p.c, npcid, Talk.get(0, npcid));
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                TileMap[] var5 = Manager.getMapid(Map.arrLang[menuId - 1]).area;
                int var6 = var5.length;

                for (int var7 = 0; var7 < var6; ++var7) {
                    TileMap area = var5[var7];
                    if (area.numplayers < Manager.getMapid(Map.arrLang[menuId - 1]).template.maxplayers) {
                        p.c.tileMap.leave(p);
                        area.EnterMap0(p.c);
                        return;
                    }
                }

        }
    } // NPC 7

    public static void npcUmayaki_Truong(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0:
            case 1:
            case 2:
                TileMap[] var5 = Manager.getMapid(Map.arrTruong[menuId]).area;
                int var6 = var5.length;

                for (int var7 = 0; var7 < var6; ++var7) {
                    TileMap area = var5[var7];
                    if (area.numplayers < Manager.getMapid(Map.arrTruong[menuId]).template.maxplayers) {
                        p.c.tileMap.leave(p);
                        area.EnterMap0(p.c);
                        return;
                    }
                }

                return;
            case 3:
                Service.chatNPC(p, (short) npcid, "Ta kéo xe qua các trường, không qua quán net đâu!");
                return;

        }
    } // NPC 8

    public static void npcToyotomi(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0:
                switch (b3) {
                    case 0:
                        Server.manager.sendTB(p, "Top đại gia", Rank.getStringBXH(0));
                        break;
                    case 1:
                        Server.manager.sendTB(p, "Top cao thủ", Rank.getStringBXH(1));
                        break;
                    case 2:
                        Server.manager.sendTB(p, "Top gia tộc", Rank.getStringBXH(2));
                        break;
                    case 3:
                        Server.manager.sendTB(p, "Top hang động", Rank.getStringBXH(3));
                        break;
                    case 4:
                        Server.manager.sendTB(p, "Top Điểm Hang Động", Rank.getStringBXH(6));
                        break;
                }
                break;
            case 1:
                if (p.c.get().nclass > 0) {
                    Service.chatNPC(p, (short) npcid, "Con đã vào lớp từ trước rồi mà.");
                } else if (p.c.get().level < 10) {
                    Service.chatNPC(p, (short) npcid, "Con cần đạt trình độ cấp 10 mới có thể nhập học con nhé!");
                } else if (p.c.get().ItemBody[1] != null) {
                    Service.chatNPC(p, (short) npcid, "Con cần có 1 tâm hồn trong trắng mới có thể nhập học, hãy tháo vũ khí trên người ra!");
                } else if (p.c.getBagNull() < 2) {
                    Service.chatNPC(p, (short) npcid, "Hành trang cần phải có ít nhất 2 ô trống mới có thể nhập học!");
                } else {
                    if (b3 == 0) {
                        Admission.Admission(p, (byte) 1);
                    } else {
                        if (b3 != 1) {
                            Service.chatNPC(p, (short) npcid, "Chức năng này đang cập nhật!");
                            break;
                        }
                        Admission.Admission(p, (byte) 2);
                    }
                    Service.chatNPC(p, (short) npcid, "Hãy chăm chỉ luyện tập, có làm thì mới có ăn con nhé.");
                }
                break;
            case 2:
                if (p.c.get().nclass != 1 && p.c.get().nclass != 2) {
                    Service.chatNPC(p, (short) npcid, "Con không phải học sinh của trường này, ta không thể giúp con tẩy điểm dược rồi.");
                } else if (b3 == 0) {
                    if (p.c.get().countTayTiemNang < 1) {
                        Service.chatNPC(p, (short) npcid, "Số lần tẩy điểm tiềm năng của con đã hết.");
                        return;
                    }
                    p.restPpoint();
                    --p.c.get().countTayTiemNang;
                    Service.chatNPC(p, (short) npcid, "Ta đã giúp con tẩy điểm tiềm năng, hãy nâng điểm thật hợp lý nha.");
                    p.sendAddchatYellow("Tẩy điểm tiềm năng thành công");
                } else if (b3 == 1) {
                    if (p.c.get().countTayKyNang < 1) {
                        Service.chatNPC(p, (short) npcid, "Số lần tẩy điểm kỹ năng của con đã hết.");
                        return;
                    }
                    p.restSpoint();
                    --p.c.get().countTayKyNang;
                    Service.chatNPC(p, (short) npcid, "Ta đã giúp con tẩy điểm kỹ năng, hãy nâng điểm thật hợp lý nha.");
                    p.sendAddchatYellow("Tẩy điểm kỹ năng thành công");
                }
                break;
            case 3:
                if (p.c.taskId == 8 && p.c.taskIndex == 1) {
                    p.c.uptaskMaint();
                    Service.openUISay(p.c, npcid, Talk.getTask(0, 112));
                    break;
                }
                Service.chatNPC(p, (short) npcid, "Học là để thành tài , chứ không phải để ganh đua với đời ");
                break;
            case 4:
                Service.chatNPC(p, (short) npcid, "Đang Cập Nhật!");
                break;

        }
    } // NPC 9

    public static void npcOokamesama(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0:
                switch (b3) {
                    case 0:
                        Server.manager.sendTB(p, "Top đại gia", Rank.getStringBXH(0));
                        break;
                    case 1:
                        Server.manager.sendTB(p, "Top cao thủ", Rank.getStringBXH(1));
                        break;
                    case 2:
                        Server.manager.sendTB(p, "Top gia tộc", Rank.getStringBXH(2));
                        break;
                    case 3:
                        Server.manager.sendTB(p, "Top hang động", Rank.getStringBXH(3));
                        break;
                    case 4:
                        Server.manager.sendTB(p, "Top Điểm Hang Động", Rank.getStringBXH(6));
                        break;
                }
                break;
            case 1:
                if (p.c.get().nclass > 0) {
                    Service.chatNPC(p, (short) npcid, "Con đã vào lớp từ trước rồi mà.");
                } else if (p.c.get().level < 10) {
                    Service.chatNPC(p, (short) npcid, "Con cần đạt trình độ cấp 10 mới có thể nhập học con nhé!");
                } else if (p.c.get().ItemBody[1] != null) {
                    Service.chatNPC(p, (short) npcid, "Con cần có 1 tâm hồn trong trắng mới có thể nhập học, hãy tháo vũ khí trên người ra!");
                } else if (p.c.getBagNull() < 2) {
                    Service.chatNPC(p, (short) npcid, "Hành trang cần phải có ít nhất 2 ô trống mới có thể nhập học!");
                } else {
                    if (b3 == 0) {
                        Admission.Admission(p, (byte) 3);
                    } else {
                        if (b3 != 1) {
                            Service.chatNPC(p, (short) npcid, "Chức năng này đang cập nhật!");
                            break;
                        }
                        Admission.Admission(p, (byte) 4);
                    }

                    Service.chatNPC(p, (short) npcid, "Hãy chăm chỉ luyện tập, có làm thì mới có ăn con nhé.");
                }
                break;
            case 2:
                if (p.c.get().nclass != 3 && p.c.get().nclass != 4) {
                    Service.chatNPC(p, (short) npcid, "Con không phải học sinh của trường này, ta không thể giúp con tẩy điểm dược rồi.");
                } else if (b3 == 0) {
                    if (p.c.get().countTayTiemNang < 1) {
                        Service.chatNPC(p, (short) npcid, "Số lần tẩy điểm tiềm năng của con đã hết.");
                        return;
                    }
                    p.restPpoint();
                    --p.c.get().countTayTiemNang;
                    Service.chatNPC(p, (short) npcid, "Ta đã giúp con tẩy điểm tiềm năng, hãy nâng điểm thật hợp lý nha.");
                    p.sendAddchatYellow("Tẩy điểm tiềm năng thành công");
                } else if (b3 == 1) {
                    if (p.c.get().countTayKyNang < 1) {
                        Service.chatNPC(p, (short) npcid, "Số lần tẩy điểm kỹ năng của con đã hết.");
                        return;
                    }

                    p.restSpoint();
                    --p.c.get().countTayKyNang;
                    Service.chatNPC(p, (short) npcid, "Ta đã giúp con tẩy điểm kỹ năng, hãy nâng điểm thật hợp lý nha.");
                    p.sendAddchatYellow("Tẩy điểm kỹ năng thành công");
                }
                break;
            case 3:
                if (p.c.taskId == 8 && p.c.taskIndex == 2) {
                    p.c.uptaskMaint();
                    Service.openUISay(p.c, npcid, Talk.getTask(0, 113));
                    break;
                }
                Service.chatNPC(p, (short) npcid, "Học là để thành tài , chứ không phải để ganh đua với đời");
                break;
            case 4:
                Service.chatNPC(p, (short) npcid, "Đang Cập Nhật");
                break;

        }

    } // NPC 10

    public static void npcKazeto(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0:
                switch (b3) {
                    case 0:
                        Server.manager.sendTB(p, "Top đại gia", Rank.getStringBXH(0));
                        break;
                    case 1:

                        Server.manager.sendTB(p, "Top cao thủ", Rank.getStringBXH(1));
                        break;
                    case 2:

                        Server.manager.sendTB(p, "Top gia tộc", Rank.getStringBXH(2));
                        break;
                    case 3:

                        Server.manager.sendTB(p, "Top hang động", Rank.getStringBXH(3));
                        break;
                    case 4:
                        Server.manager.sendTB(p, "Top Điểm Hang Động", Rank.getStringBXH(6));
                        break;

                }
                break;
            case 1:
                if (p.c.get().nclass > 0) {
                    Service.chatNPC(p, (short) npcid, "Con đã vào lớp từ trước rồi mà.");
                } else if (p.c.get().level < 10) {
                    Service.chatNPC(p, (short) npcid, "Con cần đạt trình độ cấp 10 mới có thể nhập học con nhé!");
                } else if (p.c.get().ItemBody[1] != null) {
                    Service.chatNPC(p, (short) npcid, "Con cần có 1 tâm hồn trong trắng mới có thể nhập học, hãy tháo vũ khí trên người ra!");
                } else if (p.c.getBagNull() < 2) {
                    Service.chatNPC(p, (short) npcid, "Hành trang cần phải có ít nhất 2 ô trống mới có thể nhập học!");
                } else {
                    if (b3 == 0) {
                        Admission.Admission(p, (byte) 5);
                    } else if (b3 == 1) {
                        Admission.Admission(p, (byte) 6);
                    }

                    Service.chatNPC(p, (short) npcid, "Hãy chăm chỉ luyện tập, có làm thì mới có ăn con nhé.");
                }
                break;
            case 2:
                if (p.c.get().nclass != 5 && p.c.get().nclass != 6) {
                    Service.chatNPC(p, (short) npcid, "Con không phải học sinh của trường này, ta không thể giúp con tẩy điểm dược rồi.");
                } else if (b3 == 0) {
                    if (p.c.get().countTayTiemNang < 1) {
                        Service.chatNPC(p, (short) npcid, "Số lần tẩy điểm tiềm năng của con đã hết.");
                        return;
                    }
                    p.restPpoint();
                    --p.c.get().countTayTiemNang;
                    Service.chatNPC(p, (short) npcid, "Ta đã giúp con tẩy điểm tiềm năng, hãy nâng điểm thật hợp lý nha.");
                    p.sendAddchatYellow("Tẩy điểm tiềm năng thành công");
                } else if (b3 == 1) {
                    if (p.c.get().countTayKyNang < 1) {
                        Service.chatNPC(p, (short) npcid, "Số lần tẩy điểm kỹ năng của con đã hết.");
                        return;
                    }
                    p.restSpoint();
                    --p.c.get().countTayKyNang;
                    Service.chatNPC(p, (short) npcid, "Ta đã giúp con tẩy điểm kỹ năng, hãy nâng điểm thật hợp lý nha.");
                    p.sendAddchatYellow("Tẩy điểm kỹ năng thành công");
                }
                break;
            case 3:
                if (p.c.taskId == 8 && p.c.taskIndex == 3) {
                    p.c.uptaskMaint();
                    Service.openUISay(p.c, npcid, Talk.getTask(0, 114));
                    break;
                }
                Service.chatNPC(p, (short) npcid, "Học là để thành tài , chứ không phải để ganh đua với đời");
                break;
            case 4:
                Service.chatNPC(p, (short) npcid, "Đang Cập Nhật");
                break;

        }

    } // NPC 11

    public static void npcTajima(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0:
                    Server.manager.sendTB(p, "BXH Đại Gia", Rank.getStringBXH(8));
                break;
            case 1:
                if (p.c.taskIndex == -1) {
                    Service.chatNPC(p, (short) npcid, "Con chưa nhận nhiệm vụ mà");
                    return;
                }
                if (p.c.taskId >= 43) {
                    Service.chatNPC(p, (short) npcid, "Con đã hoàn thành hết nhiệm vụ rồi mà");
                    return;
                }
                p.c.clearTask();
                Service.chatNPC(p, (short) npcid, "Ta đã huỷ hết nhiệm vụ và vật phẩm nhiệm vụ của con lần sau làm nhiệm vụ tốt hơn nhé");
                Service.getTask(p.c);
                break;
            case 2:
                if (p.c.taskId >= 43) {
                    Service.chatNPC(p, (short) npcid, "Con đã hoàn thành hết nhiệm vụ rồi mà");
                    return;
                }
                if (p.c.taskId <= 8) {
                    Service.chatNPC(p, (short) npcid, "Hãy hoàn thành nhiệm vụ vào trường trước");
                    return;
                }
                Service.startYesNoDlg(p, (byte) -2,
                        "Bạn có muốn bỏ qua nhiệm vụ không . Khi bỏ qua nhiệm vụ bạn sẽ không nhận được lượng khi hoàn thành nhiệm vụ chính tuyến . Bạn vẫn sẽ có thể nhận được Yoroi Bằng cách săn boss hoặc đi úp để kiếm ngọc rồng để ghép . Bạn Có Đồng Ý?");
                break;
            case 3:
                if (p.c.timeRemoveClone > System.currentTimeMillis()) {
                    p.toNhanBan();
                } else {
                    Service.chatNPC(p, (short) npcid, "Con không có phân thân để sử dụng chức năng này!");
                }
                break;
            case 4:
                if (!p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, "Con không phải phân thân để sử dụng chức năng này!");
                    return;
                }
                if (!p.c.clone.isDie && p.c.timeRemoveClone > System.currentTimeMillis() && p.c.isNhanban) {
                    p.exitNhanBan(true);
                }
                break;
        }
    } // NPC 12

    public static void npcOkanechan(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0:
                if (p.c.taskId == 0 && p.c.taskIndex == 3) {
                    p.c.uptaskMaint();
                    Service.openUISay(p.c, npcid, Talk.getTask(0, 4));
                    break;
                }
                Service.chatNPC(p, (short) 24, "");
                break;
            case 1:
                switch (b3) {
                    case 0:
                        Service.sendInputDialog(p, (short) 11, "Nhập Số Lượng ( 1000 Lượng = 10.000.000 Yên)");
                        break;
                }
                break;
            case 2:
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                switch (b3) {
                    case 0:
                        if (p.c.getBagNull() < 1) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        if (p.c.level >= 20 && p.c.checkLevel[0] == 0) {
                            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 1000), "Nhận thưởng thăng cấp", +1000);
                            p.upluongMessage(1000L);
                            p.c.checkLevel[0] = 1;
                            Service.chatNPC(p, (short) npcid, "Chúc mừng con đã đạt đến cấp độ mới!");
                        } else {
                            Service.chatNPC(p, (short) npcid, "Trình độ của con không đủ hoặc con đã nhận thưởng rồi!");
                        }
                        break;
                    case 1:
                        if (p.c.getBagNull() < 1) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        if (p.c.level >= 40 && p.c.checkLevel[1] == 0) {
                            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 2000), "Nhận thưởng thăng cấp", +2000);
                            p.upluongMessage(2000);
                            p.c.checkLevel[1] = 1;
                            Service.chatNPC(p, (short) npcid, "Chúc mừng con đã đạt đến cấp độ mới!");
                        } else {
                            Service.chatNPC(p, (short) npcid, "Trình độ của con không đủ hoặc con đã nhận thưởng rồi!");
                        }
                        break;
                    case 2:
                        if (p.c.getBagNull() < 1) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        if (p.c.level >= 60 && p.c.checkLevel[2] == 0) {
                            Item itemID = ItemTemplate.itemDefault(396 + p.c.nclass);
                            itemID.isLock = true;
                            p.c.addItemBag(false, itemID);
                            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 3000), "Nhận thưởng thăng cấp", +3000);
                            p.upluongMessage(3000);
                            p.c.checkLevel[2] = 1;
                            Service.chatNPC(p, (short) npcid, "Chúc mừng con đã đạt đến cấp độ mới!");
                        } else {
                            Service.chatNPC(p, (short) npcid, "Trình độ của con không đủ hoặc con đã nhận thưởng rồi!");
                        }

                        break;
                    case 3:
                        if (p.c.getBagNull() < 1) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        if (p.c.level >= 80 && p.c.checkLevel[3] == 0) {
                            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 4000), "Nhận thưởng thăng cấp", +4000);
                            p.upluongMessage(4000);
                            p.c.checkLevel[3] = 1;
                            Service.chatNPC(p, (short) npcid, "Chúc mừng con đã đạt đến cấp độ mới!");
                        } else {
                            Service.chatNPC(p, (short) npcid, "Trình độ của con không đủ hoặc con đã nhận thưởng rồi!");
                        }
                        break;
                    case 4:
                        if (p.c.getBagNull() < 1) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        if (p.c.level >= 100 && p.c.checkLevel[4] == 0) {
                            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 5000), "Nhận thưởng thăng cấp", +5000);
                            p.upluongMessage(5000);
                            p.c.checkLevel[4] = 1;
                            Service.chatNPC(p, (short) npcid, "Chúc mừng con đã đạt đến cấp độ mới!");
                        } else {
                            Service.chatNPC(p, (short) npcid, "Trình độ của con không đủ hoặc con đã nhận thưởng rồi!");
                        }
                        break;
                    case 5:
                        if (p.c.getBagNull() < 1) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        if (p.c.level >= 130 && p.c.checkLevel[5] == 0) {
                            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 6000), "Nhận thưởng thăng cấp", +6000);
                            p.upluongMessage(6000);
                            p.c.checkLevel[5] = 1;
                            Service.chatNPC(p, (short) npcid, "Chúc mừng con đã đạt đến cấp độ mới!");
                        } else {
                            Service.chatNPC(p, (short) npcid, "Trình độ của con không đủ hoặc con đã nhận thưởng rồi!");
                        }
                        break;
                    default: {
                        break;
                    }
                }
                break;
            case 3: // đổi coin
                switch (b3) {
                    case 0:
                        Service.sendInputDialog(p, (short) 9, "Nhập Số Lượng ( 1.000 Coin = 1000 Lượng)");
                        break;
                    case 1:
                        Service.sendInputDialog(p, (short) 10, "Nhập Số Lượng ( 1.000 Coin = 10.000.000 Xu)");
                        break;
                    case 2:
                        try {
                            synchronized (Server.LOCK_MYSQL) {
                                ResultSet red = SQLManager.stat.executeQuery("SELECT `coin` FROM `player` WHERE `id` = " + p.id + ";");
                                if (red != null && red.first()) {
                                    p.coin = red.getInt("coin");
                                    p.conn.sendMessageLog("Số Coin Hiện Có Của Bạn Là : " + p.coin);
                                    break;
                                }
                            }
                        } catch (SQLException var17) {
                            var17.printStackTrace();
                            p.conn.sendMessageLog("Lỗi.");
                        }
                        break;
                }
                break;
        }
    } // NPC 24

    public static void npcRikudou(Player p, byte npcid, byte menuId, byte b3) {
        MapTemplate map;
        MobTemplate mob;
        switch (menuId) {
            case 0: {
                Service.chatNPC(p, (short) npcid, "Hãy chăm chỉ lên nha.");
                break;
            }
            case 1: {
                switch (b3) {
                    case 0: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.level < 20) {
                            Service.chatNPC(p, (short) npcid, "Con cần đạt cấp độ 20 để có thể nhận nhiệm vụ hằng ngày.");
                            return;
                        }
                        if (p.c.isTaskHangNgay != 0) {
                            Service.chatNPC(p, (short) npcid, "Ta đã giao nhiệm vụ cho con trước đó rồi");
                            return;
                        }
                        if (p.c.countTaskHangNgay >= 20) {
                            Service.chatNPC(p, (short) npcid, "Con đã hoàn thành hết nhiệm vụ ngày hôm nay rồi, ngày mai hãy quay lại nha.");
                            return;
                        }
                        mob = Service.getMobIdByLevel(p.c.level);
                        if (mob != null) {
                            map = Service.getMobMapId(mob.id);
                            if (map != null) {
                                p.c.taskHangNgay[0] = 0;
                                p.c.taskHangNgay[1] = 0;
                                p.c.taskHangNgay[2] = Util.nextInt(100, 200);
                                p.c.taskHangNgay[3] = mob.id;
                                p.c.taskHangNgay[4] = map.id;
                                p.c.isTaskHangNgay = 1;
                                p.c.countTaskHangNgay++;
                                Service.getTaskOrder(p.c, (byte) 0);
                                Service.chatNPC(p, (short) npcid, "Đây là nhiệm vụ thứ " + p.c.countTaskHangNgay + "/20 trong ngày của con.");
                            }
                        }
                        break;
                    }
                    case 1: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.isTaskHangNgay == 0) {
                            Service.chatNPC(p, (short) npcid, "Con chưa nhận nhiệm vụ nào cả!");
                            return;
                        }
                        p.c.isTaskHangNgay = 0;
                        p.c.countTaskHangNgay--;
                        p.c.taskHangNgay = new int[]{-1, -1, -1, -1, -1, 0, p.c.countTaskHangNgay};
                        Service.clearTaskOrder(p.c, (byte) 0);
                        Service.chatNPC(p, (short) npcid, "Con đã huỷ nhiệm vụ lần này.");
                        break;
                    }
                    case 2: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.isTaskHangNgay == 0) {
                            Service.chatNPC(p, (short) npcid, "Con chưa nhận nhiệm vụ nào cả!");
                            return;
                        }
                        if (p.c.getBagNull() == 0) {
                            p.conn.sendMessageLog(Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        if (p.c.taskHangNgay[1] < p.c.taskHangNgay[2]) {
                            Service.chatNPC(p, (short) npcid, "Con chưa hoàn thành nhiệm vụ ta giao!");
                            return;
                        }
                        p.c.isTaskHangNgay = 0;
                        p.c.taskHangNgay = new int[]{-1, -1, -1, -1, -1, 0, p.c.countTaskHangNgay};
                        Service.clearTaskOrder(p.c, (byte) 0);
                        p.upluongMessage(Util.nextInt(10, 50));
                        if (!p.c.clan.clanName.isEmpty()) {
                            p.upExpClan(Util.nextInt(10, 50));
                        }
                        if ((p.c.taskId == 30 && p.c.taskIndex == 1) || (p.c.taskId == 39 && p.c.taskIndex == 3)) {
                            p.c.uptaskMaint();
                        }
                        if (p.c.pointUydanh < 5000) {
                            p.c.pointUydanh += 1;
                        }
                        Service.chatNPC(p, (short) npcid, "Con hãy nhận lấy phần thưởng của mình.");
                        break;
                    }
                    case 3: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.taskHangNgay[4] != -1) {
                            Map ma = Manager.getMapid(p.c.taskHangNgay[4]);
                            int var8;
                            TileMap area;
                            for (var8 = 0; var8 < ma.area.length; ++var8) {
                                area = ma.area[var8];
                                if (area.numplayers < ma.template.maxplayers) {
                                    p.c.tileMap.leave(p);
                                    area.EnterMap0(p.c);
                                    return;
                                }
                            }
                        }
                        Service.chatNPC(p, (short) npcid, "Con chưa nhận nhiệm vụ nào cả!");
                        break;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 2: {
                switch (b3) {
                    case 0: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }

                        if (p.c.level < 30) {
                            Service.chatNPC(p, (short) npcid, "Con cần đạt cấp độ 30 để có thể nhận nhiệm vụ tà thú.");
                            return;
                        }

                        if (p.c.isTaskTaThu != 0) {
                            Service.chatNPC(p, (short) npcid, "Ta đã giao nhiệm vụ cho con trước đó rồi");
                            return;
                        }

                        if (p.c.countTaskTaThu >= 2) {
                            Service.chatNPC(p, (short) npcid, "Con đã hoàn thành hết nhiệm vụ ngày hôm nay rồi, ngày mai hãy quay lại nha.");
                            return;
                        }
                        mob = Service.getMobIdTaThu(p.c.level);
                        if (mob != null) {
                            map = Service.getMobMapIdTaThu(mob.id);
                            if (map != null) {
                                p.c.taskTaThu[0] = 1;
                                p.c.taskTaThu[1] = 0;
                                p.c.taskTaThu[2] = 1;
                                p.c.taskTaThu[3] = mob.id;
                                p.c.taskTaThu[4] = map.id;
                                p.c.isTaskTaThu = 1;
                                ++p.c.countTaskTaThu;
                                Service.getTaskOrder(p.c, (byte) 1);
                                Service.chatNPC(p, (short) npcid, "Hãy hoàn thành nhiệm vụ và trở về đây nhận thưởng.");
                            }
                        }
                        break;
                    }
                    case 1: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }

                        if (p.c.isTaskTaThu == 0) {
                            Service.chatNPC(p, (short) npcid, "Con chưa nhận nhiệm vụ nào cả!");
                            return;
                        }

                        Service.clearTaskOrder(p.c, (byte) 1);
                        p.c.isTaskTaThu = 0;
                        --p.c.countTaskTaThu;
                        p.c.taskTaThu = new int[]{-1, -1, -1, -1, -1, 0, p.c.countTaskTaThu};
                        Service.chatNPC(p, (short) npcid, "Con đã huỷ nhiệm vụ lần này.");
                        break;
                    }

                    case 2: {
                        if (p.c.isNhanban) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                            return;
                        }

                        if (p.c.isTaskTaThu == 0) {
                            Service.chatNPC(p, (short) npcid, "Con chưa nhận nhiệm vụ nào cả!");
                            return;
                        }

                        if (p.c.taskTaThu[1] < p.c.taskTaThu[2]) {
                            Service.chatNPC(p, (short) npcid, "Con chưa hoàn thành nhiệm vụ ta giao!");
                            return;
                        }

                        if (p.c.getBagNull() < 2) {
                            Service.chatNPC(p, (short) npcid, "Hành trang của con không đủ chỗ trống để nhận thưởng");
                            return;
                        }

                        p.c.isTaskTaThu = 0;
                        p.c.taskTaThu = new int[]{-1, -1, -1, -1, -1, 0, p.c.countTaskTaThu};
                        Service.clearTaskOrder(p.c, (byte) 1);

                        if (p.c.pointUydanh < 5000) {
                            p.c.pointUydanh += 2;
                        }
                        if ((p.c.taskId == 30 && p.c.taskIndex == 2) || (p.c.taskId == 39 && p.c.taskIndex == 1)) {
                            p.c.uptaskMaint();
                        }
                        if (!p.c.clan.clanName.isEmpty()) {
                            p.upExpClan(50);
                        }
                        Service.addItemToBagNinja(p.c, ItemName.MANH_GIAY_VUN, true, false, Util.nextInt(1, 3), false, -1);
                        Service.chatNPC(p, (short) npcid, "Con hãy nhận lấy phần thưởng của mình.");
                        break;
                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            // Chiến Trường
            case 3: {
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                switch (b3) {
                    case 0: {
                        if (ChienTruong.chienTruong == null) {
                            Service.chatNPC(p, (short) npcid, "Chiến trường chưa được tổ chức.");
                            return;
                        }
                        if (ChienTruong.chienTruong != null) {
                            if (ChienTruong.chienTruong50 && (p.c.level < 30 || p.c.level > 50)) {
                                Service.chatNPC(p, (short) npcid, "Bây giờ là thời gian chiến trường cho cấp độ từ 30 đến 50. Trình độ của con không phù hợp để tham gia.");
                                return;
                            } else if (ChienTruong.chienTruong100 && p.c.level < 50) {
                                Service.chatNPC(p, (short) npcid, "Bây giờ là thời gian chiến trường cho cấp độ 100 trở lên. Trình độ của con không phù hợp để tham gia.");
                                return;
                            }
                            if ((ChienTruong.chienTruong50 || ChienTruong.chienTruong100) && p.c.pheCT == 1) {
                                Service.chatNPC(p, (short) npcid, "Con đã điểm danh phe Hắc giả trước đó rồi.");
                                return;
                            }
                            if (ChienTruong.start && p.c.pheCT == -1) {
                                Service.chatNPC(p, (short) npcid, "Chiến trường đã bắt đầu, không thể báo danh.");
                                return;
                            }
                            if ((ChienTruong.chienTruong50 || ChienTruong.chienTruong100) && p.c.pheCT == -1) {
                                p.c.pheCT = 0;
                                p.c.pointCT = 0;
                                p.c.isTakePoint = 0;
                                p.c.typepk = 4;
                                Service.ChangTypePkId(p.c, (byte) 4);
                                Service.updatePointCT(p.c, 0);
                                if (p.c.party != null) {
                                    p.c.party.removePlayer(p.c.id);
                                }
                                if (!ChienTruong.bxhCT.containsKey(p.c)) {
                                    ChienTruong.bxhCT.put(p.c, p.c.pointCT);
                                } else {
                                    ChienTruong.bxhCT.replace(p.c, p.c.pointCT);
                                }
                                Map ma = Manager.getMapid(ChienTruong.chienTruong.map[0].id);
                                for (TileMap area : ma.area) {
                                    if (area.numplayers < ma.template.maxplayers) {
                                        p.c.tileMap.leave(p);
                                        area.EnterMap0(p.c);
                                        return;
                                    }
                                }
                                return;
                            }
                            p.c.typepk = 4;
                            Service.ChangTypePkId(p.c, (byte) 4);
                            Service.updatePointCT(p.c, 0);
                            if (p.c.party != null) {
                                p.c.party.removePlayer(p.c.id);
                            }
                            if (!ChienTruong.bxhCT.containsKey(p.c)) {
                                ChienTruong.bxhCT.put(p.c, p.c.pointCT);
                            } else {
                                ChienTruong.bxhCT.replace(p.c, p.c.pointCT);
                            }
                            Map ma = Manager.getMapid(ChienTruong.chienTruong.map[0].id);
                            for (TileMap area : ma.area) {
                                if (area.numplayers < ma.template.maxplayers) {
                                    p.c.tileMap.leave(p);
                                    area.EnterMap0(p.c);
                                    return;
                                }
                            }
                        }
                        break;
                    }
                    case 1: {
                        if (ChienTruong.chienTruong == null) {
                            Service.chatNPC(p, (short) npcid, "Chiến trường chưa được tổ chức.");
                            return;
                        }
                        if (ChienTruong.chienTruong != null) {
                            if (ChienTruong.chienTruong50 && (p.c.level < 30 || p.c.level >= 50)) {
                                Service.chatNPC(p, (short) npcid, "Bây giờ là thời gian chiến trường cho cấp độ từ 30 đến 50. Trình độ của con không phù hợp để tham gia.");
                                return;
                            } else if (ChienTruong.chienTruong50 && p.c.level < 100) {
                                Service.chatNPC(p, (short) npcid, "Bây giờ là thời gian chiến trường cho cấp độ lớn hơn 100. Trình độ của con không phù hợp để tham gia.");
                                return;
                            }
                            if (ChienTruong.start && p.c.pheCT == -1) {
                                Service.chatNPC(p, (short) npcid, "Chiến trường đã bắt đầu, không thể báo danh.");
                                return;
                            }
                            if ((ChienTruong.chienTruong50 || ChienTruong.chienTruong100) && p.c.pheCT == 0) {
                                Service.chatNPC(p, (short) npcid, "Con đã điểm danh phe Bạch giả trước đó rồi.");
                                return;
                            }
                            if ((ChienTruong.chienTruong50 || ChienTruong.chienTruong100) && p.c.pheCT == -1) {
                                p.c.pheCT = 1;
                                p.c.pointCT = 0;
                                p.c.typepk = 5;
                                p.c.isTakePoint = 0;
                                Service.ChangTypePkId(p.c, (byte) 5);
                                Service.updatePointCT(p.c, 0);
                                if (p.c.party != null) {
                                    p.c.party.removePlayer(p.c.id);
                                }
                                if (!ChienTruong.bxhCT.containsKey(p.c)) {
                                    ChienTruong.bxhCT.put(p.c, p.c.pointCT);
                                } else {
                                    ChienTruong.bxhCT.replace(p.c, p.c.pointCT);
                                }
                                Map ma = Manager.getMapid(ChienTruong.chienTruong.map[6].id);
                                for (TileMap area : ma.area) {
                                    if (area.numplayers < ma.template.maxplayers) {
                                        p.c.tileMap.leave(p);
                                        area.EnterMap0(p.c);
                                        return;
                                    }
                                }
                                return;
                            }
                            p.c.typepk = 5;
                            Service.ChangTypePkId(p.c, (byte) 5);
                            Service.updatePointCT(p.c, 0);
                            if (p.c.party != null) {
                                p.c.party.removePlayer(p.c.id);
                            }
                            if (!ChienTruong.bxhCT.containsKey(p.c)) {
                                ChienTruong.bxhCT.put(p.c, p.c.pointCT);
                            } else {
                                ChienTruong.bxhCT.replace(p.c, p.c.pointCT);
                            }
                            Map ma = Manager.getMapid(ChienTruong.chienTruong.map[6].id);
                            for (TileMap area : ma.area) {
                                if (area.numplayers < ma.template.maxplayers) {
                                    p.c.tileMap.leave(p);
                                    area.EnterMap0(p.c);
                                    return;
                                }
                            }
                        }
                        break;
                    }
                    case 2: {
                        if (ChienTruong.finish) {
                            Service.evaluateCT(p.c);
                        } else {
                            Server.manager.sendTB(p, "Kết quả", "Chưa có thông tin.");
                        }
                        break;
                    }
                    case 3: {
                        Server.manager.sendTB(p, "Hướng dẫn", "Chiến trường được mở 2 lần mỗi ngày.\n"
                                + "- Chiến trường lv30 - 50: giành cho nhân vật level từ 30 đến 50, điểm danh vào lúc 19h và bắt đầu từ 19h30' đến 20h30'.\n"
                                + "- Chiến trường trên lv100: giành cho nhân vật level từ 100 trở lên, điểm danh vào lúc 20h30 và bắt đầu từ 21h00' đến 22h30'.\n\n");
                        break;
                    }
                }
                break;
            }

        }
    } // NPC 25

    public static void npcRikudou_ChienTruong(Player p, byte npcid, byte menuId, byte b3) throws IOException {
        switch (menuId) {
            case 0: {
                p.c.typepk = 0;
                Service.ChangTypePkId(p.c, (byte) 0);
                p.c.tileMap.leave(p);
                p.restCave();
                p.changeMap(p.c.mapLTD);
                break;
            }
            case 1: {
                Service.evaluateCT(p.c);
                break;
            }
            default: {
                Service.chatNPC(p, (short) npcid, "Chức năng này đang cập nhật!");
                break;
            }
        }
    }

    public static void npcGoosho(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0:
                p.requestItem(14);
                break;
            case 1:
                p.requestItem(15);
                break;
            case 2:
                p.requestItem(32);
                break;
            case 3:
                p.requestItem(34);
                break;

        }

    } // NPC 26

    public static void npcTruCoQuan(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0: {
                if (p.c.quantityItemyTotal(260) < 1) {
                    p.sendAddchatYellow("Không có chìa khoá để mở cửa này.");
                    return;
                }
                if (p.c.tileMap.map.lanhDiaGiaToc != null && p.c.tileMap.map.mapLDGT()) {
                    switch (p.c.tileMap.map.id) {
                        case 80: {

                            p.c.tileMap.map.lanhDiaGiaToc.openMap(1, p);
                            break;
                        }
                        case 81: {

                            p.c.tileMap.map.lanhDiaGiaToc.openMap(2, p);
                            break;
                        }
                        case 82: {

                            p.c.tileMap.map.lanhDiaGiaToc.openMap(3, p);
                            break;
                        }
                        case 83: {

                            p.c.tileMap.map.lanhDiaGiaToc.openMap(4, p);
                            break;
                        }
                        case 84: {

                            p.c.tileMap.map.lanhDiaGiaToc.openMap(5, p);
                            break;
                        }
                        case 85: {
                            p.c.tileMap.map.lanhDiaGiaToc.openMap(6, p);
                            break;
                        }
                        case 86: {
                            p.c.tileMap.map.lanhDiaGiaToc.openMap(7, p);
                            break;
                        }
                        case 87: {
                            p.c.tileMap.map.lanhDiaGiaToc.openMap(8, p);
                            Server.manager.sendTB(p, "Ghi chú", "Con đường này sẽ dẫn đến cánh cửa nơi ở của một nhân vật huyền bí đã bị lời nguyền cổ "
                                    + "xưa yểm bùa rằng sẽ không ai có thể đánh bại được nhân vật huyền bí này. Bạn hãy mau tìm cách hoá giải lời nguyền.");
                            break;
                        }
                        case 88: {
                            p.c.tileMap.map.lanhDiaGiaToc.openMap(9, p);
                            Server.manager.sendTB(p, "Ghi chú", "Con đường này sẽ dẫn đến cánh cửa nơi ở của một nhân vật huyền bí đã bị lời nguyền cổ "
                                    + "xưa yểm bùa rằng sẽ không ai có thể đánh bại được nhân vật huyền bí này. Bạn hãy mau tìm cách hoá giải lời nguyền.");
                            break;
                        }
                        case 89: {
                            p.c.tileMap.map.lanhDiaGiaToc.openMap(10, p);
                            Server.manager.sendTB(p, "Ghi chú", "Con đường này sẽ dẫn đến cánh cửa nơi ở của một nhân vật huyền bí đã bị lời nguyền cổ "
                                    + "xưa yểm bùa rằng sẽ không ai có thể đánh bại được nhân vật huyền bí này. Bạn hãy mau tìm cách hoá giải lời nguyền.");
                            break;
                        }
                        default: {
                            break;
                        }

                    }
                }
                break;
            }

        }
    } // NPC 27

    public static void npcShinwa(Player p, byte npcid, byte menuId, byte b3) throws IOException {
        switch (menuId) {
            case 0: {
                p.menuIdAuction = b3;
                final List<ShinwaTemplate> itemShinwas = ShinwaManager.entrys.get((int) b3);
                final Message mess = new Message(103);
                mess.writer().writeByte(b3);
                if (itemShinwas != null) {
                    mess.writer().writeInt(itemShinwas.size());
                    for (ShinwaTemplate item : itemShinwas) {
                        mess.writer().writeInt(item.getId());
                        mess.writer().writeInt(item.getRemainTime());
                        mess.writer().writeShort(item.getItem().quantity);
                        mess.writer().writeUTF(item.getSeller());
                        mess.writer().writeInt((int) item.getPrice());
                        mess.writer().writeShort(item.getItem().id);
                    }
                } else {
                    mess.writer().writeInt(0);
                }
                mess.writer().flush();
                p.conn.sendMessage(mess);
                mess.cleanup();
                break;
            }
            case 1: {
                p.menuIdAuction = -2;
                p.requestItem(36);
                break;
            }
            case 2: {
                try {
                    synchronized (ShinwaManager.entrys.get((int) -1)) {
                        List<ShinwaTemplate> itemShinwas = ShinwaManager.entrys.get((int) -1);
                        List<ShinwaTemplate> list = new ArrayList<>();
                        boolean flag = false;
                        for (ShinwaTemplate item : itemShinwas) {
                            if (item.getSeller().equals(p.c.name)) {
                                if (p.c.getBagNull() == 0) {
                                    flag = true;
                                    break;
                                }
                                p.c.addItemBag(true, item.getItem());
                                list.add(item);
                            }
                        }
                        if (flag) {
                            Service.chatNPC(p, (short) npcid, "Hành trang không đủ chỗ trống để nhận lại vật phẩm!");
                        } else if (list.isEmpty()) {
                            Service.chatNPC(p, (short) npcid, "Con không có đồ để nhận lại!");
                            return;
                        }
                        itemShinwas.removeAll(list);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    p.conn.sendMessageLog(e.getMessage());
                }
                break;
            }

        }
    }// NPC 28

    public static void npcChiHang(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            default: {
                Service.chatNPC(p, (short) npcid, "Chức năng này đang cập nhật!");
                break;
            }
        }
    }// NPC 29

    public static void npcRakkii(Player p, byte npcid, byte menuId, byte b3) throws IOException {
        switch (menuId) {
            case 0: {
                p.requestItem(38);
                break;
            }
            case 1: {
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                Service.sendInputDialog(p, (short) 4, "Nhập Gift Code tại đây");
                break;
            }
            case 2: {
                switch (b3) {
                    case 0:
                    case 1: {
                        Server.manager.rotationluck[0].luckMessage(p);
                        break;
                    }
                    case 2: {
                        Server.manager.sendTB(p, "Vòng Xoay Vip", "");
                        break;
                    }
                }
                break;
            }
            case 3: {
                switch (b3) {
                    case 0:
                    case 1: {
                        Server.manager.rotationluck[1].luckMessage(p);
                        break;
                    }
                    case 2: {
                        Server.manager.sendTB(p, "Vòng Xoay May Mắn Thường ", "");
                        break;
                    }
                }
                break;
            }
            case 4: {
                switch (b3) {
                    case 0:
                        Server.manager.TaiXiu[0].InfoTaiXiu(p);
                        break;
                    case 1:
                        Service.sendInputDialog(p, (short) 555, "Nhập số tiền cược");
                        break;
                    case 2:
                        Service.sendInputDialog(p, (short) 556, "Nhập số tiền cược");
                        break;
                    case 3:
                        try {
                            String a = "";
                            int size = SoiCau.soicau.size();
                            int index = size - 1;
                            if (size > 50) {
                                size = 50;
                            }
                            for (int i = 0; i < size; i++) {
                                SoiCau check = SoiCau.soicau.get(index--);
                                a = a + check.ketqua + " - " + check.soramdom + ".\n";
                            }
                            Server.manager.sendTB(p, "Soi Cầu", a);
                        } catch (Exception e) {
                        }
                        break;
                    case 4:
                        Server.manager.sendTB(p, "Hướng dẫn",
                                "Số xu đặt cược phải là số chia hết cho 10.\n"
                                + "Khi đã đặt cược không được thoát game, nếu thoát game sẽ bị mất số tiền cược và admin sẽ không giải quyết.\n"
                                + "Mỗi phiên cược sẽ là 1 phút, khi thời gian còn 10s sẽ không thể đặt cược.\n"
                                + "Khi đã đặt tài thì không thể đặt xỉu và ngược lại.\n"
                                + "Có thể đặt nhiều lần trong 1 phiên.");
                        break;
                }
                break;
            }
            case 5: {

                break;
            }
        }

    }// NPC 30

    public static void npcLongDen(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            default: {
                Service.chatNPC(p, (short) npcid, "Chức năng này đang cập nhật!");
                break;
            }
        }
    } // NPC 31

    public static void npcKagai(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 1: {
                switch (b3) {
                    case 0: {
                        if (p.c.isNhanban) {
                            p.conn.sendMessageLog(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.clan.clanName.isEmpty()) {
                            Service.chatNPC(p, (short) npcid, "Con chưa có Gia tộc.");
                            return;
                        }
                        if (p.c.clan != null && p.c.clan.typeclan != 4) {
                            Service.chatNPC(p, (short) npcid, "Con không phải tộc trưởng, không thể mời gia tộc chiến.");
                            return;
                        }
                        Service.sendInputDialog(p, (short) 5, "Nhập tên gia tộc đối phương");
                        break;
                    }
                    case 1: {
                        ClanManager clan = ClanManager.getClanName(p.c.clan.clanName);

                        if (p.c.isNhanban) {
                            p.conn.sendMessageLog(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.clan.clanName.isEmpty()) {
                            Service.chatNPC(p, (short) npcid, "Con chưa có Gia tộc.");
                            return;
                        }
                        if (clan.gtcID == -1 || clan.typepkclan == 0) {
                            Service.chatNPC(p, (short) npcid, "Chưa diễn ra Gia Tộc Chiến.");
                            return;
                        }
                        if (GiaTocChien.gtcs.containsKey(clan.gtcID)) {
                            GiaTocChien giaTocChien = GiaTocChien.gtcs.get(clan.gtcID);
                            if (giaTocChien != null && giaTocChien.map[1] != null && giaTocChien.map[2] != null) {
                                p.c.typepk = (byte) ClanManager.getClanName(p.c.clan.clanName).typepkclan;
                                Service.ChangTypePkId(p.c, (byte) ClanManager.getClanName(p.c.clan.clanName).typepkclan);
                                Service.sendPointGTC(p.c, 0);
                                if (p.c.party != null) {
                                    p.c.party.removePlayer(p.c.id);
                                }
                                p.c.tileMap.leave(p);
                                giaTocChien.map[p.c.typepk - 3].area[0].EnterMap0(p.c);
                                return;
                            }
                        }

                    }
                    default: {
                        break;
                    }
                }
                break;
            }
            case 3: { // Thuc Tinh
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    break;
                }
                switch (b3) {
                    case 0: {
                        int i;
                        Item Non = p.c.ItemBody[0];
                        if (Non == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy Mặc Nón Lên Người Mới Có Thể Thức Tỉnh ");
                            return;
                        }
                        if (Non.upgrade < 16) {
                            Service.chatNPC(p, (short) npcid, "Nón +16 Mới Có Thể Thức Tỉnh");
                            return;
                        }
                        for (i = 0; i < Non.options.size(); ++i) {
                            if (Non.options.get(i).id == 85 && Non.options.get(i).param == 9) {
                                for (i = 0; i < Non.options.size(); ++i) {
                                    if (Non.options.get(i).id == 58) {
                                        Service.chatNPC(p, (short) npcid, "Nón Đã Được Thức Tỉnh.");
                                        return;
                                    }
                                }
                                if (p.c.quantityItemyTotal(893) < 50) {
                                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ Đá Thức Tỉnh Để Thức Tỉnh");
                                    return;
                                }
                                if (p.c.xu < 10000000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000.000 Xu");
                                    return;
                                }
                                if (p.luong < 10000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000 Lượng");
                                    return;
                                }
                                if (Util.nextInt(100) < 5) {
                                    Non.options.add(new Option(58, Util.nextInt(5, 10)));
                                    Non.options.add(new Option(94, Util.nextInt(1, 10)));
                                    Non.options.add(new Option(82, Util.nextInt(100, 1000)));
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thành Công");
                                    Manager.serverChat("Kagai", " Chúc Mừng " + p.c.name + " Đã Thức Tỉnh Nón Thành Công");
                                    p.c.removeItemBody((byte) 0);
                                    p.c.addItemBag(true, Non);
                                } else {
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thất Bại");
                                }
                                p.c.removeItemBags(893, 50);
                                p.c.upxuMessage(-10000000);
                                p.upluongMessage(-10000);
                            } else {
                                Service.chatNPC(p, (short) npcid, "Nón Phải Đạt Tinh Luyện 9 Mới Có Thể Thức Tỉnh");
                            }
                        }
                        break;
                    }
                    case 1: {
                        int i;
                        Item VuKhi = p.c.ItemBody[1];
                        if (VuKhi == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy Mặc Vũ Khí Lên Người Mới Có Thể Thức Tỉnh ");
                            return;
                        }
                        if (VuKhi.upgrade < 16) {
                            Service.chatNPC(p, (short) npcid, "Vũ Khí +16 Mới Có Thể Thức Tỉnh");
                            return;
                        }
                        for (i = 0; i < VuKhi.options.size(); ++i) {
                            if (VuKhi.options.get(i).id == 85 && VuKhi.options.get(i).param == 9) {
                                for (i = 0; i < VuKhi.options.size(); ++i) {
                                    if (VuKhi.options.get(i).id == 58) {
                                        Service.chatNPC(p, (short) npcid, "Vũ Khí Đã Được Thức Tỉnh.");
                                        return;
                                    }
                                }
                                if (p.c.quantityItemyTotal(893) < 50) {
                                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ Đá Thức Tỉnh Để Thức Tỉnh");
                                    return;
                                }
                                if (p.c.xu < 10000000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000.000 Xu");
                                    return;
                                }
                                if (p.luong < 10000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000 Lượng");
                                    return;
                                }
                                if (Util.nextInt(100) < 5) {
                                    VuKhi.options.add(new Option(58, Util.nextInt(5, 10)));
                                    VuKhi.options.add(new Option(94, Util.nextInt(1, 10)));
                                    VuKhi.options.add(new Option(82, Util.nextInt(100, 1000)));
                                    VuKhi.options.add(new Option(67, Util.nextInt(10, 100)));
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thành Công");
                                    Manager.serverChat("Kagai", " Chúc Mừng " + p.c.name + " Đã Thức Tỉnh Vũ Khí Thành Công");
                                    p.c.removeItemBody((byte) 1);
                                    p.c.addItemBag(true, VuKhi);
                                } else {
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thất Bại");
                                }
                                p.c.removeItemBags(893, 50);
                                p.c.upxuMessage(-10000000);
                                p.upluongMessage(-10000);
                            } else {
                                Service.chatNPC(p, (short) npcid, "Vũ Khí Phải Đạt Tinh Luyện 9 Mới Có Thể Thức Tỉnh");
                            }
                        }
                        break;
                    }
                    case 2: {
                        int i;
                        Item Ao = p.c.ItemBody[2];
                        if (Ao == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy Mặc Áo Lên Người Mới Có Thể Thức Tỉnh ");
                            return;
                        }
                        if (Ao.upgrade < 16) {
                            Service.chatNPC(p, (short) npcid, "Áo +16 Mới Có Thể Thức Tỉnh");
                            return;
                        }
                        for (i = 0; i < Ao.options.size(); ++i) {
                            if (Ao.options.get(i).id == 85 && Ao.options.get(i).param == 9) {
                                for (i = 0; i < Ao.options.size(); ++i) {
                                    if (Ao.options.get(i).id == 58) {
                                        Service.chatNPC(p, (short) npcid, "Áo Đã Được Thức Tỉnh.");
                                        return;
                                    }
                                }
                                if (p.c.quantityItemyTotal(893) < 50) {
                                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ Đá Thức Tỉnh Để Thức Tỉnh");
                                    return;
                                }
                                if (p.c.xu < 10000000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000.000 Xu");
                                    return;
                                }
                                if (p.luong < 10000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000 Lượng");
                                    return;
                                }
                                if (Util.nextInt(100) < 5) {
                                    Ao.options.add(new Option(58, Util.nextInt(5, 10)));
                                    Ao.options.add(new Option(94, Util.nextInt(1, 10)));
                                    Ao.options.add(new Option(82, Util.nextInt(100, 1000)));
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thành Công");
                                    Manager.serverChat("Kagai", " Chúc Mừng " + p.c.name + " Đã Thức Tỉnh Áo Thành Công");
                                    p.c.removeItemBody((byte) 2);
                                    p.c.addItemBag(true, Ao);
                                } else {
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thất Bại");
                                }
                                p.c.removeItemBags(893, 50);
                                p.c.upxuMessage(-10000000);
                                p.upluongMessage(-10000);
                            } else {
                                Service.chatNPC(p, (short) npcid, "Món Phải Đạt Tinh Luyện 9 Mới Có Thể Thức Tỉnh");
                            }
                        }
                        break;
                    }
                    case 3: {
                        int i;
                        Item Lien = p.c.ItemBody[3];
                        if (Lien == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy Mặc Liên Lên Người Mới Có Thể Thức Tỉnh ");
                            return;
                        }
                        if (Lien.upgrade < 16) {
                            Service.chatNPC(p, (short) npcid, "Liên +16 Mới Có Thể Thức Tỉnh");
                            return;
                        }
                        for (i = 0; i < Lien.options.size(); ++i) {
                            if (Lien.options.get(i).id == 85 && Lien.options.get(i).param == 9) {
                                for (i = 0; i < Lien.options.size(); ++i) {
                                    if (Lien.options.get(i).id == 58) {
                                        Service.chatNPC(p, (short) npcid, "Liên Đã Được Thức Tỉnh.");
                                        return;
                                    }
                                }
                                if (p.c.quantityItemyTotal(893) < 50) {
                                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ Đá Thức Tỉnh Để Thức Tỉnh");
                                    return;
                                }
                                if (p.c.xu < 10000000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000.000 Xu");
                                    return;
                                }
                                if (p.luong < 10000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000 Lượng");
                                    return;
                                }
                                if (Util.nextInt(100) < 5) {
                                    Lien.options.add(new Option(58, Util.nextInt(5, 10)));
                                    Lien.options.add(new Option(94, Util.nextInt(1, 10)));
                                    Lien.options.add(new Option(82, Util.nextInt(100, 1000)));
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thành Công");
                                    Manager.serverChat("Kagai", " Chúc Mừng " + p.c.name + " Đã Thức Tỉnh Liên Thành Công");
                                    p.c.removeItemBody((byte) 3);
                                    p.c.addItemBag(true, Lien);
                                } else {
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thất Bại");
                                }
                                p.c.removeItemBags(893, 50);
                                p.c.upxuMessage(-10000000);
                                p.upluongMessage(-10000);
                            } else {
                                Service.chatNPC(p, (short) npcid, "Liên Phải Đạt Tinh Luyện 9 Mới Có Thể Thức Tỉnh");
                            }
                        }
                        break;
                    }
                    case 4: {
                        int i;
                        Item Gang = p.c.ItemBody[4];
                        if (Gang == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy Mặc Găng Lên Người Mới Có Thể Thức Tỉnh ");
                            return;
                        }
                        if (Gang.upgrade < 16) {
                            Service.chatNPC(p, (short) npcid, "Găng +16 Mới Có Thể Thức Tỉnh");
                            return;
                        }
                        for (i = 0; i < Gang.options.size(); ++i) {
                            if (Gang.options.get(i).id == 85 && Gang.options.get(i).param == 9) {
                                for (i = 0; i < Gang.options.size(); ++i) {
                                    if (Gang.options.get(i).id == 58) {
                                        Service.chatNPC(p, (short) npcid, "Găng Đã Được Thức Tỉnh.");
                                        return;
                                    }
                                }
                                if (p.c.quantityItemyTotal(893) < 50) {
                                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ Đá Thức Tỉnh Để Thức Tỉnh");
                                    return;
                                }
                                if (p.c.xu < 10000000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000.000 Xu");
                                    return;
                                }
                                if (p.luong < 10000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000 Lượng");
                                    return;
                                }
                                if (Util.nextInt(100) < 5) {
                                    Gang.options.add(new Option(58, Util.nextInt(5, 10)));
                                    Gang.options.add(new Option(94, Util.nextInt(1, 10)));
                                    Gang.options.add(new Option(82, Util.nextInt(100, 1000)));
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thành Công");
                                    Manager.serverChat("Kagai", " Chúc Mừng " + p.c.name + " Đã Thức Tỉnh Găng Thành Công");
                                    p.c.removeItemBody((byte) 4);
                                    p.c.addItemBag(true, Gang);
                                } else {
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thất Bại");
                                }
                                p.c.removeItemBags(893, 50);
                                p.c.upxuMessage(-10000000);
                                p.upluongMessage(-10000);
                            } else {
                                Service.chatNPC(p, (short) npcid, "Găng Phải Đạt Tinh Luyện 9 Mới Có Thể Thức Tỉnh");
                            }
                        }
                        break;
                    }
                    case 5: {
                        int i;
                        Item Nhan = p.c.ItemBody[5];
                        if (Nhan == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy Mặc Nhẫn Lên Người Mới Có Thể Thức Tỉnh ");
                            return;
                        }
                        if (Nhan.upgrade < 16) {
                            Service.chatNPC(p, (short) npcid, "Nhẫn +16 Mới Có Thể Thức Tỉnh");
                            return;
                        }
                        for (i = 0; i < Nhan.options.size(); ++i) {
                            if (Nhan.options.get(i).id == 85 && Nhan.options.get(i).param == 9) {
                                for (i = 0; i < Nhan.options.size(); ++i) {
                                    if (Nhan.options.get(i).id == 58) {
                                        Service.chatNPC(p, (short) npcid, "Nhẫn Đã Được Thức Tỉnh.");
                                        return;
                                    }
                                }
                                if (p.c.quantityItemyTotal(893) < 50) {
                                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ Đá Thức Tỉnh Để Thức Tỉnh");
                                    return;
                                }
                                if (p.c.xu < 10000000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000.000 Xu");
                                    return;
                                }
                                if (p.luong < 10000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000 Lượng");
                                    return;
                                }
                                if (Util.nextInt(100) < 5) {
                                    Nhan.options.add(new Option(58, Util.nextInt(5, 10)));
                                    Nhan.options.add(new Option(94, Util.nextInt(1, 10)));
                                    Nhan.options.add(new Option(82, Util.nextInt(100, 1000)));
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thành Công");
                                    Manager.serverChat("Kagai", " Chúc Mừng " + p.c.name + " Đã Thức Tỉnh Nhẫn Thành Công");
                                    p.c.removeItemBody((byte) 5);
                                    p.c.addItemBag(true, Nhan);
                                } else {
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thất Bại");
                                }
                                p.c.removeItemBags(893, 50);
                                p.c.upxuMessage(-10000000);
                                p.upluongMessage(-10000);
                            } else {
                                Service.chatNPC(p, (short) npcid, "Nhẫn Phải Đạt Tinh Luyện 9 Mới Có Thể Thức Tỉnh");
                            }
                        }
                        break;
                    }
                    case 6: {
                        int i;
                        Item Quan = p.c.ItemBody[6];
                        if (Quan == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy Mặc Quần Lên Người Mới Có Thể Thức Tỉnh ");
                            return;
                        }
                        if (Quan.upgrade < 16) {
                            Service.chatNPC(p, (short) npcid, "Quần +16 Mới Có Thể Thức Tỉnh");
                            return;
                        }
                        for (i = 0; i < Quan.options.size(); ++i) {
                            if (Quan.options.get(i).id == 85 && Quan.options.get(i).param == 9) {
                                for (i = 0; i < Quan.options.size(); ++i) {
                                    if (Quan.options.get(i).id == 58) {
                                        Service.chatNPC(p, (short) npcid, "Quần Đã Được Thức Tỉnh.");
                                        return;
                                    }
                                }
                                if (p.c.quantityItemyTotal(893) < 50) {
                                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ Đá Thức Tỉnh Để Thức Tỉnh");
                                    return;
                                }
                                if (p.c.xu < 10000000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000.000 Xu");
                                    return;
                                }
                                if (p.luong < 10000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000 Lượng");
                                    return;
                                }
                                if (Util.nextInt(100) < 5) {
                                    Quan.options.add(new Option(58, Util.nextInt(5, 10)));
                                    Quan.options.add(new Option(94, Util.nextInt(1, 10)));
                                    Quan.options.add(new Option(82, Util.nextInt(100, 1000)));
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thành Công");
                                    Manager.serverChat("Kagai", " Chúc Mừng " + p.c.name + " Đã Thức Tỉnh Quần Thành Công");
                                    p.c.removeItemBody((byte) 6);
                                    p.c.addItemBag(true, Quan);
                                } else {
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thất Bại");
                                }
                                p.c.removeItemBags(893, 50);
                                p.c.upxuMessage(-10000000);
                                p.upluongMessage(-10000);
                            } else {
                                Service.chatNPC(p, (short) npcid, "Quần Phải Đạt Tinh Luyện 9 Mới Có Thể Thức Tỉnh");
                            }
                        }
                        break;
                    }
                    case 7: {
                        int i;
                        Item Boi = p.c.ItemBody[7];
                        if (Boi == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy Mặc Bội Lên Người Mới Có Thể Thức Tỉnh ");
                            return;
                        }
                        if (Boi.upgrade < 16) {
                            Service.chatNPC(p, (short) npcid, "Bội +16 Mới Có Thể Thức Tỉnh");
                            return;
                        }
                        for (i = 0; i < Boi.options.size(); ++i) {
                            if (Boi.options.get(i).id == 85 && Boi.options.get(i).param == 9) {
                                for (i = 0; i < Boi.options.size(); ++i) {
                                    if (Boi.options.get(i).id == 58) {
                                        Service.chatNPC(p, (short) npcid, "Bội Đã Được Thức Tỉnh.");
                                        return;
                                    }
                                }
                                if (p.c.quantityItemyTotal(893) < 50) {
                                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ Đá Thức Tỉnh Để Thức Tỉnh");
                                    return;
                                }
                                if (p.c.xu < 10000000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000.000 Xu");
                                    return;
                                }
                                if (p.luong < 10000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000 Lượng");
                                    return;
                                }
                                if (Util.nextInt(100) < 5) {
                                    Boi.options.add(new Option(58, Util.nextInt(5, 10)));
                                    Boi.options.add(new Option(94, Util.nextInt(1, 10)));
                                    Boi.options.add(new Option(82, Util.nextInt(100, 1000)));
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thành Công");
                                    Manager.serverChat("Kagai", " Chúc Mừng " + p.c.name + " Đã Thức Tỉnh Bội Thành Công");
                                    p.c.removeItemBody((byte) 7);
                                    p.c.addItemBag(true, Boi);
                                } else {
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thất Bại");
                                }
                                p.c.removeItemBags(893, 50);
                                p.c.upxuMessage(-10000000);
                                p.upluongMessage(-10000);
                            } else {
                                Service.chatNPC(p, (short) npcid, "Bội Phải Đạt Tinh Luyện 9 Mới Có Thể Thức Tỉnh");
                            }
                        }
                        break;
                    }
                    case 8: {
                        int i;
                        Item Giay = p.c.ItemBody[8];
                        if (Giay == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy Mặc Giày Lên Người Mới Có Thể Thức Tỉnh ");
                            return;
                        }
                        if (Giay.upgrade < 16) {
                            Service.chatNPC(p, (short) npcid, "Giày +16 Mới Có Thể Thức Tỉnh");
                            return;
                        }
                        for (i = 0; i < Giay.options.size(); ++i) {
                            if (Giay.options.get(i).id == 85 && Giay.options.get(i).param == 9) {
                                for (i = 0; i < Giay.options.size(); ++i) {
                                    if (Giay.options.get(i).id == 58) {
                                        Service.chatNPC(p, (short) npcid, "Giày Đã Được Thức Tỉnh.");
                                        return;
                                    }
                                }
                                if (p.c.quantityItemyTotal(893) < 50) {
                                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ Đá Thức Tỉnh Để Thức Tỉnh");
                                    return;
                                }
                                if (p.c.xu < 10000000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000.000 Xu");
                                    return;
                                }
                                if (p.luong < 10000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000 Lượng");
                                    return;
                                }
                                if (Util.nextInt(100) < 5) {
                                    Giay.options.add(new Option(58, Util.nextInt(5, 10)));
                                    Giay.options.add(new Option(94, Util.nextInt(1, 10)));
                                    Giay.options.add(new Option(82, Util.nextInt(100, 1000)));
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thành Công");
                                    Manager.serverChat("Kagai", " Chúc Mừng " + p.c.name + " Đã Thức Tỉnh Giày Thành Công");
                                    p.c.removeItemBody((byte) 8);
                                    p.c.addItemBag(true, Giay);
                                } else {
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thất Bại");
                                }
                                p.c.removeItemBags(893, 50);
                                p.c.upxuMessage(-10000000);
                                p.upluongMessage(-10000);
                            } else {
                                Service.chatNPC(p, (short) npcid, "Giày Phải Đạt Tinh Luyện 9 Mới Có Thể Thức Tỉnh");
                            }
                        }
                        break;
                    }
                    case 9: {
                        int i;
                        Item Phu = p.c.ItemBody[9];
                        if (Phu == null) {
                            Service.chatNPC(p, (short) npcid, "Hãy Mặc Phù Lên Người Mới Có Thể Thức Tỉnh ");
                            return;
                        }
                        if (Phu.upgrade < 16) {
                            Service.chatNPC(p, (short) npcid, "Phù +16 Mới Có Thể Thức Tỉnh");
                            return;
                        }
                        for (i = 0; i < Phu.options.size(); ++i) {
                            if (Phu.options.get(i).id == 85 && Phu.options.get(i).param == 9) {
                                for (i = 0; i < Phu.options.size(); ++i) {
                                    if (Phu.options.get(i).id == 58) {
                                        Service.chatNPC(p, (short) npcid, "Phù Đã Được Thức Tỉnh.");
                                        return;
                                    }
                                }
                                if (p.c.quantityItemyTotal(893) < 50) {
                                    Service.chatNPC(p, (short) npcid, "Bạn Không Đủ Đá Thức Tỉnh Để Thức Tỉnh");
                                    return;
                                }
                                if (p.c.xu < 10000000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000.000 Xu");
                                    return;
                                }
                                if (p.luong < 10000) {
                                    Service.chatNPC(p, (short) npcid, "Cần 10.000 Lượng");
                                    return;
                                }
                                if (Util.nextInt(100) < 5) {
                                    Phu.options.add(new Option(58, Util.nextInt(5, 10)));
                                    Phu.options.add(new Option(94, Util.nextInt(1, 10)));
                                    Phu.options.add(new Option(82, Util.nextInt(100, 1000)));
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thành Công");
                                    Manager.serverChat("Kagai", " Chúc Mừng " + p.c.name + " Đã Thức Tỉnh Phù Thành Công");
                                    p.c.removeItemBody((byte) 9);
                                    p.c.addItemBag(true, Phu);
                                } else {
                                    Service.chatNPC(p, (short) npcid, "Thức Tỉnh Thất Bại");
                                }
                                p.c.removeItemBags(893, 50);
                                p.c.upxuMessage(-10000000);
                                p.upluongMessage(-10000);
                            } else {
                                Service.chatNPC(p, (short) npcid, "Phù Phải Đạt Tinh Luyện 9 Mới Có Thể Thức Tỉnh");
                            }
                        }
                        break;
                    }
                    case 10:
                        Server.manager.sendTB(p, "Hướng Dẫn",
                                "Thức Tỉnh Cần : 50 Đá Thức Tỉnh + 10.000.000 Xu + 10.000 Lượng \n"
                                + "Tỉ Lệ Thành Công : 7% \n"
                                + "Thức Tỉnh Thành Công Sẽ Được Công Thêm Chỉ Số Cho Trang Bị Đó"
                        );
                        break;
                }
                break;
            }
            case 4: {
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    break;
                } else {
                    switch (b3) {
                        case 0: {
                            p.requestItem(43);
                            break;
                        }
                        case 1: {
                            p.requestItem(44);
                            break;
                        }
                        case 2: {
                            p.requestItem(45);
                            break;
                        }
                        case 3: {
                            Server.manager.sendTB(p, "Hướng dẫn", " Đang Cập Nhật");
                            break;
                        }

                    }
                }
                break;
            }

            case 0:
            case 2:
            default: {
                Service.chatNPC(p, (short) npcid, "Chức năng này đang cập nhật!");
                break;
            }
        }
    }// NPC 32

    public static void npcKanata_LoiDai(Player p, byte npcid, byte menuId, byte b3) {
        switch (menuId) {
            case 0:
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                if (p.c.party != null && p.c.party.charID != p.c.id) {
                    p.c.party.removePlayer(p.c.id);
                }
                p.c.dunId = -1;
                p.c.isInDun = false;
                p.c.tileMap.leave(p);
                p.restCave();
                p.changeMap(p.c.mapKanata);
                break;
            case 1:
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                if (p.c.party != null && p.c.party.charID != p.c.id) {
                    Service.chatNPC(p, (short) npcid, "Con không phải nhóm trưởng, không thể đặt cược");
                    return;
                }

                Service.sendInputDialog(p, (short) 3, "Đặt tiền cược (lớn hơn 1000 xu và chia hết cho 50)");
                break;
            case 2:
                Server.manager.sendTB(p, "Hướng dẫn", "- Mời đối thủ vào lôi đài\n\n- Đặt tiền cược (Lớn hơn 1000 xu và chia hết cho 50)\n\n- Khi cả 2 đã đặt tiền cược, và số tiền phải thống nhất bằng nhau thì trận so tài mới có thể bắt đầu.\n\n- Khi đã đặt tiền cược, nhưng thoát, mất kết nối hoặc thua cuộc, thì người chơi còn lại sẽ giành chiến thắng\n\n- Số tiền thắng sẽ nhận được sẽ bị trừ phí 5%\n\n- Nếu hết thời gian mà chưa có ai giành chiến thắng thì cuộc so tài sẽ tính hoà, và mỗi người sẽ nhận lại số tiền của mình với mức phí bị trừ 1%");
                break;

        }
    }

    public static void npcAdmin(Player p, byte npcid, byte menuId, byte b3) {
        if (p.c.isNhanban) {
            Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
            return;
        }
        switch (menuId) {
            case 0: {
                if (p.c.quatanthu == 0) {
                    LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 50000), "Nhận quà tân thủ", +50000);
                    LichSu.LichSuXu(p.c.name, p.c.xu, (p.c.xu + 1000000), "Nhận quà tân thủ", +1000000);
                    p.upluongMessage(50000);
                    p.c.upyenMessage(1000000000);
                    p.c.upxuMessage(1000000);
                    Service.addItemToBagNinja(p.c, ItemName.NGOC_1_SAO, true, true, 1, false, -1);
                    Service.addItemToBagNinja(p.c, ItemName.NGOC_2_SAO, true, true, 1, false, -1);
                    Service.addItemToBagNinja(p.c, ItemName.NGOC_3_SAO, true, true, 1, false, -1);
                    Service.addItemToBagNinja(p.c, ItemName.NGOC_4_SAO, true, true, 1, false, -1);
                    Service.addItemToBagNinja(p.c, ItemName.NGOC_5_SAO, true, true, 1, false, -1);
                    Service.addItemToBagNinja(p.c, ItemName.NGOC_6_SAO, true, true, 1, false, -1);
                    Service.addItemToBagNinja(p.c, ItemName.NGOC_7_SAO, true, true, 1, false, -1);
                    Service.addItemToBagNinja(p.c, ItemName.BAT_BAO, true, true, 1, false, -1);
                    Service.addItemToBagNinja(p.c, ItemName.RUONG_BACH_NGAN, true, true, 1, false, -1);
                    Service.addItemToBagNinja(p.c, ItemName.RUONG_HUYEN_BI, true, true, 1, false, -1);
                    Item KiemGo = ItemTemplate.itemDefault(ItemName.KIEM_GO);
                    KiemGo.isLock = true;
                    KiemGo.options.add(new Option(0, Util.nextInt(5, 10)));
                    KiemGo.options.add(new Option(1, Util.nextInt(5, 10)));
                    p.c.addItemBag(false, KiemGo);
                    p.c.quatanthu = 1;
                    Service.chatNPC(p, (short) npcid, "Nhận Quà Thành Công . Chúc Bạn Chơi Game Vui Vẽ");
                } else {
                    Service.chatNPC(p, (short) npcid, "Mỗi Tài Khoản Chỉ Nhận 1 Lần!");
                }
                break;
            }
            case 1: {
                if (p.c.isDiemDanh == 0) {
                    LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 500), "Điểm danh hằng ngày", +500);
                    p.upluongMessage(500);
                    p.c.isDiemDanh = 1;
                    Service.chatNPC(p, (short) npcid, "Điểm danh thành công");
                } else {
                    Service.chatNPC(p, (short) npcid, "Hôm nay con đã điểm danh rồi, hãy quay lại vào ngày hôm sau nha!");
                }
                break;
            }
            case 2: {
                if (p.c.level == 1) {
                    p.conn.sendMessageLog("Nhân vật level 1 không thể bật tắt EXP..");
                    return;
                }
                if (p.c.get().exptype == 1) {
                    p.c.get().exptype = 0;
                    p.conn.sendMessageLog("Đã Tắt Nhận EXP . Khi Đánh Quái Bạn Sẽ Không Nhận Được Kinh Nghiệm.");
                } else {
                    p.c.get().exptype = 1;
                    p.conn.sendMessageLog("Đã Bật Nhận EXP.");
                }
                break;
            }
//            case 3:
//                Server.manager.sendTB(p, "Bảng Giá Item Xu Lượng",
//                        "- MUA TRANG BỊ , VIP , XEM CHỈ SỐ TRANG BỊ , XU LƯỢNG INBOX ZALO ADMIN : 0814015494 .\n"
//                );
//                break;
//            case 4: {
//                Item Item = p.c.ItemBody[14];
//                if (Item == null) {
//                    p.conn.sendMessageLog("Bạn Phải Đeo Mắt Cần Xóa Mới Có Thể Xóa Mắt");
//                    return;
//                }
//                p.c.removeItemBody((byte) 14);
//                p.conn.sendMessageLog("Xóa Mắt Thành Công");
//                break;
//            }
        }
    }

    public static void npcKagai_GTC(Player p, byte npcid, byte menuId, byte b3) {
        switch (p.c.mapid) {
            case 117: {
                switch (menuId) {
                    case 0: {
                        p.c.typepk = 0;
                        Service.ChangTypePkId(p.c, (byte) 0);
                        p.c.tileMap.leave(p);
                        p.restCave();
                        p.changeMap(p.c.mapLTD);
                        break;
                    }
                    case 1: {
                        Service.chatNPC(p, (short) npcid, "Đặt cược");
                        Service.sendInputDialog(p, (short) 8, "Đặt tiền cược (Bội số của 1000)");
                        break;
                    }

                }
                break;
            }
            case 118:
            case 119: {
                switch (menuId) {
                    case 0: {
                        p.c.typepk = 0;
                        Service.ChangTypePkId(p.c, (byte) 0);
                        p.c.tileMap.leave(p);
                        p.restCave();
                        p.changeMap(p.c.mapLTD);
                        break;
                    }
                    case 1: {
                        Server.manager.sendTB(p, "Kết quả", "- Gia tộc " + p.c.tileMap.map.giaTocChien.clan1.name + " giành được " + p.c.tileMap.map.giaTocChien.pointClan1 + " điểm.\n"
                                + "- Gia tộc " + p.c.tileMap.map.giaTocChien.clan2.name + " giành được " + p.c.tileMap.map.giaTocChien.pointClan2 + " điểm.\n"
                                + "Điểm của bạn " + p.c.pointGTC);
                        break;
                    }
                }
                break;
            }
        }
    }
}
