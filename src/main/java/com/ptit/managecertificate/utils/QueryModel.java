package com.ptit.managecertificate.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryModel {
	private Logger logger = LoggerFactory.getLogger(QueryModel.class);
    private int draw = 1;
    private int start;
    private int length;
    private List<Columns> columns;
    private List<Order> order;
    private Search search = new Search();

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Columns> getColumns() {
        return columns;
    }

    public void setColumns(List<Columns> columns) {
        this.columns = columns;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public QueryModel() {
    }

    public QueryModel(Map<String, String[]> requestMap) {
    	
    	this.columns = new ArrayList<Columns>();
    	this.order = new ArrayList<Order>();
    	
    	String regex = "(\\[)([a-zA-Z]*)(\\])";
    	Pattern pattern = Pattern.compile(regex);
    	
    	StringBuffer sb = new StringBuffer();
    	
    	for (Map.Entry<String, String[]> entry : requestMap.entrySet()) {
    		String name = entry.getKey();
    		String[] value = entry.getValue();
    		sb.append(name.replaceAll(regex, ""));
    		Matcher matcher = pattern.matcher(name);
    		while (matcher.find()) {
    			sb.append(".").append(matcher.group(2));
    		}
    		
    		try {
    			if(sb.toString().indexOf("columns[")>=0) {
    				
    				int indexOfOpen = sb.toString().indexOf("[");
    				int indexOfClose = sb.toString().indexOf("]");
    				String strIndex = sb.toString().substring(indexOfOpen + 1, indexOfClose);
      				if(Integer.valueOf(strIndex) + 1 > columns.size()) {
      					columns.add(new Columns());
                    }
      			} else if(sb.toString().indexOf("order[")>=0) {
    				int indexOfOpen = sb.toString().indexOf("[");
    				int indexOfClose = sb.toString().indexOf("]");
    				String strIndex = sb.toString().substring(indexOfOpen + 1, indexOfClose);

    				if(Integer.valueOf(strIndex) + 1 > order.size()) {
      					order.add(new Order());
      				}
      			}
    			BeanUtils.copyProperty(this, sb.toString(), Arrays.toString(value).replaceAll("\\[|\\]", ""));
    			
    		} catch (Exception e) {
    			logger.info(String.format("Exception:%s\n%s=%s\n", e.getMessage(), sb.toString(), Arrays.toString(value).replaceAll("\\[|\\]", "")));
    			
    			System.out.println(String.format("Exception:%s\n%s=%s\n", e.getMessage(), sb.toString(), Arrays.toString(value).replaceAll("\\[|\\]","")));
    		}
    		sb.setLength(0);
        }
    }
}


