package dao.custom.impl;

import dao.custom.QueryDAO;
import db.DBConnection;
import entity.CustomEntity;
import entity.Customer;
import entity.OrderDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public CustomEntity getOrderDetail(String orderId) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT  o.id, c.name, o.date FROM `Order` o\n" +
                    "INNER JOIN Customer c on o.customerId = c.id\n" +
                    "WHERE o.id=?");
            pstm.setObject(1,orderId);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()){
                return new CustomEntity(rst.getString(1),
                        rst.getString(2),
                        rst.getString(3));
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  null;
        }


    }

    @Override
    public CustomEntity getCustomerDetails(String orderId) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.
                    prepareStatement("SELECT  c.id, c.name, o.id FROM `Order` o\n" +
                            "INNER JOIN Customer c on o.customerId = c.id\n" +
                            "WHERE o.id=?");
            pstm.setObject(1,orderId);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()){
                return new CustomEntity(rst.getString(1),
                        rst.getString(2),
                        rst.getString(3));
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  null;
        }
    }

    @Override
    public List<CustomEntity> getSummaryDetails() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT o.id,o.date,c.id,c.name,SUM(od.qty*od.unitPrice) as total\n" +
                    "FROM `order` o\n" +
                    "JOIN customer c on o.customerId = c.id\n" +
                    "JOIN orderdetail od on o.id = od.orderId\n" +
                    "GROUP BY od.orderId;");
            List<CustomEntity> custom = new ArrayList<>();
            while (rst.next()) {
                custom.add(new CustomEntity(rst.getString(1),
                        rst.getDate(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getBigDecimal(5)));
            }
            return custom;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
