package com.gloria.demo.service.impl;

import com.gloria.demo.dao.AreaDao;
import com.gloria.demo.entity.Area;
import com.gloria.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        //int a=1/0;test ExceptionHandler
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if(area.getAreaName()!=null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.insertArea(area);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("fail to insert");
                }
            }catch(Exception e){
                throw new RuntimeException("fail to insert"+e.getMessage());
            }
        }else{
            throw new RuntimeException("Area message can't be blank!");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId()!=null && !"".equals(area.getAreaId())){

            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.updateArea(area);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("fail to update");
                }
            }catch(Exception e){
                throw new RuntimeException("fail to update"+e.getMessage());
            }
        }else{
            throw new RuntimeException("Area message can't be blank!");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try{
                int effectedNum = areaDao.deleteArea(areaId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("fail to delete");
                }
            }catch(Exception e){
                throw new RuntimeException("fail to delete"+e.getMessage());
            }
            }else{
            throw new RuntimeException("Area id can't be blank!");
        }
        }
    }

