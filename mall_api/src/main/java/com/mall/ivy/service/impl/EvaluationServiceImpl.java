package com.mall.ivy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import com.mall.ivy.dto.evaluation.EvaluationListDTO;
import com.mall.ivy.dto.evaluation.EvaluationSaveDTO;
import com.mall.ivy.dto.evaluation.EvaluationUpdateDTO;
import com.mall.ivy.mapper.EvaluationMapper;
import com.mall.ivy.model.Evaluation;
import com.mall.ivy.service.EvaluationService;
import com.mall.ivy.vo.evaluation.EvaluationVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* EvaluationService实现
* Created by Ivy.
*/
@Service
@Transactional
public class EvaluationServiceImpl implements EvaluationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EvaluationServiceImpl.class);

    @Autowired
    EvaluationMapper evaluationMapper;

    @Override
    public Result saveEvaluation(EvaluationSaveDTO dto) {
        //TODO 封装Evaluation

        Evaluation evaluation = new Evaluation();
        BeanUtils.copyProperties(dto, evaluation);
        if(evaluationMapper.insert(evaluation) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result deleteEvaluation(Integer id) {
        if(evaluationMapper.deleteByPrimaryKey(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getEvaluation(Integer id) {
        Evaluation evaluation = evaluationMapper.selectByPrimaryKey(id);
        if(evaluation != null) {
            //TODO 封装返回的内容
            EvaluationVO result = new EvaluationVO();
            return ResultUtil.success(result);
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

    @Override
    public Result listEvaluation(EvaluationListDTO dto, int pageNo, int pageSize) {
        Page<Evaluation> page = PageHelper.startPage(pageNo, pageSize);
        //List<Evaluation> evaluations = evaluationMapper.list(dto);
        return ResultUtil.success();
    }

    @Override
    public Result updateEvaluation(Integer id, EvaluationUpdateDTO dto) {
        Evaluation evaluation = evaluationMapper.selectByPrimaryKey(id);
        if(evaluation != null) {
            //TODO 设值

            if(evaluationMapper.updateByPrimaryKey(evaluation) == 1) {
                return ResultUtil.success();
            }
        }
        return ResultUtil.error(ResultEnum.FAILURE);
    }

}