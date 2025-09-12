package click.dailyfeed.pagination.mapper;

import click.dailyfeed.code.global.web.response.DailyfeedScrollPage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageMapper {
    public <D, T> DailyfeedScrollPage<T> fromJpaPage(Page<D> page, List<T> result) {
        return DailyfeedScrollPage.<T>builder()
                .content(result)
                .page(page.getNumber())
                .size(page.getSize())
                .build();
    }
}
