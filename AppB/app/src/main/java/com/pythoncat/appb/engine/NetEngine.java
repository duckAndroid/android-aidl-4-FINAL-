package com.pythoncat.appb.engine;

import com.apkfuns.logutils.LogUtils;

/**
 * Created by pythonCat on 2016/9/22 0022.
 *
 * @apiNote can only run on main process !!!
 */

public class NetEngine {

    public static int applyTribe(int yourPid, long groupId, String nick, String iconUrl) {
        LogUtils.w("your pid = " + yourPid);
        LogUtils.e(" apply tribe: groupID = " + groupId + " , nick = " + nick +
                " , iconUrl = " + iconUrl + "\n is Main Process = ");
        return 1024; // 假装需要一个返回值给别人用
    }
}
