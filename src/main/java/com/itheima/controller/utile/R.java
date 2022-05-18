package com.itheima.controller.utile;

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(String msg) {
        this.flag = false;
        this.msg=msg;
    }
}
