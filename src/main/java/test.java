import java.io.FileInputStream;
import java.io.IOException;

/**
 * Project name(项目名称)：throws和throw 声明和抛出异常
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/11
 * Time(创建时间)： 18:59
 * Version(版本): 1.0
 * Description(描述)： 当一个方法产生一个它不处理的异常时，那么就需要在该方法的头部声明这个异常，以便将该异常传递到方法的外部进行处理。
 * 使用 throws 声明的方法表示此方法不处理异常。throws 具体格式如下：
 * returnType method_name(paramList) throws Exception 1,Exception2,…{…}
 * 其中，returnType 表示返回值类型；method_name 表示方法名；paramList 表示参数列表；Exception 1，Exception2，… 表示异常类。
 * 如果有多个异常类，它们之间用逗号分隔。这些异常类可以是方法中调用了可能拋出异常的方法而产生的异常，也可以是方法体中生成并拋出的异常。
 * 使用 throws 声明抛出异常的思路是，当前方法不知道如何处理这种类型的异常，该异常应该由向上一级的调用者处理；
 * 如果 main 方法也不知道如何处理这种类型的异常，也可以使用 throws 声明抛出异常，该异常将交给 JVM 处理。
 * JVM 对异常的处理方法是，打印异常的跟踪栈信息，并中止程序运行，这就是前面程序在遇到异常后自动结束的原因。
 * 子类方法声明抛出的异常类型应该是父类方法声明抛出的异常类型的子类或相同，子类方法声明抛出的异常不允许比父类方法声明抛出的异常多
 * throws 用来声明一个方法可能抛出的所有异常信息，表示出现异常的一种可能性，但并不一定会发生这些异常；
 * throw 则是指拋出的一个具体的异常类型，执行 throw 则一定抛出了某种异常对象。
 * 通常在一个方法（类）的声明处通过 throws 声明方法（类）可能拋出的异常信息，而在方法（类）内部通过 throw 声明一个具体的异常信息。
 * throws 通常不用显示地捕获异常，可由系统自动将所有捕获的异常信息抛给上级方法；
 * throw 则需要用户自己捕获相关的异常，而后再对其进行相关包装，最后将包装后的异常信息抛出。
 * <p>
 * 创建一个 readFile() 方法，该方法用于读取文件内容，在读取的过程中可能会产生 IOException 异常，
 * 但是在该方法中不做任何的处理，而将可能发生的异常交给调用者处理。在 main() 方法中使用 try catch 捕获异常，并输出异常信息。
 */

public class test
{
    public void readFile() throws IOException
    {
        FileInputStream file = new FileInputStream("test.txt");
        int f;
        while ((f = file.read()) != -1)
        {
            System.out.println((char) f);
            f = file.read();
        }
        file.close();
    }

    public static void main(String[] args)
    {
        test t = new test();
        try
        {
            t.readFile();
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }

        test2.main(null);
    }
}
