package com.lmy.util;

import com.lmy.entity.PageBean;
import com.lmy.mapper.BaseMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGridUtil {

    @Resource
    private BaseMapper baseMapper;

    /**
     * 从数据库中查询数据并返回给前端
     * @param response HttpServletResponse对象
     * @param dataMap 包含查询参数的Map对象
     * @throws Exception
     */
    public void selectDataGrid(HttpServletResponse response, Map<String, Object> dataMap) throws Exception {
        String page = (dataMap.get("page") == null ? 1 : dataMap.get("page")) + "";//起始页
        String rows = (dataMap.get("rows") == null ? 10 : dataMap.get("rows")) + "";//每页条数
        String table = dataMap.get("table") + "";//表名
        String where = dataMap.get("where") + "";//查询条件
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        map.put("table", table);
        map.put("where", where);
        List<Map<String, Object>> list = baseMapper.findGridData(map);//查询数据
        Long total = baseMapper.getGridTotal(map);//查询数据总数
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(list);
        result.put("rows", jsonArray);
        result.put("total", total);
        ResponseUtil.write(response, result);//将结果写入response
    }
}

