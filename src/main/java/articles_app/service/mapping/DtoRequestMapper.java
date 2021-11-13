package articles_app.service.mapping;

public interface DtoRequestMapper<D, C> {
    C fromDto(D dto);
}