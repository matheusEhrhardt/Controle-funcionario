package com.marcos.mrcjewelscatalog.entities.enums;

public enum RoleEnum {

    ADMIN(0,"ROLE_ADMIN"),
    USER(1,"ROLE_USER");

    private Integer code;
    private String descriptionRole;

    private RoleEnum(Integer code, String descriptionRole){
        this.code = code;
        this.descriptionRole = descriptionRole;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescriptionRole() {
        return descriptionRole;
    }

    public static RoleEnum toEnum(Integer cod) {
        if(cod == null) {
            return null;
        }

        for(RoleEnum x : RoleEnum.values()) {
            if(cod.equals(x.getCode())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Perfil inválido");
    }
}
