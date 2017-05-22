package com.assets.core.controller;

import com.assets.core.util.Result;

/**
 * Created by hch on 2017/5/22.
 */
public class BaseController {
    public Result success(String message) {
        return new Result().addSuccess(message);
    }

    public Result success(Object data) {
        return new Result().success(data);
    }

    public Result error(String message) {
        return new Result().addError(message);
    }

    public Result warn(String message) {
        return new Result().addWarn(message);
    }
}
