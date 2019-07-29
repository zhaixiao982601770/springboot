package com.example.demo.services;

import com.example.demo.commen.PageParam;
import com.example.demo.model.Shoppingcar;


public interface ShoppingcarService {



	 Object getAllShoppingcar(PageParam<Shoppingcar> pageParam);

    boolean deleteShoppingcar(int id);

    boolean addShoppingcar(Shoppingcar shoppingcar);

    boolean updateShoppingcar(Shoppingcar shoppingcar);

    Shoppingcar getAllShoppingcarById(int id);


}