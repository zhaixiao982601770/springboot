package com.example.demo.services;

import com.example.demo.commen.HttpCode;
import com.example.demo.commen.MyException;
import com.example.demo.commen.PageParam;
import com.example.demo.dao.ShoppingcarDao;
import com.example.demo.model.Shoppingcar;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ShoppingcarServiceImpl implements ShoppingcarService {


	@Autowired
    ShoppingcarDao shoppingcarDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllShoppingcar(PageParam<Shoppingcar> pageParam){
    
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<Shoppingcar> shoppingcarList=shoppingcarDao.getAllShoppingcar(pageParam.getModel());
        PageInfo<Shoppingcar> shoppingcarPageInfo = new PageInfo<Shoppingcar>(shoppingcarList);

        return shoppingcarPageInfo;
    
    }

	@CacheEvict(value = "shoppingcars",key = "#p0")
    @Override
    public boolean deleteShoppingcar(int id){
    	return shoppingcarDao.deleteShoppingcar(id)==1;
    }

	@CachePut(value = "shoppingcars",key = "#p0.id")
    @Override
    public boolean addShoppingcar(Shoppingcar shoppingcar){
        return shoppingcarDao.addShoppingcar(shoppingcar)==1;
    }

	@Override
    public boolean updateShoppingcar(Shoppingcar shoppingcar){
    	if(StringUtils.isEmpty(shoppingcar.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改shoppingcar时，id不能为空");
        }

        return shoppingcarDao.updateShoppingcar(shoppingcar)==1;
    }

	@Cacheable(key = "#p0",value="shoppingcars")
    @Override
    @Transactional(readOnly = true)
    public Shoppingcar getAllShoppingcarById(int id){
    	return shoppingcarDao.getAllShoppingcarById(id);
    	
    }




}
