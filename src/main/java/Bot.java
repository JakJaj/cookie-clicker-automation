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

        BigInteger currentCookiesAmount;
        Locator itemToBuy;
        Locator upgrade = page.locator("#upgrade0");

        BigInteger cheapestUpgrade = new BigInteger("100");

        while (true){
            bigCookie.click();
            List<BigInteger> itemPrices = Items.getItems(page.locator("css=.price"));
            currentCookiesAmount = new BigInteger(cookiesAmount.innerText().split(" ")[0].replace(",", ""));

            for(int i = 0; i < itemPrices.size();i++){

                if(itemPrices.get(i).compareTo(currentCookiesAmount) < 0){
                    itemToBuy = page.locator("css=#product" + i);
                    itemToBuy.click();
                    break;
                }
            }
            if(currentCookiesAmount.compareTo(cheapestUpgrade) == 0){
                upgrade.click();
                upgrade.hover();
                cheapestUpgrade = Upgrade.getpriceOfCheapestItem(page.locator("div#tooltipCrate>div:nth-of-type(2)>span"));
            }
        }
    }
    public static void consent(Page page){
        page.getByLabel("Consent", new Page.GetByLabelOptions().setExact(true)).click();
        page.locator("css=#langSelect-EN").click();
    }

}
