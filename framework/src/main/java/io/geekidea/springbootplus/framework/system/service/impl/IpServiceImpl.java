package io.geekidea.springbootplus.framework.system.service.impl;

import io.geekidea.springbootplus.framework.core.constant.CommonConstant;
import io.geekidea.springbootplus.framework.system.entity.Ip;
import io.geekidea.springbootplus.framework.system.mapper.IpMapper;
import io.geekidea.springbootplus.framework.system.service.IpService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.geekidea.springbootplus.framework.common.service.impl.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.core.pagination.PageUtil;

/**
 * IP地址 服务实现类
 *
 * @author geekidea
 * @since 2020-03-20
 */
@Slf4j
@Service
public class IpServiceImpl extends BaseServiceImpl<IpMapper, Ip> implements IpService {

    @Autowired
    private IpMapper ipMapper;


    @Override
    public Ip getByIp(String ip) {
        if (StringUtils.isBlank(ip)) {
            return null;
        }
        if (CommonConstant.LOCALHOST_IP.equals(ip)) {
            return new Ip().setArea(CommonConstant.LOCALHOST_IP_NAME);
        }
        if (CommonConstant.LAN_IP.equals(ip)) {
            return new Ip().setArea(CommonConstant.LAN_IP_NAME);
        }
        return ipMapper.getByIp(ip);
    }
}