package com.mall.ivy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mall.ivy.dto.evaluation.EvaluationListDTO;
import com.mall.ivy.dto.evaluation.EvaluationSaveDTO;
import com.mall.ivy.dto.evaluation.EvaluationUpdateDTO;
import com.mall.ivy.service.EvaluationService;
import com.mall.ivy.core.resp.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * EvaluationController
 * Created by Ivy.
 */
@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EvaluationController.class);

    @Autowired
    private EvaluationService evaluationService;

    /**
     * 删除评论
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return evaluationService.deleteEvaluation(id);
    }

    /**
     * 返回单个评价
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return evaluationService.getEvaluation(id);
    }

    /**
     * 返回全部评价
     * @param dto
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public Result list(@RequestBody EvaluationListDTO dto, int pageNo, int pageSize) {
        return evaluationService.listEvaluation(dto, pageNo, pageSize);

    }
}