import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

public class Bot {


    public static void main(String[] args) {
        Playwright playwright = Playwright.create();

        Browser launch = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = launch.newContext().newPage();

        page.navigate("https://orteil.dashnet.org/cookieclicker/");

        page.waitForTimeout(3000);
        page.getByLabel("Consent", new Page.GetByLabelOptions().setExact(true)).click();
        page.locator("css=#langSelect-EN").click();

        Locator bigCookie = page.locator("css=#bigCookie");
        Locator cookiesAmount = page.locator("css=#cookies");

        Locator items = page.locator("css=.product");

        int currentCookiesAmount;


        while (true){
            bigCookie.click();
            currentCookiesAmount = Integer.parseInt(cookiesAmount.innerText().split(" ")[0].replace(",", ""));

            if(currentCookiesAmount > 0){

            }
        }

        //page.close();
        //launch.close();
        //playwright.close();

    }



}
