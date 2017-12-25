package net.george.georgechat.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author George
 * @date 2017/12/25
 * @email georgejiapeidi@gmail.com
 * @describe 正则表达式规格Util
 */
public class RegularUtils {
    public static boolean isMobleNumber(String number) {
        String MOBILE_PHONE_PATTERN = "^((13[0-9])|(15[0-9])|(18[0-9])|(14[7])|(17[0|6|7|8]))\\d{8}$";
        Pattern pattern = Pattern.compile(MOBILE_PHONE_PATTERN);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
