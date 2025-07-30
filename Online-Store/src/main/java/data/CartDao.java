package data;

import models.Cart;
import models.CartItem;

import java.util.List;

public interface CartDao {

	List<CartItem> getAll();

	void add(CartItem item);

	void remove(int productId);
}
