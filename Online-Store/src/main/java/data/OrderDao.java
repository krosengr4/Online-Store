package data;

import models.Order;
import models.OrderLineItems;

import java.util.List;

public interface OrderDao {

	List<Order> getAll();

	Order getById(int orderId);

	List<OrderLineItems> getLineItems(int orderId);

	Order add(Order order);

	void deleteLineItems(int orderId);

	void deleteOrder(int orderId);

}
