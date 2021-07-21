package com.mazdausa.mfp.dealerlocationservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mazdausa.mfp.dealerlocationservice.entity.DealerEntity;

@Repository
public interface DealerLocationDao extends JpaRepository<DealerEntity, Long> {

}
