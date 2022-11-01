package com.esprit.examen.services;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.StockServiceImpl;
import com.esprit.examen.entities.Stock;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StockRestControllerTest {

    @Autowired
    StockServiceImpl stockImpl;
    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockServiceImpl;

    Stock s = new Stock("stock test",100,20);
    @Test
    public void testAddStock() {
        //	List<Stock> stocks = stockService.retrieveAllStocks();
        //	int expected=stocks.size();
        Stock s = new Stock(10L,"stock test",100,20,null);
        Stock savedStock= stockImpl.addStock(s);

        //	assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getLibelleStock());
        //stockImpl.deleteStock(savedStock.getIdStock());
    }

    @Test
    public void testDeleteStock() {
        Stock s = new Stock("stock test",100,20);
        Stock savedStock= stockImpl.addStock(s);
        stockImpl.deleteStock(savedStock.getIdStock());
        assertNull(stockImpl.retrieveStock(savedStock.getIdStock()));
    }
    @Test
    void getStock(){
        Iterable<Stock> Lstock = stockRepository.findAll();
        Assertions.assertNotNull(Lstock);
    }

    @Test
    void retrieveStock() {
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        Stock stock = stockServiceImpl.retrieveStock(1L);
        Mockito.verify(stockRepository,Mockito.times(1)).findById(1L);
    }

}
