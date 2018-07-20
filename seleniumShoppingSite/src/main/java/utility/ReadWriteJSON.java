package utility;

/*
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
*/

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadWriteJSON {
    public static String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static JSONArray getJSONArray(String fileName, String dataSet){
        String object = readFile(fileName);
        JSONObject jObject = new JSONObject(object);
        JSONArray arr = jObject.getJSONArray(dataSet);
        return arr;

    }


    public static Iterator<Object[]> getValidAccounts() throws IOException {
        JSONArray arr = getJSONArray(Constant.dataFile,Constant.jKeySetEnum.valid_accounts.name());
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            String email = arr.getJSONObject(i).getString(Constant.jValidAccEnum.email.name());
            String pass = arr.getJSONObject(i).getString(Constant.jValidAccEnum.pass.name());
            data.add(new String[]{email, pass});
        }
        return data.iterator();
    }
    public static Iterator<Object[]> getInValidAccounts() throws IOException {
        JSONArray arr = getJSONArray(Constant.dataFile,Constant.jKeySetEnum.invalid_accounts.name());
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            String email = arr.getJSONObject(i).getString(Constant.jInvalidAccEnum.invalid_email.name());
            String pass = arr.getJSONObject(i).getString(Constant.jInvalidAccEnum.invalid_pass.name());
            data.add(new String[]{email, pass});
        }
        return data.iterator();
    }
    public static Iterator<Object[]> getNewAccounts() throws IOException {
        JSONArray arr = getJSONArray(Constant.dataFile,Constant.jKeySetEnum.new_accounts.name());
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            String new_email = arr.getJSONObject(i).getString(Constant.jNewAccEnum.new_email.name());
            String title = arr.getJSONObject(i).getString(Constant.jNewAccEnum.title.name());
            String first_name = arr.getJSONObject(i).getString(Constant.jNewAccEnum.first_name.name());
            String last_name = arr.getJSONObject(i).getString(Constant.jNewAccEnum.last_name.name());
            String new_pass = arr.getJSONObject(i).getString(Constant.jNewAccEnum.new_pass.name());
            String day =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.day.name());
            String month =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.month.name());
            String year =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.year.name());
            String address =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.address.name());
            String city =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.city.name());
            String state =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.state.name());
            String zip_code =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.zip_code.name());
            String country =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.country.name());
            String mobile_phone =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.mobile_phone.name());
            String address_alias =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.address_alias.name());
            data.add(new String[]{new_email, title, first_name, last_name, new_pass, day, month, year,
                    address, city, state, zip_code, country, mobile_phone, address_alias});
        }
        return data.iterator();
    }
    public static Iterator<Object[]> getNewAccounts_Test() throws IOException {
        JSONArray arr = getJSONArray(Constant.dataFile,Constant.jKeySetEnum.new_accounts.name());
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            String new_email = arr.getJSONObject(i).getString(Constant.jNewAccEnum.new_email.name());
            String first_name = arr.getJSONObject(i).getString(Constant.jNewAccEnum.first_name.name());
            String last_name = arr.getJSONObject(i).getString(Constant.jNewAccEnum.last_name.name());
            String new_pass = arr.getJSONObject(i).getString(Constant.jNewAccEnum.new_pass.name());
            String day =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.day.name());
            String month =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.month.name());
            String year =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.year.name());
            String address =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.address.name());
            String city =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.city.name());
            String state =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.state.name());
            String zip_code =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.zip_code.name());
            String country =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.country.name());
            String mobile_phone =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.mobile_phone.name());
            String address_alias =  arr.getJSONObject(i).getString(Constant.jNewAccEnum.address_alias.name());
            data.add(new String[]{new_email, first_name, last_name, new_pass, day, month, year,
                    address, city, state, zip_code, country, mobile_phone, address_alias});
        }
        return data.iterator();
    }
}