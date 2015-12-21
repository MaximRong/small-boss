package com.bc.smallboss.base.freemarker;

import com.bc.smallboss.base.utils.Config;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component("funs")
public class FreemarkerFuns {

    public static String res(String path) {

        String resPath = Config.getString("resPath");
        return resPath + "res/" + path;

    }

    public static String ctx() {
        return  Config.getString("ctx");

    }

    public static String photo(String photo, String defaultPhoto) {
        return StringUtils.isEmpty(photo) ? res("/biz/common/img/" + defaultPhoto) : res(photo);
    }


}
