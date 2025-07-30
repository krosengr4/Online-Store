package data;

import models.Cart;

public interface CartDao {

	Cart getAll();

	void add();

	void remove();
}
