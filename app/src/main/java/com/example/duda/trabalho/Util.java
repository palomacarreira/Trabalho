package com.example.duda.trabalho;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

public class Util {
    public static Drawable getDrawable(Activity context, String drawableName){
        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getDeclaredField(drawableName);
            int id = idField.getInt(idField);
            return context.getResources().getDrawable(id);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
