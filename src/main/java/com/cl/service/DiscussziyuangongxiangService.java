package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussziyuangongxiangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussziyuangongxiangView;


/**
 * 资源共享评论表
 *
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface DiscussziyuangongxiangService extends IService<DiscussziyuangongxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussziyuangongxiangView> selectListView(Wrapper<DiscussziyuangongxiangEntity> wrapper);
   	
   	DiscussziyuangongxiangView selectView(@Param("ew") Wrapper<DiscussziyuangongxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussziyuangongxiangEntity> wrapper);
   	

}

