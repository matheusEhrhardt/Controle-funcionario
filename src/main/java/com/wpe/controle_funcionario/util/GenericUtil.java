package com.wpe.controle_funcionario.util;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class GenericUtil{
    public String formataDataToString(Date data,String formato){
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        return dateFormat.format(data);
    }

    public Date formataStringToData(String data,String formato) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        return dateFormat.parse(data);
    }

//    public void removeCaracterEspecial(Object object){
//        Class<?> classe = object.getClass();
//        Field[] campos = classe.getDeclaredFields();
//        for (Field field: campos){
//            if (field.getType() == String.class) ;
//            System.out.println(field.getGenericType());
//
//        }
//    }
}
