package com.ricardocampos.constructionapp.enums;

public enum VehicleStatus {
    WORKSHOP,
    CONSTRUCTION_SITE,
    SHIPYARD,
    MAINTENANCE,
    DISABLED;



    public static boolean isValid(String status){

        for(VehicleStatus st : VehicleStatus.values()){
            if(st.name().equalsIgnoreCase(status)){
                return true;
            }
        }
        return false;

    }
}
