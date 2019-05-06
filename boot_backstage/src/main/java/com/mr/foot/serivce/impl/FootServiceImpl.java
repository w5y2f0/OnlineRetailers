package com.mr.foot.serivce.impl;

import com.mr.foot.serivce.FootService;
import com.mr.pojo.Foot;
import com.mr.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Fan on 2019/5/6.
 */
@Service
public class FootServiceImpl implements FootService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void insertFoot(Goods goods) {
        mongoTemplate.insert(goods);
    }

    @Override
    public List<Goods> selectAllFoot() {
        return mongoTemplate.findAll(Goods.class);
    }
}
