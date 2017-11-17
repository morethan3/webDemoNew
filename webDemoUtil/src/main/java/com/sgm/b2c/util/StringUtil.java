package com.sgm.b2c.util;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Li
 * @date 2017/8/30
 */
public class StringUtil {

    public static String createTablePrimaryKey(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static boolean containsCaseInsensitive(String strToCompare, List<String> list)
    {
        for(String str:list)
        {
            if(str.equalsIgnoreCase(strToCompare))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean checkList(List list){
        return !(null == list || 0 == list.size());
    }

    public static boolean checkString(String s){
        return !(null == s || "".equals(s));
    }
}
