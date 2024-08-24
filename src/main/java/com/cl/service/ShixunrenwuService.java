package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShixunrenwuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixunrenwuView;


/**
 * 实训任务
 *
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface ShixunrenwuService extends IService<ShixunrenwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShixunrenwuView> selectListView(Wrapper<ShixunrenwuEntity> wrapper);
   	
   	ShixunrenwuView selectView(@Param("ew") Wrapper<ShixunrenwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShixunrenwuEntity> wrapper);
   	

}

