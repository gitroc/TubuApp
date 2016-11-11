package com.tubu.tubuapp.module.examples.date;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * Created by roc on 2016/11/11.
 */

public class DateExample {
    public static void main(String[] args) throws IOException {
        testDate();
    }

    public static void testDate() {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");

        Calendar beijing = Calendar.getInstance();
        beijing.clear();
        beijing.setTimeZone(TimeZone.getDefault());
        beijing.setTimeInMillis(new Long("1478683798000"));

        res = simpleDateFormat.format(beijing.getTime());

        System.out.print(res.toString());
    }
}
