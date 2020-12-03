package com.wmp.cn.service;

import com.wmp.cn.model.domain.TbScore;
import com.wmp.cn.model.request.TbScoreFindListRequest;
import com.wmp.cn.model.request.TbScoreSaveRequest;
import com.wmp.cn.model.response.CountScoreResponse;
import com.wmp.cn.model.response.QueryResponseResultList;

public interface ScoreService {

    TbScore add(TbScoreSaveRequest tbScoreSaveRequest);

    QueryResponseResultList getListTbScore(TbScoreFindListRequest tbScoreFindListRequest);

    CountScoreResponse countScore();

}
