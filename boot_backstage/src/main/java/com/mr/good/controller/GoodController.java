package com.mr.good.controller;

import com.mr.parameter.service.ParameterService;
import com.mr.picture.service.PictureService;
import com.mr.pojo.*;
import com.mr.good.service.GoodService;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;
import java.io.IOException;
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
        parameter.setGoId(goId);
        parameterService.insertParameter(parameter);
        for (int i = 0; i < urls.length; i++) {
//            System.out.println("图片名称："+urls[i].substring(15));
            Picture pi = new Picture();
            pi.setGoId(goId);
            pi.setPiUrl(urls[i].substring(15));
            pi.setPiOrder(i);
            pictureService.insertPicture(pi);
        }
        GoodsSolr gv = new GoodsSolr(goods.getGoId().toString(), goods.getGoName(), goods.getGoSynopsis(), goods.getGoDetailed(), goods.getGoType(), goods.getGoStates(), goods.getGoDatetimes(), goods.getGoSales(), goods.getGoOld(), goods.getGoNew(), goods.getGoNum());
        addsolr(gv);
        return resultVo;
    }

    @PostMapping(value = "deleteGood")
    @ResponseBody
    public ResultVo deleteGood(String id) {
        ResultVo resultVo = goodService.deleteGood(id);
        HttpSolrClient solrClient = new HttpSolrClient.Builder()
//设置solr的地址,http://127.0.0.1:8080/solr为项目路径,car为核的名字
                .withBaseSolrUrl("http://127.0.0.1:8088/solr/goods")
                .build();
        try {
            solrClient.deleteById(id);
            solrClient.commit();
            solrClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
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
    @RequestMapping(value = "selectByType",method = RequestMethod.GET)
    public List<GoodsVo> selectByType( String type){
        List<Goods> goods = goodService.selectByType(type);
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
    @RequestMapping("selectByState")
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
    @RequestMapping(value = "addsolr",method = RequestMethod.GET)
    public void addsolr(GoodsSolr goodsSolr){
        HttpSolrClient solrClient = new HttpSolrClient.Builder()
//设置solr的地址,http://127.0.0.1:8080/solr为项目路径,car为核的名字
                .withBaseSolrUrl("http://127.0.0.1:8088/solr/goods")
                .build();
        try {
            goodsSolr.setGoId("1234");
            goodsSolr.setGoName("12414");
            solrClient.addBean(goodsSolr);
            solrClient.commit();
            solrClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value = "selectsolr")
    @ResponseBody
    public List<GoodsSolr> selectsolr(@RequestParam("name") String name){
        HttpSolrClient solrClient = new HttpSolrClient.Builder()
//设置solr的地址,http://127.0.0.1:8080/solr为项目路径,car为核的名字
                .withBaseSolrUrl("http://127.0.0.1:8088/solr/goods")
                .build();
        SolrQuery sq = new SolrQuery();
        sq.setQuery("go_name:"+name)
                .setHighlight(true)
                .setHighlightSimplePost("</font>")
                .setHighlightSimplePre("<font color = 'red'>")
                .addHighlightField("go_name");
        QueryResponse query = null;
        try {
            query = solrClient.query(sq);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<GoodsSolr> beans = query.getBeans(GoodsSolr.class);
        System.err.println(beans);
        Map<String, Map<String, List<String>>> highlighting = query.getHighlighting();
        System.err.println(highlighting);
        if (beans != null) {
            for (int i = 0; i < beans.size(); i++) {
                String id = beans.get(i).getGoId().toString();
                String book_name = highlighting.get(id).get("go_name").get(0);
                beans.get(i).setGoName(book_name);
            }
        }
        return beans;
    }
}
