package com.example.umcselfpractice.base.exception.handler;

import com.example.umcselfpractice.base.Code;
import com.example.umcselfpractice.base.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(Code errorCode){
        super(errorCode);
    }
}
