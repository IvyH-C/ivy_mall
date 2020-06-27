package com.mall.ivy.service;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.delivery.DeliveryListDTO;
import com.mall.ivy.dto.delivery.DeliverySaveDTO;
import com.mall.ivy.dto.delivery.DeliveryUpdateDTO;

/**
* DeliveryService接口
* Created by Ivy.
*/
public interface DeliveryService {

    Result saveDelivery(DeliverySaveDTO dto);

    Result deleteDelivery(Integer id);

    Result getDelivery(Integer id);

    Result listDelivery(DeliveryListDTO dto, int pageNo, int pageSize);

    Result updateDelivery(Integer id, DeliveryUpdateDTO dto);
}