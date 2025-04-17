/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Item;

import assembly.Item;
import assembly.Option;
import io.Util;

/**
 *
 * @author Administrator
 */
public class RandomOptionsItem {

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
        Util.nextInt(1, 10),
        Util.nextInt(10, 100),
        Util.nextInt(5, 10),
        Util.nextInt(5, 10),
        Util.nextInt(5, 10)};

    public static void RandomOptionsTB2(Item item) {
        if (item.id == ItemName.MAT_NA_HO && !item.isLock || item.id == ItemName.MAT_NA_HO_1 && !item.isLock) {
            byte i;
            int op;
            Option option2;
            for (i = 0; i < Util.nextInt(1, 7); ++i) {
                op = -1;
                do {
                    op = Util.nextInt(OpIdMatNaNew.length);
                    for (Option option : item.options) {
                        if (OpIdMatNaNew[op] == option.id) {
                            op = -1;
                            break;
                        }
                    }
                } while (op == -1);
                if (op == -1) {
                    return;
                }
                int par = ParramOpMatNaNew[op];
                option2 = new Option(OpIdMatNaNew[op], par);
                item.options.add(option2);
            }
        }
    }
}
