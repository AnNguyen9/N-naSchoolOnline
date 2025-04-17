package server;

import Event.EventName;
import Upgrade.AnToc;
import Menu.CayThong;
import Menu.MenuAdmin;
import Event.MenuEvent;
import Menu.MenuHandle;
import Menu.NpcMenu;
import Menu.Vip;
import Task.Task;
import Task.Text;
import Upgrade.BiKip;
import Upgrade.Boru;
import Upgrade.Yoroi;
import assembly.Admission;
import assembly.Map;
import assembly.Char;
import assembly.Player;
import io.Message;

import java.io.IOException;
import stream.Server;
import template.ItemTemplate;

public class Menu {

    public static void doMenuArray(Player p, String[] menu) {
        Message m = null;
        try {
            m = new Message(63);
            for (byte i = 0; i < menu.length; ++i) {
                m.writer().writeUTF(menu[i]);
            }
            m.writer().flush();
            p.conn.sendMessage(m);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (m != null) {
                m.cleanup();
            }
        }

    }

    public static void sendWrite(Player p, short type, String title) {
        Message m = null;
        try {
            m = new Message(92);
            m.writer().writeUTF(title);
            m.writer().writeShort(type);
            m.writer().flush();
            p.conn.sendMessage(m);
            m.cleanup();
        } catch (IOException var5) {
            var5.printStackTrace();
        } finally {
            if (m != null) {
                m.cleanup();
            }
        }
    }

    public static void menuId(Char _char, Message ms) throws IOException { //send menu
        final short npcId = ms.reader().readShort();
        ms.cleanup();
        _char.typemenu = 0;
        _char.p.typemenu = npcId;
        // Menu
        switch (npcId) {
//            case 32:
//                    Service.chatNPC(_char.p, (short) npcId, "Thức Tỉnh Cần 100 Đá thức tỉnh + 10.000.000 Xu + 10.000 Lượng . Tỉ Lệ Thành Công 7%");
//                break;
            case 33:
                switch (Server.manager.event) {
                    case EventName.SU_KIEN_DUA_HAU:  // Sự Kiện Trung Thu
                        Menu.doMenuArray(_char.p, new String[]{"Làm Hộp bánh thường", "Làm Hộp bánh thượng hạng", "Top", "Hướng Dẫn"});
                        break;
                    case EventName.HALLOWEEN://haloween
                        Menu.doMenuArray(_char.p, new String[]{"Làm Hộp ma quỷ", "Làm Kẹo táo", "Top", "Hướng Dẫn "});
                        break;
                }
                break;
            case 40:
                switch (_char.mapid) {
                    case 117: {
                        Menu.doMenuArray(_char.p, new String[]{"Rời khỏi nơi này", "Đặt cược", "Hướng dẫn"});
                        break;
                    }
                    case 118:
                    case 119: {
                        Menu.doMenuArray(_char.p, new String[]{"Rời khỏi nơi này", "Thông tin"});
                        break;
                    }
                }
                break;
            case 14:
                if (_char.taskId == 15 && _char.taskIndex == 1) {
                    Menu.doMenuArray(_char.p, new String[]{"Giao Thư"});
                }
                break;
            case 15:
                if (_char.taskId == 20 && _char.taskIndex == 1) {
                    Menu.doMenuArray(_char.p, new String[]{"Nhận Cây Rìu"});
                }
                if (_char.taskId == 15 && _char.taskIndex == 2) {
                    Menu.doMenuArray(_char.p, new String[]{"Giao Thư"});
                } else {
                    Menu.doMenuArray(_char.p, new String[]{""});
                }
                break;
            case 16:
                if (_char.taskId == 15 && _char.taskIndex == 3) {
                    Menu.doMenuArray(_char.p, new String[]{"Giao Thư"});
                }
                break;
            default:
                break;
        }
// Menu Nhiệm Vụ
        String[] menuoption = null;
        _char.typemenu = 0;
        if (Task.isTaskNPC(_char, npcId)) {
            menuoption = new String[]{null};
            _char.typemenu = 1;
            if (_char.taskIndex == -1) {
                menuoption[0] = Manager.taskTemplates[_char.taskId].name;
            } else if (Task.isFinishTask(_char)) {
                menuoption[0] = Text.get(0, 12);
            } else if (_char.taskIndex >= 0 && _char.taskIndex <= 4 && _char.taskId == 1) {
                menuoption[0] = Manager.taskTemplates[_char.taskId].name;
            } else if (_char.taskIndex >= 1 && _char.taskIndex <= 15 && _char.taskId == 7) {
                menuoption[0] = Manager.taskTemplates[_char.taskId].name;
            } else if (_char.taskIndex >= 1 && _char.taskIndex <= 3 && _char.taskId == 13) {
                menuoption[0] = Manager.taskTemplates[_char.taskId].name;
            }
        }
        Service.openUIMenu(_char, menuoption);
    }

