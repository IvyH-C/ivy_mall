package com.mall.ivy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import com.mall.ivy.dto.delivery.DeliveryListDTO;
import com.mall.ivy.dto.delivery.DeliverySaveDTO;
import com.mall.ivy.dto.delivery.DeliveryUpdateDTO;
import com.mall.ivy.mapper.DeliveryMapper;
import com.mall.ivy.model.Delivery;
import com.mall.ivy.service.DeliveryService;
import com.mall.ivy.vo.delivery.DeliveryVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* DeliveryService实现
* Created by Ivy.
*/
@Service
@Transactional
public class DeliveryServiceImpl implements DeliveryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryServiceImpl.class);

    @Autowired
    DeliveryMapper deliveryMapper;

    @Override
    public Result saveDelivery(DeliverySaveDTO dto) {
        //TODO 封装Delivery

        Delivery delivery = new Delivery();
        BeanUtils.copyProperties(dto, delivery);
        if(deliveryMapper.insert(delivery) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteDelivery(Integer id) {
        if(deliveryMapper.deleteByPrimaryKey(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getDelivery(Integer id) {
        Delivery delivery = deliveryMapper.selectByPrimaryKey(id);
        if(delivery != null) {
            //TODO 封装返回的内容
            DeliveryVO result = new DeliveryVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listDelivery(DeliveryListDTO dto, int pageNo, int pageSize) {
        Page<Delivery> page = PageHelper.startPage(pageNo, pageSize);
        //List<Delivery> deliverys = deliveryMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateDelivery(Integer id, DeliveryUpdateDTO dto) {
        Delivery delivery = deliveryMapper.selectByPrimaryKey(id);
        if(delivery != null) {
            //TODO 设值

            if(deliveryMapper.updateByPrimaryKey(delivery) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}