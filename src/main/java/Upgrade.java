import com.microsoft.playwright.Locator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Upgrade {

    public BigInteger priceOfCheapestItem;

    public static BigInteger getpriceOfCheapestItem(Locator locator){
        String temp = locator.textContent().replace(",", "");
        Map<String, Integer> numeralsMap = Items.getNumeralsMap();
        List<String> textAndNumeral = new ArrayList<>(List.of(temp.split(" ")));

        if(textAndNumeral.size() == 1){
            return new BigInteger(textAndNumeral.get(0));
        }
        else{
            int magnitude = numeralsMap.get(textAndNumeral.get(1));
            String value = textAndNumeral.get(0);
            String magnitudeString;
            if (value.contains(".")){
                magnitude--;
                value = value.replace(".","");
            }

            magnitudeString = "0".repeat(magnitude);

            return new BigInteger(value + magnitudeString);
        }
    }
}
