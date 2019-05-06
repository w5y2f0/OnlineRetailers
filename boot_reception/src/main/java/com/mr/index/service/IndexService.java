package com.mr.index.service;

import com.mr.address.Address;
import com.mr.pojo.Foot;
import com.mr.pojo.Picture;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Fan on 2019/5/5.
 */
@FeignClient(value = "provider")
public interface IndexService {

    @RequestMapping(value = "/selectAllFoot")
    List<Foot> selectAllFoot();
}
