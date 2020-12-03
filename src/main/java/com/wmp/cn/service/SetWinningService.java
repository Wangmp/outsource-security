package com.wmp.cn.service;

import com.wmp.cn.model.domain.TbSetWinning;
import com.wmp.cn.model.request.SetWinningRequest;

public interface SetWinningService {

    boolean add(SetWinningRequest setWinningRequest);

    TbSetWinning findByDelFlag();

}
