package com.devzery.scenes.Utilities;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class RandomUtilities {
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(7);
    }
    public String randomNumber() {
        return RandomStringUtils.randomNumeric(7);
    }
    public String randomAlphaNumeric() {
        return RandomStringUtils.randomAlphanumeric(7);
    }

    //length of 10 digit
    public String randomNumString() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
   // 13062022
    public String findCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
    public String getCurrentDateTime(){
        return new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
    }
    public long getTimeDifference() throws ParseException {
        String time1 = "16:00:00";
        String time2 = "19:00:00";

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        return date2.getTime() - date1.getTime();
    }
    public long getTimeDifferenceInHours() throws ParseException {
        String time1 = "16:00:00";
        String time2 = "19:00:00";

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
        long seconds = difference % 60;
        difference /= 60;
        long minutes = difference % 60;
        difference /= 60;

        return difference / 1000;
    }
    public long getTimeDifferenceInMinutes() throws ParseException {
        String time1 = "16:00:00";
        String time2 = "19:00:00";

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        long difference = date2.getTime() - date1.getTime();
        long seconds = difference % 60;
        difference /= 60;
        return difference / 1000;
    }
    public int random4digitNum() {
        // It will generate 4 digit random Number.
        // from 0 to 9999
        Random rnd = new Random();
        return rnd.nextInt(9999);
    }
    public  String random4digitString() {
        Random rnd = new Random();
        int number = rnd.nextInt(9999);
        return String.format("%04d", number);
    }
    public String randomStringCustomLength(int length) {
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
    public String random16digitString() {
        int length = 16;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
    public long getTimeDifference(Date givenDate1 , Date givenDate2) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time1 = dateFormat. format(givenDate1);
        String time2 = dateFormat. format(givenDate2);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = format.parse(time1);
        Date date2 = format.parse(time2);
        return date2.getTime() - date1.getTime();
    }
    public long getTimeFromString() throws ParseException {
        String myDate = "2014/10/29 18:10:45";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = sdf.parse(myDate);
        return date.getTime();
    }
}

