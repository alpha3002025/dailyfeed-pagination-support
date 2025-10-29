package click.dailyfeed.pagination.slice;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HasMoreComponent {

    public <T> Boolean hasMore(List<T> list, Integer size){
        return list.size() > size;
    }

    public <T> List<T> trimOverflow(List<T> list, Integer size, Boolean hasMore){
        return hasMore ? list.subList(0, size) : list;
    }

    public <T> List<T> toList(List<T> list, Integer size){
        Boolean hasMore = hasMore(list, size);
        return trimOverflow(list, size, hasMore);
    }
}
