package com.xqk.learn.javase.enums;

import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 车辆颜色枚举类
 *
 * @author 熊乾坤
 * @date 2020-05-25 15:30
 */
public enum VehicleClassEnum {
    /** 客车 */
    K("客车"),

    /** 货车 */
    H("货车"),

    /** 牵引车 */
    Q("牵引车"),

    /** 专项作业车 */
    Z("专项作业车"),

    /** 电车 */
    D("电车"),

    /** 摩托车 */
    M("摩托车"),

    /** 三轮汽车 */
    N("三轮汽车"),

    /** 拖拉机 */
    T("拖拉机"),

    /** 轮式机械 */
    J("轮式机械"),

    /** 全挂车 */
    G("全挂车"),

    /** 半挂车 */
    B("半挂车"),

    /** 其他 */
    X("其他");

    private String desc;

    VehicleClassEnum(String desc) {
        this.desc = desc;
    }

    public static VehicleClassEnum parse(String vehicle) {
        if (StringUtils.isEmpty(vehicle)) {
            return null;
        }
        try {
            return valueOf(VehicleClassEnum.class, vehicle.subSequence(0, 1).toString());
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(Objects.requireNonNull(VehicleClassEnum.parse("1H2")).desc);
    }
}
