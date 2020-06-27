package com.mall.ivy.service;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.evaluation.EvaluationListDTO;

/**
* EvaluationService接口
* Created by Ivy.
*/
public interface EvaluationService {


    Result deleteEvaluation(Integer id);

    Result getEvaluation(Integer id);

    Result listEvaluation(EvaluationListDTO dto, int pageNo, int pageSize);

}