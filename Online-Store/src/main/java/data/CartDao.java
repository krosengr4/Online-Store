package data;

import models.Cart;
import models.CartItem;

import java.util.List;

public interface CartDao {

	Cart getCart();

	List<CartItem> getCartItems();

	CartItem getItemByProductId(int productId);

	void add(CartItem item);

	void update(int productId, int quantity);

	void remove(int productId);

	void clearCart();
}
