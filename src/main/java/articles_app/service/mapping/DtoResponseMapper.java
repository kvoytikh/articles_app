package articles_app.service.mapping;

public interface DtoResponseMapper<D, C> {
    D toDto(C object);
}