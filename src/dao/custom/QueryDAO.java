package dao.custom;

import dao.SuperDAO;
import entity.CustomEntity;

import java.util.List;

public interface QueryDAO extends SuperDAO {// generic nethuwa use karanawanam eka rowtype ekak kiyala kiyanawa

    CustomEntity getOrderDetail(String orderId);
    CustomEntity getCustomerDetails(String orderId);
    List<CustomEntity> getSummaryDetails();

}
