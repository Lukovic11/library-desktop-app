package repository;

public interface DBRepository<T> extends Repository<T> {

    default public void connect() throws Exception {
        DatabaseFactoryRepository.getInstance().getConnection();
    }

    default public void disconnect() throws Exception {
        DatabaseFactoryRepository.getInstance().getConnection().close();
    }

    default public void commit() throws Exception {
        DatabaseFactoryRepository.getInstance().getConnection().commit();
    }

    default public void rollback() throws Exception {
        DatabaseFactoryRepository.getInstance().getConnection().rollback();
    }
}
