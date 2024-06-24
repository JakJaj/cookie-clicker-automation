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

        List<BigInteger> itemPrices = getItems(page);

        BigInteger currentCookiesAmount;

        while (true){
            bigCookie.click();
            currentCookiesAmount = new BigInteger(cookiesAmount.innerText().split(" ")[0].replace(",", ""));


        }

        //page.close();
        //launch.close();
        //playwright.close();

    }
    public static void consent(Page page){
        page.getByLabel("Consent", new Page.GetByLabelOptions().setExact(true)).click();
        page.locator("css=#langSelect-EN").click();
    }

    public static List<BigInteger> getItems(Page page){
        Locator items = page.locator("css=.price");
        List<BigInteger> itemPrices = new ArrayList<>();
        Map<String, Integer> numeralMap = new HashMap<>();

        numeralMap.put("million", 6);
        numeralMap.put("billion", 9);
        numeralMap.put("trillion", 12);
        numeralMap.put("quadrillion", 15);
        numeralMap.put("quintillion", 18);
        numeralMap.put("sextillion", 21);
        numeralMap.put("septillion", 24);
        numeralMap.put("octillion", 27);
        numeralMap.put("nonillion", 30);
        numeralMap.put("decillion", 33);

        String tempValue;
        for (int i = 0; i < items.count();i++){
            tempValue = items.nth(i).innerText().replace(",","");

            List<String> temp = List.of(tempValue.split(" "));

            if(temp.size() == 1){
                itemPrices.add(new BigInteger(temp.get(0)));
            }
            else{
                int magnitude = numeralMap.get(temp.get(1));
                if (temp.get(0).contains(".")){
                    magnitude--;
                    String value = temp.get(0).replace(".","");
                    String magnitudeString = "0".repeat(magnitude);

                    itemPrices.add(new BigInteger(value + magnitudeString));
                }
            }

        }
        System.out.println(Arrays.toString(itemPrices.toArray()));

        return itemPrices;
    }
}
