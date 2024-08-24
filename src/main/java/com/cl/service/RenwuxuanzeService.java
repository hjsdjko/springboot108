package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.RenwuxuanzeEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwuxuanzeView;


/**
 * 任务选择
 *
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface RenwuxuanzeService extends IService<RenwuxuanzeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RenwuxuanzeView> selectListView(Wrapper<RenwuxuanzeEntity> wrapper);
   	
   	RenwuxuanzeView selectView(@Param("ew") Wrapper<RenwuxuanzeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RenwuxuanzeEntity> wrapper);
   	

}

