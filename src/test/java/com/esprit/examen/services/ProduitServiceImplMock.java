package com.esprit.examen.services;


import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;

import lombok.extern.slf4j.Slf4j;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Slf4j
public class ProduitServiceImplMock {
	@Autowired
	IProduitService ProduitService;
	@Mock
	ProduitRepository produitRepository;
	@InjectMocks
	ProduitServiceImpl produitService;
	
	
	DateFormat df = new SimpleDateFormat("MM-dd-yyyy");

	Produit produit = new Produit("00708", "libbPorduit", 10, new Date(), new Date());
	
	ArrayList<Produit> listProduits = new ArrayList<Produit>() {
		{
			add(new Produit("00708", "libbPorduit", 10, new Date(), new Date()));
			add(new Produit("007018", "libbPovrduit", 17, new Date(), new Date()));
		}
		
	};
	
	
	@Test
	@Order(1)
	
	public void testRetrieveProduit() {
	Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
	Produit produit1 = produitService.retrieveProduit(6L);
	Assertions.assertNotNull(produit1);
	
	}

	@Test
	@Order(2)
	public void testAddProduit() throws ParseException {
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date d1 =  (Date) df.parse("12-10-2022"); 
		Date d2 =  df.parse("14-10-2022");
		Produit p = new Produit("00708", "libPorduit", 10, d1 , d2);
		Produit savedProduit = ProduitService.addProduit(p);
		assertEquals(p.getLibelleProduit(), savedProduit.getLibelleProduit());

	}
	

	@Test
	@Order(3)
	public void testDeleteProduit() {
		ProduitService.deleteProduit(5L);
		assertNull(ProduitService.retrieveProduit(4L));
	}


}
