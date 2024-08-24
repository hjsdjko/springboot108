package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RenwufenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwufenleiView;


/**
 * 任务分类
 *
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface RenwufenleiService extends IService<RenwufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RenwufenleiView> selectListView(Wrapper<RenwufenleiEntity> wrapper);
   	
   	RenwufenleiView selectView(@Param("ew") Wrapper<RenwufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RenwufenleiEntity> wrapper);
   	

}

