package com.mall.ivy.service;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.message.MessageListDTO;
import com.mall.ivy.dto.message.MessageSaveDTO;
import com.mall.ivy.dto.message.MessageUpdateDTO;

/**
* MessageService接口
* Created by Ivy.
*/
public interface MessageService {

    Result saveMessage(MessageSaveDTO dto);

    Result deleteMessage(Integer id);

    Result getMessage(Integer id);

    Result listMessage(MessageListDTO dto, int pageNo, int pageSize);

    Result updateMessage(Integer id, MessageUpdateDTO dto);
}