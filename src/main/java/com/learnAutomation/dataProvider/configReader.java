package com.learnAutomation.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader

{
    public static String getProperty(String key)
    {
        String value = null;
        try {
            Properties pro = new Properties();
            File file = new File(System.getProperty("user.dir")+
                    "/Configuration/config.properties");
            FileInputStream fis = new FileInputStream(file);

            pro.load(fis);
            value = pro.getProperty(key);

        }catch (FileNotFoundException e) {
            System.out.println("Fine Not Present " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could Not read the File.... " + e.getMessage());
        }
        return value;
    }

}
