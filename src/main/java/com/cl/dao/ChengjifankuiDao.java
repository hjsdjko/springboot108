package com.cl.dao;

import com.cl.entity.ChengjifankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ChengjifankuiView;


/**
 * 成绩反馈
 * 
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface ChengjifankuiDao extends BaseMapper<ChengjifankuiEntity> {
	
	List<ChengjifankuiView> selectListView(@Param("ew") Wrapper<ChengjifankuiEntity> wrapper);

	List<ChengjifankuiView> selectListView(Pagination page,@Param("ew") Wrapper<ChengjifankuiEntity> wrapper);
	
	ChengjifankuiView selectView(@Param("ew") Wrapper<ChengjifankuiEntity> wrapper);
	

}
