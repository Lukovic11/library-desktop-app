package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class OrderItem implements GenericEntity {

    private Long orderItemId;
    private Order order;
    private Book book;
    private boolean vracena;

    public OrderItem() {
    }

    public OrderItem(Long orderItemId, Order order, Book book, boolean vracena) {
        this.orderItemId = orderItemId;
        this.order = order;
        this.book = book;
        this.vracena = vracena;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isVracena() {
        return vracena;
    }

    public void setVracena(boolean vracena) {
        this.vracena = vracena;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.orderItemId);
        hash = 31 * hash + Objects.hashCode(this.order);
        hash = 31 * hash + Objects.hashCode(this.book);
        hash = 31 * hash + (this.vracena ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderItem other = (OrderItem) obj;
        if (this.vracena != other.vracena) {
            return false;
        }
        if (!Objects.equals(this.orderItemId, other.orderItemId)) {
            return false;
        }
        if (!Objects.equals(this.order, other.order)) {
            return false;
        }
        return Objects.equals(this.book, other.book);
    }

    @Override
    public String toString() {
        return "Stavka: " + orderItemId + ", Knjiga: " + book;
    }

    @Override
    public String getTableName() {
        return "stavkanaloga";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "stavkaId,nalogId,knjigaId,vracena";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(orderItemId).append(",")
                .append(order.getOrderId()).append(",")
                .append(book.getId()).append(",")
                .append(vracena);
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        setOrderItemId(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT oi.stavkaId,oi.nalogId,oi.knjigaID,oi.vracena FROM stavkanaloga AS oi INNER JOIN nalog AS o ON oi.nalogId=o.nalogId INNER JOIN knjiga AS k ON oi.knjigaId=k.knjigaId";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new OrderItem(rs.getLong("stavkaId"), new Order(rs.getLong("nalogId")), new Book(rs.getLong("knjigaId")), rs.getBoolean("vracena"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "stavkaId=" + ((OrderItem) object).getOrderItemId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        OrderItem oi = (OrderItem) object;
        return "nalogId=" + oi.getOrder().getOrderId() + ", knjigaId=" + oi.getBook().getId() + ", vracena=" + oi.vracena;
    }
}
