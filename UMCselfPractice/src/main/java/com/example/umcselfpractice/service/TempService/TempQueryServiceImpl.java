package com.example.umcselfpractice.service.TempService;

import com.example.umcselfpractice.base.Code;
import com.example.umcselfpractice.base.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1) {
            throw new TempHandler(Code.TEMP_EXCEPTION);
        }
    }
}
