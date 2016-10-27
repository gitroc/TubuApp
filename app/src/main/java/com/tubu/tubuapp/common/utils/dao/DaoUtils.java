package com.tubu.tubuapp.common.utils.dao;

import android.content.Context;

import com.orhanobut.logger.Logger;
import com.tubu.tubuapp.common.utils.dao.manager.DBManager;
import com.tubu.tubuapp.module.user.entity.User;

import java.util.List;
/**
 * @Description: 数据库通用单例
 * @Copyright: Copyright (c) 2016 chexiang.com. All right reserved.
 * @Author: songjunpeng
 * @Date: 2016/7/24 15:15
 * @Modifier: songjunpeng
 * @Update: 2016/7/24 15:15
 */
public class DaoUtils {
    private static String TAG = "[DaoUtils]";

    public static void testGreenDao(Context context) {
        DBManager dbManager = DBManager.getInstance(context);
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setId(i);
            user.setAge(i * 3);
            user.setName("the " + i + " person");
            dbManager.insertUser(user);
            Logger.t(TAG).i("insertUser");
        }
        List<User> userList = dbManager.queryUserList();
        for (User user : userList) {
            Logger.t(TAG).i("queryUserList--before-->" + user.getId() + "--" + user.getName() +"--"+user.getAge());
            if (user.getId() == 0) {
                dbManager.deleteUser(user);
            }
            if (user.getId() == 3) {
                user.setAge(10);
                dbManager.updateUser(user);
            }
        }
        userList = dbManager.queryUserList();
        for (User user : userList) {
            Logger.t(TAG).i("queryUserList--after--->" + user.getId() + "---" + user.getName()+"--"+user.getAge());
        }
    }
}
