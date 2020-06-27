package com.mall.ivy.service;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.evaluation.EvaluationListDTO;
import com.mall.ivy.dto.evaluation.EvaluationSaveDTO;
import com.mall.ivy.dto.evaluation.EvaluationUpdateDTO;

/**
* EvaluationService接口
* Created by Ivy.
*/
public interface EvaluationService {

    Result saveEvaluation(EvaluationSaveDTO dto);

    Result deleteEvaluation(Integer id);

    Result getEvaluation(Integer id);

    Result listEvaluation(EvaluationListDTO dto, int pageNo, int pageSize);

    Result updateEvaluation(Integer id, EvaluationUpdateDTO dto);
}