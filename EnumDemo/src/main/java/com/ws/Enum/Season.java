package com.ws.Enum;

public enum Season {

    SPRING("春","温暖"),
    SUMMER("夏","炎热"),
    AUTUMN("秋","凉爽"),
    WINTER("冬","寒冷");

    private final String name;
    private final String desc;

    private Season(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
