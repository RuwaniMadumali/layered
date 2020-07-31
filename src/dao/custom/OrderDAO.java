package dao.custom;

import com.sun.org.apache.xpath.internal.operations.Or;
import dao.CrudDAO;
import dao.SuperDAO;
import entity.Order;

import java.util.List;

public interface OrderDAO extends CrudDAO<Order,String> {

    public  String getLastOrderId();

}
