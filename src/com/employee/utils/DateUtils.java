package com.employee.utils;

import com.employee.exception.CustomException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private DateUtils() {

    }

    public static Date convertStringToDate(String inputDate) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            date = simpleDateFormat.parse(inputDate);
        } catch (ParseException pe) {
            throw new CustomException("Exception occured: " + "pe");
        }
        return date;
    }
    public static String convertDateToString(Date date) {
        String outputDate = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            outputDate = simpleDateFormat.format(date);
        } catch (Exception e) {
            throw new CustomException("Exception occured: " + "e");
        }
        return outputDate;
    }
}
