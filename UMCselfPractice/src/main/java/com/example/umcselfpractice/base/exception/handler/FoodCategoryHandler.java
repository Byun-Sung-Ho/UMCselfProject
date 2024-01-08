package com.example.umcselfpractice.base.exception.handler;

import com.example.umcselfpractice.base.Code;
import com.example.umcselfpractice.base.exception.GeneralException;

public class FoodCategoryHandler  extends GeneralException {
    public FoodCategoryHandler(Code errorCode){
        super(errorCode);
    }
}
