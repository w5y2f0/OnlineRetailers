package com.mr.good.controller;

import com.mr.parameter.service.ParameterService;
import com.mr.picture.service.PictureService;
import com.mr.pojo.Goods;
import com.mr.good.service.GoodService;
import com.mr.pojo.GoodsVo;
import com.mr.pojo.Parameter;
import com.mr.pojo.Picture;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@Controller
@RequestMapping("goods")
public class GoodController {
    @Autowired
    private GoodService goodService;
    @Autowired
    private ParameterService parameterService;
    @Autowired
    private PictureService pictureService;

    @GetMapping("addGoods")
    public String addGoods() {
        return "addGoods";
    }

    @GetMapping("updateGoods")
    public String updateGoods() {
        return "updateGoods";
    }

    @GetMapping(value = "selectAll")
    @ResponseBody
    public Map<String, Object> selectAll(Page page) {
        List<Goods> goods = goodService.selectAll(page);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", 0);
        resultMap.put("msg", "");
        resultMap.put("count", goods.size());
        resultMap.put("data", goods);
        return resultMap;
    }

    @PostMapping(value = "insertGood")
    @ResponseBody
    public ResultVo insertGood(Goods goods, String imgUrls, Parameter parameter) {
        goods.setGoDatetimes(new Date());
        goods.setGoSales(0);
        System.out.println(imgUrls);
        ResultVo resultVo = goodService.insertGood(goods);
        Integer goId = goods.getGoId();
        String[] urls = imgUrls.split(",");
//        Parameter pa = new Parameter();
        parameterService.insertParameter(parameter);
        for (int i = 0; i < urls.length; i++) {
//            System.out.println("图片名称："+urls[i].substring(15));
            Picture pi = new Picture();
            pi.setGoId(goId);
            pi.setPiUrl(urls[i].substring(15));
            pi.setPiOrder(i);
            pictureService.insertPicture(pi);
        }
        return resultVo;
    }

    @PostMapping(value = "deleteGood")
    @ResponseBody
    public ResultVo deleteGood(String id) {
        ResultVo resultVo = goodService.deleteGood(id);
        return resultVo;
    }

    @PostMapping("updateGood")
    @ResponseBody
    public ResultVo updateGood(Goods goods,Parameter parameter,Picture picture,String qaz) {
        ResultVo resultVo = goodService.updateGood(goods);
        ResultVo resultVo1 = parameterService.updateParameter(parameter);

        String[] split = qaz.split(",");
        String piUrl = picture.getPiUrl();
        String[] split1 = piUrl.split(",");
        ResultVo resultVo2 = new ResultVo();
        if(split.length==split1.length){
            for (int i = 0; i <split.length ; i++) {
                picture.setPiUrl(split1[i].substring(15));
                picture.setPiId(Integer.parseInt(split[i]));
//                picture.setPiUrl(split1[i]);
                resultVo2 = pictureService.updatePicture(picture);
            }
        }


        return resultVo2;
    }

    @GetMapping("selectById")
    @ResponseBody
    public Goods selectById(String id) {
        Goods goods = goodService.selectById(id);
        return goods;
    }
    @GetMapping("selectByIdS")
    @ResponseBody
    public ModelAndView selectByIdS(String id) {
        Goods goods = goodService.selectById(id);
        Parameter parameter = parameterService.selectByIdS(id);
        List<Picture> picture = pictureService.selectByIdS(id);
        String as = "";
        for (int i = 0; i <picture.size() ; i++) {
            Integer piId = picture.get(i).getPiId();
            as+=piId.toString()+",";
        }
        GoodsVo gv = new GoodsVo(goods.getGoId(), goods.getGoName(), goods.getGoSynopsis(), goods.getGoDetailed(), goods.getGoType(), goods.getGoStates(), goods.getGoDatetimes(), goods.getGoSales(), goods.getGoOld(), goods.getGoNew(), goods.getGoNum(), parameter.getParId(), parameter.getPaColor(), parameter.getPaWeight(), parameter.getGoSpecs(), parameter.getGoMaterial(), parameter.getGoPacking(),as);
        ModelAndView mav = new ModelAndView();
        mav.addObject("data",gv);
        mav.addObject("qwer",picture);
        mav.setViewName("updateGoods");
        return mav;
    }
    @GetMapping("selectByType")
    @ResponseBody
    public List<GoodsVo> selectByType(String Type){
        List<Goods> goods = goodService.selectByType(Type);
        List<GoodsVo> list = new ArrayList<>();
        for (int i = 0; i <goods.size() ; i++) {
            Parameter parameter = parameterService.selectByIdS(goods.get(i).getGoId().toString());
            List<Picture> picture = pictureService.selectByIdS(goods.get(i).getGoId().toString());
            String as = "";
            for (int j = 0; j <picture.size();j++) {
                Integer piId = picture.get(j).getPiId();
                as+=piId.toString()+",";
            }
            GoodsVo gv = new GoodsVo(goods.get(i).getGoId(), goods.get(i).getGoName(), goods.get(i).getGoSynopsis(), goods.get(i).getGoDetailed(), goods.get(i).getGoType(), goods.get(i).getGoStates(), goods.get(i).getGoDatetimes(), goods.get(i).getGoSales(), goods.get(i).getGoOld(), goods.get(i).getGoNew(), goods.get(i).getGoNum(), parameter.getParId(), parameter.getPaColor(), parameter.getPaWeight(), parameter.getGoSpecs(), parameter.getGoMaterial(), parameter.getGoPacking(),as);
            list.add(gv);
        }
        return list;
    }
    @GetMapping("selectByState")
    @ResponseBody
    public List<GoodsVo> selectByState(String State){
        List<Goods> goods = goodService.selectByState(State);
        List<GoodsVo> list = new ArrayList<>();
        for (int i = 0; i <goods.size() ; i++) {
            Parameter parameter = parameterService.selectByIdS(goods.get(i).getGoId().toString());
            List<Picture> picture = pictureService.selectByIdS(goods.get(i).getGoId().toString());
            String as = "";
            for (int j = 0; j <picture.size();j++) {
                Integer piId = picture.get(j).getPiId();
                as+=piId.toString()+",";
            }
            GoodsVo gv = new GoodsVo(goods.get(i).getGoId(), goods.get(i).getGoName(), goods.get(i).getGoSynopsis(), goods.get(i).getGoDetailed(), goods.get(i).getGoType(), goods.get(i).getGoStates(), goods.get(i).getGoDatetimes(), goods.get(i).getGoSales(), goods.get(i).getGoOld(), goods.get(i).getGoNew(), goods.get(i).getGoNum(), parameter.getParId(), parameter.getPaColor(), parameter.getPaWeight(), parameter.getGoSpecs(), parameter.getGoMaterial(), parameter.getGoPacking(),as);
            list.add(gv);
        }
        return list;
    }
}
