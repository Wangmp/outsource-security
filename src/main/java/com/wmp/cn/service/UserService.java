package com.wmp.cn.service;

import com.wmp.cn.model.domain.TbUser;
import com.wmp.cn.model.request.TbUserRequest;
import com.wmp.cn.model.response.TbUserResponse;

public interface UserService {

    TbUserResponse addTbUser(TbUserRequest tbUserRequest);

    TbUser getTbUser(Long id);

}
