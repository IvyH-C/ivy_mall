package com.mall.ivy.service;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.orders.OrdersListDTO;
import com.mall.ivy.dto.orders.OrdersSaveDTO;
import com.mall.ivy.dto.orders.OrdersUpdateDTO;

/**
* OrdersService接口
* Created by Ivy.
*/
public interface OrdersService {

    Result saveOrders(OrdersSaveDTO dto);

    Result deleteOrders(Integer id);

    Result getOrders(Integer id);

    Result listOrders(OrdersListDTO dto, int pageNo, int pageSize);

    Result updateOrders(Integer id, OrdersUpdateDTO dto);
}