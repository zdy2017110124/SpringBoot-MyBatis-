package com.gloria.demo.web;

import com.gloria.demo.entity.Area;
import com.gloria.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping(value="/listarea", method= RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList", list);
        return modelMap;
    }
    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    private Map<String,Object> getAreaById(Integer areaId){
        Map<String,Object> modelMap = new HashMap<>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }
    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    private  Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }
    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    private  Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.modifyArea(area));
        return modelMap;
    }
    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    private  Map<String,Object> removeArea(Integer areaId){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }

}
