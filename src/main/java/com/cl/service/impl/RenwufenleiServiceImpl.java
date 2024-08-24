package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.RenwufenleiDao;
import com.cl.entity.RenwufenleiEntity;
import com.cl.service.RenwufenleiService;
import com.cl.entity.view.RenwufenleiView;

@Service("renwufenleiService")
public class RenwufenleiServiceImpl extends ServiceImpl<RenwufenleiDao, RenwufenleiEntity> implements RenwufenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RenwufenleiEntity> page = this.selectPage(
                new Query<RenwufenleiEntity>(params).getPage(),
                new EntityWrapper<RenwufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<RenwufenleiEntity> wrapper) {
		  Page<RenwufenleiView> page =new Query<RenwufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<RenwufenleiView> selectListView(Wrapper<RenwufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public RenwufenleiView selectView(Wrapper<RenwufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
