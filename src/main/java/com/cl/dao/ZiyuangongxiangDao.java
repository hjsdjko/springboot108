package com.cl.dao;

import com.cl.entity.ZiyuangongxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiyuangongxiangView;


/**
 * 资源共享
 * 
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface ZiyuangongxiangDao extends BaseMapper<ZiyuangongxiangEntity> {
	
	List<ZiyuangongxiangView> selectListView(@Param("ew") Wrapper<ZiyuangongxiangEntity> wrapper);

	List<ZiyuangongxiangView> selectListView(Pagination page,@Param("ew") Wrapper<ZiyuangongxiangEntity> wrapper);
	
	ZiyuangongxiangView selectView(@Param("ew") Wrapper<ZiyuangongxiangEntity> wrapper);
	

}
