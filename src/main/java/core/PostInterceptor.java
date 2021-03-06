package core;

import core.mybatis.Inquire;
import user.permission.PERMISSION;

import java.util.HashMap;
import java.util.Map;

public class PostInterceptor {

    /**
     * 将操作日记记录进入数据库
     * @param userId 操作者id
     * @param permission 操作行为
     * @param obj 操作对象
     */
    public static void handle(int userId, PERMISSION permission, Object obj) {
        HashMap<String, Object> list = new HashMap<>();
        list.put("userId", userId);
        list.put("operation", permission.name());
        list.put("object", obj.toString());
        Inquire.insertOperation(list);
    }

}