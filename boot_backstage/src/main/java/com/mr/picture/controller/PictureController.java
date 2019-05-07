package com.mr.picture.controller;

import com.github.pagehelper.PageHelper;
import com.mr.picture.service.PictureService;
import com.mr.picture.service.impl.PictureServiceImpl;
import com.mr.pojo.Picture;
import com.mr.utils.Page;
import com.mr.utils.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 黄圣博 on 2019/4/29.
 */
@Controller
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @GetMapping("selectAll")
    @ResponseBody
    public  Map<String,Object> selectAll(){
        List<Picture> list= pictureService.selectAll();
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code",0);
        resultMap.put("msg","");
        resultMap.put("count",list.size());
        resultMap.put("data",list);
        return resultMap;
    }
    @PostMapping("insertPicture")
    @ResponseBody
    public ResultVo insertPicture(Picture parameter){
        ResultVo resultVo = pictureService.insertPicture(parameter);
        return resultVo;
    }
    @PostMapping("deletePicture")
    @ResponseBody
    public ResultVo deletePicture(String id){
        ResultVo resultVo = pictureService.deletePicture(id);
        return resultVo;
    }
    @GetMapping("selectById")
    @ResponseBody
    public Picture selectById(String id){
        Picture parameter = pictureService.selectById(id);
        return parameter;
    }
    @PostMapping("updatePicture")
    @ResponseBody
    public ResultVo updatePicture(Picture parameter){
        ResultVo resultVo = pictureService.updatePicture(parameter);
        return resultVo;
    }
    @SuppressWarnings("deprecation")
    @RequestMapping("/upload")
    @ResponseBody
    public ResultVo uplpad(MultipartFile file, HttpServletRequest request) {
        String desFilePath = "";
        String oriName = "";
        ResultVo result = new ResultVo();
        Map<String, String> dataMap = new HashMap<>();
        ResultVo imgResult = new ResultVo();
        try {
            // 1.获取原文件名
            oriName = file.getOriginalFilename();
            // 2.获取原文件图片后缀，以最后的.作为截取(.jpg)
            String extName = oriName.substring(oriName.lastIndexOf("."));
            // 3.生成自定义的新文件名，这里以UUID.jpg|png|xxx作为格式（可选操作，也可以不自定义新文件名）
            String uuid = UUID.randomUUID().toString();
            String newName = uuid + extName;
            // 4.获取要保存的路径文件夹
            File fi = new File("D:\\mingrui\\FIVE\\OnlineRetailers\\boot_backstage\\src\\main\\resources\\static\\imgs");
            // 5.保存图片
            desFilePath = fi + "\\" + newName;
            File desFile = new File(desFilePath);
            file.transferTo(desFile);
            System.out.println(desFilePath);
            // 6.返回保存结果信息
            result.setCode(0);
            dataMap = new HashMap<>();
            dataMap.put("src", "resources/imgs/" + newName);
            result.setData(dataMap);
            result.setMsg(oriName + "上传成功！");
            return result;
        } catch (IllegalStateException e) {
            imgResult.setCode(1);
            System.out.println(desFilePath + "图片保存失败");
            return imgResult;
        } catch (IOException e) {
            imgResult.setCode(1);
            System.out.println(desFilePath + "图片保存失败--IO异常");
            return imgResult;
        }
    }
}
