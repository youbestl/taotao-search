package com.taotao.search.controller;

import com.taotao.search.bean.SearchResult;
import com.taotao.search.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by JARVIS on 2017/7/4.
 */
@Controller
public class SearchController {

    public static final Integer ROWS = 32;

    @Autowired
    private ItemSearchService itemSearchService;

    @RequestMapping(value = "search",method = RequestMethod.GET)
    public ModelAndView search(@RequestParam("q")String keywords,
                               @RequestParam(value = "page",defaultValue = "1")Integer page) {
        ModelAndView mv = new ModelAndView("search");
        SearchResult result = null;
        try {
            result = this.itemSearchService.search(keywords,page,ROWS);
            //搜索关键字
            mv.addObject("query", keywords);
            //搜索结果数据
            mv.addObject("itemList", result.getList());
            //页数
            mv.addObject("page", page);
            int total = result.getTotal().intValue();
            int pages =  total % ROWS == 0 ? total % ROWS : (total % ROWS) +1;
            //总页数
            mv.addObject("pages", pages);
        } catch (Exception e) {
            e.printStackTrace();
            result = new SearchResult(0L, null);
        }
        return mv;
    }
}
