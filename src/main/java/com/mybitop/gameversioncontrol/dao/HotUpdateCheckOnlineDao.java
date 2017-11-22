package com.mybitop.gameversioncontrol.dao;

import com.mybitop.gameversioncontrol.entity.Hotupdatecheckonline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 热更新线上模板repository
 */
public interface HotUpdateCheckOnlineDao extends JpaRepository<Hotupdatecheckonline, Long> {
    int deleteHotupdatecheckById(Integer id);

    Hotupdatecheckonline findHotupdatecheckById(Integer id);

    List<Hotupdatecheckonline> findAll();

    Hotupdatecheckonline findHotupdatecheckByAppidAndChannelid(String appid, String channelid);

    @Transactional
    @Modifying
    @Query(value = "update hotupdatecheckonline set appname=?1,channelname=?2,appversion=?3,updatestrategy=?4,baseurl=?5,apkurl=?6,promptcollection=?7,forcecollection=?8,excludecollection=?9,updateinfo=?10 where id=?11", nativeQuery = true)
    int updateHotUpdateCheckOnlineById(String appname, String channelname, String appVersion, Integer updatestrategy, String baseurl, String apkurl, String promptcollection, String forcecollection, String excludecollection, String updateinfo, Integer id);
}