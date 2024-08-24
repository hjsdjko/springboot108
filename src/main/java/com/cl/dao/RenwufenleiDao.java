package com.cl.dao;

import com.cl.entity.RenwufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwufenleiView;


/**
 * 任务分类
 * 
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface RenwufenleiDao extends BaseMapper<RenwufenleiEntity> {
	
	List<RenwufenleiView> selectListView(@Param("ew") Wrapper<RenwufenleiEntity> wrapper);

	List<RenwufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<RenwufenleiEntity> wrapper);
	
	RenwufenleiView selectView(@Param("ew") Wrapper<RenwufenleiEntity> wrapper);
	

}
