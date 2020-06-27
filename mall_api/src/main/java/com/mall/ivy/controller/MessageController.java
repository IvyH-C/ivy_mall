package com.mall.ivy.controller;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.message.MessageListDTO;
import com.mall.ivy.dto.message.MessageSaveDTO;
import com.mall.ivy.dto.message.MessageUpdateDTO;
import com.mall.ivy.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * MessageController
 * Created by Ivy.
 */
@RestController
@RequestMapping("/message")
public class MessageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return messageService.deleteMessage(id);
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return messageService.getMessage(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody MessageListDTO dto, int pageNo, int pageSize){
        return messageService.listMessage(dto, pageNo, pageSize);
    }

}