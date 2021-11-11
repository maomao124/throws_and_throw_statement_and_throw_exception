import java.awt.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project name(项目名称)：throws和throw 声明和抛出异常
 * Package(包名): PACKAGE_NAME
 * Class(类名): test2
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/11
 * Time(创建时间)： 19:10
 * Version(版本): 1.0
 * Description(描述)：
 * 在某仓库管理系统中，要求管理员的用户名需要由 8 位以上的字母或者数字组成，不能含有其他的字符。
 * 当长度在 8 位以下时拋出异常，并显示异常信息；当字符含有非字母或者数字时，同样拋出异常，显示异常信息。
 */

public class test2
{
    public boolean validateUserName(String username)
    {
        boolean result = false;
        if (username.length() > 8)
        {
            // 判断用户名长度是否大于8位
            /*
            for (int i = 0; i < username.length(); i++)
            {
                char ch = username.charAt(i); // 获取每一位字符
                if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
                {
                    result = true;
                }
                else
                {
                    result = false;
                    throw new IllegalArgumentException("用户名只能由字母和数字组成！");
                }
            }
             */
            Pattern p = Pattern.compile("[0-9a-zA-Z]+");     //正则表达式
            Matcher m = p.matcher(username);
            boolean r = m.matches();
            if (r)
            {
                result = true;
            }
            else
            {
                result = false;
                throw new IllegalArgumentException("用户名只能由字母和数字组成！");
            }
        }
        else
        {
            throw new IllegalArgumentException("用户名长度必须大于 8 位！");
        }
        return result;
    }

    public static void main(String[] args)
    {
        test2 t = new test2();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = input.next();
        try
        {
            boolean result = t.validateUserName(username);
            if (result)
            {
                System.out.println("用户名输入正确！");
            }
        }
        catch (IllegalArgumentException e)
        {
            Toolkit.getDefaultToolkit().beep();
            System.err.println(e.getMessage());
        }
    }
}
