package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ChengjifankuiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChengjifankuiView;


/**
 * 成绩反馈
 *
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface ChengjifankuiService extends IService<ChengjifankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChengjifankuiView> selectListView(Wrapper<ChengjifankuiEntity> wrapper);
   	
   	ChengjifankuiView selectView(@Param("ew") Wrapper<ChengjifankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChengjifankuiEntity> wrapper);
   	

}

