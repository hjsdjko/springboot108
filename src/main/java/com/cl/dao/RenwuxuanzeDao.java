package com.cl.dao;

import com.cl.entity.RenwuxuanzeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.RenwuxuanzeView;


/**
 * 任务选择
 * 
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface RenwuxuanzeDao extends BaseMapper<RenwuxuanzeEntity> {
	
	List<RenwuxuanzeView> selectListView(@Param("ew") Wrapper<RenwuxuanzeEntity> wrapper);

	List<RenwuxuanzeView> selectListView(Pagination page,@Param("ew") Wrapper<RenwuxuanzeEntity> wrapper);
	
	RenwuxuanzeView selectView(@Param("ew") Wrapper<RenwuxuanzeEntity> wrapper);
	

}
