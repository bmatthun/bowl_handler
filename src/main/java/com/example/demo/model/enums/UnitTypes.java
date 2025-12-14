package com.example.demo.model.enums;

public enum UnitTypes {
    G("g"),
    DKG("dkg"),
    KG("kg"),
    DB("db"),
    L("l"),
    ML("ml"),
    DL("dl"),
    TK("tk"),
    EK("ek");

    private final String unit;

    UnitTypes(String unit) {
        this.unit = unit;
    }
}
