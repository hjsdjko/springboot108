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


import com.cl.dao.ChengjifankuiDao;
import com.cl.entity.ChengjifankuiEntity;
import com.cl.service.ChengjifankuiService;
import com.cl.entity.view.ChengjifankuiView;

@Service("chengjifankuiService")
public class ChengjifankuiServiceImpl extends ServiceImpl<ChengjifankuiDao, ChengjifankuiEntity> implements ChengjifankuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChengjifankuiEntity> page = this.selectPage(
                new Query<ChengjifankuiEntity>(params).getPage(),
                new EntityWrapper<ChengjifankuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChengjifankuiEntity> wrapper) {
		  Page<ChengjifankuiView> page =new Query<ChengjifankuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ChengjifankuiView> selectListView(Wrapper<ChengjifankuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChengjifankuiView selectView(Wrapper<ChengjifankuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
