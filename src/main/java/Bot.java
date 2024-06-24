import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.math.BigInteger;
import java.util.*;

public class Bot {


    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser launch = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = launch.newContext().newPage();

        page.navigate("https://orteil.dashnet.org/cookieclicker/");

        consent(page);

        Locator bigCookie = page.locator("css=#bigCookie");
        Locator cookiesAmount = page.locator("css=#cookies");


        List<BigInteger> itemPrices = Items.getItems(page.locator("css=.price"));

        System.out.println(itemPrices);

        BigInteger currentCookiesAmount;

        while (true){
            bigCookie.click();
            currentCookiesAmount = new BigInteger(cookiesAmount.innerText().split(" ")[0].replace(",", ""));

            for(int i = 0; i < itemPrices.size();i++){
                if(itemPrices.get(i).compareTo(currentCookiesAmount) < 0){

                }
            }

        }

        //page.close();
        //launch.close();
        //playwright.close();

    }
    public static void consent(Page page){
        page.getByLabel("Consent", new Page.GetByLabelOptions().setExact(true)).click();
        page.locator("css=#langSelect-EN").click();
    }

}
