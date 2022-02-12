package T02_JVM;

/**
 *
 */
public class T_01_JvmClassLoad {


    public static void main(String[] args) {

        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        System.out.println(T_01_JvmClassLoad.class.getClassLoader());


        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());

        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());


    }



}