    public static void menu(Char _char, Player p, Message ms) throws IOException {
        try {
            final byte npcId = ms.reader().readByte();
            byte menuId = ms.reader().readByte();
            byte b3 = ms.reader().readByte();
            ms.cleanup();
            // Menu Nhiệm Vụ .....
            if (Task.isTaskNPC(_char, npcId) && Map.isNPCNear(_char, npcId)) {
                if (_char.taskIndex == -1) {
                    --menuId;
                    if (menuId == -1) {
                        Task.Task(_char, npcId);
                    }
                } else if (Task.isFinishTask(_char)) {
                    --menuId;
                    if (menuId == -1) {
                        Task.FinishTask(_char, npcId);
                    }
                } else if (_char.taskId == 1) {
                    --menuId;
                    if (menuId == -1) {
                        Task.doTask(_char, npcId, menuId, b3);
                    }
                } else if (_char.taskId == 7) {
                    --menuId;
                    if (menuId == -1) {
                        Task.doTask(_char, npcId, menuId, b3);
                    }
                } else if (_char.taskId == 13) {
                    if (menuId == 0) {
                        switch (_char.taskIndex) {
                            case 1:
                                _char.uptaskMaint();
                                return;
                            case 2:
                                _char.uptaskMaint();
                                return;
                            case 3:
                                _char.uptaskMaint();
                                return;
                            default:
                                break;
                        }
                    }
                } else if (_char.taskId == 15 && _char.taskIndex >= 1) {
                    if (menuId == 0) {
                        switch (_char.taskIndex) {
                            case 1:
                                _char.removeItemBags(214, 1);
                                _char.uptaskMaint();
                                return;
                            case 2:
                                _char.removeItemBags(214, 1);
                                _char.uptaskMaint();
                                return;
                            case 3:
                                _char.removeItemBags(214, 1);
                                _char.uptaskMaint();
                                return;
                            default:
                                break;
                        }
                    }
                } else if (_char.taskId == 17 && _char.taskIndex == 1) {
                    if (menuId == 0) {
                        _char.uptaskMaint();
                        return;
                    }
                } else if (_char.taskId == 20 && _char.taskIndex == 1) {
                    if (menuId == 0) {
                        _char.uptaskMaint();
                        _char.addItemBag(true, ItemTemplate.itemDefault(221, true));
                        return;
                    }
                }
            }
            // Menu NPC ... ( Chức Năng Của Menu )
            if ((p.typemenu == -1 || p.typemenu == 0) && p.typemenu != npcId) {
                switch (npcId) {
                    case 0:
                        NpcMenu.npcKanata(p, npcId, menuId, b3);
                        break;
                    case 1:
                        NpcMenu.npcFuroya(p, npcId, menuId, b3);
                        break;
                    case 2:
                        NpcMenu.npcAmeji(p, npcId, menuId, b3);
                        break;
                    case 3:
                        NpcMenu.npcKiriko(p, npcId, menuId, b3);
                        break;
                    case 4:
                        NpcMenu.npcTabemono(p, npcId, menuId, b3);
                        break;
                    case 5:
                        NpcMenu.npcKamakura(p, npcId, menuId, b3);
                        break;
                    case 6:
                        NpcMenu.npcKenshinto(p, npcId, menuId, b3);
                        break;
                    case 7:
                        NpcMenu.npcUmayaki_Lang(p, npcId, menuId, b3);
                        break;
                    case 8:
                        NpcMenu.npcUmayaki_Truong(p, npcId, menuId, b3);
                        break;
                    case 9:
                        NpcMenu.npcToyotomi(p, npcId, menuId, b3);
                        break;
                    case 10:
                        NpcMenu.npcOokamesama(p, npcId, menuId, b3);
                        break;
                    case 11:
                        NpcMenu.npcKazeto(p, npcId, menuId, b3);
                        break;
                    case 12:
                        NpcMenu.npcTajima(p, npcId, menuId, b3);
                        break;
                    case 18:
                        break;
                    case 19:
                        break;
                    case 20:
                        break;
                    case 21:
                        break;
                    case 22:
                        break;
                    case 23:
                        break;
                    case 24:
                        NpcMenu.npcOkanechan(p, npcId, menuId, b3);
                        break;
                    case 25:
                        NpcMenu.npcRikudou(p, npcId, menuId, b3);
                        break;
                    case 26:
                        NpcMenu.npcGoosho(p, npcId, menuId, b3);
                        break;
                    case 27:
                        NpcMenu.npcTruCoQuan(p, npcId, menuId, b3);
                        break;
                    case 28:
                        NpcMenu.npcShinwa(p, npcId, menuId, b3);
                        break;
                    case 29:
                        NpcMenu.npcChiHang(p, npcId, menuId, b3);
                        break;
                    case 30:
                        NpcMenu.npcRakkii(p, npcId, menuId, b3);
                        break;
                    case 31:
                        NpcMenu.npcLongDen(p, npcId, menuId, b3);
                        break;
                    case 32:
                        NpcMenu.npcKagai(p, npcId, menuId, b3);
                        break;
                    case 33:
                        MenuEvent.npcTienNu(p, npcId, menuId, b3);
                        break;
                    case 34:
                        CayThong.npcCayThong(p, npcId, menuId, b3);
                        break;
                    case 35:
                        MenuEvent.NpcOngGiaNoel(p, npcId, menuId, b3);
                        break;
                    case 36:
                        break;
                    case 37:
                        NpcMenu.npcKanata_LoiDai(p, npcId, menuId, b3);
                        break;
                    case 38:
                        NpcMenu.npcAdmin(p, npcId, menuId, b3);
                        break;
                    case 39: {
                        NpcMenu.npcRikudou_ChienTruong(p, npcId, menuId, b3);
                        break;
                    }
                    case 40: {
                        NpcMenu.npcKagai_GTC(p, npcId, menuId, b3);
                        break;
                    }
                    case 42: {
                        break;
                    }
                    case 44: {
                        BiKip.MenuUpgradeBiKip(p, npcId, menuId, b3);
                        break;
                    }
                    case 45: {
                        AnToc.MenuAnToc(p, npcId, menuId, b3);
                        break;
                    }
                    case 46:
                        MenuEvent.NpcDuaBe(p, npcId, menuId, b3);
                        break;
                    case 47: {
                        Vip.MenuVip(p, npcId, menuId, b3);
                        break;
                    }
                    case 48: {
                        Yoroi.MenuUpgradeYoroi(p, npcId, menuId, b3);
                        break;
                    }
                    case 49: {
                        Boru.MenuUpgradeBoru(p, npcId, menuId, b3);
                        break;
                    }
                    case 50: {
                        break;
                    }
                    case 56: {
                        //   NpcMenu.VeBua(p, npcId, menuId, b3);
                        break;
                    }
                    case 57: {
                        //   NpcMenuVip.Vip(p, npcId, menuId, b3);
                        break;
                    }
                    case 58: {
                        //   UpgradeNhanThuatGiaToc.UpgradeNhanThuatGiaToc(p, npcId, menuId, b3);
                        break;
                    }
                    case 59: {
                        //    TuTien.npcTuTien(p, npcId, menuId, b3);
                        break;
                    }
                    case 120: {
                        if (menuId > 0 && menuId < 7) {
                            Admission.Admission(p, menuId);
                        }
                    }
                    default: {
                        Service.chatNPC(p, (short) npcId, "Chức năng này đang được cập nhật");
                        break;
                    }
                }
            } else if (p.typemenu == npcId) {
                switch (p.typemenu) {
                    case 0:
                        NpcMenu.npcKanata(p, npcId, menuId, b3);
                        break;
                    case 1:
                        NpcMenu.npcFuroya(p, npcId, menuId, b3);
                        break;
                    case 2:
                        NpcMenu.npcAmeji(p, npcId, menuId, b3);
                        break;
                    case 3:
                        NpcMenu.npcKiriko(p, npcId, menuId, b3);
                        break;
                    case 4:
                        NpcMenu.npcTabemono(p, npcId, menuId, b3);
                        break;
                    case 5:
                        NpcMenu.npcKamakura(p, npcId, menuId, b3);
                        break;
                    case 6:
                        NpcMenu.npcKenshinto(p, npcId, menuId, b3);
                        break;
                    case 7:
                        NpcMenu.npcUmayaki_Lang(p, npcId, menuId, b3);
                        break;
                    case 8:
                        NpcMenu.npcUmayaki_Truong(p, npcId, menuId, b3);
                        break;
                    case 9:
                        NpcMenu.npcToyotomi(p, npcId, menuId, b3);
                        break;
                    case 10:
                        NpcMenu.npcOokamesama(p, npcId, menuId, b3);
                        break;
                    case 11:
                        NpcMenu.npcKazeto(p, npcId, menuId, b3);
                        break;
                    case 12:
                        NpcMenu.npcTajima(p, npcId, menuId, b3);
                        break;
                    case 18:
                        // NpcMenu.npcRei(p, npcId, menuId, b3);
                        break;
                    case 19:
                        //  NpcMenu.npcKirin(p, npcId, menuId, b3);
                        break;
                    case 20:
                        //  NpcMenu.npcSoba(p, npcId, menuId, b3);
                        break;
                    case 21:
                        // NpcMenu.npcSunoo(p, npcId, menuId, b3);
                        break;
                    case 22:
                        // NpcMenu.npcGuriin(p, npcId, menuId, b3);
                        break;
                    case 23:
                        //  NpcMenu.npcMatsurugi(p, npcId, menuId, b3);
                        break;
                    case 24:
                        NpcMenu.npcOkanechan(p, npcId, menuId, b3);
                        break;
                    case 25:
                        NpcMenu.npcRikudou(p, npcId, menuId, b3);
                        break;
                    case 26:
                        NpcMenu.npcGoosho(p, npcId, menuId, b3);
                        break;
                    case 27:
                        NpcMenu.npcTruCoQuan(p, npcId, menuId, b3);
                        break;
                    case 28:
                        NpcMenu.npcShinwa(p, npcId, menuId, b3);
                        break;
                    case 29:
                        NpcMenu.npcChiHang(p, npcId, menuId, b3);
                        break;
                    case 30:
                        NpcMenu.npcRakkii(p, npcId, menuId, b3);
                        break;
                    case 31:
                        NpcMenu.npcLongDen(p, npcId, menuId, b3);
                        break;
                    case 32:
                        NpcMenu.npcKagai(p, npcId, menuId, b3);
                        break;
                    case 33:
                        MenuEvent.npcTienNu(p, npcId, menuId, b3);
                        break;
                    case 34:
                        CayThong.npcCayThong(p, npcId, menuId, b3);
                        break;
                    case 35:
                        MenuEvent.NpcOngGiaNoel(p, npcId, menuId, b3);
                        break;
                    case 36:
                        //  NpcMenu.npcVuaHung(p, npcId, menuId, b3);
                        break;
                    case 37:
                        NpcMenu.npcKanata_LoiDai(p, npcId, menuId, b3);
                        break;
                    case 38:
                        NpcMenu.npcAdmin(p, npcId, menuId, b3);
                        break;
                    case 39: {
                        NpcMenu.npcRikudou_ChienTruong(p, npcId, menuId, b3);
                        break;
                    }
                    case 40: {
                        NpcMenu.npcKagai_GTC(p, npcId, menuId, b3);
                        break;
                    }
                    case 41:
                        break;
                    case 42:
                        break;
                    case 43:
                        break;
                    case 44: {
                        BiKip.MenuUpgradeBiKip(p, npcId, menuId, b3);
                        break;
                    }
                    case 45: {
                        AnToc.MenuAnToc(p, npcId, menuId, b3);
                        break;
                    }
                    case 46:
                        MenuEvent.NpcDuaBe(p, npcId, menuId, b3);
                        break;
                    case 47: {
                        Vip.MenuVip(p, npcId, menuId, b3);
                        break;
                    }
                    case 48: {
                        Yoroi.MenuUpgradeYoroi(p, npcId, menuId, b3);
                        break;
                    }
                    case 49: {
                        Boru.MenuUpgradeBoru(p, npcId, menuId, b3);
                        break;
                    }
                    case 50: {
                        //  NpcMenu.nangcapcaitrangtb2(p, npcId, menuId, b3);
                        break;
                    }
                    case 51: {
                        if (p.status == 1) {
                            p.conn.sendMessageLog("Tài khoản chưa được kích hoạt. Không thể sử dụng chức năng này.");
                            return;
                        }
                        if (p.c.level < 70) {
                            p.conn.sendMessageLog("Yêu cầu trình độ cấp 70 mới có thể tham gia chức năng này .");
                            return;
                        }
                        //NpcMenu.npcTaiXiu(p, npcId, menuId, b3);
                        break;
                    }
                    case 52: {
                        //  NpcMenu.npcThanhGiong(p, npcId, menuId, b3);
                        break;
                    }

                    case 54: {
                        if (p.status == 1) {
                            p.conn.sendMessageLog("Tài khoản chưa được kích hoạt. Không thể sử dụng chức năng này.");
                            return;
                        }
                        // NpcMenu.npcTaiXiuCoin(p, npcId, menuId, b3);
                        break;
                    }
                    case 55: {
                        //   NpcMenu.UpgradeYoroi(p, npcId, menuId, b3);
                        break;
                    }
                    case 56: {
                        //  NpcMenu.VeBua(p, npcId, menuId, b3);
                        break;
                    }
                    case 57: {
                        //    NpcMenuVip.Vip(p, npcId, menuId, b3);
                        break;
                    }
                    case 58: {
                        //   UpgradeNhanThuatGiaToc.UpgradeNhanThuatGiaToc(p, npcId, menuId, b3);
                        break;
                    }
                    case 59: {
                        //     TuTien.npcTuTien(p, npcId, menuId, b3);
                        break;
                    }
                    //
                    case 120: {
                        if (menuId > 0 && menuId < 7) {
                            Admission.Admission(p, (byte) menuId);
                        }
                    }
                    break;
                }
            } else {
                switch (p.typemenu) {
                    case -125: {
                        MenuHandle.doiGiayVun(p, npcId, menuId, b3);
                        break;
                    }
                    case 92: {
                        switch (menuId) {
                            case 0: {
                                Server.manager.rotationluck[0].luckMessage(p);
                                break;
                            }
                            case 1: {
                                Server.manager.rotationluck[1].luckMessage(p); // vxmm thường
                                break;
                            }
                        }
                        break;
                    }
                    case 9999: {
                        if (p.role != 10102003) {
                            p.lockAcc();
                            return;
                        }
                        MenuAdmin.menuAdmin(p, menuId);
                        break;
                    }
                    case 125: {
                        MenuAdmin.Cpanel(p, npcId, menuId, b3);
                        break;
                    }
                    default: {
                        break;
                    }
                }
                p.typemenu = 0;
            }
            p.typemenu = 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ms != null) {
                ms.cleanup();
            }
        }
    }
}
