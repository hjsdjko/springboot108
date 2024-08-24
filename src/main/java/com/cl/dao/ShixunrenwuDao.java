package com.cl.dao;

import com.cl.entity.ShixunrenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShixunrenwuView;


/**
 * 实训任务
 * 
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface ShixunrenwuDao extends BaseMapper<ShixunrenwuEntity> {
	
	List<ShixunrenwuView> selectListView(@Param("ew") Wrapper<ShixunrenwuEntity> wrapper);

	List<ShixunrenwuView> selectListView(Pagination page,@Param("ew") Wrapper<ShixunrenwuEntity> wrapper);
	
	ShixunrenwuView selectView(@Param("ew") Wrapper<ShixunrenwuEntity> wrapper);
	

}
