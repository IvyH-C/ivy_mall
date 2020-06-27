package com.mall.ivy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mall.ivy.core.resp.PageVO;
import com.mall.ivy.dto.evaluation.EvaluationListDTO;
import com.mall.ivy.vo.evaluation.EvaluationVO;
import com.mall.ivy.mapper.EvaluationMapper;
import com.mall.ivy.model.Evaluation;
import com.mall.ivy.model.EvaluationExample;
import com.mall.ivy.service.EvaluationService;
import com.mall.ivy.core.enums.ResultEnum;
import com.mall.ivy.core.resp.Result;
import com.mall.ivy.core.resp.ResultUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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
    public Result deleteEvaluation(Integer id) {
        if(evaluationMapper.deleteById(id) == 1) {
            return ResultUtil.success();
        }
        return ResultUtil.error(ResultEnum.HANDLE_FAILURE);
    }

    @Override
    public Result getEvaluation(Integer id) {
        Evaluation evaluation = evaluationMapper.selectByPrimaryKey(id);
        if(evaluation==null){
            return ResultUtil.error(ResultEnum.WRONG_REQUEST_PARAMETER);
        }
            EvaluationVO result = new EvaluationVO();
            result.setContent(evaluation.getContent());
            result.setUserId(evaluation.getUserId());
            result.setGoodsId(evaluation.getGoodsId());
            result.setContent(evaluation.getContent());
            result.setGmtCreate(evaluation.getGmtCreate());
            result.setGmtModify(evaluation.getGmtModify());
            return ResultUtil.success(result);
    }

    @Override
    public Result listEvaluation(@RequestBody EvaluationListDTO dto, @RequestParam int pageNo, @RequestParam int pageSize) {
        EvaluationExample example = new EvaluationExample();
        EvaluationExample.Criteria criteria = example.createCriteria();
        criteria.andDelEqualTo(false);

        Page<Evaluation> page = PageHelper.startPage(pageNo, pageSize);
        List<Evaluation> evaluations = evaluationMapper.selectEvaluation(dto);

        PageVO pageVO = new PageVO();
        pageVO.setList(evaluations);
        pageVO.setRowCount(page.getTotal());
        return ResultUtil.success(pageVO);
    }


}