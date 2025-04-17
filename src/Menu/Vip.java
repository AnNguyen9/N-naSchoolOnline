/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import History.LichSu;
import Item.ItemName;
import assembly.Item;
import assembly.Language;
import assembly.Map;
import assembly.Player;
import assembly.TileMap;
import server.Manager;
import server.Rank;
import server.Service;
import stream.Server;
import template.ItemTemplate;

/**
 *
 * @author Administrator
 */
public class Vip {

    public static void MenuVip(Player p, byte npcid, byte menuId, byte b3) {
        short[] nam = {712, 713, 746, 747, 748, 749, 750, 751, 752};
        short[] nu = {715, 716, 753, 754, 755, 756, 757, 758, 759};
        switch (menuId) {
            case 0: {
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                if (p.c.nhanquavip == 1) {
                    Service.chatNPC(p, (short) npcid, "Bạn Đã Nhận Qùa Vip Hoặc không đủ điều kiện nhận VIP mốc này");
                    return;
                }
                if (p.c.nclass == 0) {
                    Service.chatNPC(p, (short) npcid, "Bạn Chưa Nhập Học Nên Không Thể Nhận Qùa Vip");
                    return;
                }
                switch (b3) {
                    case 0: {
                        if (p.c.vip != 1) {
                            Service.chatNPC(p, (short) npcid, "Bạn không đủ điều kiện nhận VIP Mốc Này");
                            return;
                        }
                        if (p.c.getBagNull() < 10) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        if (p.c.gender == 1) {
                            for (byte i = 0; i < 9; i++) {
                                Item itemup = ItemTemplate.itemDefault(nam[i]);
                                switch (p.c.get().nclass) {
                                    case 1:
                                    case 2:
                                        itemup.sys = 1;
                                        break;
                                    case 3:
                                    case 4:
                                        itemup.sys = 2;
                                        break;
                                    case 5:
                                    case 6:
                                        itemup.sys = 3;
                                        break;
                                    default:
                                        break;
                                }
                                p.c.addItemBag(false, itemup);
                            }
                        } else {
                            for (byte i = 0; i < 9; i++) {
                                Item itemup = ItemTemplate.itemDefault(nu[i]);
                                switch (p.c.get().nclass) {
                                    case 1:
                                    case 2:
                                        itemup.sys = 1;
                                        break;
                                    case 3:
                                    case 4:
                                        itemup.sys = 2;
                                        break;
                                    case 5:
                                    case 6:
                                        itemup.sys = 3;
                                        break;
                                    default:
                                        break;
                                }
                                p.c.addItemBag(false, itemup);
                            }
                        }
                        p.conn.sendMessageLog("Bạn đã nhận Quà Vip 1 thành công");
                        p.c.nhanquavip = 1;
                        break;
                    }
                    case 1: {
                        if (p.c.vip != 2) {
                            Service.chatNPC(p, (short) npcid, "Bạn không đủ điều kiện nhận VIP Mốc Này");
                            break;
                        }
                        if (p.c.getBagNull() < 10) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        if (p.c.gender == 1) {
                            for (byte i = 0; i < 9; i++) {
                                Item itemup = ItemTemplate.itemDefault(nam[i]);
                                switch (p.c.get().nclass) {
                                    case 1:
                                    case 2:
                                        itemup.sys = 1;
                                        break;
                                    case 3:
                                    case 4:
                                        itemup.sys = 2;
                                        break;
                                    case 5:
                                    case 6:
                                        itemup.sys = 3;
                                        break;
                                    default:
                                        break;
                                }
                                itemup.upgradeNext((byte) 8);
                                p.c.addItemBag(false, itemup);
                            }
                        } else {
                            for (byte i = 0; i < 9; i++) {
                                Item itemup = ItemTemplate.itemDefault(nu[i]);
                                switch (p.c.get().nclass) {
                                    case 1:
                                    case 2:
                                        itemup.sys = 1;
                                        break;
                                    case 3:
                                    case 4:
                                        itemup.sys = 2;
                                        break;
                                    case 5:
                                    case 6:
                                        itemup.sys = 3;
                                        break;
                                    default:
                                        break;
                                }
                                itemup.upgradeNext((byte) 8);
                                p.c.addItemBag(false, itemup);
                            }
                        }
                        p.conn.sendMessageLog("Bạn đã nhận vip 2 thành công");
                        p.c.nhanquavip = 1;
                        break;
                    }
                    case 2: {
                        if (p.c.vip != 3) {
                            Service.chatNPC(p, (short) npcid, "Bạn không đủ điều kiện nhận VIP Mốc Này");
                            break;
                        }
                        if (p.c.getBagNull() < 10) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        if (p.c.gender == 1) {
                            for (byte i = 0; i < 9; i++) {
                                Item itemup = ItemTemplate.itemDefault(nam[i]);
                                itemup.upgradeNext((byte) 16);
                                switch (p.c.get().nclass) {
                                    case 1:
                                    case 2:
                                        itemup.sys = 1;
                                        break;
                                    case 3:
                                    case 4:
                                        itemup.sys = 2;
                                        break;
                                    case 5:
                                    case 6:
                                        itemup.sys = 3;
                                        break;
                                    default:
                                        break;
                                }
                                p.c.addItemBag(false, itemup);
                            }
                        } else {
                            for (byte i = 0; i < 9; i++) {
                                Item itemup = ItemTemplate.itemDefault(nu[i]);
                                itemup.upgradeNext((byte) 16);
                                switch (p.c.get().nclass) {
                                    case 1:
                                    case 2:
                                        itemup.sys = 1;
                                        break;
                                    case 3:
                                    case 4:
                                        itemup.sys = 2;
                                        break;
                                    case 5:
                                    case 6:
                                        itemup.sys = 3;
                                        break;
                                    default:
                                        break;
                                }
                                p.c.addItemBag(false, itemup);
                            }

                        }
                        p.conn.sendMessageLog("Bạn đã nhận vip 3 thành công");
                        p.c.nhanquavip = 1;
                        break;
                    }
                    case 3: {
                        if (p.c.vip != 4) {
                            Service.chatNPC(p, (short) npcid, "Bạn không đủ điều kiện nhận VIP Mốc Này");
                            break;
                        }
                        if (p.c.getBagNull() < 10) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        Item MatNa = ItemTemplate.itemDefault(p.c.gender == 1 ? 834 : 833);
//                        Super.options.add(new Option(58, 20));
//                        Super.options.add(new Option(73, 10000));
//                        Super.options.add(new Option(6, 5000));
//                        Super.options.add(new Option(94, 100));
//                        Super.options.add(new Option(92, 100));
//                        Super.options.add(new Option(79, 20));
//                        Super.options.add(new Option(80, 200));
//                        Super.options.add(new Option(54, 20));
//                        Super.options.add(new Option(55, 20));
//                        Super.options.add(new Option(56, 20));
                        MatNa.upgrade = 16;
                        p.c.addItemBag(false, MatNa);
                        if (p.c.gender == 1) {
                            for (byte i = 0; i < 9; i++) {
                                Item itemup = ItemTemplate.itemDefault(nam[i]);
                                itemup.upgradeNext((byte) 16);
                                switch (p.c.get().nclass) {
                                    case 1:
                                    case 2:
                                        itemup.sys = 1;
                                        break;
                                    case 3:
                                    case 4:
                                        itemup.sys = 2;
                                        break;
                                    case 5:
                                    case 6:
                                        itemup.sys = 3;
                                        break;
                                    default:
                                        break;
                                }
                                p.c.addItemBag(false, itemup);
                            }
                        } else {
                            for (byte i = 0; i < 9; i++) {
                                Item itemup = ItemTemplate.itemDefault(nu[i]);
                                itemup.upgradeNext((byte) 16);
                                switch (p.c.get().nclass) {
                                    case 1:
                                    case 2:
                                        itemup.sys = 1;
                                        break;
                                    case 3:
                                    case 4:
                                        itemup.sys = 2;
                                        break;
                                    case 5:
                                    case 6:
                                        itemup.sys = 3;
                                        break;
                                    default:
                                        break;
                                }
                                p.c.addItemBag(false, itemup);
                            }
                        }
                        p.conn.sendMessageLog("Bạn đã nhận vip 4 thành công");
                        p.c.nhanquavip = 1;
                        break;
                    }
                    case 4: {
                        if (p.c.vip != 5) {
                            Service.chatNPC(p, (short) npcid, "Bạn không đủ điều kiện nhận VIP Mốc Này");
                            break;
                        }
                        if (p.c.getBagNull() < 10) {
                            Service.chatNPC(p, (short) npcid, Language.NOT_ENOUGH_BAG);
                            return;
                        }
//                        Item Super = ItemTemplate.itemDefault(p.c.gender == 1 ? 407 : 406);
//                        Super.options.add(new Option(58, 20));
//                        Super.options.add(new Option(73, 10000));
//                        Super.options.add(new Option(6, 5000));
//                        Super.options.add(new Option(94, 100));
//                        Super.options.add(new Option(92, 100));
//                        Super.options.add(new Option(79, 20));
//                        Super.options.add(new Option(80, 200));
//                        Super.options.add(new Option(54, 20));
//                        Super.options.add(new Option(55, 20));
//                        Super.options.add(new Option(56, 20));
//                        Super.upgrade = 16;
//                        p.c.addItemBag(false, Super);
                        Item PHB = ItemTemplate.itemDefault(ItemName.PHUONG_HOANG_BANG);
                        p.c.addItemBag(false, PHB);
//                        KimNguu.isLock = true;
//                        KimNguu.sys = 4;
//                        KimNguu.upgrade = 99;
//                        KimNguu.options.add(new Option(58, 20));
//                        KimNguu.options.add(new Option(94, 100));
//                        KimNguu.options.add(new Option(73, 10000));
//                        KimNguu.options.add(new Option(74, 500));
//                        KimNguu.options.add(new Option(6, 5000));
//                        KimNguu.options.add(new Option(69, 140));
//                        KimNguu.options.add(new Option(67, 100));
//                        KimNguu.options.add(new Option(68, 140));
//                        KimNguu.options.add(new Option(119, 200));
//                        KimNguu.options.add(new Option(120, 200));

                        if (p.c.gender == 1) {
                            for (byte i = 0; i < 9; i++) {
                                Item itemup = ItemTemplate.itemDefault(nam[i]);
                                itemup.upgradeNext((byte) 16);
                                switch (p.c.get().nclass) {
                                    case 1:
                                    case 2:
                                        itemup.sys = 1;
                                        break;
                                    case 3:
                                    case 4:
                                        itemup.sys = 2;
                                        break;
                                    case 5:
                                    case 6:
                                        itemup.sys = 3;
                                        break;
                                    default:
                                        break;
                                }
                                p.c.addItemBag(false, itemup);
                            }
                        } else {
                            for (byte i = 0; i < 9; i++) {
                                Item itemup = ItemTemplate.itemDefault(nu[i]);
                                itemup.upgradeNext((byte) 16);
                                switch (p.c.get().nclass) {
                                    case 1:
                                    case 2:
                                        itemup.sys = 1;
                                        break;
                                    case 3:
                                    case 4:
                                        itemup.sys = 2;
                                        break;
                                    case 5:
                                    case 6:
                                        itemup.sys = 3;
                                        break;
                                    default:
                                        break;
                                }
                                p.c.addItemBag(false, itemup);
                            }
                        }
                        p.conn.sendMessageLog("Bạn đã nhận vip 5 thành công");
                        p.c.danhhieu = p.c.nclass;
                        p.c.nhanquavip = 1;
                        break;
                    }
                }
                break;
            }
            case 1: {
                if (p.c.isNhanban) {
                    Service.chatNPC(p, (short) npcid, Language.NOT_FOR_PHAN_THAN);
                    return;
                }
                if (p.c.vip == -1) {
                    Service.chatNPC(p, (short) npcid, "Bạn không đủ điều kiện để báo danh vip");
                    return;
                }
                switch (p.c.vip) {
                    case 1: {
                        if (p.c.diemdanhvip == 0) {
                            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 1000), "Điểm danh vip", +1000);
                            p.upluongMessage(1000);
                            Service.addItemToBagNinja(p.c, ItemName.LINH_CHI_VAN_NAM, true, false, 1, false, -1);
                            p.c.diemdanhvip = 1;
                            Service.chatNPC(p, (short) npcid, "Báo danh VIP 1 thành công");
                            break;
                        } else {
                            Service.chatNPC(p, (short) npcid, "Hôm nay trùm đã Báo danh VIP, hãy quay lại vào ngày hôm sau nha!");
                        }
                        break;
                    }
                    case 2: {
                        if (p.c.diemdanhvip == 0) {
                            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 5000), "Điểm danh vip", +5000);
                            p.upluongMessage(5000);
                            Service.addItemToBagNinja(p.c, ItemName.LINH_CHI_VAN_NAM, true, false, 3, false, -1);
                            p.c.diemdanhvip = 1;
                            Service.chatNPC(p, (short) npcid, "Báo danh VIP 2 thành công.");
                            break;
                        } else {
                            Service.chatNPC(p, (short) npcid, "Hôm nay trùm đã Báo danh VIP, hãy quay lại vào ngày hôm sau nha!");
                        }
                        break;
                    }
                    case 3: {
                        if (p.c.diemdanhvip == 0) {
                            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 10000), "Điểm danh vip", +10000);
                            p.upluongMessage(10000);
                              Service.addItemToBagNinja(p.c, ItemName.LINH_CHI_VAN_NAM, true, false, 5, false, -1);
                            p.c.diemdanhvip = 1;
                            Service.chatNPC(p, (short) npcid, "Báo danh VIP 3 thành công.");
                            break;
                        } else {
                            Service.chatNPC(p, (short) npcid, "Hôm nay trùm đã Báo danh VIP, hãy quay lại vào ngày hôm sau nha!");
                        }
                        break;
                    }
                    case 4: {
                        if (p.c.diemdanhvip == 0) {
                            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 20000), "Điểm danh vip", +20000);
                            p.upluongMessage(20000);
                               Service.addItemToBagNinja(p.c, ItemName.LINH_CHI_VAN_NAM, true, false, 7, false, -1);
                            p.c.diemdanhvip = 1;
                            Service.chatNPC(p, (short) npcid, "Báo danh VIP 4 thành công.");
                            break;
                        } else {
                            Service.chatNPC(p, (short) npcid, "Hôm nay trùm đã Báo danh VIP, hãy quay lại vào ngày hôm sau nha!");
                        }
                        break;
                    }
                    case 5: {
                        if (p.c.diemdanhvip == 0) {
                            LichSu.LichSuLuong(p.c.name, p.luong, (p.luong + 30000), "Điểm danh vip", +30000);
                            p.upluongMessage(30000);
                             Service.addItemToBagNinja(p.c, ItemName.LINH_CHI_VAN_NAM, true, false, 10, false, -1);
                            p.c.diemdanhvip = 1;
                            Service.chatNPC(p, (short) npcid, "Báo danh VIP 5 thành công.");
                            break;
                        } else {
                            Service.chatNPC(p, (short) npcid, "Hôm nay trùm đã Báo danh VIP, hãy quay lại vào ngày hôm sau nha!");
                        }
                        break;
                    }
                }
                break;
            }
            case 2:
                String nhanqua = "";
                String diemdanh = "";
                if (p.c.nhanquavip == 1) {
                    nhanqua = "Đã Nhận";
                } else {
                    nhanqua = "Chưa Nhận";
                }
                if (p.c.diemdanhvip == 1) {
                    diemdanh = "Đã Báo Danh";
                } else {
                    diemdanh = "Chưa Báo Danh";
                }
                if (p.c.vip == -1) {
                    p.conn.sendMessageLog("Bạn Không Có Vip");
                } else {
                    p.conn.sendMessageLog("Bạn Hiện Đang Ở Vip " + p.c.vip + "\n"
                            + "Đặc Quyền VIP : Nhận X" + p.c.vip + " Yên Khi Úp \n"
                            + "Trạng Thái \n"
                            + "Nhận Quà Vip : " + nhanqua + "\n"
                            + "Điểm Danh Vip : " + diemdanh + "\n"
                    );
                }
                break;

            case 3: {
                switch (b3) {
                    case 0: {
                        if (p.c.vip < 3) {
                            Service.chatNPC(p, (short) npcid, "Yêu cầu Vip 3 Mới Có Thể Vào Map Này");
                            return;
                        }
                        if (p.c.getEffId(34) == null) {
                            p.conn.sendMessageLog("Phải Sử Dụng Thí Luyện Thiếp Mới Có Thể Vào Map Này.");
                            return;
                        }
                        Map ma = Manager.getMapid(112);
                        for (TileMap area : ma.area) {
                            if (area.numplayers < ma.template.maxplayers) {
                                p.c.tileMap.leave(p);
                                area.EnterMap0(p.c);
                                return;
                            }
                        }
                        break;
                    }
                    case 1:
                        Service.chatNPC(p, (short) npcid, "Để tham gia Map VIP Bạn Cần Đạt VIP 3 Và Phải Sử Dụng Thí Luyện Thiếp Mới Có Thể Vào Map. \n Quái trong Map VIP sẽ rất mạnh , Khi tiêu diệt quái sẽ nhận được 1 Lượng/1 Quái và quái sẽ rơi ra nhiều vật phẩm đặc biệt \n Hồi sinh ở Map VIP Sẽ Mất 100 Lượng 1 Lần Hồi Sinh . Mỗi Ngày chỉ có thể sử dụng tối đa 1 Thí Luyện Thiếp \n Tiêu diệt thủ lĩnh sẽ nhận được 1 viên ngọc 7 sao");
                        break;
                }
                break;
            }
            case 4:
                Server.manager.sendTB(p, "BXH VIP", Rank.getStringBXH(5));
                break;
            case 5:
                break;
