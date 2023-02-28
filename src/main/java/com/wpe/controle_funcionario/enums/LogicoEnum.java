package com.marcos.mrcjewelscatalog.enums;

public enum LogicoEnum {
    NAO("Não"),
    SIM("Sim");

    private final String description;

    LogicoEnum(String description) {
        this.description = description;
    }

    public String getValue() {
        return name();
    }

    public String getDescription() {
        return description;
    }


}
