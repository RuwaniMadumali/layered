package dao.custom.impl;

import dao.DAOFactory;
import dao.DAOType;
import dao.custom.QueryDAO;
import entity.CustomEntity;

import java.util.List;

public class QueryDAOImplTest {

    public static void main(String[] args) {   //Need to ask from Sir
        QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOType.QUERY);
        List<CustomEntity> custom =  queryDAO.getSummaryDetails();
        for (CustomEntity cx:custom) {
            System.out.println("Order ID : " + cx.getOrderId()+" "+"Order Date : " + cx.getOrderDate()+
                    "Customer ID: "+cx.getCustomerId()+"Customer Name : " + cx.getCustomerName()+ "Total : "+ cx.getTotal());
        }
    }



    /*public static void main(String[] args) { //Run without errors
        QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOType.QUERY);
        List<CustomEntity> custom =  queryDAO.getSummaryDetails();
        for (CustomEntity cx:custom) {
            System.out.println("Order ID : " + cx.getOrderId());
            System.out.println("Order Date : " + cx.getOrderDate());
            System.out.println("Customer ID: " + cx.getCustomerId());
            System.out.println("Customer Name : " + cx.getCustomerName());
            System.out.println("Total : "+ cx.getTotal());
            System.out.println("--------------------------------------");

        }
    }*/

   /* public static void main(String[] args) {
        QueryDAO queryDAO = DAOFactory.getInstance().getDAO(DAOType.QUERY);
        CustomEntity ce = queryDAO.getCustomerDetails("OD001");
        System.out.println("Customer Name : " + ce.getCustomerName());
        System.out.println("Order ID : " + ce.getOrderId());
        System.out.println("Order Date : " + ce.getOrderDate());
        System.out.println("Customer ID: " + ce.getCustomerId());
    }*/
}
