package tarakanova.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonDataReader {

    public static Object[][] getInvalidLoginData() throws FileNotFoundException {
        JsonArray jsonArray = JsonParser.parseReader(new FileReader("src/test/resources/invalidLoginData.json"))
                .getAsJsonArray();
        Object[][] data = new Object[jsonArray.size()][2];

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonElement element = jsonArray.get(i);

            data[i][0] = element.getAsJsonObject().get("username").getAsString();
            data[i][1] = element.getAsJsonObject().get("password").getAsString();
        }

        return data;
    }
}