package com.ws.Enum;

import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

public enum AuditTypeEnum {

    //枚举值定义
    PURCHASE("采购", "1"),
    AMOUNT("资金", "2"),
    ThreeOne("三重一大", "3");


    private final String name;

    private final String code;

    AuditTypeEnum(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    //以枚举值的code为键(key)，以枚举值本身为值(value)创建Map集合
    private static final Map<String, AuditTypeEnum> mappings = new HashMap<>(5);

    //values()方法作用是获取枚举成员的所有值，返回一个数组
    static {
        for (AuditTypeEnum auditTypeEntry : values()) {
            mappings.put(auditTypeEntry.code, auditTypeEntry);
        }
    }

    /**
     * 根据枚举值code查询枚举值
     *
     * @param code 枚举值code
     * @return 枚举值
     */
    @Nullable
    public static AuditTypeEnum resolve(@Nullable String code) {
        return (code != null ? mappings.get(code) : null);
    }

    @Override
    public String toString() {
        return "AuditTypeEnum{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
