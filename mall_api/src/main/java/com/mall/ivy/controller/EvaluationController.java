package com.mall.ivy.controller;

import com.mall.ivy.core.resp.Result;
import com.mall.ivy.dto.evaluation.EvaluationListDTO;
import com.mall.ivy.dto.evaluation.EvaluationSaveDTO;
import com.mall.ivy.dto.evaluation.EvaluationUpdateDTO;
import com.mall.ivy.service.EvaluationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public Result save(@RequestBody EvaluationSaveDTO dto) {
        return evaluationService.saveEvaluation(dto);
    }


    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        return evaluationService.getEvaluation(id);
    }

    @GetMapping("/list")
    public Result list(@RequestBody EvaluationListDTO dto, int pageNo, int pageSize){
        return evaluationService.listEvaluation(dto, pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody EvaluationUpdateDTO dto){
        return evaluationService.updateEvaluation(id, dto);
    }
}