package com.mr.foot.serivce;

import com.mr.pojo.Foot;
import com.mr.pojo.Goods;

import java.util.List;

/**
 * Created by Fan on 2019/5/6.
 */
public interface FootService {

    void insertFoot(Goods goods);

    List<Foot> selectAllFoot();
}
