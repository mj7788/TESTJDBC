package com.xugu.owl.utils;

import com.xugu.owl.enums.ExceptionEnum;
import com.xugu.owl.exception.GlobleException;
import com.xugu.owl.model.Result;

public class ResultUtil {
     
	public static Result success(Object data) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage("请求成功");
        result.setData(data);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
    
    public static Result error(GlobleException e) {
    	 Result result = new Result();
         result.setCode(e.getCode());
         result.setMessage(e.getMessage());
         return result;
    }
    
    public static Result error(ExceptionEnum e) {
    	Result result = new Result();
        result.setCode(e.getCode());
        result.setMessage(e.getMessage());
        return result;
    }
}
