/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ItemHandleUse;

import assembly.Char;
import assembly.Item;
import assembly.Language;
import assembly.Player;
import io.Message;
import io.Util;
import java.io.IOException;
import server.Manager;
import template.ItemTemplate;

/**
 *
 * @author Administrator
 */
public class CauCa {

    public static boolean checkWater(Char nj) {
        final int mapId = nj.tileMap.map.id;
        final int x = nj.x;
        final int y = nj.y;
        switch (mapId) {
            case 1:
                if (y == 432 && x >= 755 && x <= 805) {
                    return true;
                }
                break;
            case 2:
                if (y == 264 && x >= 923 && x <= 1021) {
                    return true;
                }
                if (y == 264 && x >= 707 && x <= 805) {
                    return true;
                }
                if (y == 264 && x >= 347 && x <= 469) {
                    return true;
                }
                break;
            case 3:
                if (y == 360 && x >= 35 && x <= 541) {
                    return true;
                }
                if (y == 360 && x >= 1211 && x <= 1408) {
                    return true;
                }
                break;
            case 4:
                if (y == 264 && x >= 2147 && x <= 2557) {
                    return true;
                }
                break;
            case 5:
                if (y == 312 && x >= 659 && x <= 733) {
                    return true;
                }
                break;
            case 6:
                if (y == 1584 && x >= 107 && x <= 325) {
                    return true;
                }
                if (y == 1152 && x >= 155 && x <= 325) {
                    return true;
                }
                break;
            case 7:
                if (y == 312 && x >= 1595 && x <= 1669) {
                    return true;
                }
                if (y == 288 && x >= 2075 && x <= 2173) {
                    return true;
                }
                if (y == 312 && x >= 2939 && x <= 3373) {
                    return true;
                }
                if (y == 312 && x >= 3683 && x <= 4357) {
                    return true;
                }
                if (y == 312 && x >= 4667 && x <= 4693) {
                    return true;
                }
                if (y == 312 && x >= 5507 && x <= 5629) {
                    return true;
                }
                break;
            case 8:
                if (y == 240 && x >= 203 && x <= 1621) {
                    return true;
                }
                break;
            case 9:
                if (y == 288 && x >= 659 && x <= 1813) {
                    return true;
                }
                if (y == 312 && x >= 1283 && x <= 1381) {
                    return true;
                }
                break;
            case 12:
                if (y == 288 && x >= 1091 && x <= 1261) {
                    return true;
                }
                break;
            case 13:
                if (y == 576 && x >= 13 && x <= 301) {
                    return true;
                }
                if (y == 552 && x >= 419 && x <= 853) {
                    return true;
                }
                break;
            case 14:
                if (y == 312 && x >= 467 && x <= 1549) {
                    return true;
                }
                if (y == 264 && x >= 899 && x <= 1069) {
                    return true;
                }
                break;
            case 16:
                if (y == 600 && x >= 59 && x <= 733) {
                    return true;
                }
                break;
            case 17:
                if (y == 312 && x >= 443 && x <= 541) {
                    return true;
                }
                break;
            case 18:
                if (y == 312 && x >= 251 && x <= 301) {
                    return true;
                }
                break;
            case 19:
                if (y == 384 && x >= 611 && x <= 685) {
                    return true;
                }
                break;
            case 20:
                if (y == 312 && x >= 83 && x <= 925) {
                    return true;
                }
                break;
            case 21:
                if (y == 480 && x >= 1067 && x <= 1237) {
                    return true;
                }
                break;
            case 22:
                if (y == 312 && x >= 2315 && x <= 2581) {
                    return true;
                }
                if (y == 288 && x >= 299 && x <= 757) {
                    return true;
                }
                break;
            case 23:
                if (y == 1608 && x >= 35 && x <= 95) {
                    return true;
                }
                if (y == 1488 && x >= 35 && x <= 95) {
                    return true;
                }
                if (y == 1248 && x >= 35 && x <= 95) {
                    return true;
                }
                if (y == 936 && x >= 35 && x <= 95) {
                    return true;
                }
                break;
            case 24:
                if (y == 384 && x >= 155 && x <= 589) {
                    return true;
                }
                break;
            case 25:
                if (y == 288 && x >= 395 && x <= 685) {
                    return true;
                }
                if (y == 312 && x >= 875 && x <= 1285) {
                    return true;
                }
                break;
            case 27:
                if (y == 456 && x >= 155 && x <= 301) {
                    return true;
                }
                if (y == 456 && x >= 1187 && x <= 1333) {
                    return true;
                }
                break;
            case 28:
                if (y == 312 && x >= 203 && x <= 1045) {
                    return true;
                }
                break;
            case 29:
                if (y == 312 && x >= 203 && x <= 1045) {
                    return true;
                }
                break;
            case 32:
                if (y == 240 && x >= 59 && x <= 157) {
                    return true;
                }
                if (y == 240 && x >= 1139 && x <= 1189) {
                    return true;
                }
                break;
            case 36:
                if (y == 384 && x >= 131 && x <= 325) {
                    return true;
                }
                if (y == 384 && x >= 491 && x <= 973) {
                    return true;
                }
                if (y == 384 && x >= 1654 && x <= 1891) {
                    return true;
                }
                break;
            case 38:
                if (y == 360 && x >= 83 && x <= 277) {
                    return true;
                }
                if (y == 360 && x >= 1379 && x <= 1501) {
                    return true;
                }
                if (y == 336 && x >= 1211 && x <= 1237) {
                    return true;
                }
                break;
            case 39:
                if (y == 312 && x >= 240 && x <= 2101) {
                    return true;
                }
                if (y == 312 && x >= 2699 && x <= 2821) {
                    return true;
                }
                break;
            case 48:
                if (y == 480 && x >= 1595 && x <= 1837) {
                    return true;
                }
                break;
            case 58:
                if (y == 312 && x >= 659 && x <= 1333) {
                    return true;
                }
                break;
            case 61:
                if (y == 288 && x >= 731 && x <= 1165) {
                    return true;
                }
                break;
            case 63:
                if (y == 336 && x >= 1691 && x <= 1888) {
                    return true;
                }
                break;
            case 67:
                if (y == 936 && x >= 59 && x <= 685) {
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    public static void Cau(Player p, Item item, byte index) throws IOException {
        Message m;
        if (p.c.isNhanban) {
            p.sendAddchatYellow(Language.NOT_FOR_PHAN_THAN);
            return;
        }
        if (!checkWater(p.c)) {
            p.sendAddchatYellow("Vui lòng tìm nơi có nước để câu.");
            return;
        }
        if (p.c.getBagNull() == 0) {
            p.sendAddchatYellow("Hành trang không đủ chỗ trống");
            return;
        }
        p.c.removeItemBag(index, 1);
        p.sendAddchatYellow("Đang thả câu...");
        p.c.eventPoint += 1;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        if (Util.nextInt(10) < 2) {
            m = new Message(-23);
            m.writer().writeInt(p.c.id);
            m.writer().writeUTF("Bạn vừa câu được Yên . Hãy cố gắng");
            m.writer().flush();
            p.c.tileMap.sendMessage(m);
            m.cleanup();
            p.c.upyenMessage(Util.nextInt(10000, 50000));
        } else if (Util.nextInt(200000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(385, false));
            Manager.chatKTG(p.c.name + " tham gia câu cá đã nhận được " + ItemTemplate.ItemTemplateId(385).name);
        } else if (Util.nextInt(150000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(384, false));
            Manager.chatKTG(p.c.name + " tham gia câu cá đã nhận được " + ItemTemplate.ItemTemplateId(384).name);
        } else if (Util.nextInt(100000) < 1) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(383, false));
            Manager.chatKTG(p.c.name + " tham gia câu cá đã nhận được " + ItemTemplate.ItemTemplateId(383).name);
        } else if (Util.nextInt(50) < 5) {
            short[] arId = {275, 276, 277, 278, 775, 789, 788, 436, 437, 695, 696, 573, 576, 6, 7};
            short idI = arId[Util.nextInt(arId.length)];
            Item itemup = ItemTemplate.itemDefault(idI);
            itemup.isLock = item.isLock;
            p.c.addItemBag(true, itemup);
            m = new Message(-23);
            m.writer().writeInt(p.c.id);
            m.writer().writeUTF("Bạn vừa câu được " + ItemTemplate.ItemTemplateId(idI).name + ". Thật may mắn ");
            m.writer().flush();
            p.c.tileMap.sendMessage(m);
            m.cleanup();
        } else if (Util.percent(100, 100)) {
            p.c.addItemBag(true, ItemTemplate.itemDefault(653, false));
            m = new Message(-23);
            m.writer().writeInt(p.c.id);
            m.writer().writeUTF("Bạn vừa câu được " + ItemTemplate.ItemTemplateId(653).name + ". Thật may mắn");
            m.writer().flush();
            p.c.tileMap.sendMessage(m);
            m.cleanup();
        } else if (Util.nextInt(130) < 130) {
            short[] arId = {652, 653, 654, 655};
            short idI = arId[Util.nextInt(arId.length)];
            Item itemup = ItemTemplate.itemDefault(idI);
            itemup.isLock = item.isLock;
            p.c.addItemBag(true, itemup);
            if (idI == 443 || idI == 485) {
                Manager.chatKTG(p.c.name + " tham gia câu cá đã nhận được " + ItemTemplate.ItemTemplateId(idI).name);
            }
            m = new Message(-23);
            m.writer().writeInt(p.c.id);
            m.writer().writeUTF("Bạn vừa câu được " + ItemTemplate.ItemTemplateId(idI).name + ". Thật may mắn ");
            m.writer().flush();
            p.c.tileMap.sendMessage(m);
            m.cleanup();
        } else {
            m = new Message(-23);
            m.writer().writeInt(p.c.id);
            m.writer().writeUTF("Trượt rồi ! làm lại nhé ! Dừng lại là thất bại");
            m.writer().flush();
            p.c.tileMap.sendMessage(m);
            m.cleanup();
        }
    }

}
