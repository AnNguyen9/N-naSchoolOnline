package ItemHandleUse;

import History.LichSu;
import Item.ItemName;
import Item.RandomItem;
import assembly.ClanManager;
import assembly.Effect;
import assembly.Item;
import assembly.Language;
import assembly.Map;
import assembly.Option;
import assembly.Player;
import assembly.UseItem;
import io.Message;
import io.Util;
import server.GameSrc;
import server.Manager;
import static stream.Client.LOCK;
import stream.Server;
import template.ItemTemplate;

public class ItemHandle {

    public static short[] idItemRuongHuyenThoai = new short[]{867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880};

    public static void RuongHuyenThoai(Player p, Item item, byte index) {
        if (p.c.getBagNull() == 0) {
            p.conn.sendMessageLog("Hành trang không đủ chỗ trống.");
            return;
        }
        p.c.removeItemBag(index, 1);
        if (p.c.taskId == 40 && p.c.taskIndex == 1) {
            p.c.uptaskMaint();
        }
        if (Util.nextInt(10) < 9) {
            p.c.upyenMessage(Util.nextInt(10000, 100000));
        } else if (Util.nextInt(100) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(222, false));
        } else if (Util.nextInt(400) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(223, false));
        } else if (Util.nextInt(600) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(224, false));
        } else if (Util.nextInt(800) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(225, false));
        } else if (Util.nextInt(1000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(226, false));
        } else if (Util.nextInt(1200) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(227, false));
        } else if (Util.nextInt(1500) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(228, false));
        } else {
            short idI = idItemRuongHuyenThoai[Util.nextInt(idItemRuongHuyenThoai.length)];
            ItemTemplate data2 = ItemTemplate.ItemTemplateId(idI);
            Item itemup;
            if (data2.type < 10) {
                if (data2.type == 1) {
                    itemup = ItemTemplate.itemDefault(idI);
                    itemup.sys = GameSrc.SysClass(data2.nclass);
                } else {
                    itemup = ItemTemplate.itemDefault(idI);
                    itemup.sys = (byte) Util.nextInt(1, 3);
                }
            } else {
                itemup = ItemTemplate.itemDefault(idI);
            }
            itemup.isLock = false;
            int idOp2;
            for (Option Option : itemup.options) {
                idOp2 = Option.id;
                Option.param = Util.nextInt(item.getOptionShopMin(idOp2, Option.param), Option.param);
            }
            p.c.addItemBag(true, itemup);
        }
    }

    public static void VungDatBiAn(Player p, Item item, byte index) {
        if (p.c.isNhanban) {
            p.conn.sendMessageLog(Language.NOT_FOR_PHAN_THAN);
            return;
        }
        if (p.c.level < 130) {
            p.sendAddchatYellow("Yêu Cầu Trình Độ Lớn Hơn 130.");
            return;
        }
        p.c.removeItemBag(index, 1);
        p.c.tileMap.leave(p);
        Map map = Server.maps[161];
        byte k;
        for (k = 0; k < map.area.length; k++) {
            if (map.area[k].numplayers < map.template.maxplayers) {
                map.area[k].EnterMap0(p.c);
                break;
            }
        }
        p.endLoad(true);
    }

    public static void HomMayMan(Player p, Item item, byte index) {
        ItemTemplate data = ItemTemplate.ItemTemplateId(item.id);
        if (p.c.getBagNull() == 0) {
            p.conn.sendMessageLog("Hành trang không đủ chỗ trống.");
            return;
        }
        p.c.removeItemBag(index, 1);
        int itemID = RandomItem.ITEM_HOMMAYMAN.next();
        Item itm = ItemTemplate.itemDefault(itemID);
        if (itemID == ItemName.MAT_NA_HO
                || itemID == ItemName.MAT_NA_HO_1
                || itemID == ItemName.SHIRAIJI
                || itemID == ItemName.HAJIRO
                || itemID == ItemName.PET_YEU_TINH
                || itemID == ItemName.PET_BONG_MA
                || item.id == ItemName.GAY_TRAI_TIM
                || item.id == ItemName.GAY_MAT_TRANG) {
            if (Util.percent(50, 1)) {
                LichSu.LichSuMoItemVinhVien(p.c.name, ItemTemplate.ItemTemplateId(itemID).name);
                Manager.chatKTG(p.c.name + " Sử Dụng " + data.name + " nhận được " + ItemTemplate.ItemTemplateId(itemID).name + " Vĩnh Viễn");
            } else {
                itm.isExpires = true;
                itm.expires = Util.TimeDay(30);
            }
        }
        p.c.addItemBag(true, itm);
    }

    public static void RuongHuyenBiBatBaoBachNgan(Player p, Item item, byte index) {
        if (p.c.getBagNull() == 0) {
            p.c.p.conn.sendMessageLog("Hành trang không đủ chỗ trống");
            return;
        }
        if (p.c.get().nclass == 0) {
            p.conn.sendMessageLog("Hãy nhập học để mở vật phẩm.");
            return;
        }
        byte sys2 = -1;
        int idI2;
        if (Util.nextInt(2) == 0) {
            if (p.c.gender == 0) { // đồ nữ
                if (p.c.get().level < 50 && item.id != 384 && item.id != 385) { // mở bát bảo
                    idI2 = (new short[]{171, 161, 151, 141, 131})[Util.nextInt(5)]; // đồ 4x nữ +12
                } else if (p.c.get().level < 60) {
                    idI2 = (new short[]{173, 163, 153, 143, 133})[Util.nextInt(5)]; // đồ 5x nữ +12 
                } else if (p.c.get().level < 70) {
                    idI2 = (new short[]{330, 329, 328, 327, 326})[Util.nextInt(5)]; // đồ 6x nữ
                } else {
                    idI2 = (new short[]{368, 367, 366, 365, 364})[Util.nextInt(5)]; // đồ 7x
                }
            } else if (p.c.get().level < 50 && item.id != 384 && item.id != 385) {
                idI2 = (new short[]{170, 160, 150, 140, 130})[Util.nextInt(5)]; // đồ 4x nam
            } else if (p.c.get().level < 60 && item.id != 385) {
                idI2 = (new short[]{172, 162, 152, 142, 132})[Util.nextInt(5)]; // đồ 5x nam
            } else if (p.c.get().level < 70) {
                idI2 = (new short[]{325, 323, 321, 319, 317})[Util.nextInt(5)]; // đồ 6x
            } else {
                idI2 = (new short[]{363, 361, 359, 357, 355})[Util.nextInt(5)]; // đồ 7x
            }
        } else if (Util.nextInt(2) == 1) {
            switch (p.c.get().nclass) {
                case 1:
                case 2:
                    sys2 = 1;
                    break;
                case 3:
                case 4:
                    sys2 = 2;
                    break;
                case 5:
                case 6:
                    sys2 = 3;
                    break;
                default:
                    break;
            }
            if (p.c.get().level < 50 && item.id != 384 && item.id != 385) {
                idI2 = (new short[]{97, 117, 102, 112, 107, 122})[p.c.get().nclass - 1]; // vũ khí 4x
            } else if (p.c.get().level < 60 && item.id != 385) {
                idI2 = (new short[]{98, 118, 103, 113, 108, 123})[p.c.get().nclass - 1]; // vũ khí 5x
            } else if (p.c.get().level < 70) {
                idI2 = (new short[]{331, 332, 333, 334, 335, 336})[p.c.get().nclass - 1];// vũ khí 6x
            } else {
                idI2 = (new short[]{369, 370, 371, 372, 373, 374})[p.c.get().nclass - 1]; // vũ khí 7x
            }
        } else if (p.c.get().level < 50 && item.id != 384 && item.id != 385) {
            idI2 = (new short[]{192, 187, 182, 177})[Util.nextInt(4)]; // trang bị 4x
        } else if (p.c.get().level < 60 && item.id != 385) {
            idI2 = (new short[]{193, 188, 183, 178})[Util.nextInt(4)];// trang bị 5x
        } else if (p.c.get().level < 70) {
            idI2 = (new short[]{324, 322, 320, 318})[Util.nextInt(4)];// trang bị 6x
        } else {
            idI2 = (new short[]{362, 360, 358, 356})[Util.nextInt(4)]; // trang bị 7x
        }
        Item itemup;
        if (sys2 < 0) {
            if (p.c.nclass == 1 && p.c.nclass == 2) {
                sys2 = 1;
            } else if (p.c.nclass == 3 && p.c.nclass == 4) {
                sys2 = 2;
            } else if (p.c.nclass == 5 && p.c.nclass == 6) {
                sys2 = 3;
            }
            sys2 = (byte) Util.nextInt(1, 3);
            itemup = ItemTemplate.itemDefault(idI2, sys2);
        } else {
            itemup = ItemTemplate.itemDefault(idI2);
        }
        itemup.sys = sys2;
        byte nextup = 12;
        if (item.id == 384) {
            nextup = 14;
        } else if (item.id == 385) {
            nextup = 16;
        }
        itemup.isLock = item.isLock;
        itemup.upgradeNext(nextup);
        p.c.addItemBag(true, itemup);
        p.c.removeItemBag(index, 1);
    }

    public static void TheBaiKinhNghiemGiaToc(Player p, Item item, byte index) {
        ClanManager clan = ClanManager.getClanName(p.c.clan.clanName);
        if (p.c.isNhanban) {
            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
            return;
        }
        if (clan == null || clan.getMem(p.c.name) == null) {
            p.sendAddchatYellow("Cần có gia tộc để sử dụng");
            return;
        }
        switch (item.id) {
            case 436:
                if (clan.level < 1) {
                    p.sendAddchatYellow("Yêu cầu gia tộc phải đạt cấp 5");
                    return;
                }
                p.upExpClan(Util.nextInt(100, 200));
                p.c.removeItemBag(index, 1);
                break;
            case 437:
                if (clan.level < 10) {
                    p.sendAddchatYellow("Yêu cầu gia tộc phải đạt cấp 10");
                    return;
                }
                p.upExpClan(Util.nextInt(300, 800));
                p.c.removeItemBag(index, 1);
                break;
            default:
                if (item.id != 438) {
                    break;
                }
                if (clan.level < 15) {
                    p.sendAddchatYellow("Yêu cầu gia tộc phải đạt cấp 15");
                    return;
                }
                p.upExpClan(Util.nextInt(1000, 2000));
                p.c.removeItemBag(index, 1);
                break;
        }
    }

    public static void KhaDiLenh(Player p, Item item, byte index) {

        Map map = Manager.getMapid(p.c.mapLTD);
        if (map != null) {
            byte i;
            for (i = 0; i < map.area.length; ++i) {
                if (map.area[i].numplayers < map.template.maxplayers) {
                    p.c.tileMap.leave(p);
                    map.area[i].EnterMap0(p.c);
                    if (item.id == 34) {
                        p.c.removeItemBag(index, 1);
                    }
                    return;
                }
            }
            return;
        }

    }

    public static void VienNgocRong(Player p, Item item, byte index) {
        Message m = null;
        if (p.c.nclass == 0) {
            p.conn.sendMessageLog("Bạn cần nhập học để sử dụng vật phẩm này.");
            return;
        }
        if (p.c.quantityItemyTotal(222) < 1 || p.c.quantityItemyTotal(223) < 1 || p.c.quantityItemyTotal(224) < 1 || p.c.quantityItemyTotal(225) < 1 || p.c.quantityItemyTotal(226) < 1 || p.c.quantityItemyTotal(227) < 1 || p.c.quantityItemyTotal(228) < 1) {
            p.conn.sendMessageLog("Bạn không có đủ 7 viên ngọc rồng 1-7 sao để nhận Yoroi.");
            return;
        }
        
        if (p.c.isNhanban) {
            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
            return;
        }
        if (p.c.getBagNull() < 1) {
            p.sendAddchatYellow(Language.NOT_ENOUGH_BAG);
            return;
        }
        synchronized (LOCK) {
            try {
                m = new Message(-30);
                m.writer().writeByte(-58);
                m.writer().writeInt(p.c.get().id);
                m.writer().flush();
                p.conn.sendMessage(m);
                m.cleanup();
                m = new Message(-30);
                m.writer().writeByte(-57);
                m.writer().flush();
                p.c.tileMap.sendMessage(m);
                m.cleanup();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int i;
        byte count = 0;
        for (i = 222; i <= 228; i++) {
            if (p.c.getIndexBagid(i, false) != -1) {
                p.c.removeItemBag(p.c.getIndexBagid(i, false), 1);
                count++;
            } else {
                p.c.removeItemBag(p.c.getIndexBagid(i, true), 1);
            }
        }
        byte nClassC = p.c.get().nclass;
        if (p.c.isNhanban) {
            nClassC = p.c.clone.nclass;
        }
        p.c.addItemBag(false, ItemTemplate.itemDefault(419 + GameSrc.SysClass(nClassC), count == 7 ? false : true));
        
    }

    public static void HoanLuongChiThao(Player p, Item item, byte index) {
        if (p.c.get().isNhanban) {
            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
            return;
        }
        if (p.c.get().pk > 0) {
            p.c.get().pk -= 5;
            if (p.c.get().pk < 0) {
                p.c.get().pk = 0;
            }
            p.sendAddchatYellow("Điểm hiếu chiến của bạn còn lại là " + p.c.get().pk);
            p.c.removeItemBag(index, 1);
            return;
        }
        p.sendAddchatYellow("Bạn không có điểm hiếu chiến.");
    }

    public static void TuiVai(Player p, Item item, byte index) {
        if (p.c.isNhanban) {
            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
            return;
        }
        byte level = (byte) ((item.id != 215) ? ((item.id != 229) ? 3 : 2) : 1);
        if (level > p.c.levelBag + 1) {
            p.sendAddchatYellow("Cần mở Túi vải cấp " + (p.c.levelBag + 1) + " mới có thể mở được túi vải này.");
            return;
        }
        if (p.c.levelBag >= level) {
            p.sendAddchatYellow("Bạn đã mở túi vải này rồi.");
            return;
        }
        p.c.levelBag = level;
        p.c.maxluggage += UseItem.arrOpenBag[level];
        Item[] bag = new Item[p.c.maxluggage];
        short j;
        for (j = 0; j < p.c.ItemBag.length; ++j) {
            bag[j] = p.c.ItemBag[j];
        }
        (p.c.ItemBag = bag)[index] = null;
        p.openBagLevel(index);
    }

    public static void TayTiemNang(Player p, Item item, byte index) {
        p.c.removeItemBag(index, 1);
        p.c.get().countTayTiemNang++;
        p.sendAddchatYellow("Số lần tẩy điểm tiềm năng tăng thêm 1");
    }

    public static void TayKyNang(Player p, Item item, byte index) {
        p.c.removeItemBag(index, 1);
        p.c.get().countTayKyNang++;
        p.sendAddchatYellow("Số lần tẩy điểm kỹ năng tăng thêm 1");
    }

    public static void RuongNgoc(Player p, Item item, byte index) {
        if (p.c.isNhanban) {
            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
            return;
        }
        if (p.c.getBagNull() == 0) {
            p.conn.sendMessageLog("Hành Trang Không Đủ Chỗ Trống");
            return;
        }
        final short[] arId = {652, 653, 654, 655};
        final short idI = arId[Util.nextInt(arId.length)];
        final Item Itemup = ItemTemplate.itemDefault(idI);
        Itemup.isLock = item.isLock;
        p.c.addItemBag(true, Itemup);
        p.c.removeItemBag(index, 1);
    }

    public static void PhaLe(Player p, Item item, byte index) {
        if (p.c.isNhanban) {
            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
            return;
        }
        int checkID = item.id - 787;
        if (p.c.ItemCaiTrang[checkID] == null) {
            if (p.c.quantityItemyTotal(item.id) < 1000) {
                p.sendAddchatYellow("Bạn không đủ mảnh để ghép.");
                return;
            }
            p.c.removeItemBags(item.id, 1000);
            p.c.ItemCaiTrang[checkID] = ItemTemplate.itemDefault(ItemTemplate.checkIdCaiTrang(checkID));
            p.c.ItemCaiTrang[checkID].upgrade = 1;
            p.c.ItemCaiTrang[checkID].isLock = true;
            p.sendAddchatYellow(ItemTemplate.ItemTemplateId(p.c.ItemCaiTrang[checkID].id).name + " đã được thêm vào bộ sưu tập cải trang.");
        } else {
            if (p.c.ItemCaiTrang[checkID].upgrade >= 10) {
                p.sendAddchatYellow("Cải trang này đã đạt cấp độ tối đa, không thể nâng cấp thêm.");
                return;
            }
            if (p.c.quantityItemyTotal(item.id) < 1000) {
                p.sendAddchatYellow("Bạn không đủ 1000 mảnh để nâng cấp.");
                return;
            }
            p.c.ItemCaiTrang[checkID].UpgradeCaiTrangNext((byte) 1);
            p.c.removeItemBags(item.id, 1000);
            p.sendAddchatYellow(ItemTemplate.ItemTemplateId(p.c.ItemCaiTrang[checkID].id).name + " đã được nâng cấp.");
        }
    }

    public static void HoaTuyet(Player p, Item item, byte index) {
        if (p.c.isNhanban) {
            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
            return;
        }
        int checkID = item.id - 775;
        if (p.c.ItemCaiTrang[checkID] == null) {
            if (p.c.quantityItemyTotal(item.id) < 1000) {
                p.sendAddchatYellow("Bạn không đủ mảnh để ghép.");
                return;
            }
            p.c.removeItemBags(item.id, 1000);
            p.c.ItemCaiTrang[checkID] = ItemTemplate.itemDefault(ItemTemplate.checkIdCaiTrang(checkID));
            p.c.ItemCaiTrang[checkID].upgrade = 1;
            p.c.ItemCaiTrang[checkID].isLock = true;
            p.sendAddchatYellow(ItemTemplate.ItemTemplateId(p.c.ItemCaiTrang[checkID].id).name + " đã được thêm vào bộ sưu tập cải trang.");
        } else {
            if (p.c.ItemCaiTrang[checkID].upgrade >= 10) {
                p.sendAddchatYellow("Cải trang này đã đạt cấp độ tối đa, không thể nâng cấp thêm.");
                return;
            }
            if (p.c.quantityItemyTotal(item.id) < 1000) {
                p.sendAddchatYellow("Bạn không đủ 1000 mảnh để nâng cấp.");
                return;
            }
            p.c.ItemCaiTrang[checkID].UpgradeCaiTrangNext((byte) 1);
            p.c.removeItemBags(item.id, 1000);
            p.sendAddchatYellow(ItemTemplate.ItemTemplateId(p.c.ItemCaiTrang[checkID].id).name + " đã được nâng cấp.");
        }
    }

    public static void NhamThach(Player p, Item item, byte index) {
        if (p.c.isNhanban) {
            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
            return;
        }
        int checkID = item.id - 787;
        if (p.c.ItemCaiTrang[checkID] == null) {
            if (p.c.quantityItemyTotal(item.id) < 1000) {
                p.sendAddchatYellow("Bạn không đủ mảnh để ghép.");
                return;
            }
            p.c.removeItemBags(item.id, 1000);
            p.c.ItemCaiTrang[checkID] = ItemTemplate.itemDefault(ItemTemplate.checkIdCaiTrang(checkID));
            p.c.ItemCaiTrang[checkID].upgrade = 1;
            p.c.ItemCaiTrang[checkID].isLock = true;
            p.sendAddchatYellow(ItemTemplate.ItemTemplateId(p.c.ItemCaiTrang[checkID].id).name + " đã được thêm vào bộ sưu tập cải trang.");
        } else {
            if (p.c.ItemCaiTrang[checkID].upgrade >= 10) {
                p.sendAddchatYellow("Cải trang này đã đạt cấp độ tối đa, không thể nâng cấp thêm.");
                return;
            }
            if (p.c.quantityItemyTotal(item.id) < 1000) {
                p.sendAddchatYellow("Bạn không đủ 1000 mảnh để nâng cấp.");
                return;
            }
            p.c.ItemCaiTrang[checkID].UpgradeCaiTrangNext((byte) 1);
            p.c.removeItemBags(item.id, 1000);
            p.sendAddchatYellow(ItemTemplate.ItemTemplateId(p.c.ItemCaiTrang[checkID].id).name + " đã được nâng cấp.");
        }
    }

    public static void ThiLuyenThiep(Player p, Item item, byte index) {
        final Effect eff = p.c.get().getEffId(34);
        if (eff != null) {
            p.sendAddchatYellow("Chỉ Sử Dụng 1 Cái 1 Lần");
            return;
        } else {
            p.setEffect(34, 0, 18000000, 0);
        }
        p.c.removeItemBag(index, 1);
    }
}
