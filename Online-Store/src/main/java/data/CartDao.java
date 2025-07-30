package data;

import models.Cart;
import models.CartItem;

import java.util.List;

public interface CartDao {

	Cart getCart();

	List<CartItem> getCartItems();

	void add(CartItem item);

	void remove(int productId);

	void clearCart();
}
