package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ZiyuangongxiangEntity;
import com.cl.entity.view.ZiyuangongxiangView;

import com.cl.service.ZiyuangongxiangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 资源共享
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
@RestController
@RequestMapping("/ziyuangongxiang")
public class ZiyuangongxiangController {
    @Autowired
    private ZiyuangongxiangService ziyuangongxiangService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiyuangongxiangEntity ziyuangongxiang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			ziyuangongxiang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZiyuangongxiangEntity> ew = new EntityWrapper<ZiyuangongxiangEntity>();

		PageUtils page = ziyuangongxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuangongxiang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZiyuangongxiangEntity ziyuangongxiang, 
		HttpServletRequest request){
        EntityWrapper<ZiyuangongxiangEntity> ew = new EntityWrapper<ZiyuangongxiangEntity>();

		PageUtils page = ziyuangongxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuangongxiang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiyuangongxiangEntity ziyuangongxiang){
       	EntityWrapper<ZiyuangongxiangEntity> ew = new EntityWrapper<ZiyuangongxiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziyuangongxiang, "ziyuangongxiang")); 
        return R.ok().put("data", ziyuangongxiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiyuangongxiangEntity ziyuangongxiang){
        EntityWrapper< ZiyuangongxiangEntity> ew = new EntityWrapper< ZiyuangongxiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziyuangongxiang, "ziyuangongxiang")); 
		ZiyuangongxiangView ziyuangongxiangView =  ziyuangongxiangService.selectView(ew);
		return R.ok("查询资源共享成功").put("data", ziyuangongxiangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiyuangongxiangEntity ziyuangongxiang = ziyuangongxiangService.selectById(id);
		ziyuangongxiang = ziyuangongxiangService.selectView(new EntityWrapper<ZiyuangongxiangEntity>().eq("id", id));
        return R.ok().put("data", ziyuangongxiang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiyuangongxiangEntity ziyuangongxiang = ziyuangongxiangService.selectById(id);
		ziyuangongxiang = ziyuangongxiangService.selectView(new EntityWrapper<ZiyuangongxiangEntity>().eq("id", id));
        return R.ok().put("data", ziyuangongxiang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiyuangongxiangEntity ziyuangongxiang, HttpServletRequest request){
    	ziyuangongxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuangongxiang);
        ziyuangongxiangService.insert(ziyuangongxiang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiyuangongxiangEntity ziyuangongxiang, HttpServletRequest request){
    	ziyuangongxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ziyuangongxiang);
        ziyuangongxiangService.insert(ziyuangongxiang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiyuangongxiangEntity ziyuangongxiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziyuangongxiang);
        ziyuangongxiangService.updateById(ziyuangongxiang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziyuangongxiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
