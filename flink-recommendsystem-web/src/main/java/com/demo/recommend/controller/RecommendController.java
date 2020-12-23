package com.demo.recommend.controller;

import com.demo.recommend.dto.ProductDto;
import com.demo.recommend.service.KafkaService;
import com.demo.recommend.service.RecommendService;
import com.demo.recommend.util.Result;
import com.demo.recommend.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class RecommendController {

    @Autowired
    RecommendService recommendService;

    @Autowired
    KafkaService kafkaService;

    /**
     * 返回推荐页面
     *
     * @param userId
     * @return
     * @throws IOException
     */
    @GetMapping("/recommend")
    public String recommendByUserId(@RequestParam("userId") String userId,
                                    Model model) throws IOException {

        // 拿到不同推荐方案的结果
        List<ProductDto> hotList = recommendService.recommendByHotList();
        List<ProductDto> itemCfCoeffList = recommendService.recommendByItemCfCoeff();
        List<ProductDto> productCoeffList = recommendService.recommendByProductCoeff();

        // 将结果返回给前端
        model.addAttribute("userId", userId);
        model.addAttribute("hotList", hotList);
        model.addAttribute("itemCfCoeffList", itemCfCoeffList);
        model.addAttribute("productCoeffList", productCoeffList);

        return "user";
    }

    @GetMapping("/log")
    @ResponseBody
    public Result logToKafka(@RequestParam("id") String userId,
                             @RequestParam("prod") String productId,
                             @RequestParam("action") String action) {

        String log = kafkaService.makeLog(userId, productId, action);
        kafkaService.send(null, log);
        return ResultUtils.success();
    }
}
