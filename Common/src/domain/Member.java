package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Member implements GenericEntity {

    private Long id;
    private String firstname;
    private String lastname;
    private Long idCardNumber;

    public Member() {
    }

    public Member(Long id, String firstname, String lastname, Long idCardNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.idCardNumber = idCardNumber;
    }

    public Member(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(Long idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.firstname);
        hash = 31 * hash + Objects.hashCode(this.lastname);
        hash = 31 * hash + Objects.hashCode(this.idCardNumber);
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
        final Member other = (Member) obj;
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.idCardNumber, other.idCardNumber);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

    @Override
    public String getTableName() {
        return "clan";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "clanId,ime,prezime,brLicneKarte";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",")
                .append("'").append(firstname).append("',")
                .append("'").append(lastname).append("',")
                .append(idCardNumber);
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Override
    public String getSelectValues() {
        return "SELECT m.clanId,m.ime,m.prezime,m.brLicneKarte FROM clan as m";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new Member(rs.getLong("clanId"), rs.getString("ime"), rs.getString("prezime"), rs.getLong("brLicneKarte"));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "clanId=" + ((Member) object).getId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        Member member = (Member) object;
        return "ime=" + "'" + member.getFirstname() + "', prezime=" + "'" + member.getLastname() + "'" + ", brLicneKarte=" + member.getIdCardNumber();
    }

}
