package com.mall.ivy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import com.mall.ivy.dto.orders.OrdersListDTO;
import com.mall.ivy.dto.orders.OrdersSaveDTO;
import com.mall.ivy.dto.orders.OrdersUpdateDTO;
import com.mall.ivy.mapper.OrdersMapper;
import com.mall.ivy.model.Orders;
import com.mall.ivy.service.OrdersService;
import com.mall.ivy.vo.orders.OrdersVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* OrdersService实现
* Created by Ivy.
*/
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersServiceImpl.class);

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public Result saveOrders(OrdersSaveDTO dto) {
        //TODO 封装Orders

        Orders orders = new Orders();
        BeanUtils.copyProperties(dto, orders);
        if(ordersMapper.insert(orders) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteOrders(Integer id) {
        if(ordersMapper.deleteByPrimaryKey(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getOrders(Integer id) {
        Orders orders = ordersMapper.selectByPrimaryKey(id);
        if(orders != null) {
            //TODO 封装返回的内容
            OrdersVO result = new OrdersVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listOrders(OrdersListDTO dto, int pageNo, int pageSize) {
        Page<Orders> page = PageHelper.startPage(pageNo, pageSize);
        //List<Orders> orderss = ordersMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateOrders(Integer id, OrdersUpdateDTO dto) {
        Orders orders = ordersMapper.selectByPrimaryKey(id);
        if(orders != null) {
            //TODO 设值

            if(ordersMapper.updateByPrimaryKey(orders) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}