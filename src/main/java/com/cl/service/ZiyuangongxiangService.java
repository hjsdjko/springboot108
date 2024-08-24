package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZiyuangongxiangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiyuangongxiangView;


/**
 * 资源共享
 *
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface ZiyuangongxiangService extends IService<ZiyuangongxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZiyuangongxiangView> selectListView(Wrapper<ZiyuangongxiangEntity> wrapper);
   	
   	ZiyuangongxiangView selectView(@Param("ew") Wrapper<ZiyuangongxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZiyuangongxiangEntity> wrapper);
   	

}

