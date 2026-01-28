package com.xqk.learn.javase.designpattern.create.builder;

/**
 * BuilderPattern
 *
 * @author qiankun.xiong
 * @version 1.0.0
 * @since 2025/6/22 20:35
 */
public class BuilderClass {
    public final String param1;
    public final int param2;
    public final int param3;

    private BuilderClass(Builder builder) {
        this.param1 = builder.param1;
        this.param2 = builder.param2;
        this.param3 = builder.param3;
    }

    @Override
    public String toString() {
        return "BuilderPattern{" +
                "param1='" + param1 + '\'' +
                ", param2=" + param2 +
                ", param3=" + param3 +
                '}';
    }

    @SuppressWarnings("all")
    private static class Builder {
        private String param1;
        private int param2;
        private int param3;

        public BuilderClass build() {
            if (param1 == null || param1.length() == 0) {
                throw new IllegalArgumentException("param1 cannot be null or empty");
            }
            return new BuilderClass(this);
        }

        public Builder setParam1(String param1) {
            this.param1 = param1;
            return this;
        }

        public Builder setParam2(int param2) {
            this.param2 = param2;
            return this;
        }

        public Builder setParam3(int param3) {
            this.param3 = param3;
            return this;
        }
    }

    public static void main(String[] args) {
        var instance = new BuilderClass.Builder()
                .setParam1("param1")
                .setParam2(2)
                .setParam3(3)
                .build();
        System.out.println(instance);
    }
}
