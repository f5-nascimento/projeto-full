package com.project.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dsvendas.dto.SaleSuccessDTO;
import com.project.dsvendas.dto.SaleSumDTO;
import com.project.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
  
	@Query("SELECT new com.project.dsvendas.dto.SaleSumDTO(obj.seller, sum(obj.amount)) from Sale as obj group by obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.project.dsvendas.dto.SaleSuccessDTO(obj.seller, sum(obj.visited), sum(obj.deals)) from Sale as obj group by obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
	
}
