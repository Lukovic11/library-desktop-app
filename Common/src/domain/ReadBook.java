package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class ReadBook implements GenericEntity {

    private Member member;
    private Book book;

    public ReadBook() {
    }

    public ReadBook(Member member, Book book) {
        this.member = member;
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "book = " + book.getTitle();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.member);
        hash = 43 * hash + Objects.hashCode(this.book);
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
        final ReadBook other = (ReadBook) obj;
        if (!Objects.equals(this.member, other.member)) {
            return false;
        }
        return Objects.equals(this.book, other.book);
    }

    @Override
    public String getTableName() {
        return "procitane";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "clanId,knjigaId";
    }

    @Override
    public String getInsertValues() {
        StringBuilder sb = new StringBuilder();
        sb.append(member.getId()).append(",")
                .append(book.getId());
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        //
    }

    @Override
    public String getSelectValues() {
        return "SELECT p.clanId,p.knjigaId FROM procitane AS p";
    }

    @Override
    public GenericEntity getNewObject(ResultSet rs) throws SQLException {
        return new ReadBook(new Member(rs.getLong("clanId")), new Book(rs.getLong("knjigaId")));
    }

    @Override
    public String getDeleteAndUpdateCondition(Object object) {
        return "clanId=" + ((ReadBook) object).getMember().getId();
    }

    @Override
    public String getUpdateSetValues(Object object) {
        ReadBook rb = (ReadBook) object;
        return "clanId=" + rb.getMember().getId() + ", knjigaId=" + rb.getBook().getId();
    }

}
