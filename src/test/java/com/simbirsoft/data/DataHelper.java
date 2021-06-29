package com.simbirsoft.data;

import org.testng.annotations.DataProvider;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataHelper {

    public static String getSum(){
        return "3000000";
    }

    public static String getYears(){
        return "15";
    }

    public static String getDate(){
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_MONTH, +14);
        return  df.format(calendar.getTime());
    }

    @DataProvider(name = "getRateCredit")
    public static Object[][] createData1() {
        return new Object[][]{
               {"8", "28 669,56"},
               {"9", "30 428,00"},
                {"10", "32 238,15"},
        };
    }
}
