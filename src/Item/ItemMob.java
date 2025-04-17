/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

import assembly.Item;
import assembly.Player;

/**
 *
 * @author Administrator
 */
public class ItemMob {

    public static void ItemMob(Player p, Item item) {
        switch (item.id) {
            case 246: {
                p.mobMeMessage(70, (byte) 0);
                break;
            }
            case 419: {
                p.mobMeMessage(122, (byte) 0);
                break;
            }
            case 840: {
                p.mobMeMessage(97, (byte) 0);
                break;
            }
            case 568: {
                p.setEffect(38, 0, (int) (item.expires - System.currentTimeMillis()), p.c.get().getPramItem(100));
                p.mobMeMessage(205, (byte) 0);
                break;
            }
            case 569: {
                p.setEffect(36, 0, (int) (item.expires - System.currentTimeMillis()), p.c.get().getPramItem(99));
                p.mobMeMessage(206, (byte) 0);
                break;
            }
            case 570: {
                p.setEffect(37, 0, (int) (item.expires - System.currentTimeMillis()), p.c.get().getPramItem(98));
                p.mobMeMessage(207, (byte) 0);
                break;
            }
            case 571: {
                p.setEffect(39, 0, (int) (item.expires - System.currentTimeMillis()), p.c.get().getPramItem(101));
                p.mobMeMessage(208, (byte) 0);
                break;
            }
            case 583: {
                p.mobMeMessage(211, (byte) 1);
                break;
            }
            case 584: {
                p.mobMeMessage(212, (byte) 1);
                break;
            }
            case 585: {
                p.mobMeMessage(213, (byte) 1);
                break;
            }
            case 586: {
                p.mobMeMessage(214, (byte) 1);
                break;
            }
            case 587: {
                p.mobMeMessage(215, (byte) 1);
                break;
            }
            case 588: {
                p.mobMeMessage(216, (byte) 1);
                break;
            }
            case 589: {
                p.mobMeMessage(217, (byte) 1);
                break;
            }
            case 742: {
                p.mobMeMessage(229, (byte) 1);
                break;
            }
            case 744: {
                p.mobMeMessage(229, (byte) 1);
                break;
            }
            case 781: {
                p.mobMeMessage(235, (byte) 1);
                break;
            }
            case 832: {
                p.mobMeMessage(238, (byte) 1);
                break;
            }
            case 847:
                p.mobMeMessage(240, (byte) 1);
                break;
            case 848:
                p.mobMeMessage(239, (byte) 1);
                break;
            case 849:
                p.mobMeMessage(241, (byte) 1);
                break;
            case 850:
                p.mobMeMessage(250, (byte) 1);
                break;
            case 851:
                p.mobMeMessage(251, (byte) 1);
                break;
            case 852:
                p.mobMeMessage(243, (byte) 1);
                break;
            case 853:
                p.mobMeMessage(244, (byte) 1);
                break;
            case 854:
                p.mobMeMessage(245, (byte) 1);
                break;
            case 855:
                p.mobMeMessage(246, (byte) 1);
                break;
        }
    }
}
