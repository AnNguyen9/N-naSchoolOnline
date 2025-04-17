package assembly;

import Item.ItemMob;
import Item.ItemName;
import ItemHandleUse.CauCa;
import ItemHandleUse.ItemHandle;
import Event.ItemHandleEvent;
import io.Message;
import io.Util;
import server.GameSrc;
import server.Manager;
import server.Menu;
import server.Service;
import stream.Server;
import template.ItemTemplate;

import java.io.IOException;

public class UseItem {

    static int[] OpIdMatNaNew = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 87, 57, 58, 94, 127, 128, 129};
    static int[] ParramOpMatNaNew = new int[]{
        Util.nextInt(250, 399),
        Util.nextInt(250, 399),
        Util.nextInt(100, 140),
        Util.nextInt(100, 140),
        Util.nextInt(100, 140),
        Util.nextInt(30, 50),
        Util.nextInt(500, 1500),
        Util.nextInt(500, 1500),
        Util.nextInt(80, 199),
        Util.nextInt(80, 199),
        Util.nextInt(2800, 3500),
        Util.nextInt(60, 100),
        Util.nextInt(10, 20),
        Util.nextInt(10, 100),
        Util.nextInt(5, 10),
        Util.nextInt(5, 10),
        Util.nextInt(5, 10)};
    static int[] arrOp = new int[]{6, 7, 10, 67, 68, 69, 70, 71, 72, 73, 74};
    static int[] arrParam = new int[]{50, 50, 10, 5, 10, 10, 5, 5, 5, 100, 50};
    public static final byte[] arrOpenBag = new byte[]{0, 6, 6, 12};
    public static short[] HanSuDung = new short[]{3, 7};
    public static short[] idItemRuongMayMan = new short[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 7, 7, 7, 242, 280, 436};
    public static short[] idItemRuongTinhXao = new short[]{4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 436, 437, 242, 280, 283, 436, 437, 437, 269};
    public static short[] idItemRuongMaQuai = {3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 618, 619, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 622, 623, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 624, 625, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 626, 627, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 628, 629, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 630, 631, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 632, 633, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 634, 635, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 8, 636, 637, 436, 539, 540, 620, 621};
    public static short[] Do9x = new short[]{618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637};
    public static short[] idItemDieuGiay = new short[]{4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 8, 9, 275, 276, 277, 278, 289, 289, 340, 340, 383, 409, 410, 436, 436, 436, 436, 436, 437, 437, 443, 485, 524, 549, 550, 551, 569, 577, 742};
    public static short[] idItemDieuVai = new short[]{4, 4, 5, 5, 6, 6, 7, 7, 8, 9, 10, 11, 275, 276, 277, 278, 289, 340, 340, 383, 409, 410, 419, 436, 436, 436, 436, 436, 436, 437, 437, 438, 443, 485, 524, 567, 567, 549, 550, 551, 569, 577, 742, 781};
    public static short[] idItemBanhChocolate = new short[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 275, 276, 277, 278, 289, 289, 340, 340, 383, 409, 410, 436, 436, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 437, 443, 485, 524, 549, 550, 551, 549, 550, 551, 569, 574, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 577, 575, 578, 742, 673, 775};
    public static short[] idItemBanhDauTay = new short[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 10, 275, 276, 277, 278, 289, 340, 340, 383, 409, 410, 419, 436, 436, 436, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 436, 437, 437, 438, 443, 485, 524, 567, 567, 549, 550, 551, 549, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 550, 551, 775, 569, 575, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 578, 574, 577, 742, 673, 775, 781};
    public static short[] idItemCayThong = new short[]{8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 549, 549, 549, 549, 550, 550, 551, 551, 436, 436, 437};
    public static short[] idItemTuiQuaGiaToc = new short[]{8, 8, 8, 8, 8, 8, 8, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 242, 242, 242, 283, 436, 436, 437};
    public static short[] idItemHomBlackFriday = new short[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 9, 275, 276, 277, 278, 289, 289, 340, 340, 383, 409, 410, 436, 436, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 437, 443, 485, 524, 549, 550, 551, 549, 550, 551, 569, 574, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 577, 575, 578, 742, 673, 775, 828};

    public static void uesItem(Player p, Item item, byte index) {
        Message m = null;
        try {
            long num2 = Level.getLevel(p.c.level).exps;
            boolean checkExpDown = false;
            if (p.c.expdown > num2 * 30L / 100L) {
                checkExpDown = true;
            }
            if (p.c.isNhanban) {
                num2 = Level.getLevel(p.c.clone.level).exps;
                if (p.c.clone.expdown > num2 * 30L / 100L) {
                    checkExpDown = true;
                }
            }
            if (item == null) {
                return;
            }
            if (ItemTemplate.ItemTemplateId(item.id).level > p.c.get().level) {
                p.sendAddchatYellow("Trình độ không đủ để sử dụng vật phẩm này.");
                return;
            }
            ItemTemplate data = ItemTemplate.ItemTemplateId(item.id);
            if (data.gender != 2 && data.gender != p.c.gender) {
                return;
            }
            if (data.type == 26) {
                p.sendAddchatYellow("Vật phẩm liên quan đến nâng cấp, hãy gặp Kenshinto trong làng để sử dụng.");
                return;
            }
            if (data.level > p.c.get().level || (p.c.isNhanban && data.level > p.c.clone.level)) {
                p.sendAddchatYellow("Trình độ không đủ để sử dụng vật phẩm này.");
                return;
            }
            if (item.id != 194) {
                if ((data.nclass > 0 && data.nclass != p.c.get().nclass)) {
                    p.sendAddchatYellow("Môn phái không phù hợp");
                    return;
                }
            }
            if ((item.id == 420 && GameSrc.SysClass(p.c.get().nclass) != 1) || (item.id == 421 && GameSrc.SysClass(p.c.get().nclass) != 2) || (item.id == 422 && GameSrc.SysClass(p.c.get().nclass) != 3)) {
                p.sendAddchatYellow("Thuộc tính của Yoroi không phù hợp để sử dụng.");
                return;
            }
            if (p.c.isNhanban && item.id == 547) {
                p.sendAddchatYellow("Chức năng này không thể sử dụng cho phân thân.");
                return;
            }
            if (ItemTemplate.isTypeBody(item.id)) {
                //  RandomOptionsItem.RandomOptionsTB2(item);
                Item itemb = null;
                item.isLock = true;
                if (ItemTemplate.isIdNewCaiTrang(item.id) || ItemTemplate.checkIdNewWP(item.id) != -1 || ItemTemplate.checkIdNewMatNa(item.id) != -1 || ItemTemplate.checkIdNewBienHinh(item.id) != -1) {
                    itemb = p.c.get().ItemBody[data.type + 16];
                    p.c.get().ItemBody[data.type + 16] = item;
                } else {
                    itemb = p.c.get().ItemBody[data.type];
                    p.c.get().ItemBody[data.type] = item;
                }
                if (p.c.taskId == 2 && p.c.taskIndex == 0) {
                    p.c.uptaskMaint();
                }
                p.c.ItemBag[index] = itemb;
                if (data.type == 10) {
                    p.mobMeMessage(0, (byte) 0);
                }
                if (itemb != null && (itemb.id == 569)) {
                    p.removeEffect(36);
                }
                if (itemb != null && itemb.id == 568) {
                    p.removeEffect(38);
                }
                if (itemb != null && itemb.id == 570) {
                    p.removeEffect(37);
                }
                if (itemb != null && itemb.id == 571) {
                    p.removeEffect(39);
                }
                ItemMob.ItemMob(p, item);
                m = new Message(11);
                m.writer().writeByte(index);
                m.writer().writeByte(p.c.get().speed());
                m.writer().writeInt(p.c.get().getMaxHP());
                m.writer().writeInt(p.c.get().getMaxMP());
                m.writer().writeShort(p.c.get().eff5buffHP());
                m.writer().writeShort(p.c.get().eff5buffMP());
                m.writer().flush();
                p.conn.sendMessage(m);
                m.cleanup();
                if ((item.id >= 795 && item.id <= 805) || (item.id >= 813 && item.id <= 817) || (item.id >= 825 && item.id <= 826) || (item.id >= 829 && item.id <= 830 || item.id == 839 || item.id >= 843 && item.id <= 846 || (item.id >= 858 && item.id <= 866) || item.id == 892 || (item.id >= 881 && item.id <= 883) || item.id == 894)) {
                    final Message m1 = new Message(57);
                    m1.writer().flush();
                    p.conn.sendMessage(m1);
                    m1.cleanup();
                    if (!p.c.isTrade) {
                        Service.CharViewInfo(p, false);
                    }
                }
            } else if (ItemTemplate.isTypeMounts(item.id)) {
                byte idM = (byte) (data.type - 29);
                Item itemM = p.c.get().ItemMounts[idM];
                if (idM == 4) {
                    if (p.c.get().ItemMounts[0] != null || p.c.get().ItemMounts[1] != null || p.c.get().ItemMounts[2] != null || p.c.get().ItemMounts[3] != null) {
                        p.conn.sendMessageLog("Bạn cần phải tháo trang bị và thú cưỡi đang sử dụng.");
                        return;
                    }
                    if (!item.isLock) {
                        byte i;
                        int op;
                        Option option2;
                        for (i = 0; i < 4; ++i) {
                            op = -1;
                            do {
                                op = Util.nextInt(UseItem.arrOp.length);
                                for (Option option : item.options) {
                                    if (UseItem.arrOp[op] == option.id) {
                                        op = -1;
                                        break;
                                    }
                                }
                            } while (op == -1);
                            if (op == -1) {
                                return;
                            }
                            int par = UseItem.arrParam[op];
                            if (item.isExpires) {
                                par *= 10;
                            }
                            option2 = new Option(UseItem.arrOp[op], par);
                            item.options.add(option2);
                        }
                    }

                    if (p.c.clone != null && p.c.isNhanban) {
                        if (item.id == 801) {
                            p.c.clone.ID_HORSE = 47;
                        }
                        if (item.id == 802) {
                            p.c.clone.ID_HORSE = 48;
                        }
                        if (item.id == 803) {
                            p.c.clone.ID_HORSE = 49;
                        }
                        if (item.id == 798) {
                            p.c.clone.ID_HORSE = 36;
                        }
                        if (item.id == 828) {
                            p.c.clone.ID_HORSE = 63;
                        }
                        Service.CharViewInfo(p, false);
                    }
                } else if (p.c.get().ItemMounts[4] == null) {
                    p.conn.sendMessageLog("Bạn cần phải tháo trang bị thú cưỡi đang sử dụng.");
                    return;
                }
                item.isLock = true;
                p.c.ItemBag[index] = itemM;
                p.c.get().ItemMounts[idM] = item;
                m = new Message(11);
                m.writer().writeByte(index);
                m.writer().writeByte(p.c.get().speed());
                m.writer().writeInt(p.c.get().getMaxHP());
                m.writer().writeInt(p.c.get().getMaxMP());
                m.writer().writeShort(p.c.get().eff5buffHP());
                m.writer().writeShort(p.c.get().eff5buffMP());
                m.writer().flush();
                p.conn.sendMessage(m);
                m.cleanup();
                if (ItemTemplate.isTypeMounts(item.id)) {
                    Player player;
                    for (int i = p.c.tileMap.players.size() - 1; i >= 0; i--) {
                        player = p.c.tileMap.players.get(i);
                        if (player != null && player.c != null) {
                            p.c.tileMap.sendMounts(p.c.get(), player);
                        }
                    }
                }
            } else if (data.skill > 0) {
                byte skill = data.skill;
                if (item.id == 547) {
                    skill += p.c.get().nclass;
                }
                p.openBookSkill(index, skill);
                return;
            } else {
                byte numbagnull = p.c.getBagNull();
                switch (item.id) {
                    case 13: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffHP(25)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 14: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffHP(90)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 15: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffHP(230)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 16: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffHP(400)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 17: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffHP(650)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 565: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffHP(1500)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 18: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffMP(150)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 19: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffMP(500)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 20: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffMP(1000)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 21: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffMP(2000)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 22: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffMP(3500)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 566: {
                        if (p.c.pk > 10 || checkExpDown) {
                            p.sendAddchatYellow(Language.MAX_EXP_DOWN);
                            return;
                        }
                        if (p.buffMP(5000)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 23: {
                        // Nhiệm vụ dùng thức ăn
                        if (p.c.taskId == 3 && p.c.taskIndex == 1) {
                            p.c.uptaskMaint();
                        }
                        if (p.dungThucan((byte) 0, 3, 1800)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 24: {
                        if (p.dungThucan((byte) 1, 20, 1800)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 25: {
                        if (p.dungThucan((byte) 2, 30, 1800)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 26: {
                        if (p.dungThucan((byte) 3, 40, 1800)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 27: {
                        if (p.dungThucan((byte) 4, 50, 1800)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 29: {
                        if (p.dungThucan((byte) 28, 60, 1800)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 30: {
                        if (p.dungThucan((byte) 28, 60, 259200)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 249: {
                        if (p.dungThucan((byte) 3, 40, 259200)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 250: {
                        if (p.dungThucan((byte) 4, 50, 259200)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 409: {
                        if (p.dungThucan((byte) 30, 75, 86400)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 410: {
                        if (p.dungThucan((byte) 31, 90, 86400)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 567: {
                        if (p.dungThucan((byte) 35, 120, 86400)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
//                    case ItemName.CHUOT_CANH_TY: {
//                        p.c.tileMap.Callmob(p.c.x, p.c.y, p, (short) 231);
//                        p.c.removeItemBag(index, 1);
//                        break;
//                    }
                    case ItemName.HOM_MAY_MAN:
                        ItemHandle.HomMayMan(p, item, index);
                        break;
                    case ItemName.HOP_BANH_THUONG:
                        ItemHandleEvent.hopbanhthuong(p, item, index);
                        break;
                    case ItemName.HOP_BANH_THUONG_HANG:
                        ItemHandleEvent.hopbanhthuonghang(p, item, index);
                        break;
                    case ItemName.KEO_TAO:
                        ItemHandleEvent.KeoTao(p, item, index);
                        break;
                    case ItemName.HOP_MA_QUY:
                        ItemHandleEvent.HopMaQuy(p, item, index);
                        break;
                    case ItemName.RUONG_NGOC:
                        ItemHandle.RuongNgoc(p, item, index);
                        break;
                    case 548:
                        CauCa.Cau(p, item, index);
                        break;
                    case 34:
                    case 36:
                        ItemHandle.KhaDiLenh(p, item, index);
                        break;
                    case 257:
                        ItemHandle.HoanLuongChiThao(p, item, index);
                        break;
                    case 222:
                    case 223:
                    case 224:
                    case 225:
                    case 226:
                    case 227:
                    case 228:
                        ItemHandle.VienNgocRong(p, item, index);
                        break;
                    case 215:
                    case 229:
                    case 283:
                        ItemHandle.TuiVai(p, item, index);
                        break;

                    case 240: {
                        ItemHandle.TayTiemNang(p, item, index);
                        break;
                    }
                    case 241: {
                        ItemHandle.TayKyNang(p, item, index);
                        break;
                    }
                    case 219:
                        if (p.c.taskIndex == 1) {
                            if (p.c.taskId == 19 || p.c.taskId == 35) {
                                if ((p.c.tileMap.map.id == 63 && p.c.taskId == 19 && p.c.x >= 1691 && p.c.x <= 1885 && p.c.y == 336)
                                        || (p.c.tileMap.map.id == 24 && p.c.taskId == 35 && p.c.x >= 155 && p.c.x <= 589 && p.c.y == 384)) {
                                    Service.sendWait(p.c, "Chờ");
                                    Thread.sleep(2000L);
                                    Service.ENDWait(p.c);
                                    if (p.c.hp >= p.c.hp) {
                                        p.c.removeItemBags(219, 1);
                                        p.c.addItemBag(true, ItemTemplate.itemDefault(220, true));
                                        p.c.uptaskMaint();
                                    }
                                } else {
                                    p.sendAddchatYellow("Không đúng vị trí để lấy nước hãy đến " + (p.c.taskId == 19 ? "Hang Ha" : "Đỉnh IChidai") + " để múc nước");
                                    Service.ENDWait(p.c);
                                }
                            }
                        }
                        break;
                    case 231:
                        if (p.c.taskId == 23 && p.c.taskIndex == 1 && p.c.x >= 1787 && p.c.x <= 1861 && p.c.y == 432) {
                            p.c.removeItemBag(index, 1);
                            p.c.uptaskMaint();
                        } else {
                            p.sendAddchatYellow("Không đúng địa điểm để vào địa đạo, hãy tìm nơi có nhiều đầu lâu nhất để sử mở khoá địa đạo");
                        }
                        break;
                    case 234:
                        if (p.c.taskId == 24 && p.c.taskIndex == 1 && p.c.x >= 1216 && p.c.x <= 1321 && p.c.y == 432) {
                            Service.sendWait(p.c, "Chờ");
                            Thread.sleep(2000L);
                            Service.ENDWait(p.c);
                            if (Util.percent(100, 10)) {
                                p.c.removeItemBags(234, 1);
                                p.c.uptaskMaint();
                            } else {
                                p.sendAddchatYellow("Báu vật đang ở đây đào sâu thêm xíu nữa");
                                Service.ENDWait(p.c);
                            }
                        } else {
                            Server.manager.sendTB(p, "Hướng Dẫn", "Hãy đến khu rừng có cua biển để tìm kho báu theo bức hình");
                            Service.ENDWait(p.c);
                        }
                        break;
                    case 266:
                        if (p.c.taskIndex == 1 && p.c.taskId == 32) {
                            if (p.c.x >= 83 && p.c.x <= 277 && p.c.y == 360) {
                                // TODO CAU VAT PHAM
                                Service.sendWait(p.c, "Đang đào");
                                Thread.sleep(2000L);
                                Service.ENDWait(p.c);
                                if (Util.percent(100, 5)) {
                                    p.c.removeItemBags(266, 1);
                                    p.c.addItemBag(true, ItemTemplate.itemDefault(267, true));
                                    p.c.uptaskMaint();
                                } else {
                                    p.sendAddchatYellow((Util.nextInt(0, 1) == 0) ? "Cần cù bù siêng năng lần này thất bại rồi" : "Dừng lại là thất bại . Ráng tìm tiếp đi con");
                                }
                            } else {
                                p.sendAddchatYellow("Hãy tìm vật phẩm ở cái hồ dưới chân ta");
                                Service.ENDWait(p.c);
                            }
                        }
                        break;

                    case 248: {
                        Effect eff = p.c.get().getEffId(22);
                        if (eff != null) {
                            long time = eff.timeRemove + 18000000L;
                            p.setEffect(22, 0, (int) (time - System.currentTimeMillis()), 2);
                        } else {
                            p.setEffect(22, 0, 18000000, 2);
                        }
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 251: {
                        if (item.quantity < 300) {
                            p.sendAddchatYellow("Bạn cần ít nhất 300 mảnh giấy vụn mới có thể sử dụng.");
                            return;
                        }
                        if (numbagnull == 0) {
                            p.conn.sendMessageLog("Hành trang không đủ chỗ trống.");
                            return;
                        }
                        p.typemenu = -125;
                        Menu.doMenuArray(p, new String[]{"Sách kỹ năng sơ", "Sách tiềm năng sơ"});
                        break;
                    }
                    case 252: { // sách kỹ năng 
                        if (p.c.get().isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.useKyNang < 3) {
                            p.c.useKyNang++;
                            p.c.spoint += 1;
                            p.loadSkill();
                            p.c.removeItemBag(index, 1);
                            p.sendAddchatYellow("Bạn nhận được 1 điểm kỹ năng.");
                        } else {
                            p.sendAddchatYellow("Bạn chỉ được học 3 lần.");
                        }
                        break;
                    }
                    case 253: { // sách tiềm năng
                        if (p.c.get().isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.useTiemNang < 8) {
                            p.c.useTiemNang++;
                            p.c.ppoint += 10;
                            p.loadPpoint();
                            p.c.removeItemBag(index, 1);
                            p.sendAddchatYellow("Bạn nhận được 10 điểm tiềm năng.");
                        } else {
                            p.sendAddchatYellow("Bạn chỉ được học 8 lần.");
                        }
                        break;
                    }
                    case 254:
                    case 255: {
                        if (p.c.expdown == 0) {
                            p.conn.sendMessageLog("Bạn không có kinh nhiệm âm để sử dụng vật phẩm này!");
                            return;
                        }
                        if (item.id == 254 && p.c.level >= 30) {
                            p.conn.sendMessageLog("Trình độ của bạn không phù hợp để sử dụng vật phẩm này.");
                            return;
                        }
                        if (item.id == 255 && (p.c.level < 30 || p.c.level >= 60)) {
                            p.conn.sendMessageLog("Trình độ của bạn không phù hợp để sử dụng vật phẩm này.");
                            return;
                        }
                        p.updateExp(p.c.expdown);
                        p.sendAddchatYellow("Kinh nghiệm âm của bạn đã được xoá.");
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 261: {
                        if (p.c.isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (!p.c.tileMap.map.mapLDGT()) {
                            p.sendAddchatYellow("Vật phẩm chỉ có thể được dùng trong Lãnh Địa Gia Tộc.");
                            return;
                        }
                        p.setEffect(23, 0, 300000, 2000);
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 263: {
                        if (p.c.isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        int per = Util.nextInt(UseItem.idItemTuiQuaGiaToc.length);
                        p.c.addItemBag(true, ItemTemplate.itemDefault(UseItem.idItemTuiQuaGiaToc[per]));
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 268: {
                        if (p.c.isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.useTaThuLenh == 0) {
                            p.conn.sendMessageLog("Số lần sử dụng lệnh bài hang động của bạn hôm nay đã hết.");
                            return;
                        }
                        p.c.useTaThuLenh--;
                        p.c.countTaskTaThu -= 2;
                        p.sendAddchatYellow("Số lần nhận nhiệm vụ tà thú tăng thêm 2 lần");
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 275: {
                        p.setEffect(24, 0, 600000, 500);
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 276: {
                        p.setEffect(25, 0, 600000, 500);
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 277: {
                        p.setEffect(26, 0, 600000, 100);
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 278: {
                        p.setEffect(27, 0, 600000, 1000);
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 280: {
                        if (p.c.useCave == 0) {
                            p.conn.sendMessageLog("Số lần sử dụng lệnh bài hang động của bạn hôm nay đã hết.");
                            return;
                        }
                        p.c.nCave++;
                        p.c.useCave--;
                        p.sendAddchatYellow("Số lần vào hang động tăng thêm 1 lần, hôm nay bạn chỉ cần có thể sử dụng lệnh bài " + p.c.useCave + " lần");
                        p.c.removeItemBag(index, 1);
                        break;
                    }

                    case 288:
                        if (p.c.isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (numbagnull == 0) {
                            p.conn.sendMessageLog("Hành trang không đủ chỗ trống.");
                            return;
                        }
                        p.c.removeItemBag(index, 1);
                        if (p.c.taskId == 40 && p.c.taskIndex == 2) {
                            p.c.uptaskMaint();
                        }
                        break;

                    case 272: {
                        if (numbagnull == 0) {
                            p.conn.sendMessageLog("Hành trang không đủ chỗ trống.");
                            return;
                        }
                        p.c.removeItemBag(index, 1);
                        if (Util.nextInt(3) == 0) {
                            int num = Util.nextInt(10000, 30000);
                            p.c.upyenMessage(num);
                            p.sendAddchatYellow("Bạn nhận được " + num + " yên");
                        } else {
                            short idI = UseItem.idItemRuongMayMan[Util.nextInt(UseItem.idItemRuongMayMan.length)];
                            ItemTemplate data2 = ItemTemplate.ItemTemplateId(idI);
                            Item itemup;
                            if (data2.type < 10) {
                                if (data2.type == 1) {
                                    itemup = ItemTemplate.itemDefault(idI);
                                    itemup.sys = GameSrc.SysClass(data2.nclass);
                                } else {
                                    byte sys = (byte) Util.nextInt(1, 3);
                                    itemup = ItemTemplate.itemDefault(idI, sys);
                                }
                            } else {
                                itemup = ItemTemplate.itemDefault(idI);
                            }
                            itemup.isLock = item.isLock;
                            int idOp2;
                            for (Option Option : itemup.options) {
                                idOp2 = Option.id;
                                Option.param = Util.nextInt(item.getOptionShopMin(idOp2, Option.param), Option.param);
                            }
                            p.c.addItemBag(true, itemup);
                        }
                        break;
                    }

                    case 282: {
                        if (numbagnull == 0) {
                            p.conn.sendMessageLog("Hành trang không đủ chỗ trống.");
                            return;
                        }
                        if (p.c.taskId == 40 && p.c.taskIndex == 1) {
                            p.c.uptaskMaint();
                        }
                        if (Util.nextInt(3) == 0) {
                            int num = Util.nextInt(10000, 30000);
                            p.c.upyenMessage(num);
                            p.sendAddchatYellow("Bạn nhận được " + num + " yên");
                        } else {
                            short idI = UseItem.idItemRuongTinhXao[Util.nextInt(UseItem.idItemRuongTinhXao.length)];
                            ItemTemplate data2 = ItemTemplate.ItemTemplateId(idI);
                            Item itemup;

                            if (data2.type < 10) {
                                if (data2.type == 1) {
                                    itemup = ItemTemplate.itemDefault(idI);
                                    itemup.sys = GameSrc.SysClass(data2.nclass);
                                } else {
                                    byte sys = (byte) Util.nextInt(1, 3);
                                    itemup = ItemTemplate.itemDefault(idI, sys);
                                }
                            } else {
                                itemup = ItemTemplate.itemDefault(idI);
                            }
                            itemup.isLock = item.isLock;
                            // set Options Random Cho Item
                            for (Option Option : itemup.options) {
                                int idOp2 = Option.id;
                                Option.param = Util.nextInt(item.getOptionShopMin(idOp2, Option.param), Option.param);
                            }
                            p.c.addItemBag(true, itemup);
                        }
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 595:  // tín vật
                        //  ItemHandleEvent.TinVat(p, item, index);
                        break;
                    case 848: {
                        byte i;
                        Item it = p.c.get().ItemMounts[4];
                        if (p.c.get().isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (it == null) {
                            p.sendAddchatYellow("Bạn Chưa Có Thú Cưỡi.");
                            return;
                        }
                        if (it.upgrade < 99 && it.sys < 4) {
                            p.sendAddchatYellow("Yêu Cầu Thú Cưỡi 5 Sao.");
                            return;
                        } else {
                            for (i = 0; i < it.options.size(); ++i) {
                                if (it.options.get(i).id == 57) {
                                    p.sendAddchatYellow("Thú Cưỡi Đã Được Khai Mở.");
                                    return;
                                }
                            }
                            if (Util.nextInt(500) < 5) {
                                Option op = new Option(57, Util.nextInt(50, 100));
                                p.c.ItemMounts[4].options.add(op);
                                p.sendAddchatYellow("Khai Mở Thành Công");
                                Manager.serverChat("Thông Báo", " Chúc Mừng " + p.c.name + " Đã Khai Mở Thú Cưỡi Thành Công");
                                p.loadMounts();
                            } else {
                                p.sendAddchatYellow("Khai Mở Thất Bại");
                            }
                            p.c.removeItemBag(index, 1);
                            break;
                        }
                    }
                    case 775: {
                        ItemHandle.HoaTuyet(p, item, index);
                        break;
                    }
                    case 788: {
                        ItemHandle.NhamThach(p, item, index);
                        break;
                    }
                    case 789: {
                        ItemHandle.PhaLe(p, item, index);
                        break;
                    }
                    case 308: {
                        if (p.c.get().isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.useBanhPhongLoi < 10) {
                            p.c.useBanhPhongLoi++;
                            p.c.spoint += 1;
                            p.loadSkill();
                            p.c.removeItemBag(index, 1);
                            p.sendAddchatYellow("Bạn nhận được 1 điểm kỹ năng.");
                        } else {
                            p.sendAddchatYellow("Bạn chỉ được học 10 lần.");
                        }
                        break;
                    }
                    case 309: {
                        if (p.c.get().isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.useBanhBangHoa < 10) {
                            p.c.useBanhBangHoa++;
                            p.c.ppoint += 10;
                            p.loadPpoint();
                            p.c.removeItemBag(index, 1);
                            p.sendAddchatYellow("Bạn nhận được 10 điểm tiềm năng.");
                        } else {
                            p.sendAddchatYellow("Bạn chỉ được học 10 lần.");
                        }
                        break;
                    }
                    case 383:
                    case 384:
                    case 385:  // Bát Bảo
                        ItemHandle.RuongHuyenBiBatBaoBachNgan(p, item, index);
                        break;
                    case 436:
                    case 437:
                    case 438:
                        ItemHandle.TheBaiKinhNghiemGiaToc(p, item, index);
                        break;
                    case 454: {
                        if (p.updateSysMounts()) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 490: {
                        if (p.c.isNhanban) {
                            p.conn.sendMessageLog(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.level > 130) {
                            p.conn.sendMessageLog("Trình độ trên Level 130 Không thể tham gia làng cổ.");
                            return;
                        }
                        if (p.c.pk > 0) {
                            p.conn.sendMessageLog("Không thể vào làng cổ khi có điểm hiếu chiến lớn hơn 0");
                            return;
                        }
                        p.c.removeItemBag(index, 1);
                        p.c.tileMap.leave(p);
                        Map map = Server.maps[138];
                        byte k;
                        for (k = 0; k < map.area.length; k++) {
                            if (map.area[k].numplayers < map.template.maxplayers) {
                                map.area[k].EnterMap0(p.c);
                                break;
                            }
                        }
                        p.endLoad(true);
                        break;
                    }
                    case 884: {
                        ItemHandle.VungDatBiAn(p, item, index);
                        break;
                    }
                    case 543: {
                        if (p.c.isNhanban) {
                            p.conn.sendMessageLog(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        p.c.removeItemBag(index, 1);
                        p.c.tileMap.leave(p);
                        Map map = Server.maps[113];
                        byte k;
                        for (k = 0; k < map.area.length; k++) {
                            if (map.area[k].numplayers < map.template.maxplayers) {
                                map.area[k].EnterMap0(p.c);
                                break;
                            }
                        }
                        p.endLoad(true);
                        break;
                    }
                    case 537: {
                        if (p.c.get().getEffId(40) == null) {
                            p.setEffect(41, 0, 7200000, 0);
                            p.c.removeItemBag(index, 1);
                        } else {
                            p.sendAddchatYellow("Bạn đã có hiệu quả cao hơn");
                        }
                        break;
                    }
                    case 564:
                        ItemHandle.ThiLuyenThiep(p, item, index);
                        break;
                    case 538: {
                        p.setEffect(40, 0, 18000000, 0);
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 539: {
                        p.setEffect(32, 0, 3600000, 3);
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 540: {
                        p.setEffect(33, 0, 3600000, 4);
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 549:
                    case 550:
                    case 551: {
                        long yenup = 0L;
                        yenup = (Util.nextInt(10000, 30000));
                        if (item.id == 550) {
                            yenup = (Util.nextInt(20000, 50000));
                        }
                        if (item.id == 551) {
                            yenup = (Util.nextInt(30000, 100000));
                        }
                        p.c.upyenMessage(yenup);
                        p.sendAddchatYellow("Bạn nhận được " + yenup + " yên.");
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 449: {
                        if (p.updateXpMounts(5, (byte) 0)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 450: {
                        if (p.updateXpMounts(7, (byte) 0)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 451: {
                        if (p.updateXpMounts(14, (byte) 0)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 452: {
                        if (p.updateXpMounts(20, (byte) 0)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 453: {
                        if (p.updateXpMounts(25, (byte) 0)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    
                    case 573: {
                        if (p.updateXpMounts(200, (byte) 0)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 574: {
                        if (p.updateXpMounts(400, (byte) 0)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 575: {
                        if (p.updateXpMounts(600, (byte) 0)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 778: { // exp trâu + bạch hổ
                        if (p.updateXpMounts(10, (byte) 2)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 576: {
                        if (p.updateXpMounts(100, (byte) 1)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 577: {
                        if (p.updateXpMounts(250, (byte) 1)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 578: {
                        if (p.updateXpMounts(500, (byte) 1)) {
                            p.c.removeItemBag(index, 1);
                        }
                        break;
                    }
                    case 891:
                        ItemHandle.RuongHuyenThoai(p, item, index);
                        break;
                    case 279:
                        Service.sendInputDialog(p, (short) 1, "Tên Nhân Vật Cần Đến");
                        break;
                    case 647: {
                        if (numbagnull == 0) {
                            p.conn.sendMessageLog("Hành trang không đủ chỗ trống.");
                            return;
                        }
                        p.c.removeItemBag(index, 1);
                        if (Util.nextInt(200) < 1) {
                            p.c.addItemBag(true, ItemTemplate.itemDefault(222, false));
                        } else if (Util.nextInt(400) < 1) {
                            p.c.addItemBag(true, ItemTemplate.itemDefault(223, false));
                        } else if (Util.nextInt(600) < 1) {
                            p.c.addItemBag(true, ItemTemplate.itemDefault(224, false));
                        } else if (Util.nextInt(800) < 1) {
                            p.c.addItemBag(true, ItemTemplate.itemDefault(225, false));
                        } else if (Util.nextInt(1000) < 1) {
                            p.c.addItemBag(true, ItemTemplate.itemDefault(226, false));
                        } else if (Util.nextInt(1500) < 1) {
                            p.c.addItemBag(true, ItemTemplate.itemDefault(227, false));
                        } else if (Util.nextInt(2000) < 1) {
                            p.c.addItemBag(true, ItemTemplate.itemDefault(228, false));
                        } else if (Util.nextInt(10) < 8) {
                            int num = Util.nextInt(10000, 100000);
                            p.c.upyenMessage(num);
                            p.sendAddchatYellow("Bạn nhận được " + num + " yên");
                            short idI = UseItem.idItemRuongMaQuai[Util.nextInt(UseItem.idItemRuongMaQuai.length)];
                            ItemTemplate data2 = ItemTemplate.ItemTemplateId(idI);
                            Item itemup;
                            if (p.c.taskId == 40 && p.c.taskIndex == 1) {
                                p.c.uptaskMaint();
                            }
                            if (data2.type < 10) {
                                if (data2.type == 1) {
                                    itemup = ItemTemplate.itemDefault(idI);
                                    itemup.sys = GameSrc.SysClass(data2.nclass);
                                } else {
                                    byte sys = (byte) Util.nextInt(1, 3);
                                    itemup = ItemTemplate.itemDefault(idI, sys);
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
                        break;
                    }

                    case 695:
                    case 696:
                    case 697:
                    case 698:
                    case 699:
                    case 700:
                    case 701:
                    case 702:
                    case 703:
                    case 704: {
                        if (p.c.isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.getBagNull() < 1) {
                            p.sendAddchatYellow(Language.NOT_ENOUGH_BAG);
                            return;
                        }
                        if (item.id == 704) {
                            p.sendAddchatYellow("Vật phẩm đã đạt cấp độ tối đa.");
                            return;
                        }
                        if (item.quantity < 10) {
                            p.sendAddchatYellow("Bạn cần đủ 10 viên đá để nâng cấp.");
                            return;
                        }
                        int quantity = item.quantity;
                        int plus = item.quantity / 10;
                        p.c.removeItemBag((byte) index, quantity - quantity % 10);
                        Item itemUp = ItemTemplate.itemDefault(item.id + 1, item.isLock);
                        itemUp.quantity = plus;
                        p.c.addItemBag(true, itemUp);
                        break;
                    }
                    case 705: {
                        if (p.c.isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.useDanhVongPhu == 0) {
                            p.conn.sendMessageLog("Số lần sử dụng Danh vọng phú của bạn hôm nay đã hết.");
                            return;
                        }
                        p.c.useDanhVongPhu--;
                        p.c.countTaskDanhVong += 5;
                        p.sendAddchatYellow("Số lần nhận nhiệm vụ Danh vọng tăng thêm 5 lần");
                        p.c.removeItemBag(index, 1);
                        break;
                    }
                    case 733:
                    case 734:
                    case 735:
                    case 736:
                    case 737:
                    case 738:
                    case 739:
                    case 740:
                    case 741: {
                        if (p.c.isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.gender == 0) {
                            p.sendAddchatYellow("Giới tính không phù hợp.");
                            return;
                        }
                        int checkID = item.id - 733;
                        if (p.c.quantityItemyTotal(item.id) < 1000) {
                            p.sendAddchatYellow("Bạn không đủ 1000 mảnh để ghép.");
                            return;
                        }
                        p.c.addItemBag(true, ItemTemplate.itemDefault(ItemTemplate.checkIdJiraiNam(checkID)));
                        p.c.removeItemBags(item.id, 1000);
                        break;
                    }
                    case 420:
                    case 421:
                    case 422: {
                        if (p.c.mapid == 111 || p.c.mapid == 133) {
                    p.sendAddchatYellow("Không thể sử dụng vật phẩm này tại đây");
                    return;
                         }break;
                    }
                    case 760:
                    case 761:
                    case 762:
                    case 763:
                    case 764:
                    case 765:
                    case 766:
                    case 767:
                    case 768: {
                        if (p.c.isNhanban) {
                            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
                            return;
                        }
                        if (p.c.gender == 1) {
                            p.sendAddchatYellow("Giới tính không phù hợp.");
                            return;
                        }
                        int checkID = item.id - 760;
                        if (p.c.quantityItemyTotal(item.id) < 1000) {
                            p.sendAddchatYellow("Bạn không đủ 1000 mảnh để ghép.");
                            return;
                        }
                        p.c.addItemBag(true, ItemTemplate.itemDefault(ItemTemplate.checkIdJiraiNu(checkID)));
                        p.c.removeItemBags(item.id, 1000);
                        break;
                    }
                    default: {
                        break;
                    }
                }
                return;
            }
            if (ItemTemplate.checkIdNewItems(item.id)) {
                if (ItemTemplate.checkIdNewWP(item.id) != -1) {
                    p.c.get().ID_WEA_PONE = ItemTemplate.idNewItemWP[1][ItemTemplate.checkIdNewWP(item.id)];
                }
                if (ItemTemplate.checkIdNewMatNa(item.id) != -1) {
                    p.c.get().ID_MAT_NA = ItemTemplate.idNewItemMatNa[1][ItemTemplate.checkIdNewMatNa(item.id)];
                }
                if (ItemTemplate.checkIdNewYoroi(item.id) != -1) {
                    p.c.get().ID_PP = ItemTemplate.idNewItemYoroi[1][ItemTemplate.checkIdNewYoroi(item.id)];
                }
                if (ItemTemplate.checkIdNewMounts(item.id) != -1) {
                    p.c.get().ID_HORSE = ItemTemplate.idNewItemMounts[1][ItemTemplate.checkIdNewMounts(item.id)];
                }
                if (ItemTemplate.checkIdNewBienHinh(item.id) != -1) {
                    p.c.get().ID_Bien_Hinh = ItemTemplate.idNewItemBienHinh[1][ItemTemplate.checkIdNewBienHinh(item.id)];
                }
                if (ItemTemplate.checkIdNewCaiTrang(item.id) != -1) {
                    p.c.get().ID_HAIR = ItemTemplate.idNewItemCaiTrang[1][ItemTemplate.checkIdNewCaiTrang(item.id)];
                    p.c.get().ID_Body = ItemTemplate.idNewItemCaiTrang[2][ItemTemplate.checkIdNewCaiTrang(item.id)];
                    p.c.get().ID_LEG = ItemTemplate.idNewItemCaiTrang[3][ItemTemplate.checkIdNewCaiTrang(item.id)];
                }
                p.sendInfoMeNewItem();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (m != null) {
                m.cleanup();
            }
        }
    }

    public static void useItemChangeMap(Player p, Message m) {
        try {
            byte indexUI = m.reader().readByte();
            byte indexMenu = m.reader().readByte();
            m.cleanup();
            Item item = p.c.ItemBag[indexUI];
            if (item != null && (item.id == 37 || item.id == 35)) {
                if (p.c.mapid == 111 || p.c.mapid == 133) {
                    p.sendAddchatYellow("Không thể sử dụng vật phẩm này tại đây");
                    return;
                }
                if (item.id != 37) {
                    p.c.removeItemBag(indexUI);
                }
                if (indexMenu == 0 || indexMenu == 1 || indexMenu == 2) {
                    Map ma = Manager.getMapid(Map.arrTruong[indexMenu]);
                    if (ma == null) {
                        return;
                    }
                    for (TileMap area : ma.area) {
                        if (area.numplayers < ma.template.maxplayers) {
                            p.c.tileMap.leave(p);
                            area.EnterMap0(p.c);
                            return;
                        }
                    }
                }
                if (indexMenu == 3 || indexMenu == 4 || indexMenu == 5 || indexMenu == 6 || indexMenu == 7 || indexMenu == 8 || indexMenu == 9) {
                    Map ma = Manager.getMapid(Map.arrLang[indexMenu - 3]);
                    if (ma == null) {
                        return;
                    }
                    for (TileMap area : ma.area) {
                        if (area.numplayers < ma.template.maxplayers) {
                            p.c.tileMap.leave(p);
                            area.EnterMap0(p.c);
                            return;
                        }
                    }
                }
            }
            p.c.get().upDie();
        } catch (IOException ex) {
        } finally {
            if (m != null) {
                m.cleanup();
            }
        }

    }
}
