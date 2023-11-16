package helpers;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CookiesHelper {

    public static void saveCookiesToFile(Set<Cookie> cookies, String filePath) {
        try {
            FileWriter fileWrite = new FileWriter(filePath);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            for (Cookie ck : cookies) {
                Bwrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";" + ck.getExpiry() + ";" + ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();
            fileWrite.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Set<Cookie> readCookiesFromFile(String filePath, WebDriver driver) {
        Set<Cookie> cookies = new HashSet<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader Buffreader = new BufferedReader(fileReader);
            String strline;
            while ((strline = Buffreader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(strline, ";");
                while (token.hasMoreTokens()) {
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;

                    String val;
                    if (!(val = token.nextToken()).equals("null")) {
                        expiry = new Date(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken()).
                            booleanValue();
                    Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
                    System.out.println(ck);
                    driver.manage().addCookie(ck);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cookies;
    }
}
