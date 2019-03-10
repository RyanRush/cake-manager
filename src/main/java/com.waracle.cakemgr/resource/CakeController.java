package com.waracle.cakemgr.resource;

import com.waracle.cakemgr.entity.CakeEntity;
import com.waracle.cakemgr.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CakeController {

    @GetMapping("/cakes")
    public List<CakeEntity> getCakes() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CakeEntity> list = session.createCriteria(CakeEntity.class).list();

        return list;
    }

}
