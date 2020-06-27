package com.mall.ivy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import com.mall.ivy.dto.message.MessageListDTO;
import com.mall.ivy.dto.message.MessageSaveDTO;
import com.mall.ivy.dto.message.MessageUpdateDTO;
import com.mall.ivy.mapper.MessageMapper;
import com.mall.ivy.model.Message;
import com.mall.ivy.service.MessageService;
import com.mall.ivy.vo.message.MessageVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* MessageService实现
* Created by Ivy.
*/
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    MessageMapper messageMapper;

    @Override
    public Result saveMessage(MessageSaveDTO dto) {
        //TODO 封装Message

        Message message = new Message();
        BeanUtils.copyProperties(dto, message);
        if(messageMapper.insert(message) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteMessage(Integer id) {
        if(messageMapper.deleteByPrimaryKey(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getMessage(Integer id) {
        Message message = messageMapper.selectByPrimaryKey(id);
        if(message != null) {
            //TODO 封装返回的内容
            MessageVO result = new MessageVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listMessage(MessageListDTO dto, int pageNo, int pageSize) {
        Page<Message> page = PageHelper.startPage(pageNo, pageSize);
        //List<Message> messages = messageMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateMessage(Integer id, MessageUpdateDTO dto) {
        Message message = messageMapper.selectByPrimaryKey(id);
        if(message != null) {
            //TODO 设值

            if(messageMapper.updateByPrimaryKey(message) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}