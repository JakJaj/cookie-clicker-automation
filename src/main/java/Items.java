import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Items {

    public static List<BigInteger> getItems(Locator items){
        List<BigInteger> itemPrices = new ArrayList<>();
        Map<String, Integer> numeralsMap = getNumeralsMap();

        String tempValue;

        for (int i = 0; i < items.count();i++){
            tempValue = items.nth(i).innerText().replace(",","");
            List<String> temp = new ArrayList<>(List.of(tempValue.split(" ")));

            if(temp.size() == 1){
                itemPrices.add(new BigInteger(temp.get(0)));
            }
            else{
                int magnitude = numeralsMap.get(temp.get(1));
                String value = temp.get(0);
                String magnitudeString;
                if (value.contains(".")){
                    magnitude--;
                    value = value.replace(".","");
                }

                magnitudeString = "0".repeat(magnitude);
                itemPrices.add(new BigInteger(value + magnitudeString));

            }
        }

        return itemPrices;
    }

    private static Map<String,Integer> getNumeralsMap(){
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

        return numeralMap;
    }
}
