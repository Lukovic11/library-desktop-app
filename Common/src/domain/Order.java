package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

public class Order implements GenericEntity {

    private Long orderId;
    private LocalDate issueDate;
    private LocalDate validUntil;
    private Administrator administrator;
    private Member member;
    private boolean status;

    public Order() {
    }

    public Order(Long orderId, LocalDate issueDate, LocalDate validUntil, Administrator administrator, Member member, boolean status) {
        this.orderId = orderId;
        this.issueDate = issueDate;
        this.validUntil = validUntil;
        this.administrator = administrator;
        this.member = member;
        this.status = status;
    }

    public Order(Long id) {
        orderId = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.orderId);
        hash = 71 * hash + Objects.hashCode(this.issueDate);
        hash = 71 * hash + Objects.hashCode(this.validUntil);
        hash = 71 * hash + Objects.hashCode(this.administrator);
        hash = 71 * hash + Objects.hashCode(this.member);
        hash = 71 * hash + (this.status ? 1 : 0);
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
        final Order other = (Order) obj;
        if (this.status != other.status) {
            return false;
        }
        if (!Objects.equals(this.orderId, other.orderId)) {
            return false;
        }
        if (!Objects.equals(this.issueDate, other.issueDate)) {
            return false;
        }
        if (!Objects.equals(this.validUntil, other.validUntil)) {
            return false;
        }
        if (!Objects.equals(this.administrator, other.administrator)) {
            return false;
        }
        return Objects.equals(this.member, other.member);
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", issueDate=" + issueDate + ", validUntil=" + validUntil + ", administrator=" + administrator + ", member=" + member + ", status=" + status + '}';
    }

    @Override
    public String getTableName() {
        return "nalog";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "nalogID,datumIzdavanja,vaziDo,adminId,clanId,status";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(orderId).append(",")
                .append("'").append(issueDate).append("','")
                .append(validUntil).append("',")
                .append(administrator.getAdminId()).append(",")
                .append(member.getId()).append(",")
                .append(status);
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        setOrderId(id);
    }

    @Override
    public String getSelectValues() {
        return "SELECT o.nalogID,o.datumIzdavanja,o.vaziDo,o.adminId,o.clanId ,o.status FROM nalog AS o INNER JOIN administrator AS a ON o.adminId = a.adminId INNER JOIN clan AS m ON o.clanId=m.clanId";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Order(rs.getLong("nalogID"), rs.getDate("datumIzdavanja").toLocalDate(), rs.getDate("vaziDo").toLocalDate(), new Administrator(rs.getLong("adminId")), new Member(rs.getLong("clanId")), rs.getBoolean("status"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "nalogId=" + ((Order) object).getOrderId();

    }

    @Override
    public String getUpdateSetValues(Object object) {
        Order order = (Order) object;
        return "datumIzdavanja=" + "'" + order.getIssueDate() + "'" + ", vaziDo='" + order.getValidUntil() + "', adminId=" + administrator.getAdminId() + ", clanId=" + member.getId() + ", status=" + order.status;

    }

}