//            case 5: {
//                Server.manager.sendTB(p, "VIP", "- Nạp Theo Mốc Để Nhận Thưởng ( Không Cộng Dồn ).\n"
//                        + "- VIP 1: 50K\n"
//                        + "Quà VIP : 1 Set Jirai Hoặc Jumito Vĩnh Viễn ( Không Thể Nâng Cấp + 0 )\n"
//                        + "Quà Điểm Danh VIP : 1.000 Lượng ( Mỗi Ngày Nhận 1 Lần )\n"
//                        + "- VIP 2: 100K\n"
//                        + "Quà Vip : 1 Set Jirai Hoặc Jumito Vĩnh Viễn ( Không Thể Nâng Cấp + 8 )\n"
//                        + "Quà Điểm Danh VIP : 2.000 Lượng ( Mỗi Ngày Nhận 1 Lần )\n"
//                        + "- VIP 3: 150K\n"
//                        + "Quà Vip : 1 Set Jirai Hoặc Jumito Vĩnh Viễn ( Không Thể Nâng Cấp + 16 )\n"
//                        + "Quà Điểm Danh Vip : 3.000 Lượng ( Mỗi Ngày Nhận 1 Lần )\n"
//                        + "Đặc Quyền Vip : Thông Báo Khi Vào Game + X3 Yên Khi Đánh Qúai\n"
//                        + "- VIP 4: 250K\n"
//                        + "Quà Vip : 1 Set Jirai Hoặc Jumito Vĩnh Viễn ( Không Thể Nâng Cấp + 16 ) + 1 Mặt Nạ Super/Onna Vĩnh Viễn\n"
//                        + "Quà Điểm Danh Vip : 4.000 Lượng ( Mỗi Ngày Nhận 1 Lần )\n"
//                        + "Đặc Quyền Vip : Thông Báo Khi Vào Game + X4 Yên Khi Đánh Qúai\n"
//                        + "- VIP 5: 500K\n"
//                        + "Quà Vip : 1 Set Jirai Hoặc Jumito Vĩnh Viễn ( Không Thể Nâng Cấp + 16 ) + 1 Mặt Nạ Super/Onna Vĩnh Viễn + 1 Thú Cưỡi Kim Ngưu 5 Sao ( Hiệu Ứng Đi Kèm ) + 1 Danh Hiệu Trùm Phái ( Không Tăng Chỉ Số ) \n"
//                        + "Đặc Quyền Vip : Thông Báo Khi Vào Game + X5 Yên Khi Đánh Qúai\n"
//                        + "Quà Điểm Danh Vip : 5.000 Lượng ( Mỗi Ngày Nhận 1 Lần )\n"
//                );
//                break;
//            }
        }
    }
}
