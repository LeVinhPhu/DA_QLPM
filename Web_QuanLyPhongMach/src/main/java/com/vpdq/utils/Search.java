/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vpdq.utils;

import java.util.Map;

/**
 *
 * @author phamt
 */
public class Search {

    private static int idCus;
    private static Map<String, String> param;


    /**
     * @return the param
     */
    public static Map<String, String> getParam() {
        return param;
    }

    /**
     * @param aParam the param to set
     */
    public static void setParam(Map<String, String> aParam) {
        param = aParam;
    }

    /**
     * @return the idCus
     */
    public static int getIdCus() {
        return idCus;
    }

    /**
     * @param aIdCus the idCus to set
     */
    public static void setIdCus(int aIdCus) {
        idCus = aIdCus;
    }

}
