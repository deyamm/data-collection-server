package com.exchange.sys.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class PageVo<T> implements IPage<T>{

    /**
     * data list
     */
    protected List<T> records = Collections.emptyList();

    /**
     *
     */
    protected long total = 0;

    /**
     *
     */
    protected long current = 1;

    /**
     *
     */
    protected long size = 10;

    /**
     *
     */
    protected String search = "";

    public PageVo() {

    }

    public PageVo(long current, long size) {
        this(current, size, 0, "");
    }

    public PageVo(long current, long size, String search) {
        this(current, size, 0, search);
    }

    public PageVo(long current, long size, long total, String search) {
        this.current = current;
        this.size = size;
        this.total = total;
        this.search = search;
    }

    @Override
    public List<OrderItem> orders() {
        return null;
    }

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public IPage<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public IPage<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public IPage<T> setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public long getCurrent() {
        return this.current;
    }

    @Override
    public IPage<T> setCurrent(long current) {
        this.current = current;
        return this;
    }

    public String getSearch() {
        return this.search;
    }
}
